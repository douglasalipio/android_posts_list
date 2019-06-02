package com.baseproject.interview

import com.babylon.mesquita.interview.data.loremIpsumTag
import com.babylon.mesquita.interview.data.makeAuthors
import com.babylon.mesquita.interview.data.makeAvatars
import com.babylon.mesquita.interview.data.makeComments
import com.babylon.mesquita.interview.data.remote.AuthorResponse
import com.babylon.mesquita.interview.data.remote.CommentResponse
import com.baseproject.interview.dataSet.*
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull

import org.junit.Test

class PostTest {

    @Test
    fun `should make an author`() {
        val container = mutableListOf<AuthorResponse>()
        val fakeAuthorResponse = fakeAuthorResponse()
        container.add(fakeAuthorResponse)
        val fakeAuthor = container.makeAuthors().last()

        assertEquals(fakeAuthorResponse.id, fakeAuthor.id)
        assertEquals(fakeAuthorResponse.address.city, fakeAuthor.address.city)
        assertEquals(fakeAuthorResponse.company.name, fakeAuthor.company.name)
        assertEquals(fakeAuthorResponse.email, fakeAuthor.email)
        assertEquals(fakeAuthorResponse.username, fakeAuthor.username)
        assertEquals(fakeAuthorResponse.website, fakeAuthor.website)
        assertEquals(fakeAuthorResponse.phone, fakeAuthor.phone)
        assertEquals(fakeAuthorResponse.name, fakeAuthor.name)
    }

    @Test
    fun `should make an comment`() {
        val container = mutableListOf<CommentResponse>()
        val fakeCommentResponse = fakeCommentResponse()
        container.add(fakeCommentResponse)
        val fakeComment = container.makeComments(fakeCommentResponse.postId).last()

        assertEquals(fakeCommentResponse.id, fakeComment.id)
        assertEquals(fakeCommentResponse.body, fakeComment.body)
        assertEquals(fakeCommentResponse.email, fakeComment.email)
        assertEquals(fakeCommentResponse.postId, fakeComment.postId)
        assertEquals(fakeCommentResponse.name, fakeComment.name)
    }

    @Test
    fun `should return an empty author list`() {
        val authorResponse = mutableListOf<AuthorResponse>()
        assert(authorResponse.makeAuthors().isEmpty())
    }

    @Test
    fun `should return an title`() {
        assertNotNull(loremIpsumTag())
    }

    @Test
    fun `should return an avatar list`() {
        val fakeAvatarResponse = fakeAvatarUrl()
        fakeAvatarResponse?.let {
            val fakeUrls = fakeAvatarResponse.makeAvatars()
            if (fakeUrls.isNotEmpty())
                assert(true)
            else
                assert(false)
        }
    }
}