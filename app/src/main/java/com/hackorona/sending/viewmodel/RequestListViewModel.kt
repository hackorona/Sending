package com.hackorona.sending.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hackorona.sending.R
import com.hackorona.sending.adapter.RequestListAdapter
import com.hackorona.sending.data.RequestInfo
import com.hackorona.sending.repository.RequestRepository

class RequestListViewModel : ViewModel() {
//    val userId: String = TODO()
//    val user: Any = TODO()

    private lateinit var requestRepository: RequestRepository
    lateinit var requestListAdapter: RequestListAdapter

    val selectedItem = MutableLiveData<RequestInfo>()

    fun init() {
        requestRepository = RequestRepository()
        requestListAdapter = RequestListAdapter(
            R.layout.request_item_view,
            this
        )
    }

    fun getRequests(): LiveData<Array<RequestInfo>> {
        return requestRepository.getRequests()
    }

    fun onItemClick(request: RequestInfo) {
        selectedItem.value = request
    }
}
