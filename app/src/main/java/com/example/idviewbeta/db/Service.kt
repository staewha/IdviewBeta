package com.example.idviewbeta.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Service (

    @PrimaryKey
    var serviceName : String,

    @ColumnInfo(name = "serviceDomain")
    var serviceDomain : String,

    @ColumnInfo(name = "policyDomain")
    var policyDomain : String

)