package com.task.order_list.controller

import com.task.order_list.model.dto.BookDTO
import com.task.order_list.service.BookService
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class BookController(private val bookService: BookService
) {
    @GetMapping
    fun getAllOrders(): List<BookDTO> = bookService.getAllCellBooks()

    @PostMapping
    fun createOrder(@RequestBody bookDTO: BookDTO): ResponseEntity<BookDTO?> {
        try {
            return  ResponseEntity(bookService.createCellForBook(bookDTO), HttpStatus.CREATED)
        } catch (exception: IllegalArgumentException) {
            return ResponseEntity(null, HttpStatus.BAD_REQUEST)
        }
    }

    @GetMapping("/hello")
    fun deleteThis(): String = "Hello World!"
}