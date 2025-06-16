package com.brafik.famous.features.feed.presentation

import androidx.lifecycle.viewModelScope
import com.brafik.famous.base.BaseViewModel
import com.brafik.famous.features.feed.domain.GetFeedUseCase
import com.brafik.famous.features.feed.presentation.model.FeedAction
import com.brafik.famous.features.feed.presentation.model.FeedEvent
import com.brafik.famous.features.feed.presentation.model.FeedViewState
import com.brafik.famous.features.feed.presentation.views.FeedCellModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FeedViewModel :
    BaseViewModel<FeedViewState, FeedAction, FeedEvent>(initialState = FeedViewState()) {
    private val getFeedUseCase = GetFeedUseCase()

    init {
        loadScreen()
    }

    override fun obtainEvent(viewEvent: FeedEvent) {
        when (viewEvent) {
            is FeedEvent.FilterClicked -> filterContent(viewEvent.filterId)
            is FeedEvent.PostClicked -> obtainPostClick(viewEvent.postId)
            FeedEvent.UserClicked -> showUserProfile()
            FeedEvent.LoadMore -> loadMoreFeed()
        }
    }

    private fun loadScreen() = viewModelScope.launch(Dispatchers.IO) {
        val feed = getFeedUseCase.execute().map {
            FeedCellModel(
                it.postId,
                "",
                it.title,
                it.topics.joinToString(","),
                "${it.likesCount} likes / ${it.repostCount} reposts",
                hasBlur = it.postId == "1",
            )
        }
        withContext(Dispatchers.Main) {
            viewState = viewState.copy(feed = feed)
        }
    }

    private fun filterContent(filterId: String) {
        TODO("Not yet implemented")
    }

    private fun obtainPostClick(postId: String) {
        TODO("Not yet implemented")
    }

    private fun showUserProfile() {
        TODO("Not yet implemented")
    }

    private fun loadMoreFeed() {
        TODO("Not yet implemented")
    }
}