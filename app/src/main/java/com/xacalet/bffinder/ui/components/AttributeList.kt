package com.xacalet.bffinder.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ProvideTextStyle
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Assignment
import androidx.compose.material.icons.filled.Timer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.xacalet.bffinder.R
import com.xacalet.bffinder.data.Dog
import com.xacalet.bffinder.ui.list.formatMonths
import com.xacalet.bffinder.ui.theme.Typography

@Composable
fun AttributeList(
    modifier: Modifier = Modifier,
    dog: Dog
) {
    Column(modifier) {
        ProvideTextStyle(value = Typography.caption) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Filled.Assignment,
                    tint = MaterialTheme.colors.primary,
                    contentDescription = null
                )
                Spacer(Modifier.size(8.dp))
                Text(text = dog.breed)
            }
            Spacer(modifier = Modifier.size(4.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_gender),
                    tint = MaterialTheme.colors.primary,
                    contentDescription = null
                )
                Spacer(Modifier.size(8.dp))
                Text(text = dog.gender)
            }
            Spacer(modifier = Modifier.size(4.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Filled.Timer,
                    tint = MaterialTheme.colors.primary,
                    contentDescription = null
                )
                Spacer(Modifier.size(8.dp))
                Text(text = formatMonths(dog.months))
            }
        }
    }
}