package com.example.wind.recyclerviewexecise;

import android.app.Activity;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RanimationActivity extends AppCompatActivity {

    private Fruit apple, banana, grape, orange, pineapple, watermelon, pear, cherry, mango,
            strawberry, cherry1,mango1,grape1;

    private SwipeRefreshLayout mRefreshLayout;
    private LinearLayoutManager mLinearLayoutManager;

    //数组初始化！
    private List<Fruit> fruitList = new ArrayList<>();
    private FruitAdapter mAdapter;
    private RecyclerView recyclerView;

    private int itemCount=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ranimation_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        //这个只能在AppCompatActivity中使用
        setSupportActionBar(toolbar);
        //原来的工具栏不显示
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        mRefreshLayout=(SwipeRefreshLayout) findViewById(R.id.layout_swiperefresh);

        recyclerView = (RecyclerView) findViewById(R.id.rec_list);
        initData();

        mAdapter = new FruitAdapter(fruitList);
        recyclerView.setAdapter(mAdapter);

        mLinearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLinearLayoutManager);

        //下拉列表1设置recyclerview布局
        Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);

        //Add,Del的监听器,增加,减少item
        findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAdapter.add(cherry1, 2);
            }
        });
        findViewById(R.id.del).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAdapter.remove(2);
            }
        });

        //下拉监听
        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //在list最前面加入一条数据
                fruitList.add(mango1);
                //数据重新加载完成后，提示数据发生改变，并且设置现在不在刷新
                mAdapter.notifyDataSetChanged();
                mRefreshLayout.setRefreshing(false);
            }
        });

        /**上拉监听
         * 监听addOnScrollListener这个方法，新建EndLessOnScrollListener
         * 在onLoadMore方法中去完成上拉加载的操作
         * */
        recyclerView.addOnScrollListener(new EndLessOnScrollListener(mLinearLayoutManager){
            @Override
            public void onLoadMore(int currentPage){
                loadMoreData();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.act_list:
                recyclerView.setLayoutManager(mLinearLayoutManager);
                break;
            case R.id.act_grid:
                recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
                break;
            case R.id.act_hgrid:
                recyclerView.setLayoutManager(new StaggeredGridLayoutManager
                        (3, StaggeredGridLayoutManager.HORIZONTAL));
                break;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    //每次上拉加载的时候，就加载十条数据到RecyclerView中
    private void loadMoreData(){
        itemCount=0;
        for(int i=0;i<3;i++){
            fruitList.add(new Fruit("上拉的葡萄"+itemCount,R.drawable.grape_pic));
            itemCount++;
            mAdapter.notifyDataSetChanged();

        }
    }

    //初始化数据
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

        cherry1 = new Fruit("New Item", R.drawable.cherry_pic);
        mango1=new Fruit("下拉的芒果",R.drawable.mango_pic);


        for (int i = 0; i < 1; i++) {
            fruitList.add(apple);
            fruitList.add(banana);
            fruitList.add(cherry);
            fruitList.add(grape);
            fruitList.add(mango);
            fruitList.add(orange);
//            fruitList.add(pear);
//            fruitList.add(pineapple);
//            fruitList.add(strawberry);
//            fruitList.add(watermelon);
        }
    }


}
