package ru.melandra.viewy;

import android.os.Parcel;
import android.os.Parcelable;

public class DetailInfo implements Parcelable {
    public int position;
    public String url;

    public DetailInfo(int position, String url) {
        this.url = url;
        this.position = position;
    }

    protected DetailInfo(Parcel in) {
        url = in.readString ();
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
        dest.writeString (url);
        dest.writeInt(position);
    }
}
