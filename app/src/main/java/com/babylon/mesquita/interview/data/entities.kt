package com.babylon.mesquita.interview.data


import android.os.Parcelable
import com.babylon.mesquita.interview.data.remote.*
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Post(
    var id: Int,
    var title: String,
    var body: String,
    var comments: List<Comment> = mutableListOf(),
    var author: Author
) : Parcelable

@Parcelize
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
) : Parcelable

@Parcelize
data class Comment(
    var postId: Int,
    var id: Int,
    var name: String,
    var email: String,
    var body: String
) : Parcelable

private fun List<AuthorResponse>.makeAuthors(): List<Author> {
    val authors = mutableListOf<Author>()
    forEach {
        val author = Author(
            it.id, it.name, it.username, it.email, it.address,
            it.phone, it.website, it.company, RANDOM_IMAGE
        )
        authors.add(author)
    }
    return authors
}

private fun List<CommentResponse>.makeComments(postId: Int): List<Comment> {
    val comments = mutableListOf<Comment>()
    forEach {
        comments.add(Comment(postId, it.id, it.name, it.email, it.body))
    }
    return comments
}

fun List<PostResponse>.makePosts(
    commentResponse: List<CommentResponse>,
    authorResponse: List<AuthorResponse>
): List<Post> {
    val posts = mutableListOf<Post>()
    forEach {
        val commentsResponse = commentResponse.filter { comment -> it.authorId == comment.postId }
        val author = authorResponse.makeAuthors().last { author -> it.authorId == author.id }
        val comments = commentsResponse.makeComments(it.id)
        val post = Post(it.id, it.title, it.body, comments, author)
        posts.add(post)
    }
    return posts
}
