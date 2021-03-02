package com.xacalet.bffinder

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavType
import androidx.navigation.compose.*
import com.xacalet.bffinder.data.DogListViewModel
import com.xacalet.bffinder.ui.detail.DogDetailsScreen
import com.xacalet.bffinder.ui.list.DogListScreen
import com.xacalet.bffinder.ui.theme.BFFinderTheme

class MainActivity : AppCompatActivity() {

    private val viewModel: DogListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BFFinderTheme {
                val navController = rememberNavController()
                NavHost(navController, startDestination = "dogList") {
                    composable(route = "dogList") {
                        viewModel.dogs.value?.let { dogs ->
                            DogListScreen(dogs, { dog ->
                                viewModel.adoptDog(dog)
                            }) { dog ->
                                navController.navigate("dogDetails/${dog.id}")
                            }
                        }
                    }
                    composable(
                        route = "dogDetails/{id}",
                        arguments = listOf(navArgument("id") { type = NavType.LongType })
                    ) { backstackEntry ->
                        backstackEntry.arguments?.getLong("id")?.let { id ->
                            viewModel.dogs.value?.firstOrNull { it.id == id }?.let { dog ->
                                DogDetailsScreen(dog, {
                                    viewModel.adoptDog(it)
                                }) {
                                    navController.popBackStack()
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
