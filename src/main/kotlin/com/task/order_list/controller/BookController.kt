package com.task.order_list.controller

import com.task.order_list.model.dto.BookDTO
import com.task.order_list.service.BookService
import com.task.order_list.service.BookServiceImpl
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class BookController(private val bookService: BookService
) {
    @GetMapping
    fun getAllBooks(): ResponseEntity<List<BookDTO>> =
        ResponseEntity.ok(bookService.getAllBooks())

    @PostMapping
    fun createBook(@RequestBody bookDTO: BookDTO): ResponseEntity<BookDTO?> =
        ResponseEntity(bookService.createBook(bookDTO), HttpStatus.CREATED)

    @GetMapping("/{id}")
    fun getBookById(@PathVariable id: Int):ResponseEntity<BookDTO> {
        return ResponseEntity.ok(bookService.getBookById(id))
    }
}