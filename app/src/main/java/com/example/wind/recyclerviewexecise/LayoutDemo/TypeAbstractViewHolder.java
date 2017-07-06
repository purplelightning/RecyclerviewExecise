package com.example.wind.recyclerviewexecise.LayoutDemo;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by wind on 17-7-6.
 */

public abstract class TypeAbstractViewHolder extends RecyclerView.ViewHolder {

    public TypeAbstractViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bindHolder(DataModel model);

}
