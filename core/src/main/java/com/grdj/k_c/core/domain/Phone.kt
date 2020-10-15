package domain

import com.google.gson.annotations.SerializedName

data class Phone (
	@SerializedName("work") val work : String,
	@SerializedName("home") val home : String,
	@SerializedName("mobile") val mobile : String
)