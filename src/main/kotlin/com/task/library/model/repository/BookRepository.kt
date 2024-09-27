package com.task.library.model.repository

import com.task.library.model.entity.Book
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository: CrudRepository<Book, Int> {

    @Query("SELECT m FROM Book as m")
    fun getAllCellBooks(): List<Book>
}
