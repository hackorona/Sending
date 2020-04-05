package com.hackorona.sending.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hackorona.sending.R
import com.hackorona.sending.data.RequestInfo
import com.hackorona.sending.fragment.RequestDetailsFragment

class RequestDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.request_details_activity)
        if (savedInstanceState == null) {
            val fragment = RequestDetailsFragment.newInstance(
                intent.getSerializableExtra("RequestData") as RequestInfo
            )
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, fragment)
                .commitNow()
        }
    }
}
