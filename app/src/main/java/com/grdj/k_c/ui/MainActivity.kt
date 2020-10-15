package com.grdj.k_c.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.grdj.k_c.R
import com.grdj.k_c.core.data.ContactDataSource
import com.grdj.k_c.core.data.ContactRepository
import com.grdj.k_c.framework.DbContactDataSource
import com.grdj.k_c.framework.InMemoryOpenContactDataSource
import com.grdj.k_c.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.fetchContacts()
    }
}