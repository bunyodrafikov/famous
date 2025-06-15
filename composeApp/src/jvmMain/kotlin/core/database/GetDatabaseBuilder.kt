package core.database

import androidx.room.Room
import androidx.room.RoomDatabase
import com.brafik.famous.core.database.AppDatabase
import com.brafik.famous.core.database.dbFileName
import java.io.File

fun getDatabaseBuilder(): RoomDatabase.Builder<AppDatabase> {
    val dbFile = File(System.getProperty("java.io.tmpdir"), dbFileName)
    return Room.databaseBuilder<AppDatabase>(name = dbFile.absolutePath)
}