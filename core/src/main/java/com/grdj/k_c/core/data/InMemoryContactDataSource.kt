package com.grdj.k_c.core.data

import domain.Contact

interface InMemoryContactDataSource {
    fun setOpenContact(contact: Contact)
    fun getOpenContact(): Contact
}