package com.example.nawkhabar.api

import com.example.nawkhabar.news.Article
import com.example.nawkhabar.news.NewsClass
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query



const val API_KEY = "Your Api Key"
interface APIInterface {

    @GET("v2/top-headlines?apiKey=$API_KEY")
    fun getData(@Query("country") country : String, @Query("page")page : Int) : Call<NewsClass>
}