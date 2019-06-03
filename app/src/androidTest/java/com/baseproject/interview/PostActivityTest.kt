package com.baseproject.interview

import android.content.Context
import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.babylon.mesquita.interview.R
import com.babylon.mesquita.interview.data.Post
import com.babylon.mesquita.interview.features.comment.CommentActivity
import com.babylon.mesquita.interview.features.post.PostActivity
import com.baseproject.interview.dataSet.fakePost
import com.baseproject.interview.dataSet.recyclerViewAtPositionOnView
import com.baseproject.interview.dataSet.recyclerViewSizeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class PostActivityTest {

    @Rule
    @JvmField
    var postDetailActivityTestRule =
        ActivityTestRule(PostActivity::class.java, true, false)

    @Test
    fun scrollToItemBelowFold_clickOnItem() {
        loadPost()
        onView(ViewMatchers.withId(R.id.postRecyclerView))
            .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(5, click()))
    }

    private fun loadPost() = startActivityWithWithStubbedTask()

    private fun startActivityWithWithStubbedTask() {
        val startIntent = Intent()
        postDetailActivityTestRule.launchActivity(startIntent)
    }
}