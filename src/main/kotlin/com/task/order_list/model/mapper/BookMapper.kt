package com.task.order_list.model.mapper

import com.task.order_list.model.dto.BookDTO
import com.task.order_list.model.entity.Book
import org.springframework.stereotype.Service

@Service
class BookMapper: Mapper<BookDTO, Book> {
    override fun fromEntity(entity: Book): BookDTO = BookDTO(
        entity.id,
        entity.name,
        entity.description
    )

    override fun toEntity(domain: BookDTO): Book = Book(
        domain.id,
        domain.name,
        domain.description
    )
}