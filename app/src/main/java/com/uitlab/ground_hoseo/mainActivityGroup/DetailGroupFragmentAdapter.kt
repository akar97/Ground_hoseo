package com.uitlab.ground_hoseo.mainActivityGroup

import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.bumptech.glide.Glide
import com.uitlab.ground_hoseo.R

class DetailGroupFragmentAdapter(fa: FragmentActivity): FragmentStateAdapter(fa) {


    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> InfromationClassFg()
            1 -> VideoConferenceFg()
            2 -> NoticeFg()
            else -> QAFg()
        }
    }

}