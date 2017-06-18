package com.devinchen.library.common.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.devinchen.library.common.manager.UtilsManager;

/**
 * CommonLibraryDemo
 * com.devinchen.library.common.utils
 * Created by Devin Chen on 2017/5/25 14:55.
 * explain:网络管理工具
 * 主要用以判断网络状态
 */

public class NetworkUtils extends UtilsManager {
    /**
     * 判断网络是否已经连接
     *
     * @return
     */
    public static boolean isNetworkConnected() {
        if (mContext != null) {
            ConnectivityManager mConnectivityManager =
                    (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
            if (mNetworkInfo != null) {
                return mNetworkInfo.isAvailable();
            }
        }
        return false;
    }

    /**
     * 判断wifi是否已经连接
     *
     * @return
     */
    public static boolean isWifiConnected() {
        if (mContext != null) {
            ConnectivityManager mConnectivityManager =
                    (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mWiFiNetworkInfo =
                    mConnectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            if (mWiFiNetworkInfo != null) {
                return mWiFiNetworkInfo.isAvailable();
            }
        }
        return false;
    }

    /**
     * 判断移动网络是否已经连接
     *
     * @return
     */
    public static boolean isMobileConnected() {
        if (mContext != null) {
            ConnectivityManager mConnectivityManager =
                    (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mMobileNetworkInfo =
                    mConnectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
            if (mMobileNetworkInfo != null) {
                return mMobileNetworkInfo.isAvailable();
            }
        }
        return false;
    }
}
