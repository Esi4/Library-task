package com.task.library

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class OrderListApplication

fun main(args: Array<String>) {
	runApplication<OrderListApplication>(*args)
}
