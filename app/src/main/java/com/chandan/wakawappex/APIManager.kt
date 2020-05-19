package com.chandan.wakawappex

import retrofit2.Callback
import retrofit2.create

object APIManager {

    fun getPhotos(callback:Callback<List<MyPhoto>>){

        App.instance!!.retrofit.create(APIService::class.java).getPhotos()
            .enqueue(callback)
    }
}