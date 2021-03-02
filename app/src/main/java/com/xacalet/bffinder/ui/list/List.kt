package com.xacalet.bffinder.ui.list

import androidx.annotation.PluralsRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Assignment
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Timer
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.xacalet.bffinder.R
import com.xacalet.bffinder.data.Dog
import com.xacalet.bffinder.ui.theme.BFFinderTheme
import com.xacalet.bffinder.ui.theme.NexaFontFamily
import com.xacalet.bffinder.ui.theme.Typography
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun BFFinderAppBar() {
    TopAppBar(
        title = {
            Text(
                fontFamily = NexaFontFamily,
                text = stringResource(id = R.string.app_name)
            )
        },
        navigationIcon = {
            IconButton({}) {
                Icon(
                    modifier = Modifier.size(28.dp),
                    painter = painterResource(R.drawable.ic_logo),
                    contentDescription = null
                )
            }
        }
    )
}

@Composable
fun DogListScreen(dogs: List<Dog>, adoptDog: (Dog) -> Unit) {
    Surface(color = MaterialTheme.colors.background) {
        Scaffold(
            topBar = { BFFinderAppBar() }
        ) {
            val (adoptedDog, setAdoptedDog) = remember { mutableStateOf<Dog?>(null) }
            LazyColumn(
                contentPadding = PaddingValues(16.dp),
            ) {
                items(dogs.size) { index ->
                    Box(modifier = Modifier.padding(8.dp)) {
                        DogListItem(dogs[index]) { dog ->
                            adoptDog(dog)
                            setAdoptedDog(dog)
                        }
                    }
                }
            }
            adoptedDog?.let { dog ->
                DogAdoptedDialog(
                    adoptedDog = dog,
                    setAdoptedDog = setAdoptedDog
                )
            }
        }
    }
}


@Composable
fun DogListItem(dog: Dog, setAdoptedDog: (Dog) -> Unit) {
    Card(shape = RoundedCornerShape(8.dp)) {
        Column {
            Box(
                Modifier
                    .height(240.dp)
                    .fillMaxWidth()
            ) {
                CoilImage(
                    modifier = Modifier.fillMaxSize(),
                    data = dog.picUrl,
                    contentScale = ContentScale.Crop,
                    contentDescription = null
                )
                Column(
                    Modifier
                        .align(Alignment.BottomCenter)
                        .fillMaxWidth()
                        .background(Color(0x88000000))
                        .padding(8.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.hi_my_name_is),
                        color = Color.White,
                        style = MaterialTheme.typography.subtitle1
                    )
                    Text(
                        text = dog.name,
                        modifier = Modifier.padding(top = 4.dp),
                        color = Color.White,
                        style = MaterialTheme.typography.h1
                    )
                }
            }
            Box(Modifier.fillMaxWidth()) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
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
                Button(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(bottom = 8.dp, end = 8.dp),
                    enabled = !dog.isBff,
                    onClick = {
                        setAdoptedDog(dog)
                    }
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
        }
    }
}

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

@Preview(showBackground = true)
@Composable
fun DogAdoptedDialogPreview() {
    val dog = Dog(
        name = "Testy",
        gender = "Female",
        months = 14,
        breed = "Fox Terrier",
        picUrl = "https://images.dog.ceo/breeds/terrier-irish/n02093991_1883.jpg",
        isBff = false
    )

    BFFinderTheme {
        DogAdoptedDialog(dog) {}
    }
}

@Preview(showBackground = true)
@Composable
fun DogListItemPreview() {
    val dog = Dog(
        name = "Testy",
        gender = "Female",
        months = 14,
        breed = "Fox Terrier",
        picUrl = "https://images.dog.ceo/breeds/terrier-irish/n02093991_1883.jpg",
        isBff = false
    )

    BFFinderTheme {
        DogListItem(dog = dog, {})
    }
}

@Composable
fun formatMonths(months: Int): String =
    if (months < 12) {
        quantityStringResource(R.plurals.x_months, months, months)
    } else {
        val years = months.div(12)
        quantityStringResource(R.plurals.x_years, years, years)
    }

@Composable
fun quantityStringResource(@PluralsRes id: Int, quantity: Int, vararg formatArgs: Any): String =
    LocalContext.current.resources.getQuantityString(id, quantity, *formatArgs)