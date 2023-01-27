package com.example.retrofitmvvm.Api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitHelper {
    private const val base_url = "https://quotable.io/"

    fun getInstance():Retrofit{
        return Retrofit.Builder().baseUrl(base_url).addConverterFactory(GsonConverterFactory.create()).build()
    }
}