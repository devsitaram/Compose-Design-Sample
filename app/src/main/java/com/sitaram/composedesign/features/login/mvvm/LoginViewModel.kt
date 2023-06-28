package com.sitaram.composedesign.features.login.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sitaram.composedesign.features.database.room.UserPojo
import com.sitaram.composedesign.features.database.room.UserRepository
import kotlinx.coroutines.launch

class LoginViewModel(private val userRepository: UserRepository) : ViewModel() {

    fun registerUser(userPojo: List<UserPojo>) {
        userRepository.insertUser(newUser = userPojo)
    }

    fun loginUser(userName: String, userPassword: String) {
        userRepository.getUserDetails(name = userName, password = userPassword)
    }

    fun updateUser(user: UserPojo) {
        userRepository.updateUserDetails(newUser = user)
    }

    fun deleteUserById(id: Int) {
        viewModelScope.launch {
            userRepository.deleteCustomerById(id = id)
        }
    }
}