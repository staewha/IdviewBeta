package com.example.idviewbeta.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Service::class], version=1)
abstract class PrivacyDatabase : RoomDatabase() {
    abstract fun privacyDao() : PrivacyDao

    companion object {
        private var INSTANCE : PrivacyDatabase ?= null

        fun getPrivacyDBInstance(context: Context): PrivacyDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    PrivacyDatabase::class.java,
                    "PRIVACY_DB"
                )
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE!!
        }

    }

}