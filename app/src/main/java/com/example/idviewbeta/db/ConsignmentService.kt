package com.example.idviewbeta.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ConsignmentService (

    @PrimaryKey
    val serviceName : String,

    @ColumnInfo
    val consignCompany : String

)