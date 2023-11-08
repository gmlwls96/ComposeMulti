package ui.screen.all

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import ui.theme.AppTheme
import ui.theme.Colors


@Composable
fun AllScreen() {

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(AppTheme.dimensions.padding20)
        ) {
            item {
                TopBar()
                MyInfoRow(
                    userVo = UserVo("hj"),
                    moveMyInfo = {}
                )
                GraySpacer()
                Spacer(modifier = Modifier.height(AppTheme.dimensions.height24))
            }

            menuList(movePiScreen = {})

            item {
                GraySpacer()
                Text(
                    text = "로그아웃",
                    color = Colors.Gray700,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = AppTheme.dimensions.padding32)
                        .clickable {}
                )
            }
        }
    }
}

@Composable
fun TopBar() {
    Text(
        text = "전체",//stringResource(id = R.string.all),
        style = AppTheme.typography.noto22,
        modifier = Modifier.padding(vertical = AppTheme.dimensions.padding8)
    )
}

@Composable
fun GraySpacer() {
    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(AppTheme.dimensions.padding12)
            .background(color = Colors.Gray100)
    )
}


@OptIn(ExperimentalResourceApi::class)
@Composable
fun MyInfoRow(
    userVo: UserVo,
    moveMyInfo: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = AppTheme.dimensions.padding24)
    ) {
        Image(
            painter = painterResource("compose-multiplatform.xml"),
            contentDescription = null,
            modifier = Modifier
                .size(60.dp)
                .padding(end = AppTheme.dimensions.padding8)

        )
        Text(
            text = userVo.customerName,
            style = AppTheme.typography.noto20,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "내 정보",
            style = AppTheme.typography.noto13Regular,
            modifier = Modifier
                .background(
                    color = Colors.Gray200,
                    shape = RoundedCornerShape(AppTheme.dimensions.radius4)
                )
                .padding(AppTheme.dimensions.padding12)
                .align(Alignment.CenterVertically)
                .clickable { moveMyInfo() }
        )
    }
}

data class UserVo(
    val customerName: String
)