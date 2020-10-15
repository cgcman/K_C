package com.grdj.k_c.framework.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ContactEntity::class], version = 1, exportSchema = false)
internal abstract class KC_Database : RoomDatabase() {

    companion object {

        private const val DATABASE_NAME = "kc.db"

        private var instance: KC_Database? = null

        private fun create(context: Context): KC_Database =
            Room.databaseBuilder(context, KC_Database::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()


        fun getInstance(context: Context): KC_Database =
            (instance ?: create(context)).also { instance = it }
    }

    abstract fun contactDao(): ContactDao
}