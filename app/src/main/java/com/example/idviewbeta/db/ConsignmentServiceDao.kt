package com.example.idviewbeta.db

import androidx.room.*

@Dao
interface ConsignmentServiceDao {

    @Query("SELECT * FROM ConsignmentService")
    fun getAllConService() : List<ConsignmentService>

    @Insert
    fun insertConService(conService : ConsignmentService)

    @Delete
    fun deleteConService(conService : ConsignmentService)

    @Update
    fun updateConService(conService : ConsignmentService)

}