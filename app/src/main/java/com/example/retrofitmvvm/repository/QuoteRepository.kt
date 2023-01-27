package com.example.retrofitmvvm.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.retrofitmvvm.Api.RetrofitService
import com.example.retrofitmvvm.Utlis.NetworkUtils
import com.example.retrofitmvvm.db.QuoteDatabase
import com.example.retrofitmvvm.models.QuoteList

class QuoteRepository(
    private val QuoteService: RetrofitService,
    private val quoteDatabase: QuoteDatabase,
    private val applicationContext: Context
){

    private val quoteLivedata = MutableLiveData<QuoteList>()

    val quotes:LiveData<QuoteList>
    get() = quoteLivedata

    suspend fun getQuote(page:Int){

        if(NetworkUtils.isInternetAvailable(applicationContext)){
            val result = QuoteService.getQuote(page)
            if(result?.body()!=null){
                quoteDatabase.quoteDao().addQuote(result.body()!!.results)
                quoteLivedata.postValue(result.body())
            }
        }
        else{
            val quotes = quoteDatabase.quoteDao().getQuote()
            val quoteList = QuoteList(1,1,1,quotes,1,1)
            quoteLivedata.postValue(quoteList)
        }
    }
}