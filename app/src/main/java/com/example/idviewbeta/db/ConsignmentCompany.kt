package com.example.idviewbeta.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ConsignmentCompany (

    @PrimaryKey
    var companyName : String,

    @ColumnInfo
    var secureLevel : Int,

    @ColumnInfo
    var country : String

)