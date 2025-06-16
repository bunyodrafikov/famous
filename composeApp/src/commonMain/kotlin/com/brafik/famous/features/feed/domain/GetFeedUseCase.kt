package com.brafik.famous.features.feed.domain

import com.brafik.famous.features.favourite.data.FavouriteLocalDataSource
import com.brafik.famous.features.favourite.data.FavouriteRoomDataSource
import com.brafik.famous.features.feed.data.FeedKtorDataSource
import com.brafik.famous.features.feed.data.FeedRemoteDataSource
import com.brafik.famous.features.feed.domain.model.Feed
import com.brafik.famous.features.feed.domain.model.mapToFeed
import com.brafik.famous.features.login.data.AuthEncryptedDataSource
import com.brafik.famous.features.login.data.AuthLocalDataSource

class GetFeedUseCase(
    private val authLocalDataSource: AuthLocalDataSource = AuthEncryptedDataSource(),
    private val favouriteLocalDataSource: FavouriteLocalDataSource = FavouriteRoomDataSource(),
    private val feedRemoteDataSource: FeedRemoteDataSource = FeedKtorDataSource(),
) {
    suspend fun execute(): List<Feed> {
        val token = authLocalDataSource.checkToken()
        val favourites = favouriteLocalDataSource.getFavouritePosts()
        val feed = feedRemoteDataSource.fetchNextChunk(token, "", emptyList())
            .map { it.mapToFeed(favourites.contains(it.postId)) }
        return feed
    }
}