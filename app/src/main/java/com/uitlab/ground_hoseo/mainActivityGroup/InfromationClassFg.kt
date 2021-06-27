package com.uitlab.ground_hoseo.mainActivityGroup

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.uitlab.ground_hoseo.databinding.InformationClassFragmentBinding
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.uitlab.ground_hoseo.R
import kotlinx.android.synthetic.main.main_activity_layout.*

class InfromationClassFg : Fragment(){
    private var binding: InformationClassFragmentBinding? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = InformationClassFragmentBinding.inflate(inflater,container,false)
        Log.d("호출", " 인포 호출")

        return binding!!.root
    }

}