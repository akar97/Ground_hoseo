package com.uitlab.ground_hoseo.intro

import android.animation.ArgbEvaluator
import android.view.View
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_first.view.*

class IntroPageTransformer(var viewPager: ViewPager) : ViewPager.PageTransformer, ViewPager.OnPageChangeListener {

    private val argbEvaluator: ArgbEvaluator?= ArgbEvaluator()
    private  var color: Int = -1

    init {
        viewPager.addOnPageChangeListener(this)
    }

    override fun transformPage(page: View, position: Float) {
        val pageWidth = page.width
        val pageWidthTimesPosition = pageWidth * position
        val absPosition = Math.abs(position)

        if (position < 0) {
            page.title.alpha = 1.0f - absPosition
            page.title.translationX = -pageWidthTimesPosition * 0.92f
            page.des.alpha = 1.0f - absPosition
            page.des.translationX = -pageWidthTimesPosition * 0.92f
        } else {
            page.title.alpha = 1.0f - absPosition
            page.title.translationX = -pageWidthTimesPosition
            page.des.alpha = 1.0f - absPosition
            page.des.translationX = -pageWidthTimesPosition
        }
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        color = argbEvaluator?.evaluate(positionOffset, (viewPager.adapter as IntroAdapter).getFragmentBackgroundColor(position), (viewPager.adapter as IntroAdapter).getFragmentBackgroundColor(position + 1)) as Int
        viewPager.setBackgroundColor(color)
    }

    override fun onPageSelected(position: Int) {
    }

    override fun onPageScrollStateChanged(state: Int) {
    }
}