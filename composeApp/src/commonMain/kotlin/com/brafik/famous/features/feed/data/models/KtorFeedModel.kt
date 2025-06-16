package com.brafik.famous.features.feed.data.models

data class KtorFeedModel(
    val postId: String,
    val title: String,
    val likesCount: Int,
    val repostCount: Int,
    val topics: List<String>
)