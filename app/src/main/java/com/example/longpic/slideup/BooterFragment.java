package com.example.longpic.slideup;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.longpic.EventScroll;
import com.example.longpic.R;
import com.example.longpic.bean.MoveItem;
import com.example.longpic.utils.RawUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * Created by lixiaoming on 2018/3/23.
 */

public class BooterFragment extends Fragment {

    private ListView lvFragmentBoot;
    private BootAdapter adapter;

    private TextView titleHeader;

    private int lastScrollY = -1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_boot, null);

        lvFragmentBoot = view.findViewById(R.id.lvFragmentBoot);
        Log.i("lxm", "bootFrame = " + lvFragmentBoot.getRootView().getId());


        View headerView = LayoutInflater.from(getContext()).inflate(R.layout.header_view, null);
        titleHeader = headerView.findViewById(R.id.titleHeader);
        lvFragmentBoot.addHeaderView(headerView);
        adapter = new BootAdapter(getContext());
        lvFragmentBoot.setAdapter(adapter);


        lvFragmentBoot.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                int scrollY = getScrollY();
                if (lastScrollY == scrollY && scrollY == 0) {
                    Log.i("lxm", "拦截...." + lastScrollY + "....." + scrollY);
                    EventBus.getDefault().post(new EventScroll(true));
                } else {
                    EventBus.getDefault().post(new EventScroll(false));
                    Log.i("lxm", "不拦截...." + lastScrollY + "....." + scrollY);
                }
                lastScrollY = scrollY;
            }
        });
        initData();
        return view;
    }

    private void initData() {
        String jsons = RawUtil.get(getContext(), R.raw.move_item);
        final List<MoveItem> list = new Gson().fromJson(jsons, new TypeToken<List<MoveItem>>() {
        }.getType());
        adapter.setList(list);

    }

    public int getScrollY() {
        View c = lvFragmentBoot.getChildAt(0);
        if (c == null) {
            return 0;
        }
        int firstVisiblePosition = lvFragmentBoot.getFirstVisiblePosition();
        int top = c.getTop();
        return -top + firstVisiblePosition * c.getHeight();
    }
}
