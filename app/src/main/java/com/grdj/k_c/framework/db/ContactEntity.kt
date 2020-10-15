package com.grdj.k_c.framework.db

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import domain.Address
import domain.Phone

@Entity(tableName = "contacts")
data class ContactEntity (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "companyName") val companyName: String,
    @ColumnInfo(name =" isFavorite") val isFavorite : Boolean,
    @ColumnInfo(name = "smallImageURL") val smallImageURL : String,
    @ColumnInfo(name = "largeImageURL") val largeImageURL : String,
    @ColumnInfo(name = "emailAddress") val emailAddress : String,
    @ColumnInfo(name = "birthdate") val birthdate : String,
    @Embedded val phone : Phone,
    @Embedded val address : Address
)