package app.skeleton.sporttrackerskeleton.ui.composable.screen.workoutdetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import app.skeleton.sporttrackerskeleton.R
import app.skeleton.sporttrackerskeleton.data.model.ExerciseModel
import app.skeleton.sporttrackerskeleton.ui.composable.shared.DataBasedContainer
import app.skeleton.sporttrackerskeleton.ui.composable.shared.DataEmptyContent
import app.skeleton.sporttrackerskeleton.ui.state.DataUiState
import app.skeleton.sporttrackerskeleton.ui.viewmodel.WorkoutDetailsViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun WorkoutDetailsScreen(
    workoutId: Int,
    modifier: Modifier = Modifier,
    viewModel: WorkoutDetailsViewModel = koinViewModel()
) {
    val exercisesState by viewModel.exercisesState.collectAsState()

    LaunchedEffect(workoutId) {
        viewModel.loadExercises(workoutId)
    }

    WorkoutDetailsScreenContent(
        modifier = modifier,
        exercisesState = exercisesState
    )
}

@Composable
private fun WorkoutDetailsScreenContent(
    modifier: Modifier = Modifier,
    exercisesState: DataUiState<List<ExerciseModel>>,
) {
    Column(modifier = modifier) {

        DataBasedContainer(
            dataState = exercisesState,

            dataPopulated = {

            },

            dataEmpty = {
                DataEmptyContent(
                    primaryText = stringResource(R.string.no_exercises_info),
                    modifier = Modifier.fillMaxSize(),
                )
            },
        )
    }
}