package com.baseproject.interview

import android.content.Context
import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.babylon.mesquita.interview.R
import com.babylon.mesquita.interview.data.Post
import com.babylon.mesquita.interview.features.comment.CommentActivity
import com.baseproject.interview.dataSet.fakePost
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import com.baseproject.interview.dataSet.recyclerViewAtPositionOnView
import com.baseproject.interview.dataSet.recyclerViewSizeMatcher
import com.baseproject.interview.dataSet.textViewTextColorMatcher


class CommentActivityTest {

    @Rule
    @JvmField
    var postDetailActivityTestRule =
        ActivityTestRule(CommentActivity::class.java, true, false)

    private val fakePost = fakePost()
    @Before
    fun setUp() {
        fakePost.title = PostDetailActivityTest.TITLE
        fakePost.body = PostDetailActivityTest.BODY
        fakePost.tag = PostDetailActivityTest.TAG
    }

    @Test
    fun scrollToItemBelowFold_clickOnItem() {
        loadComments()
        onView(withId(R.id.commentsRecyclerView))
            .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(5, click()))
    }

    @Test
    fun commentRecyclerSize() {
        loadComments()
        onView(withId(R.id.commentsRecyclerView)).check(matches(recyclerViewSizeMatcher(fakePost.comments.size)))
    }

    @Test
    fun fixedTextInCommentCardView() {
        loadComments()
        onView(withId(R.id.commentsRecyclerView)).check(
            matches(
                recyclerViewAtPositionOnView(
                    2,
                    withText(getApplicationContext<Context>().resources.getString(R.string.comment_action_replay)),
                    R.id.commentReplay
                )
            )
        )
        onView(withId(R.id.commentsRecyclerView)).check(
            matches(
                recyclerViewAtPositionOnView(
                    2,
                    withText(getApplicationContext<Context>().resources.getString(R.string.comment_action_flag)),
                    R.id.commentFlag
                )
            )
        )
        onView(withId(R.id.commentsRecyclerView)).check(
            matches(
                recyclerViewAtPositionOnView(
                    2,
                    withText(getApplicationContext<Context>().resources.getString(R.string.comment_action_recommend)),
                    R.id.commentRecommend
                )
            )
        )
    }

    private fun loadComments() = startActivityWithWithStubbedTask(fakePost)

    private fun startActivityWithWithStubbedTask(post: Post) {
        val startIntent = Intent().apply { putExtra(CommentActivity.EXTRA_COMMENTS, post) }
        postDetailActivityTestRule.launchActivity(startIntent)
    }
}