package com.task.order_list.service

import com.task.order_list.model.dto.BookDTO
import com.task.order_list.model.mapper.BookMapper
import com.task.order_list.model.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookServiceImpl(
    private val bookRepository: BookRepository,
    private val bookMapper: BookMapper
): BookService {
    override fun createCellForBook(bookDTO: BookDTO): BookDTO{

        if(bookDTO.id != -1) {
            throw IllegalArgumentException("ID must be null or -1")
        }

        val order = bookMapper.toEntity(bookDTO)
        bookRepository.save(order)
        return bookMapper.fromEntity(order)
    }

    override fun getAllCellBooks(): List<BookDTO> = bookMapper.fromEntity()bookRepository.findAll();
//
//    override fun getOrderById(orderId: Long): Order = orderRepository.findByIdOrNull(orderId)
//        ?: throw OrderNotFoundException(HttpStatus.NOT_FOUND, "Order with $orderId not found")
//    override fun updateOrder(orderId: Long, order: Order): Order {
//        return if(orderRepository.existsById(orderId)) {
//            orderRepository.save(
//                Order(
//                    id = order.id,
//                    name = order.name,
//                    description = order.description
//                )
//            )
//        } else throw OrderNotFoundException(HttpStatus.NOT_FOUND, "Order with $orderId not found")
//    }
//
//    override fun deleteOrder(orderId: Long) {
//        return if (orderRepository.existsById(orderId)) {
//            orderRepository.deleteById(orderId)
//        } else throw OrderNotFoundException(HttpStatus.NOT_FOUND, "Order with $orderId not found")
//    }

}