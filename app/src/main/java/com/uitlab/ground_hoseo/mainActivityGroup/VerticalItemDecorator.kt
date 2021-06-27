package com.uitlab.ground_hoseo.mainActivityGroup

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/* Item 간격을 조정해주는 클래스 */
class VerticalItemDecorator(private val divHeight: Int): RecyclerView.ItemDecoration() {
    @Override
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.top = divHeight
        outRect.bottom = divHeight
    }
}