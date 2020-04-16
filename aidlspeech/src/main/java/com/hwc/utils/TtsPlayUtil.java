package com.hwc.utils;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.hwc.tts.listener.OnVoiceTtsListener;

import org.qiyi.video.svg.Andromeda;
import org.qiyi.video.svg.callback.BaseCallback;
import org.qiyi.video.svg.config.DispatcherConstants;
import org.qiyi.video.svg.transfer.RemoteTransfer;

import aidl.module.tts.IVoiceTts;
import aidl.module.tts.TtsData;

public class TtsPlayUtil  extends BaseProcessUtil{

    private volatile static TtsPlayUtil instance;

    public static TtsPlayUtil getInstance() {
        if (instance == null) {
            synchronized (TtsPlayUtil.class) {
                if (instance == null) {
                    instance = new TtsPlayUtil();
                }
            }
        }
        return instance;
    }

    private TtsPlayUtil() {

    }


    /**
     * 开始播放
     * @param ttsData
     * @param onVoiceTtsListener
     * @return
     */
    public boolean play(TtsData ttsData, final OnVoiceTtsListener onVoiceTtsListener) {
        if (null == context) {
            Log.d(TAG, "TtsPlayUtil Not init Context Is Null");
            return false;
        }
        RemoteTransfer.getInstance().setCurrentAuthority(DispatcherConstants.AUTHORITY_SPEECH);
        IBinder iVoiceTts = Andromeda.with(context).getRemoteService(IVoiceTts.class);
        if (null == iVoiceTts) {
            Log.d(TAG, "iVoiceTts is Null");
            return false;
        }
        IVoiceTts buyApple = IVoiceTts.Stub.asInterface(iVoiceTts);
        if (null != buyApple) {
            try {
//                TtsData ttsData = new TtsData();
//                ttsData.ttsType = TtsType.VOICE_XF_SPEECH;
//                ttsData.text = "今天天气怎么样？";
                buyApple.play(ttsData, new BaseCallback() {
                    @Override
                    public void onSucceed(Bundle result) {
                        String resultState = result.getString("ResultState", "");
                        String resultStateMsg = result.getString("ResultStateMsg", "");
                        if (onVoiceTtsListener != null) {
                            onVoiceTtsListener.onSpeakState(resultState, resultStateMsg);
                        }
                        org.qiyi.video.svg.log.Logger.d("got remote service with callback in other process(:banana),resultState:" + resultState + " resultStateMsg:" + resultStateMsg);
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
     * 停止播放
     * @param type
     * @return
     */
    public boolean stop(int type) {
        if (null == context) {
            Log.d(TAG, "TtsPlayUtil Not init Context Is Null");
            return false;
        }
        RemoteTransfer.getInstance().setCurrentAuthority(DispatcherConstants.AUTHORITY_SPEECH);
        IBinder iVoiceTts = Andromeda.with(context).getRemoteService(IVoiceTts.class);
        if (null == iVoiceTts) {
            Log.d(TAG, "iVoiceTts is Null");
            return false;
        }
        IVoiceTts buyApple = IVoiceTts.Stub.asInterface(iVoiceTts);
        if (null != buyApple) {
            try {
                buyApple.stop(type);
                return true;
            } catch (RemoteException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

}
