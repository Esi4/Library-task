package com.task.library.controller

import com.task.library.model.dto.BookDTO
import com.task.library.service.BookService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/books")
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

    @PutMapping
    fun updateBook(@RequestBody bookDTO: BookDTO): ResponseEntity<BookDTO> {
        return ResponseEntity.ok(bookService.updateBook(bookDTO))
    }

    @DeleteMapping("/{id}")
    fun deleteBook(@PathVariable id: Int): ResponseEntity<Unit> {
        return ResponseEntity(bookService.deleteBook(id), HttpStatus.NO_CONTENT)
    }

    @GetMapping("/author/{author}")
    fun findAllBooksByAuthor(@PathVariable author: String): ResponseEntity<List<BookDTO>> {
        return ResponseEntity.ok(bookService.findAllBooksByAuthor(author))
    }

    @GetMapping("/title/{title}")
    fun findAllBooksByTitle(@PathVariable title: String): ResponseEntity<List<BookDTO>> {
        return ResponseEntity.ok(bookService.findAllBooksByTitle(title))
    }

    @PatchMapping("/{id}/rating/{newRating}")
    fun updateRatingBook(@PathVariable id: Int, @PathVariable newRating: Int): ResponseEntity<BookDTO> {
        return ResponseEntity.ok(bookService.updateRatingBook(id, newRating))
    }
}