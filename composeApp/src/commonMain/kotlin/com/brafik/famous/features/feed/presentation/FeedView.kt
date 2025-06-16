package com.brafik.famous.features.feed.presentation

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.brafik.famous.features.feed.presentation.model.FeedEvent
import com.brafik.famous.features.feed.presentation.model.FeedViewState
import com.brafik.famous.features.feed.presentation.views.FeedCell

@Composable
fun FeedView(viewState: FeedViewState, eventHandler: (FeedEvent) -> Unit) {
    LazyColumn {
        items(viewState.feed) {
            FeedCell(it)
        }
    }
}