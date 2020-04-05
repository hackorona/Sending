package com.hackorona.sending.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.Observer
import androidx.lifecycle.SavedStateViewModelFactory
import com.hackorona.sending.R
import com.hackorona.sending.activity.RequestDetailsActivity
import com.hackorona.sending.data.RequestInfo
import com.hackorona.sending.databinding.RequestListFragmentBinding
import com.hackorona.sending.viewmodel.RequestListViewModel

class RequestListFragment : Fragment() {
    companion object {
        fun newInstance() = RequestListFragment()
    }

    private val viewModel: RequestListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: RequestListFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.request_list_fragment, container, false
        )
        if (savedInstanceState == null) viewModel.init()
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getRequests().observe(
            viewLifecycleOwner,
            Observer { viewModel.requestListAdapter.requestArray = it })

        viewModel.selectedItem.observe(viewLifecycleOwner, Observer {
            val intent = Intent(requireActivity(), RequestDetailsActivity::class.java)
            intent.putExtra("RequestData", it)
            startActivity(intent)
        })
    }
}
