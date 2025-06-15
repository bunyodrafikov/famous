package com.brafik.famous.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.brafik.famous.features.drafts.data.DraftDao
import com.brafik.famous.features.drafts.data.DraftEntity

@Database(entities = [DraftEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun getDraftDao(): DraftDao
}

internal const val dbFileName = "appfamous.db"