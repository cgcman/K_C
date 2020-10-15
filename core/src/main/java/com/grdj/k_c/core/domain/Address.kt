package domain

import com.google.gson.annotations.SerializedName

data class Address (
	@SerializedName("street") val street : String,
	@SerializedName("city") val city : String,
	@SerializedName("state") val state : String,
	@SerializedName("country") val country : String,
	@SerializedName("zipCode") val zipCode : Int
)