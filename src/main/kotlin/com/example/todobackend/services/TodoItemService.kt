package com.example.todobackend.services

import com.example.todobackend.entities.TodoItem
import com.example.todobackend.entities.dto.UpdateRequestDTO
import com.example.todobackend.repositories.TodoItemRepo
import org.springframework.stereotype.Service

@Service
class TodoItemService(private val todoItemRepo: TodoItemRepo) {

    fun getAllItems():List<TodoItem>{
        return todoItemRepo.findAll()
    }
    fun deleteAll(){
        return todoItemRepo.deleteAll()
    }
    fun addItem(itemInfo: TodoItem) {
        val item = TodoItem(
            null, itemInfo.title,
            itemInfo.description,
            itemInfo.isDone,
        )
        todoItemRepo.save(item)
    }
    fun updateItem(item: TodoItem) {
        val todoItem = item._id?.let { todoItemRepo.findTodoItemBy_id(it) }
        if (todoItem != null) {
            todoItem.isDone = item.isDone
            todoItem.title = item.title
            todoItem.description = item.description
            todoItemRepo.save(todoItem)
        }

    }
    fun deleteItem(id:String){
        todoItemRepo.deleteById(id)
    }
}

