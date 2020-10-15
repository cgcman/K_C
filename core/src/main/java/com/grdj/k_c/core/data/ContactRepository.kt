package com.grdj.k_c.core.data

import domain.Contact

class ContactRepository(
    private val dataSource: ContactDataSource,
    private val openDataSource: OpenContactDataSource) {
    suspend fun addContact(contact: Contact) = dataSource.add(contact)
    suspend fun removeContact(contact: Contact) = dataSource.remove(contact)
    suspend fun readContact() : List<Contact> = dataSource.read()
    fun setOpenContact(contact: Contact) = openDataSource.setOpenContact(contact)
    fun getOpenContact() : Contact = openDataSource.getOpenContact()
}