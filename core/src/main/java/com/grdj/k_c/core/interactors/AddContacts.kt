package com.grdj.k_c.core.interactors

import com.grdj.k_c.core.data.ContactRepository
import domain.Contact

class AddContacts(private val contactRepository: ContactRepository) {
    suspend operator fun invoke(contacts: List<Contact>) = contactRepository.addContacts(contacts)
}