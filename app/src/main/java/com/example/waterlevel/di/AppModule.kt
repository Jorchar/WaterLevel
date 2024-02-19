package com.example.waterlevel.di

import android.content.Context
import androidx.room.Room
import com.example.waterlevel.data.local.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Singleton
    @Provides
    fun provideRoomDatabase(@ApplicationContext appContext: Context): AppDatabase =
        Room.databaseBuilder(
            context = appContext,
            klass = AppDatabase::class.java,
            name = "plant-database"
        ).allowMainThreadQueries().build()
}