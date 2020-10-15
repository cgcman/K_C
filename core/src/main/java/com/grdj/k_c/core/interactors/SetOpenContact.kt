package com.grdj.k_c.core.interactors

import com.grdj.k_c.core.data.ContactRepository
import domain.Contact

class SetOpenContact(private val contactRepository: ContactRepository) {
    suspend operator fun invoke(contact: Contact) = contactRepository.setOpenContact(contact)
}