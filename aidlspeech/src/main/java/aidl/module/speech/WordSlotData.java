package aidl.module.speech;

import android.os.Parcel;
import android.os.Parcelable;

public class WordSlotData implements Parcelable {

    /**
     * 词槽
     */
    public String slotData;

    /**
     * 类型
     */
    public String type;

    public WordSlotData() {

    }

    protected WordSlotData(Parcel in) {
        slotData = in.readString();
        type = in.readString();
    }

    public static final Creator<WordSlotData> CREATOR = new Creator<WordSlotData>() {
        @Override
        public WordSlotData createFromParcel(Parcel in) {
            return new WordSlotData(in);
        }

        @Override
        public WordSlotData[] newArray(int size) {
            return new WordSlotData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(slotData);
        parcel.writeString(type);
    }
}
