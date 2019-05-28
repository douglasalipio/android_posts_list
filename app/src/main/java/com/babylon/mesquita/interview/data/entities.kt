package com.babylon.mesquita.interview.data

import com.babylon.mesquita.interview.data.remote.Address
import com.babylon.mesquita.interview.data.remote.Company

data class Post(
    val id: Int,
    val title: String,
    val body: String,
    val avatarUrl: String,
    val author: Author,
    val comments: List<Comment>
)

data class Author(
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val address: Address,
    val phone: String,
    val website: String,
    val company: Company
)

data class Comment(
    val post: Post,
    val id: Int,
    val name: String,
    val email: String,
    val body: String
)