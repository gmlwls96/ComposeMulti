package ui.screen.all

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ui.theme.AppTheme
import ui.theme.Colors

fun LazyListScope.menuList(
    movePiScreen: () -> Unit,
    menuList: List<TitleVo> = makeList(movePiScreen)
) {
    menuList.forEach { titleVo ->
        item {
            Text(
                text = titleVo.title,
                style = AppTheme.typography.noto15,
                modifier = Modifier.padding(AppTheme.dimensions.padding4)
            )
        }

        items(titleVo.contentList){
            MenuRow(title = it)
        }

        item {
            Spacer(modifier = Modifier.height(AppTheme.dimensions.height24))
        }
    }
}

private fun makeList(movePiScreen: () -> Unit) =
    listOf(
        TitleVo(
            title = "상품가입", //R.string.all_product_subscription,
            contentList = listOf("상품")
        ),
        TitleVo(
            title = "계좌",//R.string.all_account,
            contentList = listOf(
                "입출금",
                "내 계좌"
            )
        ),
        TitleVo(
            title = "투자",// R.string.all_investment,
            contentList = listOf(
                "나의 투자성향",
                "전문투자자 등록 / 해지"
            )
        ),
        TitleVo(
            title = "고객센터",//R.string.all_customer_center,
            contentList = listOf(
                "고객센터",
                "자주묻는질문",
                "자주묻는질문",
                "공지사항"
            )
        ),
        TitleVo(
            title = "내 전담직원",//R.string.all_my_staff,
            contentList = listOf(
                "전화상담",
                "챗봇상담",
            )
        ),
        TitleVo(
            title = "동의 내역",//R.string.all_consent_details,
            contentList = listOf(
                "서비스 이용약관",
                "개인정보 처리방침",
            )
        ),
    )

@Composable
fun MenuRow(
    title: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
) {
    Row(modifier = modifier.clickable { onClick() }) {
        Text(
            text = title,
            style = AppTheme.typography.noto15Regular,
            color = Colors.Gray1000,
            modifier = Modifier
                .padding(AppTheme.dimensions.padding8)
                .align(Alignment.CenterVertically)
        )
    }
}

data class TitleVo(
    val title: String,
    val contentList: List<String>
)
