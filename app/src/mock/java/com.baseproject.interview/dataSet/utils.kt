package com.baseproject.interview.dataSet

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.matcher.BoundedMatcher
import org.hamcrest.Description
import org.hamcrest.Matcher
import kotlin.random.Random
import androidx.annotation.NonNull
import android.widget.TextView






fun numberRandom(): Int {
    val randomNumber = List(10) { Random.nextInt(0, 10) }
    return randomNumber[Random.nextInt(randomNumber.size)]
}

fun stringRandom(): String {
    val source = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    return (1..source.length)
        .map { Random.nextInt(0, source.length) }
        .map(source::get)
        .joinToString("")
}

fun recyclerViewSizeMatcher(matcherSize: Int): Matcher<View> {
    return object : BoundedMatcher<View, RecyclerView>(RecyclerView::class.java) {
        override fun describeTo(description: Description) {
            description.appendText("with list size: $matcherSize")
        }

        override fun matchesSafely(recyclerView: RecyclerView): Boolean {
            return matcherSize == recyclerView.adapter!!.itemCount
        }
    }
}

fun recyclerViewAtPositionOnView(position: Int, itemMatcher: Matcher<View>, targetViewId: Int): Matcher<View> {
    return object : BoundedMatcher<View, RecyclerView>(RecyclerView::class.java) {
        override fun describeTo(description: Description) {
            description.appendText("has view id $itemMatcher at position $position")
        }

        public override fun matchesSafely(recyclerView: RecyclerView): Boolean {
            val viewHolder = recyclerView.findViewHolderForAdapterPosition(position)
            val targetView = viewHolder!!.itemView.findViewById<View>(targetViewId)
            return itemMatcher.matches(targetView)
        }
    }
}

fun textViewTextColorMatcher(matcherColor: Int): Matcher<View> {
    return object : BoundedMatcher<View, TextView>(TextView::class.java) {
        override fun describeTo(description: Description) {
            description.appendText("with text color: $matcherColor")
        }

        override fun matchesSafely(textView: TextView): Boolean {
            return matcherColor == textView.currentTextColor
        }
    }
}