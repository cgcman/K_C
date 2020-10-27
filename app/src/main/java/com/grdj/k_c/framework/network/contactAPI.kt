package com.grdj.k_c.framework.network

import com.grdj.k_c.framework.network.DTO.Contact
import retrofit2.http.GET

interface contactAPI {
    @GET("technical-challenge/v3/contacts.json")
    suspend fun getContact(): List<Contact>
}