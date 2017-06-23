package com.example.wind.recyclerviewexecise.TransDemo;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

/**
 * Created by wind on 17-6-18.
 */
//声明抽象类..
public abstract class EndLessOnScrollListener extends RecyclerView.OnScrollListener {
    //声明一个LinearLayoutManager
    private LinearLayoutManager mLinearLayoutManager;
    private GridLayoutManager mGridLayoutManager;

    private int currentPage = 0;

    //已经加载出来的Item的数量
    private int totalItemCount;

    //主要用来存储上一个totalItemCount
    private int previousTotal = 0;

    //在屏幕上可见的item数量
    private int visibleItemCount;

    //在屏幕可见的Item中的第一个
    private int firstVisibleItem;

    //是否正在上拉数据
    private boolean loading = true;

    public EndLessOnScrollListener(LinearLayoutManager linearLayoutManager) {
        this.mLinearLayoutManager = linearLayoutManager;
    }
    //使用GridLayoutManager代替
//    public EndLessOnScrollListener(GridLayoutManager gridLayoutManager){
//        this.mGridLayoutManager=gridLayoutManager;
//    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        visibleItemCount = recyclerView.getChildCount();
        totalItemCount = mLinearLayoutManager.getItemCount();
        firstVisibleItem = mLinearLayoutManager.findFirstVisibleItemPosition();
//        totalItemCount=mGridLayoutManager.getItemCount();
//        firstVisibleItem=mGridLayoutManager.findFirstVisibleItemPosition();

        if (loading) {

            Log.d("aaa", "firstVisibleItem: " + firstVisibleItem);
            Log.d("aaa", "totalItemCount:" + totalItemCount);
            Log.d("aaa", "visibleItemCount:" + visibleItemCount);

            if (totalItemCount > previousTotal) {
                //说明数据已经加载结束
                loading = false;
                previousTotal = totalItemCount;
            }
        }

        //加载过程结束时,总的item数量减去当前页面显示的数量小于等于当前显示的第一个item的位置
        if (!loading && totalItemCount - visibleItemCount <= firstVisibleItem) {
            currentPage++;
            onLoadMore(currentPage);
            loading = true;
        }

    }

    /**
     * 提供一个抽闲方法，在Activity中监听到这个EndLessOnScrollListener
     * 并且实现这个方法
     */
    public abstract void onLoadMore(int currentPage);

}























