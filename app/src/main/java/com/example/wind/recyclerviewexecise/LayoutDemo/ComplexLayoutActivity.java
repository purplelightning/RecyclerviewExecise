package com.example.wind.recyclerviewexecise.LayoutDemo;


import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.wind.recyclerviewexecise.R;

import java.util.ArrayList;
import java.util.List;

public class ComplexLayoutActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DemoAdapter mAdapter;
    private List<DataModel> mList;

    int colors[] = {android.R.color.holo_red_dark, android.R.color.holo_blue_dark,
            android.R.color.holo_orange_dark, android.R.color.holo_blue_bright, android.R.color.
            holo_green_light};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.complex_layout);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        initData();

        mAdapter = new DemoAdapter(this, mList);
        recyclerView.setAdapter(mAdapter);


//        recyclerView.setLayoutManager(new LinearLayoutManager(this,
//                LinearLayoutManager.VERTICAL, false));
        final GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
        //设置横跨样式，如果为样式３,则占一行，否则占一个
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int type=recyclerView.getAdapter().getItemViewType(position);
                if(type==DataModel.TYPE_THREE){
                    return gridLayoutManager.getSpanCount();
                }else{
                    return 1;
                }
            }
        });
        recyclerView.setLayoutManager(gridLayoutManager);

    }

    private void initData() {
        mList = new ArrayList<>();
        int type;
        for (int i = 0; i < 30; i++) {

            if(i<5||(i>=15&&i<20)){
                type=1;
            }else if((i>=5&&i<10)||(i>=20&&i<25)){
                type=2;
            }else{
                type=3;
            }

            DataModel data = new DataModel();
            data.avatarColor = colors[(int) (Math.random() * 4) + 1];
            data.type = type;
            data.name = "name: " + i;
            data.content = "content: " + i;
            data.contentColor = colors[(int) (Math.random() * 4) + 1];
            mList.add(data);
        }

//        mAdapter.addList(mList);
//        mAdapter.notifyDataSetChanged();

    }
}










