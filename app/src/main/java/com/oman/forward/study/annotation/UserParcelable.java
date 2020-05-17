package com.oman.forward.study.annotation;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author:ZhouJiang
 * @date:2020/5/17 08:50
 * @email:zhoujiang2012@163.com
 */
public class UserParcelable implements Parcelable {
    private String name;

    public UserParcelable(String name) {
        this.name = name;
    }

    protected UserParcelable(Parcel in) {
        name = in.readString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static final Creator<UserParcelable> CREATOR = new Creator<UserParcelable>() {
        @Override
        public UserParcelable createFromParcel(Parcel in) {
            return new UserParcelable(in);
        }

        @Override
        public UserParcelable[] newArray(int size) {
            return new UserParcelable[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
    }

    @Override
    public String toString() {
        return "UserParcelable{" +
                "name='" + name + '\'' +
                '}';
    }
}
