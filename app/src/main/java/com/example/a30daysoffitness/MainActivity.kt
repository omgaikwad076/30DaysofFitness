package com.example.a30daysoffitness

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.a30daysoffitness.model.Exercise
import com.example.a30daysoffitness.model.ExercisesRepository
import com.example.a30daysoffitness.ui.theme._30DaysOfFitnessTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            _30DaysOfFitnessTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ExerciseApp()
                }
            }
        }
    }
}

@Composable
fun ExerciseApp(){
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar()
        }
    ){
        val exercises = ExercisesRepository.exercises
        ExercisesList(exercise = exercises, contentPadding = it)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(
    modifier: Modifier = Modifier
){
    CenterAlignedTopAppBar(
        title = {
            Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.displayMedium
            )
        }
    )
}
@Preview(showBackground = true)
@Composable
fun ExeciseAppTop(){
    ExerciseApp()
}