package com.brafik.famous.features.feed.data

import com.brafik.famous.core.network.DemoHttpClient
import com.brafik.famous.core.network.HttpClient
import com.brafik.famous.features.feed.data.models.KtorFeedModel

class FeedKtorDataSource(
    private val httpClient: HttpClient = DemoHttpClient()
): FeedRemoteDataSource {
    override fun fetchNextChunk(
        token: String,
        postId: String,
        filters: List<String>
    ): List<KtorFeedModel> {
        return emptyList()
    }

}