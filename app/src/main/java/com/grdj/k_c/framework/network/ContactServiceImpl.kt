package com.grdj.k_c.framework.network

import com.google.gson.GsonBuilder
import com.grdj.k_c.framework.network.DTO.Contact
import com.grdj.k_c.framework.resources.ResourcesProvider
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class ContactServiceImpl @Inject constructor(
    private val resourcesProvider: ResourcesProvider) : ContactService
    {
    private var base_url = resourcesProvider.getAPI_URL()
    val gson = GsonBuilder()
        .excludeFieldsWithoutExposeAnnotation()
        .create()

    private val api = Retrofit.Builder()
        .baseUrl(base_url)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
        .create(contactAPI::class.java)

    override suspend fun getContactFromNetwork() : List<Contact> {
        return api.getContact()
    }
}