package com.grdj.k_c.framework.network

import com.grdj.k_c.framework.network.DTO.Contact

interface ContactService {
    suspend fun getContactFromNetwork() : List<Contact>
}