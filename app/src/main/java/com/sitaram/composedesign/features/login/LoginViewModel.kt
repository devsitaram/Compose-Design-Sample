package com.sitaram.composedesign.features.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.sitaram.composedesign.features.database.UserPojo
import com.sitaram.composedesign.features.database.UserRepository
import kotlinx.coroutines.launch

class LoginViewModel(appObj: Application) : AndroidViewModel(appObj) {

//    private val userRepository: UserRepository = UserRepository(appObj)
//
//    fun registerUser(userPojo: UserPojo) {
//        viewModelScope.launch {
//            userRepository.insertUser(newUser = userPojo)
//        }
//
//    }
//
//    fun getLoginUser(userName: String, userPassword: String) {
//        viewModelScope.launch {
//            userRepository.getUserDetails(name = userName, password = userPassword)
//        }
//
//    }
//
//    fun updateUser(user: UserPojo) {
//        viewModelScope.launch {
//            userRepository.updateUserDetails(newUser = user)
//        }
//    }
//
//    fun deleteUserById(id: Int) {
//        viewModelScope.launch {
//            userRepository.deleteCustomerById(id = id)
//        }
//    }
}