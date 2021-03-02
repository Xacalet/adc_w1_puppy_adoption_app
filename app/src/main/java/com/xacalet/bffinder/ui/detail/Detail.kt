package com.xacalet.bffinder.ui.detail

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.xacalet.bffinder.data.Dog
import com.xacalet.bffinder.ui.components.*
import com.xacalet.bffinder.ui.theme.BFFinderTheme
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun DogDetailsScreen(
    dog: Dog,
    adoptDog: (Dog) -> Unit,
    onClickNavigationIcon: () -> Unit
) {
    val (adoptedDog, setAdoptedDog) = remember { mutableStateOf<Dog?>(null) }
    Surface(color = MaterialTheme.colors.background) {
        Scaffold(
            topBar = {
                BFFinderAppBar(NavIcon.Back, onClickNavigationIcon)
            }
        ) {
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(16.dp)) {
                CoilImage(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp),
                    data = dog.picUrl,
                    contentScale = ContentScale.Crop,
                    contentDescription = null
                )
                Spacer(Modifier.size(32.dp))
                Text(
                    text = dog.name,
                    style = MaterialTheme.typography.h1
                )
                Spacer(Modifier.size(16.dp))
                AttributeList(
                    dog = dog,
                    modifier = Modifier.wrapContentSize()
                )
                Spacer(Modifier.size(16.dp))
                Text(
                    modifier = Modifier.weight(1f),
                    text = dog.description,
                    style = MaterialTheme.typography.body1
                )
                Spacer(Modifier.size(16.dp))
                BecomeBffButton(
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                        .width(200.dp)
                        .height(60.dp)
                        .align(Alignment.CenterHorizontally),
                    dog = dog,
                    onClick = {
                        setAdoptedDog(dog)
                        adoptDog(dog)
                    }
                )
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

@Composable
@Preview
fun DogDetailsScreen() {
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
        DogDetailsScreen(dog, {}, {})
    }
}