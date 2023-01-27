package com.example.retrofitmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitmvvm.Api.RetrofitHelper
import com.example.retrofitmvvm.Api.RetrofitService
import com.example.retrofitmvvm.repository.QuoteRepository
import com.example.retrofitmvvm.viewModels.MainViewModel
import com.example.retrofitmvvm.viewModels.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = (application as QuoteApplication).quoteRepository
        mainViewModel = ViewModelProvider(this,MainViewModelFactory(repository))[MainViewModel::class.java]

        mainViewModel.quotes.observe(this, Observer {
//            Log.d("abhay",it.results.toString())
            Toast.makeText(this@MainActivity, it.results.size.toString(), Toast.LENGTH_SHORT).show()
        })
    }
}