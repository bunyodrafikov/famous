package com.brafik.famous.core.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

fun getDatabaseBuilder(context: Context): RoomDatabase.Builder<AppDatabase> {
    val applicationContext = context.applicationContext
    val databasePath = applicationContext.getDatabasePath(dbFileName)
    return Room.databaseBuilder<AppDatabase>(
        context = applicationContext,
        name = databasePath.absolutePath
    )
}