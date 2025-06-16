package com.brafik.famous.features.favourite.data

import com.brafik.famous.core.database.AppDatabase
import com.brafik.famous.core.di.InjectProvider

interface FavouriteLocalDataSource {
    suspend fun getFavouritePostIds(): List<String>
}

class FavouriteRoomDataSource(
    private val database: AppDatabase = InjectProvider.getDatabase()
): FavouriteLocalDataSource {
    override suspend fun getFavouritePostId(): List<String> {
        return emptyList()
    }
}