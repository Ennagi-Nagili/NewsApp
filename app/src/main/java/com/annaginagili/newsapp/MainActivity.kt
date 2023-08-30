package com.annaginagili.newsapp

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var recycler: RecyclerView
    lateinit var adapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler = findViewById(R.id.recycler)

        recycler.setHasFixedSize(true)
        getNews()
    }

    private fun getNews() {
        val call = RetrofitClient.getInstance().getApi().getNews()
        call.enqueue(object : Callback<Results> {
            override fun onResponse(call: Call<Results>, response: Response<Results>) {
                val newsList: Results? = response.body()
                adapter = NewsAdapter(this@MainActivity, newsList!!.results as ArrayList<News>)
                recycler.layoutManager = GridLayoutManager(this@MainActivity, newsList.results.size,
                GridLayoutManager.VERTICAL, false)
                recycler.adapter = adapter
            }

            override fun onFailure(call: Call<Results>, t: Throwable) {
                Toast.makeText(applicationContext, "An error has occured", Toast.LENGTH_LONG).show();
                Log.e("errorin", t.message.toString())
            }
        })
    }
}