package com.task.order_list.model.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class BookNotFoundException(): Exception() {
    @ExceptionHandler(IllegalArgumentException:: class)
    fun exceptionHandler(exception: Exception): ResponseEntity<ApiError> {
        val error = ApiError(exception.message)
        return ResponseEntity(error, error.status)
    }
}