package com.hwc.utils;

import android.media.AudioManager;
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

public class TtsPlayUtil extends BaseProcessUtil {

    private OnVoiceTtsListener voiceTtsListener;

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
     *
     * @param ttsData
     * @param onVoiceTtsListener
     * @return
     */
    public boolean play(TtsData ttsData, final OnVoiceTtsListener onVoiceTtsListener) {
        IBinder iVoiceTts = checkIsConnect();
        if (iVoiceTts == null) {
            return false;
        }
        IVoiceTts buyApple = IVoiceTts.Stub.asInterface(iVoiceTts);
        if (null != buyApple) {
            try {
                voiceTtsListener = onVoiceTtsListener;
                buyApple.play(ttsData, new BaseCallback() {
                    @Override
                    public void onSucceed(Bundle bundle) {
                        String ttsCallBackState = bundle.getString("ttsCallBackState", "");
                        String result = bundle.getString("result", "");
                        if (voiceTtsListener != null) {
                            voiceTtsListener.onSpeakState(ttsCallBackState, result);
                        }
                        org.qiyi.video.svg.log.Logger.d("ttsCallBackState:" + ttsCallBackState + " result:" + result);
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
     *
     * @param type
     * @return
     */
    public boolean stop(int type) {
        releaseListener();
        IBinder iVoiceTts = checkIsConnect();
        if (iVoiceTts == null) {
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

    /**
     * 设置声道音量
     *
     * @param type
     * @return
     */
    public boolean setVolume(int type, float volume) {
        IBinder iVoiceTts = checkIsConnect();
        if (iVoiceTts == null) {
            return false;
        }
        IVoiceTts buyApple = IVoiceTts.Stub.asInterface(iVoiceTts);
        if (null != buyApple) {
            try {
                buyApple.setVolume(type, volume);
                return true;
            } catch (RemoteException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 释放设置的监听器
     */
    public void releaseListener() {
        voiceTtsListener = null;
    }

    /**
     * 停止Music声道TTs播放
     *
     * @return
     */
    public boolean stopMusicSoundTts() {
        return stop(AudioManager.STREAM_MUSIC);
    }

    /**
     * 停止System声道TTs播放
     *
     * @return
     */
    public boolean stopSystemSoundTts() {
        return stop(AudioManager.STREAM_SYSTEM);
    }



    private IBinder checkIsConnect() {
        if (null == context) {
            Log.d(TAG, "TtsPlayUtil Not init Context Is Null");
            return null;
        }
        RemoteTransfer.getInstance().setCurrentAuthority(DispatcherConstants.AUTHORITY_VOICE);
        IBinder iVoiceTts = Andromeda.with(context).getRemoteService(IVoiceTts.class);
        if (null == iVoiceTts) {
            Log.d(TAG, "iVoiceTts is Null");
            SpeechServiceUtil.getInstance().startService(context);
        }
        return iVoiceTts;
    }
}
