package com.hwc.utils;

import android.content.Context;
import android.os.IBinder;

import org.qiyi.video.svg.Andromeda;
import org.qiyi.video.svg.config.DispatcherConstants;
import org.qiyi.video.svg.transfer.RemoteTransfer;

public class BaseProcessUtil {

    protected final String TAG = getClass().getSimpleName();

    protected Context context;

    /**
     * 初始化
     * @param context
     */
    public void init(Context context) {
        this.context = context;
        Andromeda.init(context);
    }

    /**
     * 注册服务
     * @param serviceClass
     * @param stubBinder
     * @param <T>
     */
    public <T extends IBinder> void registerSpeechRemoteService(Class serviceClass, T stubBinder) {
        registerRemoteService(DispatcherConstants.AUTHORITY_VOICE, serviceClass, stubBinder);
    }

    /**
     * 注册服务
     * @param authority
     * @param serviceClass
     * @param stubBinder
     * @param <T>
     */
    public <T extends IBinder> void registerRemoteService(String authority, Class serviceClass, T stubBinder) {
        RemoteTransfer.getInstance().setCurrentAuthority(authority);
        Andromeda.registerRemoteService(serviceClass, stubBinder);
    }

    /**
     * 注销服务
     * @param serviceClass
     */
    public void unregisterRemoteService(Class serviceClass) {
        Andromeda.unregisterRemoteService(serviceClass);
    }

}
