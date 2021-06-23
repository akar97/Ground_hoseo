package com.uitlab.ground_hoseo.detailpage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.uitlab.ground_hoseo.R
import com.uitlab.ground_hoseo.databinding.DetailMainGroupBoardQaBinding
import com.uitlab.ground_hoseo.databinding.DetailMainNoticeBinding
import com.uitlab.ground_hoseo.detailpagenotice.GroupNotice
import com.uitlab.ground_hoseo.detailpagenotice.GroupNoticeRecylerAdapter

class GroupBoardQA: Fragment() {

    private var binding: DetailMainGroupBoardQaBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View?{

        binding = DetailMainGroupBoardQaBinding.inflate(inflater,container,false)

        val list = ArrayList<GroupNotice>()
        list.add(GroupNotice(null, "질문하세요 시발놈련들아!", "21.05.21"))
        list.add(GroupNotice(null, "질문하세요 시발놈련들아!", "21.05.21"))
        list.add(GroupNotice(null, "질문하세요 시발놈련들아!", "21.05.21"))
        list.add(GroupNotice(null, "질문하세요 시발놈련들아!", "21.05.21"))
        list.add(GroupNotice(null, "질문하세요 시발놈련들아!", "21.05.21"))
        list.add(GroupNotice(null, "질문하세요 시발놈련들아!", "21.05.21"))
        list.add(GroupNotice(null, "질문하세요 시발놈련들아!", "21.05.21"))
        list.add(GroupNotice(null, "질문하세요 시발놈련들아!", "21.05.21"))
        list.add(GroupNotice(null, "질문하세요 시발놈련들아!", "21.05.21"))
        list.add(GroupNotice(null, "질문하세요 시발놈련들아!", "21.05.21"))
        list.add(GroupNotice(null, "질문하세요 시발놈련들아!", "21.05.21"))
        list.add(GroupNotice(null, "질문하세요 시발놈련들아!", "21.05.21"))
        list.add(GroupNotice(null, "질문하세요 시발놈련들아!", "21.05.21"))


        val adapter = GroupNoticeRecylerAdapter(list)

        binding!!.drvRlvqa.adapter = adapter
        adapter.notifyDataSetChanged()

        return binding!!.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
    }

}