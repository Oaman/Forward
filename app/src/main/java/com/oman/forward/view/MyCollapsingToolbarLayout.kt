package com.oman.forward.view

import android.content.Context
import android.util.AttributeSet
import android.view.WindowInsets
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.oman.forward.R

class MyCollapsingToolbarLayout : CollapsingToolbarLayout {
    private var topInset = 0
    private val ignoreInsetTopInHeight: Boolean

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
            context,
            attrs,
            defStyleAttr
    ) {
        val a = context.obtainStyledAttributes(attrs,
                        R.styleable.MyCollapsingToolbarLayout, defStyleAttr, 0)
        ignoreInsetTopInHeight =
                a.getBoolean(R.styleable.MyCollapsingToolbarLayout_ignoreInsetTopInHeight,
                        false)
        a.recycle()
    }

    override fun dispatchApplyWindowInsets(insets: WindowInsets?): WindowInsets {
        topInset = insets?.systemWindowInsetTop ?: 0
        return super.dispatchApplyWindowInsets(insets)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val mode: Int = MeasureSpec.getMode(heightMeasureSpec)
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        if (ignoreInsetTopInHeight && mode == MeasureSpec.UNSPECIFIED && topInset > 0) {
            super.onMeasure(
                    widthMeasureSpec,
                    MeasureSpec.makeMeasureSpec(measuredHeight - topInset, MeasureSpec.EXACTLY)
            )
        }
    }
}