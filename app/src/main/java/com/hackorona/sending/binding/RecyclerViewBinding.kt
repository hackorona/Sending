package com.hackorona.sending.binding

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.annotation.DimenRes
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hackorona.sending.R

@BindingAdapter("setAdapter")
fun bindRecyclerViewAdapter(
    recyclerView: RecyclerView,
    adapter: RecyclerView.Adapter<*>
) {
    recyclerView.setHasFixedSize(true)
    recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
    recyclerView.addItemDecoration(
        ItemOffsetDecoration(
            recyclerView.context,
            R.dimen.recyclerview_item_offset
        )
    )
    recyclerView.adapter = adapter
}

class ItemOffsetDecoration constructor(private val itemOffset: Int) :
    RecyclerView.ItemDecoration() {
    constructor(
        context: Context, @DimenRes itemOffsetId: Int
    ) : this(context.resources.getDimensionPixelSize(itemOffsetId))

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.set(
            itemOffset,
            itemOffset,
            itemOffset,
            if (parent.getChildViewHolder(view).adapterPosition == state.itemCount - 1) itemOffset else 0
        )
    }
}
