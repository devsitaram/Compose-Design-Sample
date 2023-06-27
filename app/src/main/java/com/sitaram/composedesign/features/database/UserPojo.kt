package com.sitaram.composedesign.features.database

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
class UserPojo {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "userId")
    val id: Int? = null

    @ColumnInfo(name = "userEmail")
    var email: String? = null

    @ColumnInfo(name = "userName")
    var name: String? = null

    @ColumnInfo(name = "userPassword")
    var password: String? = null

    // constructor
    constructor(email: String, name: String, password: String){
        this.email = email
        this.name = name
        this.password = password
    }
}