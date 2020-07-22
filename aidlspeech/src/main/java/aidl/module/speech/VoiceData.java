package aidl.module.speech;

import android.os.Parcel;
import android.os.Parcelable;

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
     * 遇到异常是否自动重启
     */
    public boolean isErrorRestart;

    /**
     * 是否返回语义
     */
    public boolean isReturnSemantics;

    /**
     * 是否控制声音
     */
    public boolean isControlSound;

    /**
     * 音频文件路径
     * 默认为null,不保存音频操作
     */
    public String voiceFilePath;

    /**
     * 前端点静音超时时间
     */
    public String vadBos;

    /**
     * 后端点静音检测时间
     */
    public String vadEos;

    public VoiceData() {

    }

    protected VoiceData(Parcel in) {
        data = in.createByteArray();
        isLongSpeech = in.readByte() != 0;
        speechTime = in.readLong();
        isErrorRestart = in.readByte() != 0;
        isReturnSemantics = in.readByte() != 0;
        isControlSound = in.readByte() != 0;
        voiceFilePath = in.readString();
        vadBos = in.readString();
        vadEos = in.readString();
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
        parcel.writeByte((byte) (isLongSpeech ? 1 : 0));
        parcel.writeLong(speechTime);
        parcel.writeByte((byte) (isErrorRestart ? 1 : 0));
        parcel.writeByte((byte) (isReturnSemantics ? 1 : 0));
        parcel.writeByte((byte) (isControlSound ? 1 : 0));
        parcel.writeString(voiceFilePath);
        parcel.writeString(vadBos);
        parcel.writeString(vadEos);
    }
}
