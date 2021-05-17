package kz.aspan.angime.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.android.scopes.ViewModelScoped
import kz.aspan.angime.repositories.AuthRepository
import kz.aspan.angime.repositories.DefaultAuthRepository

@Module
@InstallIn(ViewModelComponent::class)
object AuthModule {

    @ViewModelScoped
    @Provides
    fun provideAuthRepository() = DefaultAuthRepository() as AuthRepository
}