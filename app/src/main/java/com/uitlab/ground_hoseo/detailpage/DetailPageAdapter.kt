package com.uitlab.ground_hoseo.detailpage

import android.util.Log
import androidx.fragment.app.*
import androidx.viewpager2.adapter.FragmentStateAdapter

class DetailPageAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {

    var fragmentList = listOf<Fragment>()

    override fun getItemCount(): Int {
        Log.d("카운트","${fragmentList.size}")
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {

        val idx = position

        return when(idx){
            0 -> {
                fragmentList[0]
            }
            1 ->{
                fragmentList[1]
            }
            else ->{
                fragmentList[2]
            }
        }
    }


}

