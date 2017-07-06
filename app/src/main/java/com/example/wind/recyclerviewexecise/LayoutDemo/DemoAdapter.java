package com.example.wind.recyclerviewexecise.LayoutDemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wind.recyclerviewexecise.R;

import java.util.ArrayList;
import java.util.List;

import static com.example.wind.recyclerviewexecise.LayoutDemo.DataModel.TYPE_ONE;
import static com.example.wind.recyclerviewexecise.LayoutDemo.DataModel.TYPE_THREE;
import static com.example.wind.recyclerviewexecise.LayoutDemo.DataModel.TYPE_TWO;

/**
 * Created by wind on 17-7-6.
 */

public class DemoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<DataModel> mList = new ArrayList<>();
    private LayoutInflater layoutInflater;

    public DemoAdapter(Context context, List<DataModel> list) {
        layoutInflater = LayoutInflater.from(context);
        mList=list;
    }

//    static class DemoHolder extends RecyclerView.ViewHolder {
//        View itemView;
//        TextView itemName;
//
//        public DemoHolder(View view) {
//            super(view);
//            itemView = view;
//            itemName = (TextView) view.findViewById(R.id.item_text);
//        }
//    }

//    public void addList(List<DataModel> list) {
//        mList.addAll(list);
//    }

    @Override
    public int getItemViewType(int position) {
        return mList.get(position).type;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_ONE:
                View view1 = layoutInflater.inflate(R.layout.item_type_one, parent, false);
                return new TypeOneViewHolder(view1);
            case TYPE_TWO:
                View view2 = layoutInflater.inflate(R.layout.item_type_two, parent, false);
                return new TypeTwoViewHolder(view2);
            case TYPE_THREE:
                View view3 = layoutInflater.inflate(R.layout.item_type_three, parent, false);
                return new TypeThreeViewHolder(view3);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        //继承了抽象类,就不用switch判断,直接使用bindHolder方法
        ((TypeAbstractViewHolder) holder).bindHolder(mList.get(position));

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}






