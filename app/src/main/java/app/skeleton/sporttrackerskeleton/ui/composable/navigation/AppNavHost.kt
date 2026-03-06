package app.skeleton.sporttrackerskeleton.ui.composable.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import app.skeleton.sporttrackerskeleton.ui.composable.screen.history.HistoryScreen
import app.skeleton.sporttrackerskeleton.ui.composable.screen.onboarding.OnboardingScreen
import app.skeleton.sporttrackerskeleton.ui.composable.screen.settings.SettingsScreen
import app.skeleton.sporttrackerskeleton.ui.composable.screen.splash.SplashScreen
import app.skeleton.sporttrackerskeleton.ui.composable.screen.statistics.StatisticsScreen
import app.skeleton.sporttrackerskeleton.ui.composable.screen.usercabinet.UserProfileScreen
import app.skeleton.sporttrackerskeleton.ui.composable.screen.workout.WorkoutScreen
import app.skeleton.sporttrackerskeleton.ui.composable.screen.workoutdetails.WorkoutDetailsScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = NavRoute.Splash,
        modifier = modifier,
    ) {
        composable<NavRoute.Splash> {
            SplashScreen(
                onNavigateToHomeScreen = {
                    navController.navigate(route = NavRoute.Workout) {
                        popUpTo(navController.graph.startDestinationId) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                },
                onNavigateToOnboarding = {
                    navController.navigate(route = NavRoute.Onboarding) {
                        popUpTo(navController.graph.startDestinationId) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }
            )
        }

        composable<NavRoute.Onboarding> {
            OnboardingScreen(
                onNavigateToHomeScreen = {
                    navController.navigate(NavRoute.Workout) {
                        popUpTo(NavRoute.Onboarding) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }
            )
        }

        composable<NavRoute.Workout> {
            WorkoutScreen(
                onNavigateToWorkoutDetails = { id: Int ->
                    navController.navigate(
                        route = NavRoute.WorkoutDetail(id = id)
                    )
                }
            )
        }

        composable<NavRoute.WorkoutDetail> { backStackEntry ->
            val workoutDetail: NavRoute.WorkoutDetail = backStackEntry.toRoute()
            WorkoutDetailsScreen(
                workoutId = workoutDetail.id,
            )
        }

        composable<NavRoute.History> {
            HistoryScreen()
        }

        composable<NavRoute.Statistics> {
            StatisticsScreen()
        }

        composable<NavRoute.Settings> {
            SettingsScreen()
        }

        composable<NavRoute.UserProfile> {
            UserProfileScreen()
        }
    }
}