package aidl.module.speech;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by huang on 17/2/14.
 */

public class VoiceData implements Parcelable {
    public String result;
    public byte[] data;

    public VoiceData() {

    }

    protected VoiceData(Parcel in) {
        result = in.readString();
        data = in.createByteArray();
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
        parcel.writeString(result);
        parcel.writeByteArray(data);
    }
}
