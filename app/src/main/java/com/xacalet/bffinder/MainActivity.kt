package com.xacalet.bffinder

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.xacalet.bffinder.data.DogListViewModel
import com.xacalet.bffinder.ui.list.DogListScreen
import com.xacalet.bffinder.ui.theme.BFFinderTheme

class MainActivity : AppCompatActivity() {

    private val viewModel: DogListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BFFinderTheme {
                viewModel.dogs.value?.let { dogs ->
                    DogListScreen(dogs) { dog ->
                        viewModel.adoptDog(dog)
                    }
                }
            }
        }
    }
}
