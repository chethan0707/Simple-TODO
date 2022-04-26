package com.example.todobackend.entities

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document(collection = "items")
class TodoItem (
       @Id
        var _id:String,
       @Field("title")
       var title:String,
        @Field("description")
       var description:String,
       @Field("is_done")
       var isDone:Boolean
        )