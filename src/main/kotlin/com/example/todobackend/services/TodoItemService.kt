package com.example.todobackend.services

import com.example.todobackend.entities.AddItemDTO
import com.example.todobackend.entities.AddUserDTO
import com.example.todobackend.entities.TodoItem
import com.example.todobackend.entities.User
import com.example.todobackend.repositories.TodoItemRepo
import com.example.todobackend.repositories.UserRepo
import org.bson.types.ObjectId
import org.springframework.stereotype.Service

@Service
class TodoItemService(private val todoItemRepo: TodoItemRepo,private val userRepo: UserRepo) {

    fun createUser(userRequest:AddUserDTO):User{
        val user = User(
            _id = null,
            email = userRequest.email,
            userName = userRequest.userName,
            items = mutableMapOf()
        )
        return userRepo.save(user)
    }

    fun getAllItems(email: String): MutableMap<String, TodoItem> {
        val user  = userRepo.findUserByEmail(email)
        return user.items
    }

    fun deleteItem(id:String,email: String){
        val user = userRepo.findUserByEmail(email)
        user.items.remove(id)
        userRepo.save(user)
//        userRepo.deleteItems(id)
    }
    fun deleteAll(email: String){
        val user = userRepo.findUserByEmail(email)
        user.items = mutableMapOf()
        userRepo.save(user)
    }
    fun addItem(addItemDTO: AddItemDTO) {
        val user = userRepo.findUserByEmail(addItemDTO.email)
        val item = TodoItem(
            _id = ObjectId().toString(), addItemDTO.item.title,
            addItemDTO.item.description,
            addItemDTO.item.isDone,
        )
        user.items[item._id] = item
        userRepo.save(user)
    }
    fun updateItem(addItemDTO: AddItemDTO) {
        val user = userRepo.findUserByEmail(addItemDTO.email)
        user.items[addItemDTO.item._id]?.isDone =addItemDTO.item.isDone
        user.items[addItemDTO.item._id]?.title = addItemDTO.item.title
        user.items[addItemDTO.item._id]?.description = addItemDTO.item.description
        userRepo.save(user)
    }
//    fun deleteItem(id:String){
//        todoItemRepo.deleteById(id)
//    }
}

