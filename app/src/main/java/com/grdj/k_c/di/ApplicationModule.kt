package com.grdj.k_c.di

import android.content.Context
import com.grdj.k_c.core.data.ContactRepository
import com.grdj.k_c.core.interactors.*
import com.grdj.k_c.framework.datasources.DbContactLocalDataSource
import com.grdj.k_c.framework.datasources.InMemoryInMemoryContactDataSource
import com.grdj.k_c.framework.Interactors
import com.grdj.k_c.framework.datasources.NetworkContactLocalDataSource
import com.grdj.k_c.framework.utils.DefaultDispatcherProvider
import com.grdj.k_c.framework.utils.DispatcherProvider
import com.grdj.k_c.framework.errormanager.ErrorManagerHelper
import com.grdj.k_c.framework.errormanager.ErrorManagerHelperImpl
import com.grdj.k_c.framework.network.ContactService
import com.grdj.k_c.framework.network.ContactServiceImpl
import com.grdj.k_c.framework.resources.ResourcesProvider
import com.grdj.k_c.framework.resources.ResourcesProviderImpl
import com.grdj.k_c.framework.utils.network.NetworkManager
import com.grdj.k_c.framework.utils.network.NetworkManagerImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton
import kotlin.coroutines.CoroutineContext


@Module
@InstallIn(ApplicationComponent::class)
class ApplicationModule {

    @Provides
    fun provideContactService(@ApplicationContext context: Context) : ContactService = ContactServiceImpl(
        ResourcesProviderImpl(context)
    )

    @Provides
    fun provideErrorManagerHelper() : ErrorManagerHelper = ErrorManagerHelperImpl()

    @Provides
    fun provideResourcesProvider(@ApplicationContext context: Context) : ResourcesProvider = ResourcesProviderImpl(context)

    @Provides
    fun provideNetworkManager(@ApplicationContext context: Context) : NetworkManager = NetworkManagerImpl(context)

    @Provides
    fun provideInteractors(@ApplicationContext context: Context) : Interactors = Interactors(
        AddContact(
            ContactRepository(
                DbContactLocalDataSource(context),
                InMemoryInMemoryContactDataSource(),
                NetworkContactLocalDataSource(
                    ContactServiceImpl(
                    ResourcesProviderImpl(context)
                ))
            )
        ),
        AddContacts(
            ContactRepository(
                DbContactLocalDataSource(context),
                InMemoryInMemoryContactDataSource(),
                NetworkContactLocalDataSource(
                    ContactServiceImpl(
                        ResourcesProviderImpl(context)
                    ))
            )
        ),
        RemoveContact(
            ContactRepository(
                DbContactLocalDataSource(context),
                InMemoryInMemoryContactDataSource(),
                NetworkContactLocalDataSource(
                    ContactServiceImpl(
                    ResourcesProviderImpl(context)
                ))
            )
        ),
        ReadContacts(
            ContactRepository(
                DbContactLocalDataSource(context),
                InMemoryInMemoryContactDataSource(),
                NetworkContactLocalDataSource(
                    ContactServiceImpl(
                        ResourcesProviderImpl(context)
                    )
                )
            )
        ),
        SetOpenContact(
            ContactRepository(
                DbContactLocalDataSource(context),
                InMemoryInMemoryContactDataSource(),
                NetworkContactLocalDataSource(
                    ContactServiceImpl(
                        ResourcesProviderImpl(context)
                    )
                )
            )
        ),
        FetchContacts(
            ContactRepository(
                DbContactLocalDataSource(context),
                InMemoryInMemoryContactDataSource(),
                NetworkContactLocalDataSource(
                    ContactServiceImpl(
                        ResourcesProviderImpl(context)
                    )
                )
            )
        )
    )

    @Singleton
    @Provides
    fun provideDispatcherProvider() : DispatcherProvider = DefaultDispatcherProvider()
}