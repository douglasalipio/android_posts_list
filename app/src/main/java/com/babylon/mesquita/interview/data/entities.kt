package com.babylon.mesquita.interview.data

import com.babylon.mesquita.interview.data.remote.*

data class Post(
    var id: Int,
    var title: String,
    var body: String,
    var comments: List<Comment> = mutableListOf(),
    var author: Author
)

data class Author(
    var id: Int,
    var name: String,
    var username: String,
    var email: String,
    var address: Address,
    var phone: String,
    var website: String,
    var company: Company,
    var avatarUrl: String
)

data class Comment(
    var postId: Int,
    var id: Int,
    var name: String,
    var email: String,
    var body: String
)

private fun List<AuthorResponse>.convertToAuthors(): List<Author> {
    val authors = mutableListOf<Author>()
    forEach {
        authors.add(
            Author(
                it.id,
                it.name,
                it.username,
                it.email,
                it.address,
                it.phone,
                it.website,
                it.company,
                it.urlAvatar
            )
        )
    }
    return authors
}

private fun List<CommentResponse>.convertToComments(postId: Int): List<Comment> {
    val comments = mutableListOf<Comment>()
    forEach {
        comments.add(Comment(postId, it.id, it.name, it.email, it.body))
    }
    return comments
}

fun List<PostResponse>.assignAtributes(commentResponse: List<CommentResponse>, authorResponse: List<AuthorResponse>) {
    val posts = mutableListOf<Post>()
    forEach { postResponse ->
        val postComments = commentResponse.filter { postResponse.authorId == it.postId }
        val postAuthor = authorResponse.convertToAuthors().last { postResponse.authorId == it.id }
        posts.add(
            Post(
                postResponse.id,
                postResponse.title,
                postResponse.body,
                postComments.convertToComments(postResponse.id),
                postAuthor
            )
        )
    }
}
