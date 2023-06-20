package com.example.idviewbeta.db

import androidx.room.*

@Dao
interface PrivacyDao {

    @Query("SELECT * FROM PRIVACY")
    fun getAllPrivacy() : List<Privacy>

    @Insert
    fun insertPrivacy(privacy : Privacy)

    @Delete
    fun deletePrivacy(privacy : Privacy)

    @Update
    fun updatePrivacy(privacy : Privacy)

}