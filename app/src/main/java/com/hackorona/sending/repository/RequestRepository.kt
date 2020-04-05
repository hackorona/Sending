package com.hackorona.sending.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hackorona.sending.data.RequestCategory
import com.hackorona.sending.data.RequestInfo
import com.hackorona.sending.data.RequestPriority
import java.util.*
import javax.inject.Singleton

@Singleton
class RequestRepository {
    fun getRequests(): LiveData<Array<RequestInfo>> {
        val data = MutableLiveData<Array<RequestInfo>>()
        data.value = arrayOf(
            RequestInfo(
                "Buy me some groceries",
                Calendar.getInstance().timeInMillis,
                "Beit Hakerem, Jerusalem",
                RequestCategory.BUY_DELIVER,
                "I need 2 liters of milk, eggs, bananas, apples. If you could get me lots of toilet paper as well, that'd be great.",
                RequestPriority.NORMAL
            ),
            RequestInfo(
                "Fix my PC",
                Calendar.getInstance().apply { add(Calendar.HOUR_OF_DAY, -1) }.timeInMillis,
                "Hadasa, Jerusalem",
                RequestCategory.TECH,
                "My computer is acting up... I think it has corona virus! Please help, I don't understand computers and I'm too old for this.",
                RequestPriority.HIGH
            ),
            RequestInfo(
                "Move some furniture to help me clean my apartment",
                Calendar.getInstance().apply { add(Calendar.HOUR_OF_DAY, -2) }.timeInMillis,
                "Har Hatsofim, Jerusalem",
                RequestCategory.PHYSICAL_HELP,
                "It's time to clean my old apartment and my grandson is not here to help me move the heavy furniture so I can sweep underneath. If you could help me mop the floor too, I'd be very much grateful!",
                RequestPriority.LOW
            ),
            RequestInfo(
                "Zoom is so confusing!",
                Calendar.getInstance().apply { add(Calendar.HOUR_OF_DAY, -3) }.timeInMillis,
                "God knows where, Maale Adumim",
                RequestCategory.TECH,
                null,
                RequestPriority.HIGH
            )
        )
        return data
    }
}
