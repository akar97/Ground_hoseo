package com.uitlab.ground_hoseo.detailpage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.uitlab.ground_hoseo.R
import com.uitlab.ground_hoseo.databinding.DetailMainNoticeBinding
import com.uitlab.ground_hoseo.detailpagenotice.GroupNotice
import com.uitlab.ground_hoseo.detailpagenotice.GroupNoticeRecylerAdapter
import kotlinx.android.synthetic.main.detail_main_notice.view.*

class Notice: Fragment() {

    private var binding: DetailMainNoticeBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View?{
        binding = DetailMainNoticeBinding.inflate(inflater,container,false)

        val list = ArrayList<GroupNotice>()
        list.add(GroupNotice(null, "이번주 수업 시간표", "21.05.21"))
        list.add(GroupNotice(null, "이번주 수업 시간표", "21.05.21"))
        list.add(GroupNotice(null, "이번주 수업 시간표", "21.05.21"))
        list.add(GroupNotice(null, "이번주 수업 시간표", "21.05.21"))
        list.add(GroupNotice(null, "이번주 수업 시간표", "21.05.21"))
        list.add(GroupNotice(null, "이번주 수업 시간표", "21.05.21"))
        list.add(GroupNotice(null, "이번주 수업 시간표", "21.05.21"))
        list.add(GroupNotice(null, "이번주 수업 시간표", "21.05.21"))
        list.add(GroupNotice(null, "이번주 수업 시간표", "21.05.21"))
        list.add(GroupNotice(null, "이번주 수업 시간표", "21.05.21"))
        list.add(GroupNotice(null, "이번주 수업 시간표", "21.05.21"))
        list.add(GroupNotice(null, "이번주 수업 시간표", "21.05.21"))
        list.add(GroupNotice(null, "이번주 수업 시간표", "21.05.21"))
        list.add(GroupNotice(null, "이번주 수업 시간표", "21.05.21"))


        val adapter = GroupNoticeRecylerAdapter(list)

        binding!!.drvRlvT.adapter = adapter
        adapter.notifyDataSetChanged()

        return binding!!.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }

    override fun onResume() {
        super.onResume()
    }
}