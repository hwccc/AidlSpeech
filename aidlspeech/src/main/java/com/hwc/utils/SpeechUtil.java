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
                buyApple.startReco(voiceData, new BaseCallback() {
                    @Override
                    public void onSucceed(Bundle result) {
                        if (onRecognitionListener != null) {
                            int speechCallBackState = result.getInt("speechCallBackState");
                            VoiceExtraBean voiceExtraBean = (VoiceExtraBean) result.getSerializable("voiceExtraBean");
                            onRecognitionListener.onRecognitionState(speechCallBackState, voiceExtraBean);
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
     * @param result
     * @param onSelectSceneListener
     * @return
     */
    public boolean startSelectScene(String result, final OnSelectSceneListener onSelectSceneListener) {
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
                buyApple.startSelectScene(result, new BaseCallback() {
                    @Override
                    public void onSucceed(Bundle result) {
                        if (onSelectSceneListener != null) {
                            String state = result.getString("state");
                            int position = result.getInt("position", -1);
                            onSelectSceneListener.onStateCall(state, position);
                            org.qiyi.video.svg.log.Logger.d("state：" + state + " position: " + position);
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
