package app.skeleton.sporttrackerskeleton.ui.composable.approot

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import app.skeleton.sporttrackerskeleton.ui.composable.navigation.BottomNavigationItem
import app.skeleton.sporttrackerskeleton.ui.composable.navigation.NavRoute


@Composable
fun AppBottomBar(
    currentDestination: NavDestination?,
    navigationItems: List<BottomNavigationItem>,
    onNavigateToRoute: (BottomNavigationItem) -> Unit,
) {

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary,
    ) {
        navigationItems.forEach { item ->
            NavigationBarItem(
                selected = isSelectedDestination(currentDestination, item.route),
                onClick = { onNavigateToRoute(item) },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = stringResource(item.titleRes)
                    )
                },
                label = {
                    Text(text = stringResource(item.titleRes))
                },
            )
        }
    }
}

private fun isSelectedDestination(destination: NavDestination?, route: NavRoute): Boolean {
    return destination?.let {
        destination.hierarchy.any { navDestination -> navDestination.hasRoute(route::class) }
    } ?: return false
}