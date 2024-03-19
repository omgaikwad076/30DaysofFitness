package com.example.a30daysoffitness

import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.Spring.DampingRatioLowBouncy
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a30daysoffitness.model.Exercise
import com.example.a30daysoffitness.model.ExercisesRepository.exercises
import com.example.a30daysoffitness.ui.theme._30DaysOfFitnessTheme

@Composable
fun ExercisesList(
        exercise: List<Exercise>,
        modifier: Modifier = Modifier,
        contentPadding : PaddingValues = PaddingValues(0.dp)
){
    val visibleState = remember {
        MutableTransitionState(false).apply {
            targetState = true
        }
    }
    AnimatedVisibility(
        visibleState = visibleState,
enter = fadeIn(
animationSpec = spring(dampingRatio = DampingRatioLowBouncy)
),
        exit = fadeOut(),
        modifier = Modifier
    ){
        LazyColumn(
            contentPadding = contentPadding
        ){
            itemsIndexed(exercises){index, exercise ->
                ExerciseListItem(
                    exercise = exercise,
                    modifier = modifier
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                )

            }
        }
    }
}

@Composable
fun ExerciseListItem(
    exercise: Exercise,
    modifier: Modifier = Modifier
){
    Card (
        elevation =CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = modifier
    ){
        Column (
            modifier = modifier
        ){
                Text(
                    text = stringResource(exercise.day),
                    style = MaterialTheme.typography.titleSmall
                )

                Text(
                    text = stringResource(exercise.name),
                    style = MaterialTheme.typography.labelMedium
                )
                Image(
                    painter = painterResource(exercise.image),
                    contentDescription = null
                )
            Text(
                text = stringResource(exercise.content),
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

@Preview("Dark Theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HeroPreview() {
    val exercise = Exercise(
        R.string.day1name,
        R.string.day1,
        R.drawable.push,
        R.string.description1
    )
    _30DaysOfFitnessTheme {
        ExerciseListItem(exercise = exercise)
    }
}

@Preview(showBackground = true)
@Composable
fun ExercisesListPreview(){
    ExercisesList(exercise = exercises)
}