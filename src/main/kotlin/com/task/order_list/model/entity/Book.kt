package com.task.order_list.model.entity

import jakarta.persistence.*

@Entity
data class Book(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    val name: String,

    val description: String
)