package com.sunggyun.networkcheck

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.widget.Toast

/**
 * 11.26.2019 TUE written by Thomas Park
 */
class NetworkConnectionStateMonitor(context: Context) : ConnectivityManager.NetworkCallback() {

    private var context : Context? = null
    private var networkRequest: NetworkRequest? = null
    private var connectivityManager : ConnectivityManager? = null

    init {
        this.context = context
        this.networkRequest =
            NetworkRequest.Builder()
            .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
                .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
                .build()
    }

    fun register() {
        connectivityManager = context!!.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        connectivityManager!!.registerNetworkCallback(networkRequest!!, this)
    }

    fun unregister() {
        connectivityManager!!.unregisterNetworkCallback(this)
    }

    override fun onAvailable(network: Network) {
        super.onAvailable(network)
        // Do what you need to do here
        // 네트워크가 연결되었을 때 할 동작
        Toast.makeText(this.context, "network available", Toast.LENGTH_SHORT).show()
    }

    override fun onLost(network: Network) {
        super.onLost(network)
        // Do what you need to do here
        // 네트워크 연결이 끊겼을 때 할 동작
        Toast.makeText(this.context, "network lost", Toast.LENGTH_SHORT).show()
    }
}
