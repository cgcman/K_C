package com.grdj.k_c.core.data

import domain.Contact

class ContactRepository(
    private val localDataSource: ContactLocalDataSource,
    private val inMemoryDataSource: InMemoryContactDataSource,
    private val networkDataSource: ContactNetworkDataSource) {
    suspend fun addContact(contact: Contact) = localDataSource.add(contact)
    suspend fun addContacts(contacts: List<Contact>) = localDataSource.addList(contacts)
    suspend fun removeContact(contact: Contact) = localDataSource.remove(contact)
    suspend fun readContact() : List<Contact> = localDataSource.read()
    suspend fun fetchContact() : List<Contact> = networkDataSource.fetch()
    fun setOpenContact(contact: Contact) = inMemoryDataSource.setOpenContact(contact)
    fun getOpenContact() : Contact = inMemoryDataSource.getOpenContact()
}