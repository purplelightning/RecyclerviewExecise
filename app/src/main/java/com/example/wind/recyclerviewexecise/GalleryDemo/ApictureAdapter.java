package com.example.wind.recyclerviewexecise.GalleryDemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wind.recyclerviewexecise.R;

import java.util.List;

/**
 * Created by wind on 17-6-21.
 */

public class ApictureAdapter extends MyRecyclerView.Adapter<ApictureAdapter.AHolder> {

    private List<Apicture> mPicList;
    private Context mContext;

    //实现item点击接口
    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    private OnItemClickListener mListener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }


    public ApictureAdapter(List<Apicture> plicList, Context context) {
        mPicList = plicList;
        mContext = context;
    }

    static class AHolder extends MyRecyclerView.ViewHolder {
        View picView;
        ImageView picImg;
        TextView picName;

        public AHolder(View view) {
            super(view);
            picView = view;
            picImg = (ImageView) view.findViewById(R.id.img);
            picName = (TextView) view.findViewById(R.id.text);
        }
    }

    @Override
    public AHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gallery_layout, parent, false);
        AHolder aholder = new AHolder(view);
        //这句之前写错了,把大图的id传了过来,所以一直报错,并没有什么用
        //aholder.picImg = (ImageView) view.findViewById(R.id.img);
        return aholder;
    }

    @Override
    public void onBindViewHolder(final AHolder holder, final int position) {
        Apicture apicture = mPicList.get(position);
        holder.picImg.setImageResource(apicture.getPicId());
        holder.picName.setText(apicture.getPicName());

        //监听器回调
        if (mListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onItemClick(holder.itemView, position);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return mPicList.size();
    }
}
