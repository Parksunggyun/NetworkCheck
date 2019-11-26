package com.sunggyun.networkcheck

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/**
 * 11.26.2019 TUE written by Thomas Park
 */
class MainActivity : AppCompatActivity() {

    companion object {
        val TAG = MainActivity::class.java.simpleName
    }

    lateinit var networkConnectionStateMonitor: NetworkConnectionStateMonitor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        networkConnectionStateMonitor = NetworkConnectionStateMonitor(this)
        networkConnectionStateMonitor.register()

    }

    override fun onDestroy() {
        super.onDestroy()
        networkConnectionStateMonitor.unregister()
    }

}
