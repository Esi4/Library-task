package com.task.library.model.mapper

interface Mapper<D, E> {

    fun fromEntity(entity: E): D

    fun toEntity(domain: D): E
}