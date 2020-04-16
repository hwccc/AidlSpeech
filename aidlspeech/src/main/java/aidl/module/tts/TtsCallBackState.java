package aidl.module.tts;

public interface TtsCallBackState {

    String ENTRANCE_START = "进入TTS启动";
    String START = "TTS播放开始";
    String ERROR = "TTS播放异常";
    String END = "TTS播放结束";
    String INTERRUPT_PLAY = "TTS播放被打断";
}
