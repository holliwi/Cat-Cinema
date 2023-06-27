package com.example.ilovexxx.data

import com.example.ilovexxx.model.CinemaData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {

    @Headers("X-API-KEY: e6ec1aeb-b6cf-404a-9200-98b4980737b5")
    @GET("api/v2.2/films/top")
    suspend fun getFilms() : Response<CinemaData>
}