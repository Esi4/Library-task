package com.task.order_list.service

import com.task.order_list.model.dto.BookDTO

interface BookService {

    fun getAllBooks(): List<BookDTO>

    fun createBook(bookDTO: BookDTO): BookDTO

    fun getBookById(bookId: Int): BookDTO

    fun updateBook(bookDTO: BookDTO): BookDTO

    fun deleteBook(bookId: Int)

    fun findAllBooksByAuthor(author: String): List<BookDTO>

    fun findAllBooksByTitle(title: String): List<BookDTO>

    fun updateRatingBook(bookId: Int, newRating: Int): BookDTO
}