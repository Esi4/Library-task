package com.task.order_list.model.repository

import com.task.order_list.model.entity.Book
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository: CrudRepository<Book, Int> {}
