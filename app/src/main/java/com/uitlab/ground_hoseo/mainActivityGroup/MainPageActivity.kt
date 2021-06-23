package com.uitlab.ground_hoseo.mainActivityGroup

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.uitlab.ground_hoseo.R
import com.yarolegovich.discretescrollview.DiscreteScrollView
import kotlinx.android.synthetic.main.main_activity_layout.*
import android.util.Pair
import com.uitlab.ground_hoseo.groupCreate.GroupCreateActivity
import kotlinx.android.synthetic.main.main_activity_expansion_layout.*

class MainPageActivity: AppCompatActivity() {
    lateinit var multiAdapter: MainPageScrollViewAdapter
    val datas = mutableListOf<Item>()
    var scrollView: DiscreteScrollView ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity_layout)

        scrollView = findViewById<DiscreteScrollView>(R.id.picker)
        multiAdapter = MainPageScrollViewAdapter(this)
        scrollView?.adapter = multiAdapter
        initRecycler()

        Glide.with(this)
            .load(R.drawable.duck)
            .circleCrop()
            .into(user_img)


        multiAdapter.setOnItemClickListener(object : MainPageScrollViewAdapter.OnItemClickListener{
            override fun onItemClick(v: View, data: Item, pos: Int, data_t: MutableList<Item>) { // 새로운 카드 추가하는 부분
                Log.d("Pos: ", "$pos")
                v.setOnClickListener {
                    data_t.add(Item(multi_type1, "김우성2", "AI", R.drawable.shop1, "이 수업은 큰일입니다."))
                    multiAdapter.notifyDataSetChanged()
                }
            }

        })
        
        multiAdapter.setOnItemClickListener1(object : MainPageScrollViewAdapter.OnItemClickListener1{
            override fun onItemClick1(v: View, data: Item, pos: Int, data_t: MutableList<Item>) {
                v.setOnClickListener {
                    if(pos > 0) {
                        val intent = Intent(this@MainPageActivity, SecondActivity::class.java)
/*
                        var options : ActivityOptions = ActivityOptions.makeSceneTransitionAnimation(
                                this@MainPageActivity,
                                Pair.create(name_txt, "nameTransition"),
                                Pair.create(title_txt, "contentTransition"),
                                Pair.create(profile_img, "imageTransition")
                        )
                        startActivity(intent, options.toBundle())

 */
                        startActivity(intent)
                    }
                }
            }
        })

        add_group_btn.setOnClickListener {
            val intent = Intent(this@MainPageActivity, GroupCreateActivity::class.java)
            startActivity(intent)
        }
        
    }
    

    fun initRecycler(){
        datas.apply {
            add(Item(multi_type2,"","",0,"")) //카드 추가하는 카드뷰 default
            multiAdapter.data = datas
        }
    }

}