package com.chandan.wakawappex

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.listitem.view.*

class MyAdapter(private val list: List<MyPhoto>) :  RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    interface OnItemClickListener{
        fun onItemClicked(myphoto: MyPhoto)
    }

    var onItemClickListener : OnItemClickListener? = null
    inner class MyViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.listitem, parent, false)) {

        fun bind(myPhoto: MyPhoto) = with(itemView){
            textView.text = myPhoto.title
            Glide.with(context).load(myPhoto.thumbnailUrl).into(imageView)

            setOnClickListener{
                onItemClickListener?.onItemClicked(myPhoto)
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)  = MyViewHolder(parent)


    override fun getItemCount()  = list.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
         holder.bind(list[position])


    }
}