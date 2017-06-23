package com.example.wind.recyclerviewexecise.GalleryDemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.wind.recyclerviewexecise.GalleryDemo.Apicture;
import com.example.wind.recyclerviewexecise.GalleryDemo.ApictureAdapter;
import com.example.wind.recyclerviewexecise.GalleryDemo.MyRecyclerView;
import com.example.wind.recyclerviewexecise.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GalleryActivity extends Activity {

    private ApictureAdapter mAdapter;
    private List<Apicture> mPicList = new ArrayList<Apicture>();
    private MyRecyclerView recyclerView;
    private ImageView picImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery_layout);

        picImg = (ImageView) findViewById(R.id.content);

        recyclerView = (MyRecyclerView) findViewById(R.id.recyclerView_gallery);
        initData();

        mAdapter = new ApictureAdapter(mPicList, this);
        recyclerView.setAdapter(mAdapter);

        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL));
        //设置监听器,滚动和点击都会把上面的大图设置为第一个view或者点击的item
        mAdapter.setOnItemClickListener(new ApictureAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
//                Toast.makeText(MainActivity.this,"You clicked on "+mPicList.get(position).getPicName(),Toast.LENGTH_SHORT).show();
                picImg.setImageResource(mPicList.get(position).getPicId());
            }
        });

        recyclerView.setOnItemScrollChangeListener(new MyRecyclerView.OnItemScrollChangeListener() {
            @Override
            public void onChange(View view, int position) {
                picImg.setImageResource(mPicList.get(position).getPicId());
            }
        });
    }

    private void initData() {
        Apicture aa = new Apicture(R.drawable.a, "a");
        Apicture bb = new Apicture(R.drawable.b, "b");
        Apicture cc = new Apicture(R.drawable.c, "c");
        Apicture dd = new Apicture(R.drawable.d, "d");
        Apicture ee = new Apicture(R.drawable.e, "e");
        Apicture ff = new Apicture(R.drawable.f, "f");
        Apicture gg = new Apicture(R.drawable.g, "g");
        Apicture hh = new Apicture(R.drawable.h, "h");
        Apicture ll = new Apicture(R.drawable.l, "l");
        for (int i = 0; i < 4; i++) {
            mPicList.add(aa);
            mPicList.add(bb);
            mPicList.add(cc);
            mPicList.add(dd);
            mPicList.add(ee);
            mPicList.add(ff);
            mPicList.add(gg);
            mPicList.add(hh);
            mPicList.add(ll);
        }

//        mPicList = new ArrayList<Integer>(Arrays.asList(R.drawable.a,
//                R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e,
//                R.drawable.f, R.drawable.g, R.drawable.h, R.drawable.l));
    }
}
