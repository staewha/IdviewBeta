package com.example.idviewbeta.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ConsignmentCompany::class], version=1)
abstract class ConComDataBase : RoomDatabase() {
    abstract fun conComDao() : ConsignmentCompanyDao

    companion object {
        private var INSTANCE : ConComDataBase ?= null

        fun getConComDBInstance(context: Context): ConComDataBase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    ConComDataBase::class.java,
                    "CONCOM_DB"
                )
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE!!
        }

    }

}