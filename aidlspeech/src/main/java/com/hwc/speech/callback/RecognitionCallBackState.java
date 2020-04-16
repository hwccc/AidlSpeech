package com.hwc.speech.callback;

import androidx.annotation.IntDef;

/**
 * @author hwc
 */
public class RecognitionCallBackState {

    /**
     * 开始识别
     */
    public static final int START = 1;
    /**
     * 识别中
     */
    public static final int IDENTIFICATION = 2;

    /**
     * 识别音量
     */
    public static final int VOLUME = 3;

    /**
     * 识别结束
     */
    public static final int STOP = 4;
    /**
     * 识别返回的语义，在识别结束以后进行回调
     */
    public static final int SEMANTICS = 5;

    /**
     * 启动识别错误
     */
    public static final int START_ERROR = 6;

    /**
     * 识别错误
     */
    public static final int SPEECH_ERROR = 7;

    /**
     * 自定义一个注解SpeechState
     */
    @IntDef({START, IDENTIFICATION, VOLUME, STOP, SEMANTICS, START_ERROR, SPEECH_ERROR})
    public @interface RecognitionState {

    }

}
