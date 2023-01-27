package com.example.retrofitmvvm.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.retrofitmvvm.models.Result

@Database(entities = [Result::class], version = 1)
abstract class QuoteDatabase:RoomDatabase() {
    abstract fun quoteDao(): QuoteDao

    companion object {
        @Volatile
        private var INSTANCE: QuoteDatabase? = null

        fun getDatabase(context: Context): QuoteDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        QuoteDatabase::class.java,
                        "quote_database"
                    ).build()
                }
            }
            return INSTANCE!!
        }
    }
}