// IMyAidlInterface.aidl
package aidl.module.speech;
import aidl.module.speech.VoiceRecognizeResult;
import aidl.module.speech.VoiceData;
import aidl.module.speech.WordSlotData;
import org.qiyi.video.svg.IPCCallback;

interface IVoiceRecognize {
    int startReco(in VoiceData result, IPCCallback callback);
    int setMicData(in VoiceData result);
    int stopReco();
    boolean isStartVoiceSpeech();
    boolean isStartRecognition();
    int updateWordSlot(in WordSlotData wordSlotData);
    int startSelectScene(in VoiceData result, IPCCallback callback);
    int stopScene();
    int startWakeup();
    int stopWakeup();
    int setMonitorVoice(boolean isStartMonitorVoice, String packageName);
}
