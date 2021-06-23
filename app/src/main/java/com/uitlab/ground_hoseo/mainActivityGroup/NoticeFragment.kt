package com.uitlab.ground_hoseo.mainActivityGroup

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.uitlab.ground_hoseo.databinding.NoticeFragmentBinding
import com.uitlab.ground_hoseo.databinding.QaFragmentBinding

class NoticeFragment: Fragment() {
    private var binding: NoticeFragmentBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        Log.d("프래그먼트 호출2", ":호출!")

        binding = NoticeFragmentBinding.inflate(inflater,container,false)

        return binding!!.root
    }
}