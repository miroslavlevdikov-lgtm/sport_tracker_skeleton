package app.skeleton.sporttrackerskeleton.di

import app.skeleton.sporttrackerskeleton.ui.viewmodel.AppViewModel
import app.skeleton.sporttrackerskeleton.ui.viewmodel.HistoryViewModel
import app.skeleton.sporttrackerskeleton.ui.viewmodel.OnboardingViewModel
import app.skeleton.sporttrackerskeleton.ui.viewmodel.SplashViewModel
import app.skeleton.sporttrackerskeleton.ui.viewmodel.StatisticsViewModel
import app.skeleton.sporttrackerskeleton.ui.viewmodel.UserProfileViewModel
import app.skeleton.sporttrackerskeleton.ui.viewmodel.WorkoutDetailsViewModel
import app.skeleton.sporttrackerskeleton.ui.viewmodel.WorkoutViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModule = module {
    viewModel {
        SplashViewModel(
            onboardingRepository = get()
        )
    }

    viewModel {
        OnboardingViewModel(
            onboardingRepository = get()
        )
    }

    viewModel {
        AppViewModel(
            userRepository = get()
        )
    }

    viewModel {
        WorkoutViewModel(
            workoutRepository = get()
        )
    }

    viewModel {
        WorkoutDetailsViewModel(
            workoutRepository = get(),
            statisticsRepository = get(),
        )
    }

    viewModel {
        HistoryViewModel(
            completeWorkoutRepository = get()
        )
    }

    viewModel {
        UserProfileViewModel(
            userRepository = get()
        )
    }

    viewModel {
        StatisticsViewModel(
            completeWorkoutRepository = get()
        )
    }
}