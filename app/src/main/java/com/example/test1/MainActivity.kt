package com.example.test1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private var recyclerView : RecyclerView? = null
    private var adapter: Adapter? = null
    private var movieList = mutableListOf<Productos>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listDataInRecycler()
    }

    private fun listDataInRecycler(){
        movieList = ArrayList()
        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        adapter = Adapter(movieList)
        recyclerView!!.layoutManager = LinearLayoutManager(this)
        recyclerView!!.adapter = adapter

        ApiClient.instance.getProducts().enqueue(object : Callback<CallApi>{
            override fun onResponse(call: Call<CallApi>, response: Response<CallApi>) {
                if (response.isSuccessful){
                    response.body()?.products?.forEach {productos ->
                        movieList.add(productos)
                        adapter!!.notifyDataSetChanged()
                    }
                }
            }
            override fun onFailure(call: Call<CallApi>, t: Throwable) {
                println(t.message.toString())
            }

        })

        adapter!!.onItemClick = {
            val intent = Intent(this,Detalles_productos::class.java)
            intent.putExtra("product",it)
            startActivity(intent)
        }
    }
}