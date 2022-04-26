package com.example.todobackend.entities

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "users")
class User(
    @Id
    var _id:String?,


    @org.springframework.data.mongodb.core.index.Indexed(unique = true)
    val email:String,
    val userName:String,
    var items:MutableMap<String,TodoItem>,
) {
}