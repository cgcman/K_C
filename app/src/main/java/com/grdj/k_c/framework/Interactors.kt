package com.grdj.k_c.framework

import com.grdj.k_c.core.interactors.*

data class Interactors(
    val addContact : AddContact,
    val removeContact : RemoveContact,
    val readContacts: ReadContacts,
    val setOpenContact: SetOpenContact,
    val fetchContacts: FetchContacts
)