package com.task.library.service.scheduler

import com.task.library.service.BookService
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service

@Service
class Scheduler(val bookService : BookService) {

    @Scheduled(initialDelay = 3000L, fixedDelayString = "\${scheduler.intervalMs}")
    fun doWork() {
        val booksList = bookService.getAllBooks().filter{it.rating == 0}

        for (book in booksList) {
            bookService.deleteBook(book.id)
        }
    }
}