// IRecognizeResult.aidl
package aidl.module.speech;

import aidl.module.speech.VoiceRecognizeResult;
interface IRecognizeResult {
   int sendRecognizeResult(in VoiceRecognizeResult result);
}
