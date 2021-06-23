package com.uitlab.ground_hoseo.mainActivityGroup

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.uitlab.ground_hoseo.databinding.QaFragmentBinding
import com.uitlab.ground_hoseo.databinding.VideoConferenceFragmentBinding

class QAFragment : Fragment() {
    private var binding: QaFragmentBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        Log.d("프래그먼트 호출3", ":호출!")

        binding = QaFragmentBinding.inflate(inflater,container,false)

        return binding!!.root
    }
}