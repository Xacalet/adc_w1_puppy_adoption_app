package com.xacalet.bffinder.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.xacalet.bffinder.R
import com.xacalet.bffinder.data.Dog
import com.xacalet.bffinder.ui.theme.Typography
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun DogAdoptedDialog(adoptedDog: Dog, setAdoptedDog: (Dog?) -> Unit) {
    Dialog(onDismissRequest = { }) {
        Surface(shape = RoundedCornerShape(8.dp)) {
            Column(
                modifier = Modifier
                    .background(MaterialTheme.colors.primarySurface)
                    .width(250.dp)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(R.string.congratulations),
                    color = contentColorFor(MaterialTheme.colors.primarySurface),
                    style = Typography.h2
                )
                Spacer(modifier = Modifier.size(32.dp))
                CoilImage(
                    modifier = Modifier
                        .size(128.dp)
                        .clip(CircleShape)
                        .border(
                            width = 8.dp,
                            color = contentColorFor(MaterialTheme.colors.primarySurface),
                            shape = CircleShape
                        ),
                    data = adoptedDog.picUrl,
                    contentScale = ContentScale.Crop,
                    contentDescription = null
                )
                Spacer(modifier = Modifier.size(32.dp))
                Text(
                    text = stringResource(R.string.congratulations_message, adoptedDog.name),
                    color = contentColorFor(MaterialTheme.colors.primarySurface),
                    style = Typography.body1.copy(textAlign = TextAlign.Center)
                )
                Spacer(modifier = Modifier.size(32.dp))
                OutlinedButton(
                    onClick = { setAdoptedDog(null) }
                ) {
                    Text(stringResource(R.string.great).toUpperCase())
                }
            }
        }
    }
}