package com.grdj.k_c.framework

import com.grdj.k_c.core.data.OpenContactDataSource
import domain.Contact

class InMemoryOpenContactDataSource : OpenContactDataSource {

    private var openContact: Contact = Contact.EMPTY

    override fun setOpenContact(contact: Contact) {
        openContact = contact
    }

    override fun getOpenContact(): Contact {
        return openContact
    }
}