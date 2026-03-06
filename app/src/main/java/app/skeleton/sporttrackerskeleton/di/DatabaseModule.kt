package app.skeleton.sporttrackerskeleton.di

import androidx.room.Room
import app.skeleton.sporttrackerskeleton.data.database.AppDatabase
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            context = get(),
            klass = AppDatabase::class.java,
            name = "database-name"
        ).build()
    }

    single { get<AppDatabase>().statisticsDao() }
}