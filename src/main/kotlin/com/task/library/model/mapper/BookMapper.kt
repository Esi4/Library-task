package com.task.library.model.mapper

import com.task.library.model.dto.BookDTO
import com.task.library.model.entity.Book
import org.springframework.stereotype.Service

@Service
class BookMapper: Mapper<BookDTO, Book> {
    override fun fromEntity(entity: Book): BookDTO = BookDTO(
        entity.id,
        entity.author,
        entity.title,
        entity.rating,
        entity.description
    )

    override fun toEntity(domain: BookDTO): Book = Book(
        domain.id,
        domain.author ?: "Unknown Author",
        domain.title ?: throw IllegalArgumentException("Book must have a title"),
        domain.rating ?: 0,
        domain.description?: ""
    )
}