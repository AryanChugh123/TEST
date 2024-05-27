package com.example.plugins

import com.example.routes.customerRouting
import com.example.routes.getAllOrders
import com.example.routes.getOrder
import com.example.routes.totalizeOrder
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
      customerRouting()
        getAllOrders()
        getOrder()
        totalizeOrder()
    }
}
