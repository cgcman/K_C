package com.grdj.k_c.core.data

import domain.Contact

interface ContactLocalDataSource {
    suspend fun add(contact: Contact)
    suspend fun read(): List<Contact>
    suspend fun remove(contact: Contact)
}