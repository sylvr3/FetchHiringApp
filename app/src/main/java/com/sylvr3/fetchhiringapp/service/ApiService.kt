package com.sylvr3.fetchhiringapp.service

import com.sylvr3.fetchhiringapp.model.HiringListItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("hiring.json")
    fun getData(): Call<MutableList<HiringListItem>>
}
