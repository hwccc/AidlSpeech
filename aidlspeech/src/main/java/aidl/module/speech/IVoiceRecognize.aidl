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
    int cancelReco();
    int isStartReco(IPCCallback callback);
    int updateWordSlot(in WordSlotData wordSlotData);
}
