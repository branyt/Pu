package com.main.pu;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.main.pu.adapter.StackViewAdapter;
import com.main.pu.stackview.StackViewVertical;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private StackViewVertical stackViewVertical;
    private StackViewAdapter adapter;
    private final List<String> mImagesLink = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);
        DisplayImageOptions options = new DisplayImageOptions.Builder().showImageOnLoading(R.mipmap.ic_launcher) // ����ͼƬ�����ڼ���ʾ��ͼƬ
                .showImageForEmptyUri(R.mipmap.ic_launcher) // ����ͼƬUriΪ�ջ��Ǵ����ʱ����ʾ��ͼƬ
                .showImageOnFail(R.mipmap.ic_launcher) // ����ͼƬ���ػ��������з���������ʾ��ͼƬ
                .cacheInMemory(true) // �������ص�ͼƬ�Ƿ񻺴����ڴ���
                .cacheOnDisk(true) // �������ص�ͼƬ�Ƿ񻺴���SD����
                        // .displayer(new RoundedBitmapDisplayer(20)) // ���ó�Բ��ͼƬ
                .build(); // �������ù���DisplayImageOption����

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext()).defaultDisplayImageOptions(options)
                .threadPriority(Thread.NORM_PRIORITY - 2).denyCacheImageMultipleSizesInMemory()
                .diskCacheFileNameGenerator(new Md5FileNameGenerator()).tasksProcessingOrder(QueueProcessingType.LIFO).build();
        ImageLoader.getInstance().init(config);
        StackViewVertical stackViewVertical =( StackViewVertical)findViewById(R.id.stack);
        List<String> photos = new ArrayList<>();
        StackViewAdapter adapter = new StackViewAdapter(this,photos);
        stackViewVertical.setAdapter(adapter);
    }
}
