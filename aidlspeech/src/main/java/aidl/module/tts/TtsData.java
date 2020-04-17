package aidl.module.tts;

import android.os.Parcel;
import android.os.Parcelable;

public class TtsData implements Parcelable {

    /**
     * 播报的文本
     */
    public String text;

    /**
     * 播报的文本
     */
    public int ttsType;

    /**
     * 是否播报失败进行重新播放
     */
    public  boolean isRetry;

    /**
     * 重试次数
     */
    public  int retryCount;

    /**
     * 回调延迟时间
     */
    public long delayTime;

    /**
     * 是否进行混音模式
     */
    public boolean isStartMixing;


    /**
     * 是否控制声音
     */
    public boolean isControlSound;

    public TtsData() {

    }

    protected TtsData(Parcel in) {
        text = in.readString();
        ttsType = in.readInt();
        isRetry = in.readByte() != 0;
        retryCount = in.readInt();
        delayTime = in.readLong();
        isStartMixing = in.readByte() != 0;
        isControlSound = in.readByte() != 0;
    }

    public static final Creator<TtsData> CREATOR = new Creator<TtsData>() {
        @Override
        public TtsData createFromParcel(Parcel in) {
            return new TtsData(in);
        }

        @Override
        public TtsData[] newArray(int size) {
            return new TtsData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(text);
        parcel.writeInt(ttsType);
        parcel.writeByte((byte) (isRetry ? 1 : 0));
        parcel.writeInt(retryCount);
        parcel.writeLong(delayTime);
        parcel.writeByte((byte) (isStartMixing ? 1 : 0));
        parcel.writeByte((byte) (isControlSound ? 1 : 0));
    }
}
