package com.babylon.mesquita.interview.util

import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.GridLayoutManager


abstract class InfiniteScrollListener(private val layoutManager: GridLayoutManager) : RecyclerView.OnScrollListener() {

    private var minItemsBeforeNextLoad = 5
    private val startingPage = 1
    private var currentPage = 1
    private var latestTotalItemCount = 0
    private var isLoading = true

    init {
        minItemsBeforeNextLoad *= layoutManager.spanCount
    }

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        val lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition()
        val totalItemCount = layoutManager.itemCount

        // Assume list was invalidated -- set back to default
        if (totalItemCount < latestTotalItemCount) {
            this.currentPage = this.startingPage
            this.latestTotalItemCount = totalItemCount
        }

        // If still loading and dataset size has been updated,
        // update load state and last item count
        if (isLoading && totalItemCount > latestTotalItemCount) {
            isLoading = false
            latestTotalItemCount = totalItemCount
        }

        // If not loading and within threashold limit, increase current page and load more data
        if (!isLoading && lastVisibleItemPosition + minItemsBeforeNextLoad > totalItemCount) {
            currentPage++
            onLoadMore(currentPage, totalItemCount, recyclerView)
            isLoading = true
        }
    }

    abstract fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView)
}