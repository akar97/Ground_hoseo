package com.uitlab.ground_hoseo.detailpage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.uitlab.ground_hoseo.databinding.DetailMainVideoConferenceBinding

class VideoConferenceFragement: Fragment() {

    private var binding: DetailMainVideoConferenceBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View?{
        binding = DetailMainVideoConferenceBinding.inflate(inflater,container,false)

        Glide.with(binding!!.root.context).load("https://fakeimg.pl/334x332/").into(binding!!.videoConfImg)

        return binding!!.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
    }

}