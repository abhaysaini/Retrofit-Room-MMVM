package com.example.retrofitmvvm

import android.app.Application
import com.example.retrofitmvvm.Api.RetrofitHelper
import com.example.retrofitmvvm.Api.RetrofitService
import com.example.retrofitmvvm.db.QuoteDatabase
import com.example.retrofitmvvm.repository.QuoteRepository

class QuoteApplication :Application(){

    lateinit var quoteRepository: QuoteRepository
    override fun onCreate() {
        super.onCreate()
        initalize()
    }

    private fun initalize() {
        val retroService = RetrofitHelper.getInstance().create(RetrofitService::class.java)
        val database = QuoteDatabase.getDatabase(applicationContext)
        quoteRepository = QuoteRepository(retroService,database,applicationContext)
    }
}