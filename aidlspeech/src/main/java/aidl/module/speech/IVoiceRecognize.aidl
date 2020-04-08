// IMyAidlInterface.aidl
package aidl.module.speech;
import aidl.module.speech.VoiceRecognizeResult;
import aidl.module.speech.VoiceData;
import org.qiyi.video.svg.IPCCallback;

interface IVoiceRecognize {
    int startReco(in VoiceData result, IPCCallback callback);
    int setMicData(byte[] micData);
    int stopReco();
    int cancelReco();
}