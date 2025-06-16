package com.brafik.famous.features.feed

import com.brafik.famous.base.BaseViewModel
import com.brafik.famous.features.feed.model.FeedAction
import com.brafik.famous.features.feed.model.FeedEvent
import com.brafik.famous.features.feed.model.FeedViewState

class FeedViewModel(): BaseViewModel<FeedViewState, FeedAction, FeedEvent>(initialState = FeedViewState()) {
    override fun obtainEvent(viewEvent: FeedEvent) {

    }
}