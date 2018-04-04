package com.example.longpic.move;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

import com.bumptech.glide.Glide;
import com.example.longpic.R;
import com.example.longpic.bean.MoveItem;
import com.example.longpic.utils.RawUtil;
import com.example.longpic.widget.MoveView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import java.util.List;

public class MoveActivity extends AppCompatActivity {

    private ListView listView;
    private MoveAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move);

        listView = findViewById(R.id.lvMove);
        adapter = new MoveAdapter(this);
        listView.setAdapter(adapter);
        initData();

        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
//                if (adapter.getCount() > totalItemCount){

                for (int i = 0; i < visibleItemCount; i++) {
                    try {
                        View childView = listView.getChildAt(firstVisibleItem+i);
                        MoveView moveView = childView.findViewById(R.id.ivMoveItem);
                        int[] location = new int[2];
                        moveView.getLocationInWindow(location);

                        int y = location[1];

                        moveView.setScrollY(y / 10);

                    } catch (Exception e) {
                        Log.i("lxm","e = "+e.toString());
                    }
                }

            }
        });

    }

    private void initData() {
        String jsons = RawUtil.get(this, R.raw.move_item);
        final List<MoveItem> list = new Gson().fromJson(jsons, new TypeToken<List<MoveItem>>() {
        }.getType());
        adapter.setList(list);

    }
}
