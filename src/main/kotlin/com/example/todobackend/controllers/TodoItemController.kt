package com.example.todobackend.controllers

import com.example.todobackend.entities.TodoItem
import com.example.todobackend.entities.dto.UpdateRequestDTO
import com.example.todobackend.services.TodoItemService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = ["/todo"])
class TodoItemController(private val todoItemService: TodoItemService) {
    @GetMapping("/items")
    fun getItems():ResponseEntity<List<TodoItem>>{
        return ResponseEntity.ok(todoItemService.getAllItems())
    }

    @PostMapping("/add")
    fun addItem(@RequestBody todoItem: TodoItem): ResponseEntity<HttpStatus> {
        todoItemService.addItem(todoItem)
        return ResponseEntity.ok(HttpStatus.ACCEPTED)
    }

    @PostMapping("/update")
    fun updateItem(@RequestBody todoItem: TodoItem):ResponseEntity<HttpStatus>{
        todoItemService.updateItem(todoItem)
        return ResponseEntity.ok(HttpStatus.ACCEPTED)
    }

    @DeleteMapping("/delete")
    fun deleteItem(@RequestParam _id:String):ResponseEntity<HttpStatus>{
        todoItemService.deleteItem(_id)
        return ResponseEntity.ok(HttpStatus.ACCEPTED)
    }

    @DeleteMapping("delete/all")
    fun deleteAll():ResponseEntity<HttpStatus>{
        todoItemService.deleteAll()
        return ResponseEntity.ok(HttpStatus.ACCEPTED)
    }
}
