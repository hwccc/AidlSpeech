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
     * 是否请求语义,默认请求
     */
    public boolean isRequestSemantics = true;

    /**
     * 是否返回语义数据
     */
    public boolean isReturnSemanticsJson;

    /**
     * 是否控制声音
     */
    public boolean isControlSound;

    /**
     * 是否播放提示音
     */
    public boolean isPlayHintSound;

    /**
     * 音频文件路径
     * 默认为null,不保存音频操作
     */
    public String voiceFilePath;

    /**
     * 前端点静音超时时间
     */
    public long vadBos;

    /**
     * 后端点静音检测时间
     */
    public long vadEos;

    /**
     * 语音场景（用于导航、电台、打电话、微信联系人搜索）
     */
    public int scene;

    /**
     * 启动语音是否显示界面
     */
    public boolean isShowView;

    /**
     * 语音选择场景超时时间（设置这个时间后，在这个时间内出现异常会自己重启）
     */
    public long selectOvertime = -1;

    /**
     * 启动语音说的提示语
     */
    public String hintText;

    public VoiceData() {

    }

    protected VoiceData(Parcel in) {
        data = in.createByteArray();
        isLongSpeech = in.readByte() != 0;
        speechTime = in.readLong();
        isErrorRestart = in.readByte() != 0;
        isReturnSemanticsJson = in.readByte() != 0;
        isRequestSemantics = in.readByte() != 0;
        isControlSound = in.readByte() != 0;
        isPlayHintSound = in.readByte() != 0;
        voiceFilePath = in.readString();
        vadBos = in.readLong();
        vadEos = in.readLong();
        scene = in.readInt();
        isShowView = in.readByte() != 0;
        selectOvertime = in.readLong();
        hintText = in.readString();
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
        parcel.writeByte((byte) (isReturnSemanticsJson ? 1 : 0));
        parcel.writeByte((byte) (isRequestSemantics ? 1 : 0));
        parcel.writeByte((byte) (isControlSound ? 1 : 0));
        parcel.writeByte((byte) (isPlayHintSound ? 1 : 0));
        parcel.writeString(voiceFilePath);
        parcel.writeLong(vadBos);
        parcel.writeLong(vadEos);
        parcel.writeInt(scene);
        parcel.writeByte((byte) (isShowView ? 1 : 0));
        parcel.writeLong(selectOvertime);
        parcel.writeString(hintText);
    }
}
