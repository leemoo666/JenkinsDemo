package com.example.longpic.slideup;

import android.content.Context;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.longpic.R;
import com.example.longpic.bean.MoveItem;
import com.example.longpic.widget.MoveView;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class BootAdapter extends BaseAdapter {

    private Context context;
    private List<MoveItem> list = new ArrayList<>();

    public BootAdapter(Context context) {
        this.context = context;
    }

    public void setList(List<MoveItem> list) {
        if (list == null) return;
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_boot, parent, false);
            holder.titleMoveItem = convertView.findViewById(R.id.titleMoveItem);
            holder.ivMoveItem = convertView.findViewById(R.id.ivMoveItem);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        MoveItem item = list.get(position);
        holder.titleMoveItem.setText(item.getTitle());
        Glide.with(context).load(item.getUrl()).placeholder(R.drawable.ic_launcher).into(holder.ivMoveItem);
        return convertView;
    }

    static class ViewHolder {
        private TextView titleMoveItem;
        private ImageView ivMoveItem;
    }
}
