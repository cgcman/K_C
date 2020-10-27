package com.grdj.k_c.framework.network.DTO

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Contact (
	@SerializedName("id") val id : Int,
	@SerializedName("name") val name : String,
	@SerializedName("companyName") val companyName : String,
	@SerializedName("isFavorite") val isFavorite : Boolean,
	@SerializedName("smallImageURL") val smallImageURL : String,
	@SerializedName("largeImageURL") val largeImageURL : String,
	@SerializedName("emailAddress") val emailAddress : String,
	@SerializedName("birthdate") val birthdate : String,
	@SerializedName("phone") val phone : Phone,
	@SerializedName("address") val address : Address
) : Parcelable