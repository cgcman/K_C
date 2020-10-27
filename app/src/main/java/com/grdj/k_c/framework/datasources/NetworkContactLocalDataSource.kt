package com.grdj.k_c.framework.datasources

import com.grdj.k_c.core.data.ContactNetworkDataSource
import com.grdj.k_c.framework.network.ContactService
import domain.Address
import domain.Contact
import domain.Phone
import javax.inject.Inject

class NetworkContactLocalDataSource @Inject constructor(
    private val service: ContactService): ContactNetworkDataSource {

    override suspend fun fetch(): List<Contact> {
        return service.getContactFromNetwork().map {
            Contact(
                it.id,
                it.name,
                it.companyName,
                it.isFavorite,
                it.smallImageURL,
                it.largeImageURL,
                it.emailAddress,
                it.birthdate,
                Phone(it.phone.work, it.phone.home, it.phone.mobile),
                Address(it.address.street, it.address.city, it.address.state, it.address.country, it.address.zipCode)
            )
        }
    }
}