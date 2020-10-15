package com.grdj.k_c.di

import android.app.Application
import android.content.Context
import com.grdj.k_c.App
import com.grdj.k_c.core.data.ContactRepository
import com.grdj.k_c.core.interactors.AddContact
import com.grdj.k_c.core.interactors.ReadContacts
import com.grdj.k_c.core.interactors.RemoveContact
import com.grdj.k_c.core.interactors.SetOpenContact
import com.grdj.k_c.framework.DbContactDataSource
import com.grdj.k_c.framework.InMemoryOpenContactDataSource
import com.grdj.k_c.framework.Interactors
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
class ApplicationModule {

    @Singleton
    @Provides
    fun provideInteractors(@ApplicationContext context: Context) : Interactors = Interactors(
        AddContact(
            ContactRepository(
                DbContactDataSource(context),
                InMemoryOpenContactDataSource()
            )
        ),
        RemoveContact(
            ContactRepository(
                DbContactDataSource(context),
                InMemoryOpenContactDataSource()
            )
        ),
        ReadContacts(
            ContactRepository(
                DbContactDataSource(context),
                InMemoryOpenContactDataSource()
            )
        ),
        SetOpenContact(
            ContactRepository(
                DbContactDataSource(context),
                InMemoryOpenContactDataSource()
            )
        )
    )
}