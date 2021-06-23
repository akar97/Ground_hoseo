package com.uitlab.ground_hoseo.detailpage

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.uitlab.ground_hoseo.databinding.DetailMainBinding

class DetailPage: AppCompatActivity() {
    private lateinit var context: Context
    val binding by lazy { DetailMainBinding.inflate(layoutInflater)}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val fragementList = listOf<Fragment>(VideoConferenceFragement(), Notice(), GroupBoardQA())
        val adapter = DetailPageAdapter(this)
        adapter.fragmentList = fragementList
        binding.detailViewpager.adapter = adapter

        val tabTitles = listOf<String>("화상회의", "공지사항", "Q/A")
        TabLayoutMediator(binding.detailTablayout, binding.detailViewpager) { tab, postion ->
            tab.text = tabTitles[postion]
        }.attach()



    }
}