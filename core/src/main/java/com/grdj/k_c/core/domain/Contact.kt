package domain

data class Contact (
	val id : Int,
	val name : String,
	val companyName : String,
	val isFavorite : Boolean,
	val smallImageURL : String,
	val largeImageURL : String,
	val emailAddress : String,
	val birthdate : String,
	val phone : Phone,
	val address : Address
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