package com.geniusapk.indnews.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {


    //https://newsapi.org/v2/top-headlines?country=in&sortBy=publishedAt&apiKey=8289982b3728484785c88db1e666ed41

    @GET("top-headlines")
    suspend fun getNewsFromService(

        @Query("country") country: String = "in",
        @Query("sortBy") sortBy: String = "publishedAt",
        @Query("category") category: String?,
        @Query("apiKey") apiKey: String = "8289982b3728484785c88db1e666ed41"



        ): Response<NewsModel>


}