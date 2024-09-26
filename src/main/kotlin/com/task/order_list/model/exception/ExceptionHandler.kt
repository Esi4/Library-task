package com.task.order_list.model.exception

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler(): Exception() {

    @ExceptionHandler(Exception::class)
    fun generalExceptionHandler(exception: Exception): ResponseEntity<ApiError> {
        val error = ApiError(exception.message)
        return ResponseEntity(error, error.status)
    }


    @ExceptionHandler(BookException::class)
    fun BookExceptionHandler(exception: Exception): ResponseEntity<ApiError> {
        val error = ApiError(exception.message)
        return ResponseEntity(error, error.status)
    }




}