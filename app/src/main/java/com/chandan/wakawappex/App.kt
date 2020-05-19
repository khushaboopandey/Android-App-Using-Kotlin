package com.chandan.wakawappex

import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class App : Application()
{
      lateinit var retrofit: Retrofit

    companion object{
        var instance:App?=null
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        retrofit = Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}