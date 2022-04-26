package com.example.todobackend.entities

class AddItemDTO(
    val item:TodoItem,
    val email:String
) {
}

class AddUserDTO(
    var _id:String?,
    val email:String,
    val userName:String,
)