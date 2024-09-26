package com.task.order_list.model.entity

import jakarta.persistence.*

@Entity
data class Book(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    val author: String,

    val title: String,

    val rating: Int,

    val description: String
)