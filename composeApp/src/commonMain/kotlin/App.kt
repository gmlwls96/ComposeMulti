import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import ui.screen.Screen
import ui.screen.all.AllScreen
import ui.screen.login.LoginScreen
import ui.screen.start.StartScreen

@Composable
fun App() {
    MaterialTheme {
        Main()
    }
}


@Composable
fun Main() {
    var nav by rememberSaveable{
        mutableStateOf(Screen.START.name)
    }

    when(nav){
        Screen.START.name -> {
            StartScreen { nav = Screen.LOGIN.name }
        }
        Screen.LOGIN.name -> {
            LoginScreen(moveNext = {nav = Screen.ALL.name})
        }
        Screen.ALL.name -> {
            AllScreen()
        }
    }
}