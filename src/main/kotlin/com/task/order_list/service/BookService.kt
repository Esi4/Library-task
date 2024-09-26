package com.task.order_list.service

import com.task.order_list.model.dto.BookDTO

interface BookService {

    fun getAllBooks(): List<BookDTO>

    fun createBook(bookDTO: BookDTO): BookDTO

    fun getBookById(bookId: Int): BookDTO
}