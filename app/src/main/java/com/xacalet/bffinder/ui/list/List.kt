package com.xacalet.bffinder.ui.list

import androidx.annotation.PluralsRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.xacalet.bffinder.R
import com.xacalet.bffinder.data.Dog
import com.xacalet.bffinder.ui.components.*
import com.xacalet.bffinder.ui.theme.BFFinderTheme
import dev.chrisbanes.accompanist.coil.CoilImage


@Composable
fun DogListScreen(
    dogs: List<Dog>,
    adoptDog: (Dog) -> Unit,
    onItemClick: (Dog) -> Unit
) {
    Surface(color = MaterialTheme.colors.background) {
        Scaffold(
            topBar = {
                BFFinderAppBar(NavIcon.Logo) {}
            }
        ) {
            val (adoptedDog, setAdoptedDog) = remember { mutableStateOf<Dog?>(null) }
            LazyColumn(
                contentPadding = PaddingValues(16.dp),
            ) {
                items(dogs.size) { index ->
                    Box(modifier = Modifier.padding(8.dp)) {
                        DogListItem(dogs[index], { dog ->
                            setAdoptedDog(dog)
                            adoptDog(dog)
                        }, onItemClick)
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
fun DogListItem(
    dog: Dog,
    setAdoptedDog: (Dog) -> Unit,
    onItemClick: (Dog) -> Unit
) {
    Card(
        modifier = Modifier.clickable {
            onItemClick(dog)
        },
        shape = RoundedCornerShape(8.dp)
    ) {
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
                AttributeList(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    dog = dog
                )
                BecomeBffButton(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(bottom = 8.dp, end = 8.dp),
                    dog = dog,
                    onClick = { setAdoptedDog(dog) }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DogAdoptedDialogPreview() {
    val dog = Dog(
        id = 1,
        name = "Testy",
        gender = "Female",
        months = 14,
        breed = "Fox Terrier",
        description = "She is very smart, knows 'sit', and is ready to learn many more tricks! She enjoys treats but is still figuring out what she needs to do to earn them! She loves cuddles and is always excited to see new people. She might be a bit much for very small children due to her jumpiness, but a family with older kids that enjoyed playing with her could help burn off some of her extra puppy energy. She would likely be okay with a calmer dog near her size, but larger rowdy dogs make her very anxious.",
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
        id = 1,
        name = "Testy",
        gender = "Female",
        months = 14,
        breed = "Fox Terrier",
        description = "She is very smart, knows 'sit', and is ready to learn many more tricks! She enjoys treats but is still figuring out what she needs to do to earn them! She loves cuddles and is always excited to see new people. She might be a bit much for very small children due to her jumpiness, but a family with older kids that enjoyed playing with her could help burn off some of her extra puppy energy. She would likely be okay with a calmer dog near her size, but larger rowdy dogs make her very anxious.",
        picUrl = "https://images.dog.ceo/breeds/terrier-irish/n02093991_1883.jpg",
        isBff = false
    )

    BFFinderTheme {
        DogListItem(dog = dog, {}, {})
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