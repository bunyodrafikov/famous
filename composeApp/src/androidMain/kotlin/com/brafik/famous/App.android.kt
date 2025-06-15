package com.brafik.famous

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.brafik.famous.core.database.getDatabaseBuilder
import com.brafik.famous.core.database.getRoomDatabase
import com.brafik.famous.core.di.InjectProvider

class AppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val appDatabase = getRoomDatabase(
            getDatabaseBuilder(applicationContext)
        )

        InjectProvider.addDependency("database", appDatabase)

        setContent { App() }
    }
}

@Preview
@Composable
fun AppPreview() { App() }
