package app.skeleton.sporttrackerskeleton.ui.composable.screen.workout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import app.skeleton.sporttrackerskeleton.R
import app.skeleton.sporttrackerskeleton.ui.composable.shared.DataBasedContainer
import app.skeleton.sporttrackerskeleton.ui.composable.shared.DataEmptyContent
import app.skeleton.sporttrackerskeleton.ui.viewmodel.WorkoutViewModel
import app.skeleton.sporttrackerskeleton.ui.viewmodel.WorkoutsState
import org.koin.androidx.compose.koinViewModel

@Composable
fun WorkoutScreen(
    modifier: Modifier = Modifier,
    viewModel: WorkoutViewModel = koinViewModel(),
    onNavigateToWorkoutDetails: (Int) -> Unit,
) {
    val workoutsState by viewModel.workoutsState.collectAsState()

    WorkoutScreenContent(
        modifier = modifier,
        workoutsState = workoutsState,
        onNavigateToWorkoutDetails = onNavigateToWorkoutDetails,
    )
}

@Composable
private fun WorkoutScreenContent(
    modifier: Modifier = Modifier,
    workoutsState: WorkoutsState,
    onNavigateToWorkoutDetails: (Int) -> Unit,
) {
    Column(modifier = modifier) {

        DataBasedContainer(
            dataState = workoutsState,

            dataPopulated = {

            },

            dataEmpty = {
                DataEmptyContent(
                    primaryText = stringResource(R.string.no_workouts_info),
                    modifier = Modifier.fillMaxSize(),
                )
            },
        )
    }
}