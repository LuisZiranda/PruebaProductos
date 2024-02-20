package com.example.test1

import retrofit2.Call
import retrofit2.http.GET

interface MyApi {
    @GET("products")
    fun getProducts(): Call<CallApi>
}
