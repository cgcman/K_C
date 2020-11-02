package com.grdj.k_c.framework.utils.network

import android.content.Context
import com.grdj.k_c.framework.ext.isConnected

class NetworkManagerImpl(val context: Context): NetworkManager {
    override fun isConnected() = context.isConnected()
}