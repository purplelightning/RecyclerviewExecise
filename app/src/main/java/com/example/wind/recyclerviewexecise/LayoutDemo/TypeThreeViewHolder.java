package com.example.wind.recyclerviewexecise.LayoutDemo;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wind.recyclerviewexecise.R;

/**
 * Created by wind on 17-7-6.
 */

public class TypeThreeViewHolder extends TypeAbstractViewHolder {

    public ImageView avatar;
    public TextView name;
    public TextView content;
    public ImageView contentImage;

    public TypeThreeViewHolder(View itemView) {
        super(itemView);
        avatar = (ImageView) itemView.findViewById(R.id.avatar);
        name = (TextView) itemView.findViewById(R.id.name);
        content=(TextView)itemView.findViewById(R.id.content);
        contentImage = (ImageView) itemView.findViewById(R.id.contentImage);
        itemView.setBackgroundColor(Color.GRAY);
    }

    @Override
    public void bindHolder(DataModel model) {
        avatar.setBackgroundResource(model.avatarColor);
        name.setText(model.name);
        content.setText(model.content);
        contentImage.setBackgroundResource(model.contentColor);
    }
}







