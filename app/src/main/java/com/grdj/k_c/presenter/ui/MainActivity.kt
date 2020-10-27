package com.grdj.k_c.presenter.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.grdj.k_c.R
import com.grdj.k_c.framework.ext.observe
import com.grdj.k_c.presenter.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import domain.Contact
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.fetchContacts()
        viewModel.contacts.observe(this, Observer {
            onGetContacts(it)
        })
    }

    private fun onGetContacts(list: List<Contact>){
        Timber.d("$list");
    }
}