package com.grdj.k_c.framework.errormanager

interface ErrorManagerHelper {
    suspend fun <T> dataCall(dataCall: suspend () -> T): ResultWrapper<T>
}