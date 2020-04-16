package com.hwc.speech;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.didi365.speech.manager.bean.VoiceExtraBean;
import com.hwc.speech.listener.OnRecognitionListener;

import org.qiyi.video.svg.Andromeda;
import org.qiyi.video.svg.callback.BaseCallback;
import org.qiyi.video.svg.config.DispatcherConstants;
import org.qiyi.video.svg.transfer.RemoteTransfer;

import aidl.module.speech.IVoiceRecognize;
import aidl.module.speech.VoiceData;

public class SpeechUtil {

    private static final String TAG = SpeechUtil.class.getSimpleName();

    private Context context;

    private volatile static SpeechUtil instance;

    public static SpeechUtil getInstance() {
        if (instance == null) {
            synchronized (SpeechUtil.class) {
                if (instance == null) {
                    instance = new SpeechUtil();
                }
            }
        }
        return instance;
    }

    private SpeechUtil() {

    }

    public void init(Context context) {
        this.context = context;
        Andromeda.init(context);
    }

    /**
     * 启动识别
     * @param voiceData
     * @param onRecognitionListener
     * @return
     */
    public boolean start(VoiceData voiceData, final OnRecognitionListener onRecognitionListener) {
        if (null == context) {
            Log.d(TAG, "SpeechUtil Not init Context Is Null");
            return false;
        }
        RemoteTransfer.getInstance().setCurrentAuthority(DispatcherConstants.AUTHORITY_SPEECH);
        IBinder iVoiceRecognize = Andromeda.with(context).getRemoteService(IVoiceRecognize.class);
        if (null == iVoiceRecognize) {
            Log.d(TAG, "iVoiceRecognize is Null");
            return false;
        }
        IVoiceRecognize buyApple = IVoiceRecognize.Stub.asInterface(iVoiceRecognize);
        if (null != buyApple) {
            try {
                buyApple.startReco(voiceData, new BaseCallback() {
                    @Override
                    public void onSucceed(Bundle result) {
                        if (onRecognitionListener != null) {
                            int speechCallBackState = result.getInt("speechCallBackState");
                            VoiceExtraBean voiceExtraBean = (VoiceExtraBean) result.getSerializable("voiceExtraBean");
                            onRecognitionListener.onRecognitionState(speechCallBackState, voiceExtraBean);
                            org.qiyi.video.svg.log.Logger.d("got remote service with callback in other process(:banana),resultStr:" + voiceExtraBean.toString());
                        }
                    }

                    @Override
                    public void onFailed(String reason) {
                        org.qiyi.video.svg.log.Logger.e("buyAppleOnNet failed,reason:" + reason);
                    }
                });
                return true;
            } catch (RemoteException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 停止识别
     * @return
     */
    public boolean stop() {
        if (null == context) {
            Log.d(TAG, "SpeechUtil Not init Context Is Null");
            return false;
        }
        RemoteTransfer.getInstance().setCurrentAuthority(DispatcherConstants.AUTHORITY_SPEECH);
        IBinder iVoiceRecognize = Andromeda.with(context).getRemoteService(IVoiceRecognize.class);
        if (null == iVoiceRecognize) {
            Log.d(TAG, "iVoiceRecognize is Null");
            return false;
        }
        IVoiceRecognize buyApple = IVoiceRecognize.Stub.asInterface(iVoiceRecognize);
        if (null != buyApple) {
            try {
                buyApple.stopReco();
                return true;
            } catch (RemoteException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

}
