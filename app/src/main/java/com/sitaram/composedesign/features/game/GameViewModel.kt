package com.sitaram.composedesign.features.game

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.sitaram.composedesign.features.game.pojo.GameItems
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GameViewModel {

    private val gameModel = GameModel()
    // to check the API call response
    fun setGames(context: Context) {
        gameModel.getGame().enqueue(object : Callback<List<GameItems>> {
            override fun onResponse(call: Call<List<GameItems>>, response: Response<List<GameItems>>) {
                if (response.isSuccessful) {
                    getGame(response.body())
                    Toast.makeText(context, "Api call Success.", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "Api call BookPojo is unsuccessful.", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<GameItems>>, throwable: Throwable) {
                throwable.printStackTrace()
                Log.d("onFailure", "Api call BookPojo fails: $throwable")
            }
        })
    }
}
