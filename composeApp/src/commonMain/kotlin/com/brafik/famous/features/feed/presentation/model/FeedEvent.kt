package com.brafik.famous.features.feed.presentation.model

sealed class FeedEvent {
    class PostClicked(val postId: String) : FeedEvent()
    class FilterClicked(val filterId: String) : FeedEvent()
    data object UserClicked : FeedEvent()
    data object LoadMore : FeedEvent()
}