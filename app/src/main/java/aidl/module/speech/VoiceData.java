package aidl.module.speech;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by huang on 17/2/14.
 */

public class VoiceData implements Parcelable {

    /**
     * 音频数据
     */
    public byte[] data;

    /**
     * 是否启动长语音识别
     */
    public boolean isLongSpeech;

    /**
     * 识别时间
     */
    public long speechTime;

    /**
     * 遇到异常是否自动从其
     */
    public boolean isErrorRestart;

    /**
     * 是否返回语义
     */
    public boolean isReturnSemantics;


    public VoiceData() {

    }

    protected VoiceData(Parcel in) {
        data = in.createByteArray();
        isLongSpeech = in.readBoolean();
        speechTime = in.readLong();
        isErrorRestart = in.readBoolean();
        isReturnSemantics = in.readBoolean();
    }

    public static final Creator<VoiceData> CREATOR = new Creator<VoiceData>() {
        @Override
        public VoiceData createFromParcel(Parcel in) {
            return new VoiceData(in);
        }

        @Override
        public VoiceData[] newArray(int size) {
            return new VoiceData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(data);
        parcel.writeBoolean(isLongSpeech);
        parcel.writeLong(speechTime);
        parcel.writeBoolean(isErrorRestart);
        parcel.writeBoolean(isReturnSemantics);
    }
}
