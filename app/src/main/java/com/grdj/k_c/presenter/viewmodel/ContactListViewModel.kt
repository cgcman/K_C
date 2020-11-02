package com.grdj.k_c.presenter.viewmodel

import android.app.Application
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import com.grdj.k_c.framework.Interactors
import com.grdj.k_c.framework.errormanager.ErrorManagerHelper
import com.grdj.k_c.framework.errormanager.ResultWrapper
import com.grdj.k_c.framework.resources.ResourcesProvider
import com.grdj.k_c.framework.utils.DefaultDispatcherProvider
import com.grdj.k_c.framework.utils.DispatcherProvider
import com.grdj.k_c.framework.utils.network.NetworkManager
import domain.Contact
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber

class ContactListViewModel @ViewModelInject constructor(
    application: Application,
    private val interactors: Interactors,
    private val errorManagerHelper: ErrorManagerHelper,
    private val networkManager: NetworkManager,
    private val dispatcher: DispatcherProvider = DefaultDispatcherProvider(),
    private val resourcesProvider: ResourcesProvider
): BaseViewModel(application) {

    var contacts: MutableLiveData<List<Contact>> = MutableLiveData()
    var error: MutableLiveData<Boolean> = MutableLiveData()
    var message: MutableLiveData<String> = MutableLiveData()

    fun getContacts() {
        launch {
            val response = if(networkManager.isConnected()) getContactFromNetwork() else getContactFromDb()
            when (response) {
                is ResultWrapper.NetworkError -> showNetworkError()
                is ResultWrapper.GenericError -> showGenericError(response)
                is ResultWrapper.Success -> {
                    populateUI(response.value)
                }
            }
        }
    }

    fun populateUI(response: List<Contact>?){
        contacts.value = response
        launch{
            interactors.addContacts(response!!)
        }
    }

    fun showNetworkError(){
        error.value = true
        message.value = resourcesProvider.getApiError()
        Timber.d("RESPONSE, NETWORK ERROR")
    }

    fun showGenericError(response: Any?) {
        error.value = true
        message.value = resourcesProvider.getApiError()
        Timber.d("RESPONSE, $response")
    }

    private suspend fun getContactFromNetwork() : ResultWrapper<List<Contact>?> {
        return withContext(dispatcher.io()) {
            errorManagerHelper.dataCall() {
                interactors.fetchContacts()
            }
        }
    }

    private suspend fun getContactFromDb() : ResultWrapper<List<Contact>?> {
        return withContext(dispatcher.io()) {
            errorManagerHelper.dataCall() {
                interactors.readContacts()
            }
        }
    }
}