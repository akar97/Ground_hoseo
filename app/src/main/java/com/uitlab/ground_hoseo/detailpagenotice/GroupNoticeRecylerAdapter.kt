package com.uitlab.ground_hoseo.detailpagenotice

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.uitlab.ground_hoseo.R
import kotlinx.android.synthetic.main.detailgroup_notice_item.view.*

class GroupNoticeRecylerAdapter(private val items: ArrayList<GroupNotice>) : RecyclerView.Adapter<GroupNoticeRecylerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupNoticeRecylerAdapter.ViewHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.detailgroup_notice_item, parent, false)
        return GroupNoticeRecylerAdapter.ViewHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: GroupNoticeRecylerAdapter.ViewHolder, position: Int) {
        val item = items[position]
        val listener = View.OnClickListener {
            it -> Toast.makeText(it.context, "clicked", Toast.LENGTH_LONG).show()
        }
        holder.apply {
            bind(listener, item)
            itemView.tag = item
        }
    }

    override fun getItemCount(): Int {
        Log.d("아이템카운드","${items.size}")
        return items.size
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v){
        private val view: View = v
        fun bind(listener: View.OnClickListener, item: GroupNotice){
            Glide.with(view.context).load("https://fakeimg.pl/61x61/").into(view.drv_img)
            view.dtv_rv_content.text= item.contents
            view.dtv_rv_time.text = item.times
            view.setOnClickListener(listener)
        }
    }
}