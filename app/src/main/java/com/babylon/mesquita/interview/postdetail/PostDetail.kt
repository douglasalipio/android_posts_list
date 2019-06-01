package com.babylon.mesquita.interview.postdetail

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import com.babylon.mesquita.interview.R

import kotlinx.android.synthetic.main.activity_post_detail.*

class PostDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_detail)
        initToolbar()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
    private fun initToolbar() {
        setSupportActionBar(postDetailToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }
}
