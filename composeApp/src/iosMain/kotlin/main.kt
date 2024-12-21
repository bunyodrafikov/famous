import androidx.compose.ui.window.ComposeUIViewController
import com.brafik.famous.App
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController { App() }
