package com.brafik.famous.features.feed.presentation.model

import com.brafik.famous.features.feed.presentation.views.FeedCellModel

data class FeedViewState(
    val feed: List<FeedCellModel> = emptyList(),
    val filters: List<String> = emptyList(),
)