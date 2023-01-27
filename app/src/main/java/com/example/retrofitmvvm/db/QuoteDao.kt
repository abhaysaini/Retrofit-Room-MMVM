package com.example.retrofitmvvm.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.retrofitmvvm.models.Result

@Dao
interface QuoteDao {

    @Insert
    suspend fun addQuote(quotes:List<Result>)

    @Query("SELECT * FROM quote")
    suspend fun getQuote():List<Result>
}