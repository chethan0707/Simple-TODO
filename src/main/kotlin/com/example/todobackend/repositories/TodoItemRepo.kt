package com.example.todobackend.repositories

import com.example.todobackend.entities.TodoItem
import org.springframework.data.mongodb.repository.MongoRepository

interface TodoItemRepo:MongoRepository<TodoItem,String> {
    fun findTodoItemBy_id(title:String):TodoItem
}