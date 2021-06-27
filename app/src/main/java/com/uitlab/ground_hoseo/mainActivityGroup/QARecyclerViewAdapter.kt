package com.uitlab.ground_hoseo.mainActivityGroup

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.uitlab.ground_hoseo.R

class QARecyclerViewAdapter(private val context: Context): RecyclerView.Adapter<QARecyclerViewAdapter.ViewHolder>() {
    var datas = mutableListOf<GroupData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QARecyclerViewAdapter.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.main_recyclerview_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: QARecyclerViewAdapter.ViewHolder, position: Int) {
        holder.bind(datas[position])
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        private val title: TextView = itemView.findViewById(R.id.item_title)
        private val name: TextView = itemView.findViewById(R.id.item_name)
        private val img: ImageView = itemView.findViewById(R.id.item_img)

        fun bind(item: GroupData){
            title.text = item.title
            name.text = item.name
            Glide.with(itemView).load(item.img).into(img)
        }
    }

}