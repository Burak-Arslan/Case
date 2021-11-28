package com.ambluden.core.di

import android.content.Context
import com.ambluden.core.base.constants.CommonPreferences
import com.ambluden.core.base.constants.CommonPreferencesImpl
import com.ambluden.core.base.constants.PreferenceWrapper
import com.ambluden.core.data.model.AppConfig
import com.ambluden.core.util.GsonProvider
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoreModule {

    @Singleton
    @Provides
    fun providePreferenceWrapper(
        @ApplicationContext context: Context,
        gson: Gson,
        appConfig: AppConfig
    ) = PreferenceWrapper(context, gson, appConfig)

    @Singleton
    @Provides
    fun provideCommonPreferences(
        wrapper: PreferenceWrapper
    ): CommonPreferences = CommonPreferencesImpl(wrapper)


    @Singleton
    @Provides
    fun provideGson() = GsonProvider.gson
}
