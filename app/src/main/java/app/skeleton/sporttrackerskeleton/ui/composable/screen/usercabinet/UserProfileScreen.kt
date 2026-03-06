package app.skeleton.sporttrackerskeleton.ui.composable.screen.usercabinet

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import app.skeleton.sporttrackerskeleton.ui.viewmodel.UserProfileViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun UserProfileScreen(
    modifier: Modifier = Modifier,
    viewModel: UserProfileViewModel = koinViewModel(),
) {
    val isUserNameError by viewModel.userNameErrorState.collectAsState()

    UserProfileScreenContent(
        modifier = modifier,
        userNameFieldValue = viewModel.userName,
        userHeightFieldValue = viewModel.userHeight,
        userWeightFieldValue = viewModel.userWeight,
        userAgeFieldValue = viewModel.userAge,
        userGoalWorkoutsValue = viewModel.userGoalWorkouts,
        onUserNameFieldChange = viewModel::updateUserName,
        onUserHeightFieldChange = viewModel::updateUserHeight,
        onUserWeightFieldChange = viewModel::updateUserWeight,
        onUserAgeFieldChange = viewModel::updateUserAge,
        onUserGoalWorkoutsFieldChange = viewModel::updateUserGoalWorkouts,
        isUserNameError = isUserNameError,
        onUpdateUser = viewModel::updateUser,
    )
}

@Composable
private fun UserProfileScreenContent(
    modifier: Modifier = Modifier,
    userNameFieldValue: String,
    userHeightFieldValue: String,
    userWeightFieldValue: String,
    userAgeFieldValue: String,
    userGoalWorkoutsValue: String,
    onUserNameFieldChange: (String) -> Unit,
    onUserHeightFieldChange: (String) -> Unit,
    onUserWeightFieldChange: (String) -> Unit,
    onUserAgeFieldChange: (String) -> Unit,
    onUserGoalWorkoutsFieldChange: (String) -> Unit,
    isUserNameError: Boolean,
    onUpdateUser: () -> Unit,
) {
    Column(modifier = modifier) {

    }
}

@Composable
fun UserTextField(
    input: String,
    onInputChange: (String) -> Unit,
    labelText: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    isError: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
) {
    OutlinedTextField(
        value = input,
        onValueChange = onInputChange,
        modifier = modifier,
        enabled = enabled,
        label = {
            Text(
                text = labelText,
                style = MaterialTheme.typography.titleSmall,
            )
        },
        isError = isError,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        singleLine = true,
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = MaterialTheme.colorScheme.surface,
            unfocusedContainerColor = MaterialTheme.colorScheme.surface,
            focusedTextColor = MaterialTheme.colorScheme.onSurface,
            unfocusedTextColor = MaterialTheme.colorScheme.onSurface,
            focusedBorderColor = MaterialTheme.colorScheme.primary,
            unfocusedBorderColor = MaterialTheme.colorScheme.outline,
            focusedLabelColor = MaterialTheme.colorScheme.primary,
            unfocusedLabelColor = MaterialTheme.colorScheme.onSurfaceVariant,
            cursorColor = MaterialTheme.colorScheme.primary
        ),
    )
}