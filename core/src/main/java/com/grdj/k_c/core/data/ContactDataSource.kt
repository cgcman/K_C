package com.grdj.k_c.core.data

import domain.Contact

interface ContactDataSource {
    suspend fun add(contact: Contact)
    suspend fun read(): List<Contact>
    suspend fun remove(contact: Contact)
}