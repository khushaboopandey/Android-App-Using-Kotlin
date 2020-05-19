package com.chandan.wakawappex

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    private  var myphoto : MyPhoto? = null
    companion object {

        fun startActivity(contex: Context, myphoto: MyPhoto) {
            val intent = Intent(contex, DetailsActivity::class.java)
            intent.putExtra("myphoto", myphoto)
            contex.startActivity(intent)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        myphoto  = intent.getParcelableExtra("myphoto")
        textView2.text = myphoto !!.title
        Glide.with(this).load(myphoto!!.url).into(imageView2)

    }
}
