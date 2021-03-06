package com.grdj.k_c.framework.resources

import android.content.Context
import com.grdj.k_c.R

class ResourcesProviderImpl(val context: Context) : ResourcesProvider{
    override fun getNotConnectedMessage() = context.resources.getString(R.string.NOT_CONNECTED_MESSAGE)
    override fun getApiError() = context.resources.getString(R.string.API_ERROR)
    override fun getDeleteDBErrorr() = context.resources.getString(R.string.DELETE_DB_ERROR)
    override fun getDeleteDBSuccess() = context.resources.getString(R.string.DELETE_DB_SUCCESS)
    override fun getAPI_URL() = context.resources.getString(R.string.API_SERVICE)
}