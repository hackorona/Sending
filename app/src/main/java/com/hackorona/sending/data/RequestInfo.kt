package com.hackorona.sending.data

import com.hackorona.sending.util.getTimeAgo
import java.io.Serializable
import java.util.*

data class RequestInfo(
    val title: String,
    val time: Long,
    val location: String,
    val category: RequestCategory,
    val description: String?,
    val priority: RequestPriority
) : Serializable {
    val relativeTime: String
        get() = Date(time).getTimeAgo()
}
