package com.example.wind.recyclerviewexecise;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by wind on 17-6-18.
 */

public class RefreshFootAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    //上拉加载更多
    public static final int PULLUP_LOAD_MORE = 0;
    //正在加载中
    public static final int LOADING_MORE = 1;
    //上拉加载更多状态-默认为0
    private int load_more_status = 0;
    private LayoutInflater mInflater;
    private List<Fruit> mFruitList;
    private static final int TYPE_ITEM = 0;  //普通Item View
    private static final int TYPE_FOOTER = 1;  //顶部FootView

    public RefreshFootAdapter(List<Fruit> fruitList, Context context) {
        this.mFruitList = fruitList;
        this.mInflater = LayoutInflater.from(context);
    }

    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        View fruitView;
        ImageView fruitImage;
        TextView fruitName;

        public ItemViewHolder(View view) {
            super(view);
            fruitView = view;
            fruitImage = (ImageView) view.findViewById(R.id.img);
            fruitName = (TextView) view.findViewById(R.id.text);
        }
    }

    /**
     * 底部FootView布局
     */
    public static class FootViewHolder extends RecyclerView.ViewHolder {
        View fruitView;
        ImageView fruitImage;
        TextView fruitName;
        TextView footText;

        public FootViewHolder(View view) {
            super(view);
            fruitView = view;
//            fruitImage=(ImageView)view.findViewById(R.id.img);
//            fruitName=(TextView)view.findViewById(R.id.text);
            footText = (TextView) view.findViewById(R.id.foot_text);

        }
    }

    /**
     * item显示类型
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //进行判断显示类型，来创建返回不同的View
        if (viewType == TYPE_ITEM) {
            View view = mInflater.inflate(R.layout.item_layout, parent, false);
            //这边可以做一些属性设置，甚至事件监听绑定
            //view.setBackgroundColor(Color.RED);
            ItemViewHolder itemViewHolder = new ItemViewHolder(view);
            return itemViewHolder;
        } else if (viewType == TYPE_FOOTER) {
            View foot_view = mInflater.inflate(R.layout.item_more_layout, parent, false);
            //这边可以做一些属性设置，甚至事件监听绑定
            //view.setBackgroundColor(Color.RED);
            FootViewHolder footViewHolder = new FootViewHolder(foot_view);
            return footViewHolder;
        }

        return null;
    }

    /**
     * 数据的绑定显示
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            Fruit fruit = mFruitList.get(position);
            ((ItemViewHolder) holder).fruitImage.setImageResource(fruit.getImageId());
            ((ItemViewHolder) holder).fruitName.setText(fruit.getFruitName());
        } else if (holder instanceof FootViewHolder) {
            FootViewHolder footViewHolder = (FootViewHolder) holder;
            switch (load_more_status) {
                case PULLUP_LOAD_MORE:
                    footViewHolder.footText.setText("上拉加载更多...");
                    break;
                case LOADING_MORE:
                    footViewHolder.footText.setText("正在加载更多数据...");
                    break;

                default:
                    break;
            }
        }
    }
    //多了一个Foot Item
    @Override
    public int getItemCount() {
        return mFruitList.size()+1;
    }

    /**
     * 进行判断是普通Item视图还是FootView视图
     */
    public int getItemViewType(int position){
        if(position+1==getItemCount()){
            return TYPE_FOOTER;
        }else {
            return TYPE_ITEM;
        }
    }

    public void changeMoreStatus(int status){
        load_more_status=status;
        notifyDataSetChanged();
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







