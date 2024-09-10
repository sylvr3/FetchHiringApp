package com.sylvr3.fetchhiringapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sylv3.fetchhiringapp.R
import com.sylvr3.fetchhiringapp.adapter.HiringListItemAdapter
import com.sylvr3.fetchhiringapp.data.HiringListRepository
import com.sylvr3.fetchhiringapp.model.HiringListItem
import com.sylvr3.fetchhiringapp.utils.HiringListUtils
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var adapter: HiringListItemAdapter

    @Inject
    lateinit var dataRepository: HiringListRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        dataRepository.getData().enqueue(object : Callback<MutableList<HiringListItem>> {
            override fun onResponse(
                call: Call<MutableList<HiringListItem>>,
                response: Response<MutableList<HiringListItem>>
            ) {
                if (response.isSuccessful) {
                    // only return items in list that are not null or empty
                    val items = response.body()?.filter { !it.name.isNullOrBlank() } ?: emptyList()
                    val groupedItems = HiringListUtils.processItems(items)
                    adapter = HiringListItemAdapter(groupedItems)
                    recyclerView.adapter = adapter
                }

            }

            override fun onFailure(call: Call<MutableList<HiringListItem>>, t: Throwable) {
                TODO("Not yet implemented")
                //TODO print stack trace using preferred approach
            }
        })
    }


}




