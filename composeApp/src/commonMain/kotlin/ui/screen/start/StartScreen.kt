package ui.screen.start

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import ui.theme.AppTheme
import ui.theme.Colors

@OptIn(ExperimentalResourceApi::class)
@Composable
fun StartScreen(moveLogin: () -> Unit) {
    Column(
        Modifier
            .fillMaxSize()
            .background(Colors.Black)
            .padding(AppTheme.dimensions.padding20),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(AppTheme.dimensions.margin60))
        Text(
            text = "간편하고\n손쉬운 투자",//stringResource(MR.strings.login_title),
            style = AppTheme.typography.noto22,
            color = Colors.White
        )
        Spacer(modifier = Modifier.height(AppTheme.dimensions.margin16))

        Text(
            text = "계좌개설부터 고액투자까지\n쉽고 간편하게 내 손안에서",//stringResource(MR.strings.login_sub_title),
            style = AppTheme.typography.noto15Regular,
            color = Colors.Gray200
        )

        Image(
            modifier = Modifier.fillMaxWidth(fraction = 0.7f)
                .aspectRatio(1f),
            painter = painterResource("compose-multiplatform.xml"),
            contentDescription = null
        )

        Spacer(modifier = Modifier.weight(1f))

        TextButton(
            onClick = moveLogin,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Colors.FintaBlue,
                contentColor = Colors.White,
                disabledBackgroundColor = Colors.Gray,
                disabledContentColor = Colors.White
            ),
            shape = RoundedCornerShape(AppTheme.dimensions.radius8),
            modifier = Modifier.padding(AppTheme.dimensions.padding10)
                .align(Alignment.CenterHorizontally)
            ,
        ) {
            Text(
                text = "간편 로그인"//stringResource(MR.strings.login_bt)
            )
        }
    }
}