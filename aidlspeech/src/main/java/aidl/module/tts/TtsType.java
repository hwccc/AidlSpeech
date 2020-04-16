package aidl.module.tts;

/**
 * TTS播报类型
 *
 * @author hwc
 */
public interface TtsType {

    /**
     * 百度播报
     * 百度播报分为3种类：
     * 1、离线播报
     * 2、在线播报
     * 3、RestApi播报
     */
    int VOICE_BD_SPEECH = 1;

    /**
     * 小冰播报
     */
    int VOICE_XB_SPEECH = 2;

    /**
     * 讯飞播报
     */
    int VOICE_XF_SPEECH = 3;

    /**
     * 播放播报
     */
    int TTS_PLAY_TYPE_DEFAULT = VOICE_XF_SPEECH;
}
