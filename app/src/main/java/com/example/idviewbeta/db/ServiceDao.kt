package com.example.idviewbeta.db

import androidx.room.*

@Dao
interface ServiceDao {

    @Query("SELECT * FROM SERVICELIST")
    fun getAllService() : List<Service>

    @Insert
    fun insertService(service : Service)

    @Delete
    fun deleteService(service : Service)

    @Update
    fun updateService(service : Service)

}