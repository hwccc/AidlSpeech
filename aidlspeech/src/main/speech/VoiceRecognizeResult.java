package java.aidl.module.speech;

import android.os.Parcel;
import android.os.Parcelable;


public class VoiceRecognizeResult implements Parcelable {

    /**
     * 识别状态
     */
    public int speechCallBackState;

    /**
     * 消息类型
     */
    public int type;

    /**
     * 返回说话音量
     */
    public String volume;

    /**
     * 用户说话的结果
     */
    public String result;

    /**
     * 识别结果Id
     * 讯飞没有该字段
     */
    public String resultId;

    /**
     * 错误标识码
     */
    public String errorCode;

    /**
     * 错误描述
     */
    public String errorMsg;

    /**
     * 语义
     */
    public String semantics;

    public VoiceRecognizeResult(){

    }

    protected VoiceRecognizeResult(Parcel in) {
        speechCallBackState = in.readInt();
        type = in.readInt();
        volume = in.readString();
        result = in.readString();
        resultId = in.readString();
        errorCode = in.readString();
        errorMsg = in.readString();
        semantics = in.readString();
    }

    public static final Creator<VoiceRecognizeResult> CREATOR = new Creator<VoiceRecognizeResult>() {
        @Override
        public VoiceRecognizeResult createFromParcel(Parcel in) {
            return new VoiceRecognizeResult(in);
        }

        @Override
        public VoiceRecognizeResult[] newArray(int size) {
            return new VoiceRecognizeResult[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(speechCallBackState);
        dest.writeInt(type);
        dest.writeString(volume );
        dest.writeString(result );
        dest.writeString(resultId );
        dest.writeString(errorCode );
        dest.writeString(errorMsg );
        dest.writeString(semantics );
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public String toString() {
        return "VoiceRecognizeResult{" +
                "speechCallBackState=" + speechCallBackState +
                ", type=" + type +
                ", volume='" + volume + '\'' +
                ", result='" + result + '\'' +
                ", resultId='" + resultId + '\'' +
                ", errorCode='" + errorCode + '\'' +
                ", errorMsg='" + errorMsg + '\'' +
                ", semantics='" + semantics + '\'' +
                '}';
    }
}
