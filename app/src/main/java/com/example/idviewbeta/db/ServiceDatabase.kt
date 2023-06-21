package com.example.idviewbeta.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Service::class], version=1)
abstract class ServiceDatabase : RoomDatabase() {
    abstract fun serviceDao() : ServiceDao

    companion object {
        private var INSTANCE : ServiceDatabase ?= null

        fun getServiceDBInstance(context: Context): ServiceDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    ServiceDatabase::class.java,
                    "SERVICE_DB"
                )
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE!!
        }

    }

}