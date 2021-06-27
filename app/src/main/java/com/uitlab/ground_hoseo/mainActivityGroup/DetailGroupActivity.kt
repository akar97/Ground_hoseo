package com.uitlab.ground_hoseo.mainActivityGroup

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.uitlab.ground_hoseo.R
import github.com.st235.lib_expandablebottombar.ExpandableBottomBar
import kotlinx.android.synthetic.main.detail_group_activity_layout.*

class DetailGroupActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_group_activity_layout)

        val bottomBar: ExpandableBottomBar = findViewById(R.id.expandable_bottom_bar)
        viewpager_test.adapter = DetailGroupFragmentAdapter(this)
        viewpager_test.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        viewpager_test.isUserInputEnabled = false //뷰페이저 스와이프 막기

        bottomBar.onItemSelectedListener = { view, menuItem, _ ->
            when(menuItem.id){
                R.id.introduce_frag ->
                    viewpager_test.currentItem = 0
                R.id.video_frag ->
                    viewpager_test.currentItem = 1
                R.id.notice_frag ->
                    viewpager_test.currentItem = 2
                R.id.qa_frag ->
                    viewpager_test.currentItem = 3
            }
        }



    }
}