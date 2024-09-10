package com.sylvr3.fetchhiringapp.viewmodel

import com.sylvr3.fetchhiringapp.data.HiringListRepository
import com.sylvr3.fetchhiringapp.model.HiringListItem

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class HiringListViewModel @Inject constructor(
    private val dataRepository: HiringListRepository
) : ViewModel() {

    private val _data = MutableLiveData<List<HiringListItem>>()
    val data: LiveData<List<HiringListItem>> get() = _data

    fun fetchData() {
        dataRepository.getData().enqueue(object : Callback<MutableList<HiringListItem>> {
            override fun onResponse(
                call: Call<MutableList<HiringListItem>>,
                response: Response<MutableList<HiringListItem>>
            ) {
                if (response.isSuccessful) {
                    _data.value = response.body() ?: emptyList()
                }
            }

            override fun onFailure(call: Call<MutableList<HiringListItem>>, t: Throwable) {
                // Handle error
            }
        })
    }
}
