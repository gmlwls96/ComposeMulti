package ui.screen.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory
import ui.theme.AppTheme
import ui.theme.Colors

// https://github.com/icerockdev/moko-compose-multiplatform-template/blob/main/shared/src/commonMain/kotlin/SimpleScreen.kt

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = getViewModel(
        key = "login-screen",
        factory = viewModelFactory { LoginViewModel() }
    )
) {
    val email by viewModel.email.collectAsState()
    val password by viewModel.password.collectAsState()
    val fillState by viewModel.fillState.collectAsState(false)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Colors.Black)
            .padding(AppTheme.dimensions.padding20),
    ) {
        TextField(
            modifier = Modifier.fillMaxWidth()
                .height(AppTheme.dimensions.height56)
                .background(color = Colors.White),
            value = email,
            onValueChange = viewModel::changeEmail,
            label = {
                Text("email을 입력하세요")
            }
        )

        TextField(
            modifier = Modifier.fillMaxWidth()
                .height(AppTheme.dimensions.height56)
                .background(color = Colors.White),
            value = password,
            onValueChange = viewModel::changePassword,
            label = {
                Text("password를 입력하세요")
            }
        )

        Spacer(modifier = Modifier.weight(1f))

        TextButton(
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Colors.FintaBlue,
                contentColor = Colors.White,
                disabledBackgroundColor = Colors.Gray,
                disabledContentColor = Colors.White
            ),
            enabled = fillState,
            shape = RoundedCornerShape(AppTheme.dimensions.radius8),
            modifier = Modifier.padding(AppTheme.dimensions.padding10)
                .align(Alignment.CenterHorizontally),
            onClick = {},
        ) {
            Text(text = "로그인")
        }
    }
}
