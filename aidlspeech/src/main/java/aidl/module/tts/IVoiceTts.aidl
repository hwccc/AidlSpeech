// IMyAidlInterface.aidl
package aidl.module.tts;
import aidl.module.tts.TtsData;
import org.qiyi.video.svg.IPCCallback;

interface IVoiceTts {
    int play(in TtsData result, IPCCallback callback);
    int stop(in int type);
    int isPlayTts(IPCCallback callback);
}
