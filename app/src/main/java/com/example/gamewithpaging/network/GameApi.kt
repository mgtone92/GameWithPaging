package com.example.gamewithpaging.network

import com.example.gamewithpaging.model.Game
import com.example.gamewithpaging.model.GameDetailModel
import com.example.gamewithpaging.model.GameResults
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GameApi {

//    https://api.rawg.io/api/games?ordering=%22released%22&platforms=4&page_size=10&page=1&key=905bf28dea024135b163cb11b38ced30
    @GET("games")
    suspend fun getGamesList(
        @Query("page_size") size: Int,
        @Query("page") page: Int,
        @Query("ordering") ordered: String,
        @Query("platforms") platforms: String,
        @Query("metacritic") metacritic: String,
        @Query("key") key: String
    ): Game

    @GET("games/{id}")
    suspend fun getGameDetail(
        @Path("id") gamesId: String,
        @Query("key") key: String
    ): GameDetailModel
}