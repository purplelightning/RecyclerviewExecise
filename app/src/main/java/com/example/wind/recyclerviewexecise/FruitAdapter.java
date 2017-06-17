package com.example.wind.recyclerviewexecise;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by wind on 17-6-17.
 */

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.FruitViewHolder> {

    private List<Fruit> mFruitList;


    public FruitAdapter(List<Fruit> fruitlist) {
        mFruitList = fruitlist;
    }

    static class FruitViewHolder extends RecyclerView.ViewHolder {

        View fruitView;
        ImageView fruitImg;
        TextView fruitName;

        public FruitViewHolder(View view) {
            super(view);
            fruitView = view;
            fruitImg = (ImageView) view.findViewById(R.id.img);
            fruitName = (TextView) view.findViewById(R.id.text);

        }
    }

    @Override
    public FruitViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new FruitViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FruitViewHolder holder, int position) {
        Fruit fruit = mFruitList.get(position);
        holder.fruitImg.setImageResource(fruit.getImageId());
        holder.fruitName.setText(fruit.getFruitName());
    }

    @Override
    public int getItemCount() {
        return mFruitList.size();
    }
    //在position处增加item,然后要调用notifyItemInserted方法来改变UI
    public void add(Fruit aa,int position){
        mFruitList.add(position,aa);
        notifyItemInserted(position);
    }
    //删除position处的item,然后要调用notifyItemRemoved方法来改变UI
    public void remove(int position){
        mFruitList.remove(position);
        notifyItemRemoved(position);
    }

}












