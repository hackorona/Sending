package com.hackorona.sending.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.hackorona.sending.BR
import com.hackorona.sending.data.RequestInfo
import com.hackorona.sending.viewmodel.RequestListViewModel

class RequestListAdapter(
    private val layoutId: Int,
    private val viewModel: RequestListViewModel
) : RecyclerView.Adapter<RequestListAdapter.GenericViewHolder>() {
    var requestArray: Array<RequestInfo>? = null

    override fun getItemCount(): Int {
        return if (requestArray == null) 0 else requestArray!!.size
    }

    override fun getItemViewType(position: Int): Int {
        return layoutId
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenericViewHolder {
        val binding: ViewDataBinding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.context), viewType, parent, false)
        return GenericViewHolder(
            binding
        )
    }

    override fun onBindViewHolder(holder: GenericViewHolder, position: Int) {
        holder.bind(requestArray!![position], viewModel)
    }

    class GenericViewHolder(private val dataBinding: ViewDataBinding) :
        RecyclerView.ViewHolder(dataBinding.root) {

        fun bind(r: RequestInfo, viewModel: RequestListViewModel) {
            dataBinding.setVariable(BR.obj, r)
            dataBinding.setVariable(BR.viewModel, viewModel)
            dataBinding.executePendingBindings()
        }
    }
}
