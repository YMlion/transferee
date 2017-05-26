package com.hitomi.tilibrary.transfer;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

import com.hitomi.tilibrary.loader.NoneImageLoader;
import com.hitomi.tilibrary.style.index.NumberIndexIndicator;
import com.hitomi.tilibrary.style.progress.ProgressPieIndicator;

/**
 * Main workflow: <br/>
 * 1、点击缩略图展示缩略图到 transferee 过渡动画 <br/>
 * 2、显示下载高清图片进度 <br/>
 * 3、加载完成显示高清图片 <br/>
 * 4、高清图支持手势缩放 <br/>
 * 5、关闭 transferee 展示 transferee 到原缩略图的过渡动画 <br/>
 * /**
 * created by ylm on 2017/05/24
 */
public class TransfereeActivity extends AppCompatActivity implements TransferLayout.OnLayoutResetListener {

    protected TransferLayout transLayout;
    protected TransferConfig transConfig;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createLayout();
        setContentView(transLayout);
    }

    private void createLayout() {
        transLayout = new TransferLayout(this);
        transLayout.setOnLayoutResetListener(this);
        transLayout.setBackgroundColor(Color.TRANSPARENT);
        setTransConfig(initTransConfig());
        transLayout.show();
        addOtherViews(transLayout);
    }

    protected void addOtherViews(ViewGroup parent) {

    }

    /**
     * 检查参数，如果必须参数缺少，就使用缺省参数或者抛出异常
     */
    private void checkConfig() {
        if (transConfig.isSourceEmpty())
            throw new IllegalArgumentException("the parameter sourceImageList can't be empty");

        transConfig.setNowThumbnailIndex(transConfig.getNowThumbnailIndex() < 0
                ? 0 : transConfig.getNowThumbnailIndex());

        transConfig.setOffscreenPageLimit(transConfig.getOffscreenPageLimit() <= 0
                ? 1 : transConfig.getOffscreenPageLimit());

        transConfig.setDuration(transConfig.getDuration() <= 0
                ? 300 : transConfig.getDuration());

        transConfig.setProgressIndicator(transConfig.getProgressIndicator() == null
                ? new ProgressPieIndicator() : transConfig.getProgressIndicator());

        transConfig.setIndexIndicator(transConfig.getIndexIndicator() == null
                ? new NumberIndexIndicator() : transConfig.getIndexIndicator());

        transConfig.setImageLoader(transConfig.getImageLoader() == null
                ? new NoneImageLoader() : transConfig.getImageLoader());
    }

    /**
     * 配置 transferee 参数对象
     *
     * @param config 参数对象
     * @return transferee
     */
    protected void setTransConfig(TransferConfig config) {
        transConfig = config;
        checkConfig();
        transLayout.apply(config);
    }

    protected TransferConfig initTransConfig() {
        return TransferConfig.build().create();
    }

    /**
     * 关闭 transferee
     */
    protected void dismiss() {
        transLayout.dismiss(transConfig.getNowThumbnailIndex());
    }

    @Override
    public void onBackPressed() {
        dismiss();
    }

    @Override
    public void onReset() {
        finish();
    }
}
