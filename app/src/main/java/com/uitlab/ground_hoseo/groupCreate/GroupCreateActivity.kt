package com.uitlab.ground_hoseo.groupCreate

import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.uitlab.ground_hoseo.R


class GroupCreateActivity : AppCompatActivity(){

    var spinner: Spinner ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.group_add_layout)

        spinner = findViewById(R.id.spinner1)
        val items = resources.getStringArray(R.array.itemList)

        val myAdapter = object : ArrayAdapter<String>(this, R.layout.group_add_spinner_item){
            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                val v = super.getView(position, convertView, parent)

                if(position == count){
                    //마지막 포지션의 textView 를 힌트 용으로 사용합니다.
                    (v.findViewById<View>(R.id.tvItemSpinner) as TextView).text = ""
                    //아이템의 마지막 값을 불러와 hint로 추가해 줍니다.
                    (v.findViewById<View>(R.id.tvItemSpinner) as TextView).hint = getItem(count)
                }
                return v
            }

            override fun getCount(): Int {
                return super.getCount() - 1
            }
        }

        myAdapter.addAll(items.toMutableList())
        myAdapter.add("그룹 최대 인원을 설정하세요")

        spinner?.adapter = myAdapter

        //스피너 초기값을 마지막 아이템으로 설정해 줍니다. (마지막 아이템이 힌트 이기 때문이죠)
        spinner?.setSelection(myAdapter.count)

        //droplist를 spinner와 간격을 두고 나오게 해줍니다.)
        //아이템 크기가 45dp 이므로 45dp 간격을 주었습니다.
        //이때 dp 를 px 로 변환해 주는 작업이 필요합니다.
        spinner?.dropDownVerticalOffset = dipToPixels(45f).toInt()
        spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                when (position) {
                    0 -> {

                    }
                    1 -> {

                    }
                    //...
                    else -> {

                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Log.d("MyTag", "onNothingSelected")
            }

        }


        /*
        val myAdapter = ArrayAdapter(this, R.layout.group_add_spinner_item, items)

        spinner?.adapter = myAdapter

        spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {

                //아이템이 클릭 되면 맨 위부터 position 0번부터 순서대로 동작하게 됩니다.
                when (position) {
                    0 -> {

                    }
                    1 -> {

                    }
                    //...
                    else -> {

                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }

         */
    }

    private fun dipToPixels(dipValue: Float): Float {
        return TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                dipValue,
                resources.displayMetrics
        )
    }
}