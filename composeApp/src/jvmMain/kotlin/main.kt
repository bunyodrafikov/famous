import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import java.awt.Dimension
import com.brafik.famous.App
import com.brafik.famous.core.database.getRoomDatabase
import com.brafik.famous.core.di.InjectProvider
import core.database.getDatabaseBuilder

fun main() = application {
    Window(
        title = "Famous",
        state = rememberWindowState(width = 800.dp, height = 600.dp),
        onCloseRequest = ::exitApplication,
    ) {
        window.minimumSize = Dimension(350, 600)
        val appDatabase = getRoomDatabase(
            getDatabaseBuilder()
        )
        InjectProvider.addDependency("database", appDatabase)
        App()
    }
}

@Preview
@Composable
fun AppPreview() { App() }