package com.example.models
import kotlinx.serialization.Serializable

@Serializable
data class Customer(val id:String,val firstname:String,val lastname:String,val email:String){

}
val customerStorage= mutableListOf<Customer>()