package com.babylon.mesquita.interview.post

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.babylon.mesquita.interview.R
import com.babylon.mesquita.interview.data.Post
import com.google.android.material.navigation.NavigationView
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar.*
import kotlinx.android.synthetic.main.content_post.*
import javax.inject.Inject

class PostActivity : DaggerAppCompatActivity(), PostContract.View, NavigationView.OnNavigationItemSelectedListener {

    @Inject
    internal lateinit var postPresenter: PostContract.Presenter
    private val postClick: (Int) -> Unit = this::onPostClick


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        postPresenter.takeView(this)
        postPresenter.loadPosts()
        setSupportActionBar(toolbar)
        initComponents()
    }

    private fun initComponents() {
        val navView: NavigationView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navView.setNavigationItemSelectedListener(this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main2, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onBackPressed() {
        drawerLayout?.let {
            if (it.isDrawerOpen(GravityCompat.START)) {
                it.closeDrawer(GravityCompat.START)
            } else {
                super.onBackPressed()
            }
        }
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.nav_gallery -> {

            }
            R.id.nav_home -> {
                // Handle the camera action
            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_tools -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }
        drawerLayout?.closeDrawer(GravityCompat.START)
        return true
    }

    override fun showPosts(posts: List<Post>) {
        val adapter = PostAdapter(postClick)
        adapter.addAll(posts)
        postList?.let {
            it.layoutManager = LinearLayoutManager(this)
            it.adapter = adapter
        }
    }

    private fun onPostClick(postion: Int) {

    }

    override fun showDataError() {
        Log.e("test", "feature error.")
    }
}

