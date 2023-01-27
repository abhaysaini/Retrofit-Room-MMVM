package com.example.retrofitmvvm.Api

import com.example.retrofitmvvm.models.QuoteList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    @GET("/quotes")
    suspend fun getQuote(@Query("page") page:Int):Response<QuoteList>
}