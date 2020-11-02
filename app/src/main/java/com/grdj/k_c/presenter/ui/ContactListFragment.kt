package com.grdj.k_c.presenter.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.grdj.k_c.R
import com.grdj.k_c.presenter.viewmodel.ContactListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_contact_list.*
import timber.log.Timber

@AndroidEntryPoint
class ContactListFragment : Fragment() {

    val viewModel: ContactListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_contact_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getContacts()
        viewModel.contacts.observe( viewLifecycleOwner, Observer {list ->
            var txt = ""
            for(item in list){
                Timber.d("RESULT ${item.name}")
                txt = txt + " - ${item.name}"
            }
            text.apply {
                text = txt
            }
        })
    }
}