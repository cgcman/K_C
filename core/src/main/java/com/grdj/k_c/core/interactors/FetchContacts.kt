package com.grdj.k_c.core.interactors

import com.grdj.k_c.core.data.ContactRepository
import domain.Contact

class FetchContacts(private val contactRepository: ContactRepository) {
    suspend operator fun invoke() : List<Contact> = contactRepository.fetchContact()
}