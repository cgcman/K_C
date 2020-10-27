package com.grdj.k_c.core.data

import domain.Contact

interface ContactNetworkDataSource {
    suspend fun fetch(): List<Contact>
}