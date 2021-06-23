package com.uitlab.ground_hoseo.mainActivityGroup

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.uitlab.ground_hoseo.R
import kotlinx.android.synthetic.main.card_view_default_layout.view.*
import kotlinx.android.synthetic.main.card_view_layout.view.*

class MainPageScrollViewAdapter(private val context: Context): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var mLastClickTime : Long = 0
    var data = mutableListOf<Item>()

    interface OnItemClickListener{
        fun onItemClick(v: View, data: Item, pos: Int, data_t: MutableList<Item>)
    }

    private var listener : OnItemClickListener? = null

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    interface OnItemClickListener1{
        fun onItemClick1(v: View, data: Item, pos: Int, data_t: MutableList<Item>)
    }

    private var listener1 : OnItemClickListener1? = null

    fun setOnItemClickListener1(listener1: OnItemClickListener1) {
        this.listener1 = listener1
    }



    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): RecyclerView.ViewHolder {
        val view: View?
        return when(viewType){
            multi_type1 -> {
                view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_layout, parent, false)
                ViewHolder1(view)
            }
            else -> {
                view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_default_layout, parent, false)
                ViewHolder2(view)
            }
        }

    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when(data[position].type){
            multi_type1 -> {
                (holder as ViewHolder1).bind(data[position])
                holder.setIsRecyclable(false)
            }
            multi_type2 -> {
                (holder as ViewHolder2).bind(data[position])
                holder.setIsRecyclable(false)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return data[position].type
    }

    override fun getItemCount(): Int {
       return data.size
    }

    inner class ViewHolder1(itemView: View): RecyclerView.ViewHolder(itemView){
        internal val image: ImageView = itemView.findViewById(R.id.profile_img)
        internal var title_txt: TextView = itemView.findViewById(R.id.title_txt)
        internal var name_txt: TextView = itemView.findViewById(R.id.name_txt)
        internal var detail_txt: TextView =itemView.findViewById(R.id.detail_context_text)


        fun bind(item: Item){
            //Glide.with(itemView.context)
             //   .load(item.img)
              //  .into(image)
            title_txt.text = item.title
            name_txt.text = item.name
            detail_txt.text = item.content
            val pos = adapterPosition
            if (pos != RecyclerView.NO_POSITION) {
                listener1?.onItemClick1(itemView, item, pos, data)
            }
        }
    }

    inner class ViewHolder2(itemView: View): RecyclerView.ViewHolder(itemView){
        internal val btn: Button = itemView.findViewById(R.id.addbtn)

        fun bind(item: Item){
            val pos = adapterPosition
            if (pos != RecyclerView.NO_POSITION) {
                listener?.onItemClick(itemView.addbtn, item, pos, data)
            }
        }

    }

}