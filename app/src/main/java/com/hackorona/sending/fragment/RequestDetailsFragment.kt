package com.hackorona.sending.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.hackorona.sending.R
import com.hackorona.sending.data.RequestInfo
import com.hackorona.sending.databinding.RequestDetailsFragmentBinding
import com.hackorona.sending.databinding.RequestListFragmentBinding
import com.hackorona.sending.viewmodel.RequestDetailsViewModel

class RequestDetailsFragment(val request: RequestInfo) : Fragment() {
    companion object {
        fun newInstance(request: RequestInfo) = RequestDetailsFragment(request)
    }

    private val viewModel: RequestDetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: RequestDetailsFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.request_details_fragment, container, false
        )
        binding.obj = request
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val acceptButton = view.findViewById<Button>(R.id.accept_button)
        val deleteButton = view.findViewById<Button>(R.id.delete_button)

        acceptButton.setOnClickListener {
            acceptButton.text = "I'm here"
            deleteButton.text = "Cancel"
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        requireActivity().title = request.title
    }
}
