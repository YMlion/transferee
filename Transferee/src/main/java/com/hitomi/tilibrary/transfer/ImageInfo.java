package com.hitomi.tilibrary.transfer;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * created by ylm on 2017/05/24
 */
public class ImageInfo implements Parcelable {
    public int locationX;
    public int locationY;
    public int width;
    public int height;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.locationX);
        dest.writeInt(this.locationY);
        dest.writeInt(this.width);
        dest.writeInt(this.height);
    }

    public ImageInfo() {
    }

    public ImageInfo(ImageView view) {
        int[] location = getViewLocation(view);
        locationX = location[0];
        locationY = location[1];
        width = view.getWidth();
        height = view.getHeight();
    }

    public static List<ImageInfo> getImageInfos(List<ImageView> imageViews) {
        List<ImageInfo> imageInfos = new ArrayList<>();
        for (ImageView imageView : imageViews) {
            imageInfos.add(new ImageInfo(imageView));
        }
        return imageInfos;
    }

    public static int[] getViewLocation(View view) {
        int[] location = new int[2];
        view.getLocationInWindow(location);
        return location;
    }

    protected ImageInfo(Parcel in) {
        this.locationX = in.readInt();
        this.locationY = in.readInt();
        this.width = in.readInt();
        this.height = in.readInt();
    }

    public static final Parcelable.Creator<ImageInfo> CREATOR = new Parcelable.Creator<ImageInfo>() {
        @Override
        public ImageInfo createFromParcel(Parcel source) {
            return new ImageInfo(source);
        }

        @Override
        public ImageInfo[] newArray(int size) {
            return new ImageInfo[size];
        }
    };
}
