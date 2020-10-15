package com.grdj.k_c.framework

import com.grdj.k_c.core.interactors.AddContact
import com.grdj.k_c.core.interactors.ReadContacts
import com.grdj.k_c.core.interactors.RemoveContact
import com.grdj.k_c.core.interactors.SetOpenContact

data class Interactors(
    val addContact : AddContact,
    val removeContact : RemoveContact,
    val readContacts: ReadContacts,
    val setOpenContact: SetOpenContact
)