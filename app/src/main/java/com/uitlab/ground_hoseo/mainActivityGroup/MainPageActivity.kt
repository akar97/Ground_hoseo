package com.uitlab.ground_hoseo.mainActivityGroup

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.uitlab.ground_hoseo.R
import kotlinx.android.synthetic.main.main_activity_layout.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.uitlab.ground_hoseo.groupCreate.GroupCreateActivity
import com.uitlab.ground_hoseo.groupSearch.GroupSearchActivity

class MainPageActivity: AppCompatActivity() {

    lateinit var mainpageRecyclerviewAdapter: MainpageRecyclerviewAdapter
    val datas = mutableListOf<GroupData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity_layout)

        add_group_btn.setOnClickListener {
            Intent(this, GroupCreateActivity::class.java).apply {
            }.run { startActivity(this) }
        }

        search_group_btn.setOnClickListener {
            Intent(this, GroupSearchActivity::class.java).apply {
            }.run { startActivity(this) }
        }

        initRecycler()
    }

    private fun initRecycler() {

        mainpageRecyclerviewAdapter = MainpageRecyclerviewAdapter(this)
        rv_group_list.adapter = mainpageRecyclerviewAdapter
        rv_group_list.layoutManager = LinearLayoutManager(this)
        rv_group_list.addItemDecoration(VerticalItemDecorator(20))
        rv_group_list.addItemDecoration(HorizontalItemDecorator(10))

        datas.apply {
            add(GroupData(img = R.drawable.kimduk, title = "안드로이드 프로그래밍", name = "김득회"))
            add(GroupData(img = R.drawable.kimduk, title = "인공지능과 운영체제", name = "김득회"))
            add(GroupData(img = R.drawable.kimduk, title = "파이썬", name = "김득회"))
            add(GroupData(img = R.drawable.kimduk, title = "C언어", name = "김득회"))
            add(GroupData(img = R.drawable.kimduk, title = "C#", name = "김득회"))

            mainpageRecyclerviewAdapter.datas = datas
            mainpageRecyclerviewAdapter.notifyDataSetChanged()

        }
    }
}