package com.sitaram.composedesign.features.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import io.reactivex.rxjava3.core.Completable

@SuppressWarnings("AndroidUnresolvedRoomSqlReference")
@Dao
interface Dao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun registerUser(userList: List<UserPojo>): Completable?

    @Query("SELECT EXISTS(SELECT * FROM user WHERE user_name =:userName AND user_password =:userPassword)")
    fun getLoginUser(userName: String, userPassword: String): Boolean?

    @Update
    suspend fun updateUser(user: UserPojo)

    @Query("DELETE FROM user where userId = :id")
    suspend fun deleteUserById(id: Int)
}