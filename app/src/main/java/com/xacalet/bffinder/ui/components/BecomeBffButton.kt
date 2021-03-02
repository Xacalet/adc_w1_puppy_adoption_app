package com.xacalet.bffinder.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.xacalet.bffinder.R
import com.xacalet.bffinder.data.Dog

@Composable
fun BecomeBffButton(
    modifier: Modifier = Modifier,
    dog: Dog,
    onClick: (Dog) -> Unit
) {
    Button(
        modifier = modifier,
        enabled = !dog.isBff,
        onClick = { onClick(dog) }
    ) {
        if (dog.isBff) {
            Text(stringResource(R.string.already_your_bff))
        } else {
            Icon(
                imageVector = Icons.Filled.Favorite,
                contentDescription = null
            )
            Spacer(Modifier.size(16.dp))
            Text(stringResource(R.string.become_bff))
        }
    }
}
