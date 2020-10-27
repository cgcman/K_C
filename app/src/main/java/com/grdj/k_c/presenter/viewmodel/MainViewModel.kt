package com.grdj.k_c.presenter.viewmodel

import android.app.Application
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.grdj.k_c.framework.Interactors
import domain.Contact
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
    application: Application,
    private val interactors: Interactors
    ): BaseViewModel(application){

    var contacts: MutableLiveData<List<Contact>> = MutableLiveData()

    fun fetchContacts() {
        launch {
            contacts.postValue(interactors.fetchContacts())
        }
    }
}