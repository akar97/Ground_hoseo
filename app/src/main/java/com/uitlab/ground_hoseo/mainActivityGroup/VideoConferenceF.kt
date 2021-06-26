package com.uitlab.ground_hoseo.mainActivityGroup

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.uitlab.ground_hoseo.databinding.VideoConferenceFragmentBinding

class VideoConferenceF: Fragment() {

    private var binding: VideoConferenceFragmentBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        binding = VideoConferenceFragmentBinding.inflate(inflater,container,false)

        return binding!!.root
    }
}