package com.hwc.utils;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.didi365.speech.manager.bean.VoiceExtraBean;
import com.hwc.speech.listener.OnRecognitionListener;
import com.hwc.speech.listener.OnSelectSceneListener;

import org.qiyi.video.svg.Andromeda;
import org.qiyi.video.svg.callback.BaseCallback;
import org.qiyi.video.svg.config.DispatcherConstants;
import org.qiyi.video.svg.transfer.RemoteTransfer;

import aidl.module.speech.IVoiceRecognize;
import aidl.module.speech.VoiceData;
import aidl.module.speech.WordSlotData;

public class SpeechUtil extends BaseProcessUtil {

    private static final String TAG = SpeechUtil.class.getSimpleName();

    private OnRecognitionListener recognitionListener;

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


    /**
     * 启动识别
     *
     * @param voiceData
     * @param onRecognitionListener
     * @return
     */
    public boolean start(VoiceData voiceData, final OnRecognitionListener onRecognitionListener) {
        if (null == context) {
            Log.d(TAG, "SpeechUtil Not init Context Is Null");
            return false;
        }
        RemoteTransfer.getInstance().setCurrentAuthority(DispatcherConstants.AUTHORITY_VOICE);
        IBinder iVoiceRecognize = Andromeda.with(context).getRemoteService(IVoiceRecognize.class);
        if (null == iVoiceRecognize) {
            Log.d(TAG, "iVoiceRecognize is Null");
            return false;
        }
        IVoiceRecognize buyApple = IVoiceRecognize.Stub.asInterface(iVoiceRecognize);
        if (null != buyApple) {
            try {
                this.recognitionListener = onRecognitionListener;
                buyApple.startReco(voiceData, new BaseCallback() {
                    @Override
                    public void onSucceed(Bundle result) {
                        if (recognitionListener != null) {
                            int speechCallBackState = result.getInt("speechCallBackState");
                            VoiceExtraBean voiceExtraBean = (VoiceExtraBean) result.getSerializable("voiceExtraBean");
                            recognitionListener.onRecognitionState(speechCallBackState, voiceExtraBean);
                            org.qiyi.video.svg.log.Logger.d("voiceExtraBean: " + voiceExtraBean.toString());
                        }
                    }

                    @Override
                    public void onFailed(String reason) {
                        org.qiyi.video.svg.log.Logger.e("failed: " + reason);
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
     *
     * @return
     */
    public boolean stop() {
        releaseListener();
        if (null == context) {
            Log.d(TAG, "SpeechUtil Not init Context Is Null");
            return false;
        }
        RemoteTransfer.getInstance().setCurrentAuthority(DispatcherConstants.AUTHORITY_VOICE);
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

    /**
     * 释放设置的监听器
     */
    public void releaseListener() {
        recognitionListener = null;
    }

    /**
     * 更新词槽
     *
     * @param wordSlotData
     */
    public boolean updateWordSlot(WordSlotData wordSlotData) {
        if (null == context) {
            Log.d(TAG, "SpeechUtil Not init Context Is Null");
            return false;
        }
        RemoteTransfer.getInstance().setCurrentAuthority(DispatcherConstants.AUTHORITY_VOICE);
        IBinder iVoiceRecognize = Andromeda.with(context).getRemoteService(IVoiceRecognize.class);
        if (null == iVoiceRecognize) {
            Log.d(TAG, "iVoiceRecognize is Null");
            return false;
        }
        IVoiceRecognize buyApple = IVoiceRecognize.Stub.asInterface(iVoiceRecognize);
        if (null != buyApple) {
            try {
                buyApple.updateWordSlot(wordSlotData);
                return true;
            } catch (RemoteException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }


    /**
     * 是否在进行小喵识别
     */
    public boolean isStartVoiceSpeech() {
        if (null == context) {
            Log.d(TAG, "SpeechUtil Not init Context Is Null");
            return false;
        }
        RemoteTransfer.getInstance().setCurrentAuthority(DispatcherConstants.AUTHORITY_VOICE);
        IBinder iVoiceRecognize = Andromeda.with(context).getRemoteService(IVoiceRecognize.class);
        if (null == iVoiceRecognize) {
            Log.d(TAG, "iVoiceRecognize is Null");
            return false;
        }
        IVoiceRecognize buyApple = IVoiceRecognize.Stub.asInterface(iVoiceRecognize);
        if (null != buyApple) {
            try {
                return buyApple.isStartVoiceSpeech();
            } catch (RemoteException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }


    /**
     * 是否在进行录音识别
     */
    public boolean isStartRecognition() {
        if (null == context) {
            Log.d(TAG, "SpeechUtil Not init Context Is Null");
            return false;
        }
        RemoteTransfer.getInstance().setCurrentAuthority(DispatcherConstants.AUTHORITY_VOICE);
        IBinder iVoiceRecognize = Andromeda.with(context).getRemoteService(IVoiceRecognize.class);
        if (null == iVoiceRecognize) {
            Log.d(TAG, "iVoiceRecognize is Null");
            return false;
        }
        IVoiceRecognize buyApple = IVoiceRecognize.Stub.asInterface(iVoiceRecognize);
        if (null != buyApple) {
            try {
                return buyApple.isStartRecognition();
            } catch (RemoteException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }


    /**
     * 启动识别
     *
     * @param voiceData
     * @param onSelectSceneListener
     * @return
     */
    public boolean startSelectScene(VoiceData voiceData, final OnSelectSceneListener onSelectSceneListener) {
        if (null == context) {
            Log.d(TAG, "SpeechUtil Not init Context Is Null");
            return false;
        }
        RemoteTransfer.getInstance().setCurrentAuthority(DispatcherConstants.AUTHORITY_VOICE);
        IBinder iVoiceRecognize = Andromeda.with(context).getRemoteService(IVoiceRecognize.class);
        if (null == iVoiceRecognize) {
            Log.d(TAG, "iVoiceRecognize is Null");
            return false;
        }
        IVoiceRecognize buyApple = IVoiceRecognize.Stub.asInterface(iVoiceRecognize);
        if (null != buyApple) {
            try {
                buyApple.startSelectScene(voiceData, new BaseCallback() {
                    @Override
                    public void onSucceed(Bundle bundle) {
                        if (onSelectSceneListener != null) {
                            int speechCallBackState = bundle.getInt("speechCallBackState");
                            String result = bundle.getString("result");
                            String state = bundle.getString("state");
                            int position = bundle.getInt("position", -1);
                            onSelectSceneListener.onStateCall(speechCallBackState, result, state, position);
                            org.qiyi.video.svg.log.Logger.d("speechCallBackState: " + speechCallBackState + " result: " + result + " state: " + state + " position: " + position);
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
     *
     * @return
     */
    public boolean stopScene() {
        if (null == context) {
            Log.d(TAG, "SpeechUtil Not init Context Is Null");
            return false;
        }
        RemoteTransfer.getInstance().setCurrentAuthority(DispatcherConstants.AUTHORITY_VOICE);
        IBinder iVoiceRecognize = Andromeda.with(context).getRemoteService(IVoiceRecognize.class);
        if (null == iVoiceRecognize) {
            Log.d(TAG, "iVoiceRecognize is Null");
            return false;
        }
        IVoiceRecognize buyApple = IVoiceRecognize.Stub.asInterface(iVoiceRecognize);
        if (null != buyApple) {
            try {
                buyApple.stopScene();
                return true;
            } catch (RemoteException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

}
