package com.sitaram.composedesign.features.database

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class UserRepository(application: Application) {

//    private val coroutineScope = CoroutineScope(Dispatchers.Main)
//    private var usersDao: Dao? = null
//
//    // register
//    suspend fun insertUser(newUser: UserPojo) {
//        usersDao?.registerUser(newUser)
//    }
//
//    // login
//    suspend fun getUserDetails(name: String, password: String){
//        usersDao?.getLoginUser(name,password)
//    }
//
//    // update
//    suspend fun updateUserDetails(newUser: UserPojo) {
//        usersDao?.updateUser(newUser)
//    }
//
//    // delete
//    suspend fun deleteCustomerById(id: Int) {
//        usersDao?.deleteUserById(id)
//    }
//
//    init {
//        val database = DatabaseHelper.getDatabaseInstance(application)
//        usersDao = database?.userDao()
//    }
}