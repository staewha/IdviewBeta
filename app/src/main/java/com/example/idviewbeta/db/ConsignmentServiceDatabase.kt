package com.example.idviewbeta.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Service::class], version=1)
abstract class ConsignmentServiceDatabase : RoomDatabase() {
    abstract fun conServiceDao() : ConsignmentServiceDao

    companion object {
        private var INSTANCE : ConsignmentServiceDatabase ?= null

        fun getConServiceDBInstance(context: Context): ConsignmentServiceDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    ConsignmentServiceDatabase::class.java,
                    "CONSERVICE_DB"
                )
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE!!
        }

    }

}