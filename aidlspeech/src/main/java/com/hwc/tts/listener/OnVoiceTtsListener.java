package com.hwc.tts.listener;

import com.hwc.tts.callback.TtsCallBackState;

/**
 * @author hwc
 */
public interface OnVoiceTtsListener {

    /**
     * TTS播放状态回调
     *
     * @param ttsCallBackState
     */
    void onSpeakState(@TtsCallBackState.TtsState String ttsCallBackState, String stateMsg);

}
