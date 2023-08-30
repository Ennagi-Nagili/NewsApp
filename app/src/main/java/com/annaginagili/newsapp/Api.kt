package com.annaginagili.newsapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("v3/3c86374a-738d-4911-bf09-1dac9e9760e4")
    fun getNews(): Call<Results>
}