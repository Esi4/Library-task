package com.task.order_list.service

import com.task.order_list.model.dto.BookDTO
import com.task.order_list.model.exception.BookException
import com.task.order_list.model.mapper.BookMapper
import com.task.order_list.model.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookServiceImpl(
    private val bookRepository: BookRepository,
    private val bookMapper: BookMapper
): BookService {
    override fun createBook(bookDTO: BookDTO): BookDTO{

        if(bookDTO.id != -1) {
            throw IllegalArgumentException("ID must be null or -1")
        }

        val book = bookRepository.save(bookMapper.toEntity(bookDTO))
        return bookMapper.fromEntity(book)
    }

    override fun getAllBooks(): List<BookDTO> {
        val bookList = bookRepository.getAllCellBooks()

        if(bookList.isEmpty()) {
            throw BookException("DataBase is Empty")
        }

        return bookRepository.getAllCellBooks().map{
            bookMapper.fromEntity(it)
        }
    }

    override fun getBookById(bookId: Int): BookDTO {
        return bookMapper.fromEntity(bookRepository.findById(bookId).get())
    }

    override fun updateBook(bookDTO: BookDTO): BookDTO {
        val exists = bookRepository.existsById(bookDTO.id)
        if(!exists) throw BookException("Book with id ${bookDTO.id} is not present")


        getBookById(bookDTO.id)
        bookRepository.save(bookMapper.toEntity(bookDTO))
        return bookDTO
    }

    override fun deleteBook(bookId: Int) {
        val exists = bookRepository.existsById(bookId)
        if(!exists) throw BookException("Book with id $bookId is not present")

        bookRepository.deleteById(bookId)
    }

    override fun findAllBooksByAuthor(author: String): List<BookDTO> {
        val booksByAuthor = bookRepository.getAllCellBooks().filter { it.author == author }

        if(booksByAuthor.isEmpty()) {
            throw BookException("No books found with this author")
        }

        return booksByAuthor.map{
            bookMapper.fromEntity(it)
        }
    }

    override fun findAllBooksByTitle(title: String): List<BookDTO> {
        val booksByAuthor = bookRepository.getAllCellBooks().filter { it.title == title }

        if(booksByAuthor.isEmpty()) {
            throw BookException("No books found with this title")
        }

        return booksByAuthor.map{
            bookMapper.fromEntity(it)
        }
    }

    override fun updateRatingBook(bookId: Int, newRating: Int): BookDTO {
        val exists = bookRepository.findById(bookId)

        if (newRating !in 1..10) {
            throw BookException("Rating should be between 0 and 10")
        }

        val updatedBookRating = exists.get().copy(rating = newRating)
        val updatedBookDTORating = bookMapper.fromEntity(updatedBookRating)
        updateBook(updatedBookDTORating)
        return  updatedBookDTORating
    }

}