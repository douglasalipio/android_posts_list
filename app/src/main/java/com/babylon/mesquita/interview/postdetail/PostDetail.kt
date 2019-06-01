package com.babylon.mesquita.interview.postdetail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.post_detail_container.*
import android.view.MenuItem


class PostDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(com.babylon.mesquita.interview.R.layout.post_detail_container)
        super.onCreate(savedInstanceState)
        initToolbar()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initToolbar() {
        postDetailToolbar.let {
            setSupportActionBar(it)
            supportActionBar?.setDisplayShowTitleEnabled(false)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setDisplayShowHomeEnabled(true)
        }
    }
}
