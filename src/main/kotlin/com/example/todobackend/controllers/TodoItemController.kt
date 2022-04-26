package com.example.todobackend.controllers

import com.example.todobackend.entities.AddItemDTO
import com.example.todobackend.entities.AddUserDTO
import com.example.todobackend.entities.TodoItem
import com.example.todobackend.entities.User
import com.example.todobackend.services.TodoItemService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = ["/todo"])
class TodoItemController(private val todoItemService: TodoItemService) {
    @GetMapping("/items")
    fun getItems(@RequestParam email:String):ResponseEntity<List<TodoItem>>{
        return ResponseEntity.ok(todoItemService.getAllItems(email).values.toList())
    }

    @PostMapping("user/add")
    fun createUser(@RequestBody user: AddUserDTO){
        todoItemService.createUser(user)
    }

    @PostMapping("/add")
    fun addItem(@RequestBody addItemDTO: AddItemDTO): ResponseEntity<HttpStatus> {
        todoItemService.addItem(addItemDTO)
        return ResponseEntity.ok(HttpStatus.ACCEPTED)
    }

    @PostMapping("/update")
    fun updateItem(@RequestBody addItemDTO: AddItemDTO):ResponseEntity<HttpStatus>{
        todoItemService.updateItem(addItemDTO)
        return ResponseEntity.ok(HttpStatus.ACCEPTED)
    }

    @DeleteMapping("/delete")
    fun deleteItem(@RequestParam _id:String,@RequestParam email: String):ResponseEntity<HttpStatus>{
        todoItemService.deleteItem(_id,email)
        return ResponseEntity.ok(HttpStatus.ACCEPTED)
    }

    @DeleteMapping("delete/all")
    fun deleteAll(@RequestParam email: String):ResponseEntity<HttpStatus>{
        todoItemService.deleteAll(email)
        return ResponseEntity.ok(HttpStatus.ACCEPTED)
    }
}
