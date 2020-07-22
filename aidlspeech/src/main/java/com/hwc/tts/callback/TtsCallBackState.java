package com.hwc.tts.callback;

import android.support.annotation.StringDef;

/**
 * @author hwc
 */
public class TtsCallBackState {

    public static final String ENTRANCE_START = "进入TTS启动";
    public static final String START = "TTS播放开始";
    public static final String ERROR = "TTS播放异常";
    public static final String END = "TTS播放结束";
    public static final String INTERRUPT_PLAY = "TTS播放被打断";

    /**
     * 自定义一个注解SpeechState
     */
    @StringDef({ENTRANCE_START, START, ERROR, END, INTERRUPT_PLAY})
    public @interface TtsState {

    }

}
