package app.skeleton.sporttrackerskeleton.ui.composable.screen.history

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import app.skeleton.sporttrackerskeleton.R
import app.skeleton.sporttrackerskeleton.data.model.CompleteWorkoutModel
import app.skeleton.sporttrackerskeleton.ui.composable.shared.CalendarView
import app.skeleton.sporttrackerskeleton.ui.composable.shared.DataBasedContainer
import app.skeleton.sporttrackerskeleton.ui.composable.shared.DataEmptyContent
import app.skeleton.sporttrackerskeleton.ui.state.DataUiState
import app.skeleton.sporttrackerskeleton.ui.viewmodel.HistoryViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun HistoryScreen(
    modifier: Modifier = Modifier,
    viewModel: HistoryViewModel = koinViewModel(),
) {
    val viewedMonth by viewModel.viewedMonth.collectAsState()
    val selectedDate by viewModel.selectedDate.collectAsState()
    val calendarDays by viewModel.calendarDays.collectAsState()
    val completeWorkoutsState by viewModel.completeWorkoutsState.collectAsState()

    HistoryScreenContent(
        modifier = modifier,
        viewedMonth = viewedMonth,
        selectedDate = selectedDate,
        calendarDays = calendarDays,
        completeWorkoutsState = completeWorkoutsState,
        onDayClick = viewModel::selectDate,
        onPreviousMonthClick = viewModel::previousMonth,
        onNextMonthClick = viewModel::nextMonth
    )
}

@Composable
private fun HistoryScreenContent(
    modifier: Modifier = Modifier,
    viewedMonth: java.time.LocalDate,
    selectedDate: java.time.LocalDate,
    calendarDays: List<java.time.LocalDate?>,
    completeWorkoutsState: DataUiState<List<CompleteWorkoutModel>>,
    onDayClick: (java.time.LocalDate) -> Unit,
    onPreviousMonthClick: () -> Unit,
    onNextMonthClick: () -> Unit,
) {
    Column(modifier = modifier) {
        CalendarView(
            viewedMonth = viewedMonth,
            selectedDate = selectedDate,
            days = calendarDays,
            onDayClick = onDayClick,
            onPreviousMonthClick = onPreviousMonthClick,
            onNextMonthClick = onNextMonthClick
        )

        Spacer(modifier = Modifier.height(15.dp))

        DataBasedContainer(
            dataState = completeWorkoutsState,

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