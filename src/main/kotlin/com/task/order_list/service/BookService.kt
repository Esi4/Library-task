package com.task.order_list.service

import com.task.order_list.model.dto.BookDTO

interface BookService {

    fun getAllCellBooks(): List<BookDTO>

//    fun getOrderById(orderId: Long): Order
//
    fun createCellForBook(bookDTO: BookDTO): BookDTO
//
//    fun updateOrder(orderId: Long, order: Order): Order
//
//    fun deleteOrder(orderId: Long)
}