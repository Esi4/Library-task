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
            bookMapper.fromEntity(it);
        }
    }

    override fun getBookById(bookId: Int): BookDTO {
        return bookMapper.fromEntity(bookRepository.findById(bookId).get())
    }

    override fun updateBook(bookDTO: BookDTO): BookDTO {
        getBookById(bookDTO.id)
        bookRepository.save(bookMapper.toEntity(bookDTO))
        return bookDTO
    }

}