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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity_layout)
    }
}