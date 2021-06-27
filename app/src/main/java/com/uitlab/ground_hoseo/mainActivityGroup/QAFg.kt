package com.uitlab.ground_hoseo.mainActivityGroup

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.uitlab.ground_hoseo.R
import com.uitlab.ground_hoseo.databinding.QaFragmentBinding
import com.uitlab.ground_hoseo.databinding.VideoConferenceFragmentBinding

class QAFg : Fragment() {
    private var binding: QaFragmentBinding? = null
    lateinit var qaRecyclerViewAdapter: QARecyclerViewAdapter
    val datas = mutableListOf<GroupData>()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val activity = context as Activity

        binding = QaFragmentBinding.inflate(inflater,container,false)

        initRecycler(activity)
        return binding!!.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    private fun initRecycler(activity: Activity) {

        qaRecyclerViewAdapter = QARecyclerViewAdapter(activity)
        binding?.rvQaList?.adapter = qaRecyclerViewAdapter
        binding?.rvQaList?.layoutManager = LinearLayoutManager(activity)
        binding?.rvQaList?.addItemDecoration(VerticalItemDecorator(20))
        binding?.rvQaList?.addItemDecoration(HorizontalItemDecorator(10))

        datas.apply {
            add(GroupData(img = R.drawable.kimduk, title = "안드로이드 프로그래밍", name = "김득회"))
            add(GroupData(img = R.drawable.kimduk, title = "인공지능과 운영체제", name = "김득회"))
            add(GroupData(img = R.drawable.kimduk, title = "파이썬", name = "김득회"))
            add(GroupData(img = R.drawable.kimduk, title = "C언어", name = "김득회"))
            add(GroupData(img = R.drawable.kimduk, title = "C#", name = "김득회"))

            qaRecyclerViewAdapter.datas = datas
            qaRecyclerViewAdapter.notifyDataSetChanged()

        }
    }
}