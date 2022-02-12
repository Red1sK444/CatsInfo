package com.r3d1r4ph.catsinfo.feature.cats.list.presentation.recycler

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.r3d1r4ph.catsinfo.R

class CatItemDecoration : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        val position = parent.getChildAdapterPosition(view)
        if (position == RecyclerView.NO_POSITION) return

        val margin16 = parent.context.resources.getDimensionPixelSize(R.dimen.margin_16)

        outRect.apply {
            left = margin16
            top = margin16
            right = margin16
            bottom = margin16
        }
    }
}