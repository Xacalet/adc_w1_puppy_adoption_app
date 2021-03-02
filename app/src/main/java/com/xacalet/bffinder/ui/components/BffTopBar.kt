package com.xacalet.bffinder.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.xacalet.bffinder.R
import com.xacalet.bffinder.ui.theme.NexaFontFamily

@Composable
fun BFFinderAppBar(
    navIcon: NavIcon,
    onClickNavigationIcon: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                fontFamily = NexaFontFamily,
                text = stringResource(id = R.string.app_name)
            )
        },
        navigationIcon = {
            IconButton(onClickNavigationIcon) {
                when (navIcon) {
                    is NavIcon.Logo -> {
                        Icon(
                            modifier = Modifier.size(28.dp),
                            painter = painterResource(R.drawable.ic_logo),
                            contentDescription = null
                        )
                    }
                    is NavIcon.Back -> {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = null
                        )
                    }
                }
            }
        }
    )
}

sealed class NavIcon {
    object Logo : NavIcon()
    object Back : NavIcon()
}
