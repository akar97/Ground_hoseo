package com.uitlab.ground_hoseo.mainActivityGroup

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.uitlab.ground_hoseo.R
import github.com.st235.lib_expandablebottombar.ExpandableBottomBar
import kotlinx.android.synthetic.main.main_activity_expansion_layout.*

class SecondActivity : AppCompatActivity() {

    val fragementList = mutableListOf<Fragment>(InfromationClassActivity(),VideoConferenceF(), NoticeFragment(), QAFragment())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity_expansion_layout)

        val bottomBar: ExpandableBottomBar = findViewById(R.id.expandable_bottom_bar)
        val adapter = MainPagerAdapter(this)

        adapter.fragments = fragementList
        mael_viewpager.adapter = adapter
        mael_viewpager.isUserInputEnabled = false //뷰페이저2 스와이프 막기

        bottomBar.onItemSelectedListener = { v, i, _ ->
            when(i.id){
                R.id.introduce_frag -> mael_viewpager.currentItem = 0
                R.id.video_frag -> mael_viewpager.currentItem = 1
                R.id.notice_frag -> mael_viewpager.currentItem = 2
                R.id.qa_frag -> mael_viewpager.currentItem = 3
            }
        }
/*
        Glide.with(this)
            .load(R.drawable.duck)
            .circleCrop()
            .into(profile_img)
 */
    }

}