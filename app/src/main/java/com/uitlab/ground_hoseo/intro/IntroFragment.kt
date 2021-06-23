package com.uitlab.ground_hoseo.intro

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.uitlab.ground_hoseo.R
import com.uitlab.ground_hoseo.login.Login
import kotlinx.android.synthetic.main.activity_second.view.*

const val BACKGROUND_COLOR = "backgroundColor"
const val PAGE = "page"

class IntroFragment : Fragment() {

    private var mBackgroundColor: Int? = null
    private var mPage: Int? = null

    companion object {
        fun newInstance(backgroundColor: Int, page: Int): IntroFragment {
            val frag = IntroFragment()
            val bundle = Bundle()
            bundle.putInt(BACKGROUND_COLOR, backgroundColor)
            bundle.putInt(PAGE, page)
            frag.arguments = bundle
            return frag
        }
    }

    fun getBackgroundColor(): Int? = mBackgroundColor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBackgroundColor = arguments?.getInt(BACKGROUND_COLOR)
        mPage = arguments?.getInt(PAGE)
    }



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view =
            if (mPage == 0) inflater.inflate(R.layout.activity_first, container, false) else inflater.inflate(R.layout.activity_second, container, false)
        view.tag = mPage

        view?.btnlogin?.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                Log.d("확인", "확인")
                val intent = Intent(context, Login::class.java)
                startActivity(intent)
            }
        })

        return view
    }

}