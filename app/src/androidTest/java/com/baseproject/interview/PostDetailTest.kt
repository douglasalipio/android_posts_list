package com.baseproject.interview

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.babylon.mesquita.interview.R
import com.babylon.mesquita.interview.data.Post
import com.babylon.mesquita.interview.features.postdetail.PostDetailActivity
import com.baseproject.interview.dataSet.fakePost
import com.baseproject.interview.util.rotateOrientation
import com.baseproject.interview.util.rotateToLandscape
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class PostDetailTest {
    @Rule
    @JvmField
    var postDetailActivityTestRule =
        ActivityTestRule(PostDetailActivity::class.java,true, false)

    private val fakePost = fakePost()

    companion object {
        const val TITLE = "title"
        const val TAG = "tag"
        const val BODY = "body"
    }

    @Before
    fun setUp() {
        fakePost.title = TITLE
        fakePost.body = BODY
        fakePost.tag = TAG
    }

    @Test
    fun postDetails_DisplayedInUi() {
        loadPostDetail()
        onView(withId(R.id.postTag)).check(matches(withText(TAG)))
        onView(withId(R.id.postDetailTitle)).check(matches(withText(TITLE)))
        onView(withId(R.id.postBody)).check(matches(withText(BODY)))
    }

    @Test
    fun orientationChange_DisplayedInUi() {
        loadPostDetail()
        postDetailActivityTestRule.activity.rotateOrientation()
        onView(withId(R.id.postTag)).check(matches(withText(TAG)))
        onView(withId(R.id.postDetailTitle)).check(matches(withText(TITLE)))
        onView(withId(R.id.postBody)).check(matches(withText(BODY)))
    }

    @Test
    fun orientationLandscape_DisplayedInUi() {
        loadPostDetail()
        postDetailActivityTestRule.activity.rotateToLandscape()
        onView(withId(R.id.postTag)).check(matches(withText(TAG)))
        onView(withId(R.id.postDetailTitle)).check(matches(withText(TITLE)))
        onView(withId(R.id.postBody)).check(matches(withText(BODY)))
    }

    @Test
    fun openCommentScreen() {
        loadPostDetail()
        onView(withId(R.id.commentButton)).perform(click())
    }

    private fun loadPostDetail() = startActivityWithWithStubbedTask(fakePost)

    private fun startActivityWithWithStubbedTask(post: Post) {
        val startIntent = Intent().apply { putExtra(PostDetailActivity.EXTRA_POST_DETAIL, post) }
        postDetailActivityTestRule.launchActivity(startIntent)
    }
}