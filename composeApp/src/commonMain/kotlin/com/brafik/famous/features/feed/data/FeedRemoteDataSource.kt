package com.brafik.famous.features.feed.data

import com.brafik.famous.features.feed.data.models.KtorFeedModel

interface FeedRemoteDataSource {
    fun fetchNextChunk(token: String, postId: String, filters: List<String>): List<KtorFeedModel>
}