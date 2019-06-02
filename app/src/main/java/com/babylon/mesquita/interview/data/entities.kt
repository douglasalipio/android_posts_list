package com.babylon.mesquita.interview.data


import android.os.Parcelable
import com.babylon.mesquita.interview.data.remote.*
import kotlinx.android.parcel.Parcelize
import java.security.SecureRandom
import kotlin.random.Random

@Parcelize
data class Post(
    var id: Int,
    var title: String,
    var body: String,
    var comments: List<Comment> = mutableListOf(),
    var author: Author,
    var tag: String
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
    var id: Int,
    var name: String,
    var email: String,
    var body: String,
    var postId: Int
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
        comments.add(Comment(it.id, it.name, it.email, it.body, postId))
    }
    return comments
}

fun List<PostResponse>.makePosts(
    commentResponse: List<CommentResponse>,
    authorResponse: List<AuthorResponse>,
    avatarsUrl: MutableList<String>
): List<Post> {
    val posts = mutableListOf<Post>()
    forEach { postResponse ->
        val commentsResponse = commentResponse.filter { comment -> postResponse.authorId == comment.postId }
        val author = authorResponse.makeAuthors().last { author -> postResponse.authorId == author.id }
        author.avatarUrl = avatarsUrl.last()
        avatarsUrl.removeAt(avatarsUrl.lastIndex)
        val comments = commentsResponse.makeComments(postResponse.id)
        val post = Post(postResponse.id, postResponse.title, postResponse.body, comments, author, loremIpsumTag())
        posts.add(post)
    }
    return posts
}

fun AvatarResponse.makeAvatars(): List<String> {
    val urlAvatars = mutableListOf<String>()
    results.forEach {
        urlAvatars.add(it.picture.large)
    }
    return urlAvatars
}

fun loremIpsumTag(): String {
    val randomTitle = arrayOf("odio adipisc", "vero eaque aliquid", "dolorem")
    val randomIndex = SecureRandom().nextInt(randomTitle.size)
    return randomTitle[randomIndex]
}

