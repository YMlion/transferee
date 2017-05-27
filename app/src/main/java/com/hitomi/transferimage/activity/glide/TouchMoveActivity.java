package com.hitomi.transferimage.activity.glide;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.hitomi.tilibrary.transfer.ImageInfo;
import com.hitomi.transferimage.R;
import com.hitomi.transferimage.activity.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class TouchMoveActivity extends BaseActivity {

    private ImageView imageView1, imageView2, imageView3;
    private List<ImageView> imageViewList;

    private List<String> imageStrList;

    {
        imageStrList = new ArrayList<>();
        imageStrList.add("http://oxgood.com/wp-content/uploads/2016/07/7d635b455733338d4d6c13c2b2dda0b0-1024x665.jpg");
        imageStrList.add("http://oxgood.com/wp-content/uploads/2016/07/83fbe92159108b49ca13d187c5c8bcec-1024x785.jpg");
        imageStrList.add("http://oxgood.com/wp-content/uploads/2016/07/ce0ee71099e9b79cbb5996265cd2e6cd-758x1024.jpg");
        imageStrList.add("http://oxgood.com/wp-content/uploads/2016/07/ccf1baf0694d0f8beed24597ad761987-1024x637.jpg");
        imageStrList.add("http://oxgood.com/wp-content/uploads/2016/07/09e67a0760fc22370c890bdc3954382b-827x1024.jpg");
        imageStrList.add("http://i1.17173cdn.com/2fhnvk/YWxqaGBf/cms3/mcofEgbkwpuvlob.jpg!a-3-640x.jpg");
        imageStrList.add("http://i3.17173cdn.com/2fhnvk/YWxqaGBf/cms3/DWABSHbkCdElEDA.jpg!a-3-640x.jpg");
        imageStrList.add("http://i2.17173cdn.com/2fhnvk/YWxqaGBf/cms3/xNLzqtbkCdElEyC.jpg!a-3-640x.jpg");
        imageStrList.add("http://i1.17173cdn.com/2fhnvk/YWxqaGBf/cms3/vUFNHwbljxruktB.jpg!a-3-640x.jpg");
        imageStrList.add("http://i3.17173cdn.com/2fhnvk/YWxqaGBf/cms3/FNGGjrbljxrukba.jpg!a-3-640x.jpg");
        imageStrList.add("http://i3.17173cdn.com/2fhnvk/YWxqaGBf/cms3/Juvmrjbkwpuvjyv.jpg!a-3-640x.jpg");
        imageStrList.add("http://i1.17173cdn.com/2fhnvk/YWxqaGBf/cms3/qlwPVQbkwpuvmcc.jpg!a-3-640x.jpg");
        imageStrList.add("http://i3.17173cdn.com/2fhnvk/YWxqaGBf/cms3/vMbgOlbkwpuvlEE.jpg!a-3-640x.jpg");
        imageStrList.add("http://i2.17173cdn.com/2fhnvk/YWxqaGBf/cms3/GJhaLjbkwpuvlty.jpg!a-3-640x.jpg");
        imageStrList.add("http://oxgood.com/wp-content/uploads/2016/07/c3e4308aa6e2074c77d343d8824179c0-1024x628.jpg");
        imageStrList.add("http://oxgood.com/wp-content/uploads/2016/07/d86a1428bea533217c7e2b13b4e5963e-1024x736.jpg");
        imageStrList.add("http://oxgood.com/wp-content/uploads/2016/07/5cf47d87616dba975d1e85214025c349-1024x676.jpg");
        imageStrList.add("http://oxgood.com/wp-content/uploads/2016/07/53605f987ec71b74bb376b47a238430a-1024x734.jpg");
        imageStrList.add("http://oxgood.com/wp-content/uploads/2016/07/dad7c7f0e646780774de0374f406014b-1024x820.jpg");
        imageStrList.add("http://oxgood.com/wp-content/uploads/2016/07/cbdef59bd87caa712abb0f144c463101-1024x833.jpg");
        imageStrList.add("http://oxgood.com/wp-content/uploads/2016/07/e0f944e4c73ad5b6a018029bc7ebbb37-1024x734.jpg");
        imageStrList.add("http://oxgood.com/wp-content/uploads/2016/07/eadc61ec6a819fe8fb518f06b37b5ccf-1024x668.jpg");
        imageStrList.add("http://oxgood.com/wp-content/uploads/2016/07/e41b862ee191d342ec80cf39f97cc067-1024x724.jpg");
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_touch_move;
    }

    @Override
    protected void initView() {
        imageView1 = (ImageView) findViewById(R.id.image_view1);
        imageView2 = (ImageView) findViewById(R.id.image_view2);
        imageView3 = (ImageView) findViewById(R.id.image_view3);

        TouchMoveActivity.TouchViewMotion touchViewMotion = new TouchMoveActivity.TouchViewMotion();
        imageView1.setOnTouchListener(touchViewMotion);
        imageView2.setOnTouchListener(touchViewMotion);
        imageView3.setOnTouchListener(touchViewMotion);

        TouchMoveActivity.ShowViewHDListener showViewHDListener = new TouchMoveActivity.ShowViewHDListener();
        imageView1.setOnClickListener(showViewHDListener);
        imageView2.setOnClickListener(showViewHDListener);
        imageView3.setOnClickListener(showViewHDListener);

        imageViewList = new ArrayList<>();
        imageViewList.add(imageView1);
        imageViewList.add(imageView2);
        imageViewList.add(imageView3);
    }

    @Override
    protected void testTransferee() {
        Glide.with(this)
                .load(imageStrList.get(0))
                .asBitmap()
                .placeholder(R.mipmap.ic_empty_photo)
                .into(imageView1);
        Glide.with(this)
                .load(imageStrList.get(1))
                .asBitmap()
                .placeholder(R.mipmap.ic_empty_photo)
                .into(imageView2);
        Glide.with(this)
                .load(imageStrList.get(2))
                .asBitmap()
                .placeholder(R.mipmap.ic_empty_photo)
                .into(imageView3);
    }

    private class ShowViewHDListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            /*transferee.apply(TransferConfig.build()
                    .setImageLoader(GlideImageLoader.with(getApplicationContext()))
                    .setMissPlaceHolder(R.mipmap.ic_empty_photo)
//                    .setOriginImageList(imageViewList)
                    .setImageInfos(ImageInfo.getImageInfos(imageViewList))
                    .setSourceImageList(imageStrList)
                    .setNowThumbnailIndex(imageViewList.indexOf(v))
                    .setProgressIndicator(new ProgressPieIndicator())
                    .setJustLoadHitImage(true)
                    .create())
                    .show(new Transferee.OnTransfereeStateChangeListener() {
                        @Override
                        public void onShow() {
                            Glide.with(TouchMoveActivity.this).pauseRequests();
                        }

                        @Override
                        public void onDismiss() {
                            Glide.with(TouchMoveActivity.this).resumeRequests();
                        }
                    });*/
            Intent intent = new Intent(TouchMoveActivity.this, PicturePreviewActivity.class);
            intent.putExtra("index", imageViewList.indexOf(v));
            intent.putStringArrayListExtra("sourceList", (ArrayList<String>) imageStrList);
            intent.putParcelableArrayListExtra("imageInfos", (ArrayList<ImageInfo>) ImageInfo.getImageInfos(imageViewList));
            intent.putExtra("bitmap", ((BitmapDrawable) ((ImageView) v).getDrawable()).getBitmap());
            startActivity(intent);
            overridePendingTransition(R.anim.scale_center, android.R.anim.fade_out);
        }
    }

    private class TouchViewMotion implements View.OnTouchListener {
        private float preX, preY;

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    preX = event.getRawX();
                    preY = event.getRawY();
                    break;
                case MotionEvent.ACTION_MOVE:
                    float diffX = event.getRawX() - preX;
                    float diffY = event.getRawY() - preY;

                    v.setX(v.getX() + diffX);
                    v.setY(v.getY() + diffY);

                    preX = event.getRawX();
                    preY = event.getRawY();
                    break;
            }
            return false;
        }
    }
}
