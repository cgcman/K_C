package com.grdj.k_c.presenter.viewmodel

import android.app.Application
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import com.grdj.k_c.framework.Interactors
import com.grdj.k_c.framework.errormanager.ErrorManagerHelper
import com.grdj.k_c.framework.errormanager.ResultWrapper
import com.grdj.k_c.framework.resources.ResourcesProvider
import com.grdj.k_c.framework.resources.ResourcesProviderImpl
import com.grdj.k_c.framework.utils.DefaultDispatcherProvider
import com.grdj.k_c.framework.utils.DispatcherProvider
import com.grdj.k_c.framework.utils.network.NetworkManager
import domain.Contact
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber

class MainViewModel @ViewModelInject constructor(
    application: Application): BaseViewModel(application){

}