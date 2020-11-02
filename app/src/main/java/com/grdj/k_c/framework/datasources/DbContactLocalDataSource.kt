package com.grdj.k_c.framework.datasources

import android.content.Context
import com.grdj.k_c.core.data.ContactLocalDataSource
import com.grdj.k_c.framework.db.ContactEntity
import com.grdj.k_c.framework.db.KC_Database
import domain.Contact

class DbContactLocalDataSource(context : Context) : ContactLocalDataSource {

    private val contactDao = KC_Database.getInstance(context).contactDao()

    override suspend fun add(contact: Contact) {
        contactDao.addContact(
            ContactEntity(
                contact.id,
                contact.name,
                contact.companyName,
                contact.isFavorite,
                contact.smallImageURL,
                contact.largeImageURL,
                contact.emailAddress,
                contact.birthdate,
                contact.phone,
                contact.address
            ))
    }

    override suspend fun addList(contacts: List<Contact>) {
        contactDao.addContactList( contacts.map{ contact ->
            ContactEntity(
                contact.id,
                contact.name,
                contact.companyName,
                contact.isFavorite,
                contact.smallImageURL,
                contact.largeImageURL,
                contact.emailAddress,
                contact.birthdate,
                contact.phone,
                contact.address
            )
        })
    }

    override suspend fun read(): List<Contact> {
        return contactDao.getContacts().map {
            Contact(
                it.id,
                it.name,
                it.companyName,
                it.isFavorite,
                it.smallImageURL,
                it.largeImageURL,
                it.emailAddress,
                it.birthdate,
                it.phone,
                it.address) }
    }

    override suspend fun remove(contact: Contact) {
        contactDao.removeContact(ContactEntity(
            contact.id,
            contact.name,
            contact.companyName,
            contact.isFavorite,
            contact.smallImageURL,
            contact.largeImageURL,
            contact.emailAddress,
            contact.birthdate,
            contact.phone,
            contact.address
        ))
    }
}