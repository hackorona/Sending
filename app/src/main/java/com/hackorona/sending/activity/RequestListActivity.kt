package com.hackorona.sending.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commitNow
import com.hackorona.sending.R
import com.hackorona.sending.fragment.RequestListFragment

class RequestListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.request_list_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.commitNow {
                replace(
                    R.id.container,
                    RequestListFragment.newInstance()
                )
            }
        }
    }
}
