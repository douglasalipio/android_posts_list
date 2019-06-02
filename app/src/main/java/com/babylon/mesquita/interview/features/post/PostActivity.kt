package com.babylon.mesquita.interview.features.post

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.babylon.mesquita.interview.R
import com.babylon.mesquita.interview.data.Post
import com.babylon.mesquita.interview.features.postdetail.PostDetailActivity
import com.babylon.mesquita.interview.features.postdetail.PostDetailActivity.Companion.EXTRA_POST_DETAIL
import com.google.android.material.navigation.NavigationView
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.post.*
import kotlinx.android.synthetic.main.app_bar.*
import kotlinx.android.synthetic.main.post_content.*
import javax.inject.Inject


class PostActivity : DaggerAppCompatActivity(), PostContract.View, NavigationView.OnNavigationItemSelectedListener {

    @Inject
    internal lateinit var postPresenter: PostContract.Presenter
    private val postClick: (Post) -> Unit = this::onPostClick
    private val adapter = PostAdapter(postClick)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.post)
        postPresenter.takeView(this)
        postPresenter.loadDataBlog()
        setSupportActionBar(postToolbar)
        initComponents()
    }

    private fun initComponents() {
        val navView: NavigationView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            postToolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
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
            R.id.nav_home -> ""
            R.id.nav_share -> ""
        }
        drawerLayout?.closeDrawer(GravityCompat.START)
        return true
    }


    override fun showPosts(posts: List<Post>) {
        adapter.addAll(posts)
        postList?.let {
            it.layoutManager = LinearLayoutManager(this)
            it.adapter = adapter
        }
    }

    private fun onPostClick(post: Post) {
        val intent = Intent(this, PostDetailActivity::class.java)
        intent.putExtra(EXTRA_POST_DETAIL, post)
        startActivity(intent)
    }

    override fun showDataError() {
        Toast.makeText(this, "Something unexpected occurred.", Toast.LENGTH_LONG).show()
    }
}

