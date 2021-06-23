package com.uitlab.ground_hoseo.mainActivityGroup

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.uitlab.ground_hoseo.databinding.InformationClassFragmentBinding
import androidx.fragment.app.Fragment

class InfromationClassActivity : Fragment(){
    private var binding: InformationClassFragmentBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        Log.d("프래그먼트 호출1", ":호출!")

        binding = InformationClassFragmentBinding.inflate(inflater,container,false)

        return binding!!.root
    }
}