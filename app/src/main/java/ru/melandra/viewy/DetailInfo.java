package ru.melandra.viewy;

import android.os.Parcel;
import android.os.Parcelable;

public class DetailInfo implements Parcelable {
    public int position;

    public DetailInfo(int position) {
        this.position = position;
    }

    protected DetailInfo(Parcel in) {
        position = in.readInt();
    }

    public static final Creator<DetailInfo> CREATOR = new Creator<DetailInfo>() {
        @Override
        public DetailInfo createFromParcel(Parcel in) {
            return new DetailInfo(in);
        }

        @Override
        public DetailInfo[] newArray(int size) {
            return new DetailInfo[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(position);
    }
}
