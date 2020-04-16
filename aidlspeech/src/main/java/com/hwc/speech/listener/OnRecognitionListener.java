package com.hwc.speech.listener;

import com.didi365.speech.manager.bean.VoiceExtraBean;
import com.hwc.speech.callback.RecognitionCallBackState;

/**
 * 语音识别回调
 *
 * @author hwc
 * @date 2018/08/09
 */

public interface OnRecognitionListener {

    /**
     * 识别状态回调
     *
     * @param speechCallBackState 识别状态
     * @param voiceExtraBean      识别返回的参数
     */
    void onRecognitionState(@RecognitionCallBackState.RecognitionState int speechCallBackState, VoiceExtraBean voiceExtraBean);

}
