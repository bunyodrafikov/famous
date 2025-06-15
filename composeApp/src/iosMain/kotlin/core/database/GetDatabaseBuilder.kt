package core.database

import androidx.room.Room
import androidx.room.RoomDatabase
import com.brafik.famous.core.database.AppDatabase
import com.brafik.famous.core.database.dbFileName
import platform.Foundation.NSHomeDirectory

fun getDatabaseBuilder(): RoomDatabase.Builder<AppDatabase> {
    val dbFilePath = NSHomeDirectory() + "/$dbFileName"
    return Room.databaseBuilder<AppDatabase>(
        dbFilePath,
        factory = { AppDatabase::class.instantiateImpl() }
    )
}