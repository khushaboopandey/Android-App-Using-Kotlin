package com.chandan.wakawappex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), Callback<List<MyPhoto>>, MyAdapter.OnItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        APIManager.getPhotos(this)

        list.layoutManager = LinearLayoutManager(this, GridLayoutManager.VERTICAL, false)
        list.layoutManager = GridLayoutManager(this, 2)

        list.hasFixedSize()
     }

    override fun onFailure(call: Call<List<MyPhoto>>, t: Throwable) {
        Toast.makeText(this, "Error occurd", Toast.LENGTH_SHORT).show()
    }

    override fun onResponse(call: Call<List<MyPhoto>>, response: Response<List<MyPhoto>>) {
        if (response.isSuccessful){
            if (!response.body().isNullOrEmpty()){
                val adapter = MyAdapter(response.body()!!)

                adapter.onItemClickListener = this@MainActivity
                list.adapter= adapter

            }
        }
            else{
            Toast.makeText(this, "Error occurd", Toast.LENGTH_SHORT).show()

        }


     }

    override fun onItemClicked(myphoto: MyPhoto) {
        DetailsActivity.startActivity(this,myphoto)

    }
}
