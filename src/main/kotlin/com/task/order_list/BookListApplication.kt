package com.task.order_list

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
class OrderListApplication

fun main(args: Array<String>) {
	runApplication<OrderListApplication>(*args)
}
