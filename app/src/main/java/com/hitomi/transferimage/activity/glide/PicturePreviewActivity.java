package com.hitomi.transferimage.activity.glide;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.hitomi.glideloader.GlideImageLoader;
import com.hitomi.tilibrary.style.progress.ProgressPieIndicator;
import com.hitomi.tilibrary.transfer.ImageInfo;
import com.hitomi.tilibrary.transfer.TransferConfig;
import com.hitomi.tilibrary.transfer.TransfereeActivity;
import com.hitomi.transferimage.R;

import java.util.ArrayList;
import java.util.List;

public class PicturePreviewActivity extends TransfereeActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void addOtherViews(View parent) {
    }

    @Override
    protected TransferConfig initTransConfig() {
        Intent intent = getIntent();
        ArrayList<String> imageStrList = intent.getStringArrayListExtra("sourceList");
        int index = intent.getIntExtra("index", 0);
        List<ImageInfo> imageInfos = intent.getParcelableArrayListExtra("imageInfos");
        return TransferConfig.build()
                .setImageLoader(GlideImageLoader.with(getApplicationContext()))
                .setImageInfos(imageInfos)
                .setMissPlaceHolder(R.mipmap.ic_empty_photo)
                .setSourceImageList(imageStrList)
                .setDuration(450)
                .setNowThumbnailIndex(index)
                .setProgressIndicator(new ProgressPieIndicator())
                .setJustLoadHitImage(true)
                .create();
    }
}
