package com.sunggyun.networkcheck;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.widget.Toast;

import androidx.annotation.NonNull;


/**
 * 11.26.2019 TUE written by Thomas Park
 */
public class NetworkConnectionStateMoniterJava extends ConnectivityManager.NetworkCallback {

    private Context context;
    private NetworkRequest networkRequest;
    private ConnectivityManager connectivityManager;

    public NetworkConnectionStateMoniterJava(Context context) {
        this.context = context;
        networkRequest =
                new NetworkRequest.Builder()
                .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
                .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
                .build();
        this.connectivityManager = (ConnectivityManager) this.context.getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    public void register() {
        this.connectivityManager.registerNetworkCallback(networkRequest, this);
    }

    public void unregister() {
        this.connectivityManager.unregisterNetworkCallback(this);
    }

    @Override
    public void onAvailable(@NonNull Network network) {
        super.onAvailable(network);
        // Do what you need to do here
        // 네트워크가 연결되었을 때 할 동작
        Toast.makeText(this.context, "network available", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLost(@NonNull Network network) {
        super.onLost(network);
        // Do what you need to do here
        // 네트워크 연결이 끊겼을 때 할 동작
        Toast.makeText(this.context, "network lost", Toast.LENGTH_SHORT).show();
    }
}
