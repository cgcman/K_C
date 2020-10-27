package com.grdj.k_c.framework.datasources

import com.grdj.k_c.core.data.InMemoryContactDataSource
import domain.Contact

class InMemoryInMemoryContactDataSource : InMemoryContactDataSource {

    private var openContact: Contact = Contact.EMPTY

    override fun setOpenContact(contact: Contact) {
        openContact = contact
    }

    override fun getOpenContact(): Contact {
        return openContact
    }
}