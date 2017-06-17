package com.example.wind.recyclerviewexecise;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RanimationActivity extends AppCompatActivity {

    private Fruit apple, banana, grape, orange, pineapple, watermelon, pear, cherry, mango,
            strawberry,cherry1;

    //数组初始化！
    private List<Fruit> fruitList = new ArrayList<>();
    private FruitAdapter mAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ranimation_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        //这个只能在AppCompatActivity中使用
        setSupportActionBar(toolbar);
        //原来的工具栏不显示
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        recyclerView = (RecyclerView) findViewById(R.id.rec_list);
        initData();

        mAdapter = new FruitAdapter(fruitList);
        recyclerView.setAdapter(mAdapter);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));

        //下拉列表设置recyclerview动画效果
        Spinner spinner = (Spinner) findViewById(R.id.spinner);


        //增加,减少item监听器
        findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAdapter.add(cherry1,2);
            }
        });

        findViewById(R.id.del).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAdapter.remove(2);
            }
        });


    }

    private void initData() {
        apple = new Fruit("apple", R.drawable.apple_pic);
        banana = new Fruit("banana", R.drawable.banana_pic);
        cherry = new Fruit("cherry", R.drawable.cherry_pic);
        grape = new Fruit("grape", R.drawable.grape_pic);
        mango = new Fruit("mango", R.drawable.mango_pic);
        orange = new Fruit("orange", R.drawable.orange_pic);
        pear = new Fruit("pear", R.drawable.pear_pic);
        pineapple = new Fruit("pineapple", R.drawable.pineapple_pic);
        strawberry = new Fruit("strawberry", R.drawable.strawberry_pic);
        watermelon = new Fruit("watermelon", R.drawable.watermelon_pic);

        cherry1=new Fruit("New Item",R.drawable.cherry_pic);

        for (int i = 0; i < 3; i++) {
            fruitList.add(apple);
            fruitList.add(banana);
            fruitList.add(cherry);
            fruitList.add(grape);
            fruitList.add(mango);
            fruitList.add(orange);
            fruitList.add(pear);
            fruitList.add(pineapple);
            fruitList.add(strawberry);
            fruitList.add(watermelon);
        }
    }


}
