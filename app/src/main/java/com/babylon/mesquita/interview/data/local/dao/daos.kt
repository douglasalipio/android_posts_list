package com.babylon.mesquita.interview.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.Query
import com.babylon.mesquita.interview.data.remote.AuthorResponse
import com.babylon.mesquita.interview.data.remote.PostResponse

@Dao
interface PostDao {

    @Insert(onConflict = IGNORE)
    fun insertPost(person: PostResponse): Long

    @Query("SELECT * FROM post")
    fun getAllPosts(): List<PostResponse>
}

@Dao
interface AuthorDao {

    @Insert(onConflict = IGNORE)
    fun insertAuthor(author: AuthorResponse): Long

    @Query("SELECT * FROM post")
    fun getAllAuthors(): List<PostResponse>
}
