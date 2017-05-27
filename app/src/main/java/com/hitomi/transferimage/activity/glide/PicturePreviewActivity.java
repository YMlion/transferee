package com.hitomi.transferimage.activity.glide;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.design.widget.Snackbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.hitomi.glideloader.GlideImageLoader;
import com.hitomi.tilibrary.style.progress.ProgressPieIndicator;
import com.hitomi.tilibrary.transfer.ImageInfo;
import com.hitomi.tilibrary.transfer.TransferConfig;
import com.hitomi.tilibrary.transfer.TransfereeActivity;
import com.hitomi.transferimage.R;

import java.util.ArrayList;
import java.util.List;

/**
 * created by ylm on 2017/05/24
 */
public class PicturePreviewActivity extends TransfereeActivity implements View.OnClickListener {

    @Override
    protected void addOtherViews(ViewGroup parent) {
        View titleBar = LayoutInflater.from(this).inflate(R.layout.title_bar, parent, false);
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.topMargin = 75;
        lp.gravity = Gravity.TOP;
        titleBar.setLayoutParams(lp);
        parent.addView(titleBar);
        titleBar.findViewById(R.id.tv_preview_back).setOnClickListener(this);
        titleBar.findViewById(R.id.tv_preview_operation).setOnClickListener(this);
    }

    @Override
    protected TransferConfig initTransConfig() {
        Intent intent = getIntent();
        ArrayList<String> imageStrList = intent.getStringArrayListExtra("sourceList");
        int index = intent.getIntExtra("index", 0);
        List<ImageInfo> imageInfos = intent.getParcelableArrayListExtra("imageInfos");
        Bitmap bitmap = intent.getParcelableExtra("bitmap");
        return TransferConfig.build()
                .setImageLoader(GlideImageLoader.with(getApplicationContext()))
                .setImageInfos(imageInfos)
                .setMissPlaceHolder(R.mipmap.ic_empty_photo)
                .setSourceImageList(imageStrList)
                .setDuration(450)
                .setFirstBitmap(bitmap)
                .setNowThumbnailIndex(index)
                .setProgressIndicator(new ProgressPieIndicator())
                .setJustLoadHitImage(true)
                .create();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_preview_back:
                dismiss();
                break;
            case R.id.tv_preview_operation:
                Snackbar.make(v, "干点什么", Snackbar.LENGTH_SHORT).setAction("关闭", null).show();
                break;
        }
    }
}
