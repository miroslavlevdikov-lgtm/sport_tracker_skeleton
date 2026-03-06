package app.skeleton.sporttrackerskeleton.di

import app.skeleton.sporttrackerskeleton.data.datastore.OnboardingDataStoreManager
import app.skeleton.sporttrackerskeleton.data.datastore.UserManager
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataStoreModule = module {
    single { OnboardingDataStoreManager(androidContext()) }

    single { UserManager(androidContext()) }
}