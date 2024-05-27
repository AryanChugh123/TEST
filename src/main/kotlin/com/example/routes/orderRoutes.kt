package com.example.routes

import com.example.models.orderStorage
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.getAllOrders() {

    route("/order"){
        get {
            if (orderStorage.isNotEmpty()){
                call.respond(orderStorage)
            }
        }

    }
}
fun Route.getOrder(){
    route("/order/{id?}"){
        get{
            val id = call.parameters["id"]?: return@get call.respondText("id does not exist",status= HttpStatusCode.BadRequest)
            val orderitem= orderStorage.find {it.number==id} ?:return@get call.respondText("order not found ",status=HttpStatusCode.NotFound)
            call.respond(orderitem)
        }
    }
}
fun Route.totalizeOrder(){
    route("/order/{id?}/total"){
        get{
            val id= call.parameters["id"]?: return@get call.respondText("id not found",status=HttpStatusCode.BadRequest)
            val order= orderStorage.find{it.number==id}?:return@get call.respondText("order not found ",status=HttpStatusCode.NotFound)
            val sum=order.contents.sumOf{it.price*it.amount}
            call.respond(sum)


        }
    }
}