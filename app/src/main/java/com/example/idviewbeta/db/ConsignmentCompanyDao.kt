package com.example.idviewbeta.db

import androidx.room.*

@Dao
interface ConsignmentCompanyDao {

    @Query("SELECT * FROM ConsignmentCompany")
    fun getAllConCo() : List<ConsignmentCompany>

    @Insert
    fun insertConCo(conCo : ConsignmentCompany)

    @Delete
    fun deleteConCo(conCo : ConsignmentCompany)

    @Update
    fun updateConCo(conCo : ConsignmentCompany)

}