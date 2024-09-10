package com.sylvr3.fetchhiringapp.data

import com.sylvr3.fetchhiringapp.model.HiringListItem
import com.sylvr3.fetchhiringapp.service.ApiService
import retrofit2.Call
import javax.inject.Inject

class HiringListRepository @Inject constructor(
    private val apiService: ApiService
) {
    fun getData(): Call<MutableList<HiringListItem>> {
        return apiService.getData()
    }
}