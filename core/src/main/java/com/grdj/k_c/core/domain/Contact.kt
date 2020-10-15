package domain

import com.google.gson.annotations.SerializedName

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
){
	companion object {
		val EMPTY = Contact(0,
			"",
			"",
			false,
			"",
			"",
			"",
			"",
			Phone("","",""),
			Address("","","","",0))
	}
}