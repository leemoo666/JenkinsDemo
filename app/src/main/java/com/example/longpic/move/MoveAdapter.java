package com.example.longpic.move;

import android.content.Context;
import android.graphics.Color;
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
public class MoveAdapter extends BaseAdapter {

    private Context context;
    private List<MoveItem> list = new ArrayList<>();

    public MoveAdapter(Context context) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_move, parent, false);
            holder.titleMoveItem = convertView.findViewById(R.id.titleMoveItem);
            holder.ivMoveItem = convertView.findViewById(R.id.ivMoveItem);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        int[] location = new int[2];
        convertView.getLocationInWindow(location);

        int y = location[1];
        Log.i("lxm","y = "+y+".....position = "+position);

        MoveItem item = list.get(position);
        holder.titleMoveItem.setText(item.getTitle());
        Glide.with(context).load(item.getUrl()).placeholder(R.drawable.ic_launcher).into(holder.ivMoveItem);
        holder.ivMoveItem.setScrollY(y / 10);
        return convertView;
    }

    static class ViewHolder {
        private TextView titleMoveItem;
        private MoveView ivMoveItem;
    }
}
