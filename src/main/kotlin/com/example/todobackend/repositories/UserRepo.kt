package com.example.todobackend.repositories

import com.example.todobackend.entities.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query

interface UserRepo:MongoRepository<User,String> {
    fun findUserByEmail(email:String):User
//    fun deleteItems(id:String)
}