package com.example.idviewbeta.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Privacy (

    @PrimaryKey
    var serviceName : String,

    @ColumnInfo
    var id : Boolean,

    @ColumnInfo
    var passwd : Boolean,

    @ColumnInfo
    var name : Boolean,

    @ColumnInfo
    var emailAddress : Boolean,

    @ColumnInfo
    var phoneNum : Boolean,

    @ColumnInfo
    var address : Boolean,

    @ColumnInfo
    var birth : Boolean,

    @ColumnInfo
    var sex : Boolean,

//    @ColumnInfo
//    var kakaoCI: Boolean,
//
//    @ColumnInfo
//    var naverCI : Boolean,

    @ColumnInfo
    var shippingInfo: Boolean,

    @ColumnInfo
    var paymentInfo : Boolean,

//    @ColumnInfo
//    var customsNumber: Boolean

)