package com.diygreen.slidingpanelayoutdemo.simple;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.diygreen.slidingpanelayoutdemo.R;

import java.util.ArrayList;
import java.util.List;

public class LeftMenuFragment extends Fragment {

    private ListView mLeftMenuLV;

    private BookMarkListener mListener = null;
    private List<String> mDataList;

    public interface BookMarkListener {
        void onChangeBookMark(String bookMark);
    }

    public LeftMenuFragment() {
        // Required empty public constructor
    }

    public static LeftMenuFragment newInstance() {
        LeftMenuFragment fragment = new LeftMenuFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_leftmenu, container, false);
        initView(view);
        initListener();
        return view;
    }

    public void setListener(BookMarkListener listener) {
        mListener = listener;
    }

    private void initView(View view) {
        mLeftMenuLV = (ListView) view.findViewById(R.id.lv_leftmenu);
        mDataList = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            mDataList.add("Menu-" + i);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                LeftMenuFragment.this.getActivity(),
                R.layout.item_bookmark,
                R.id.tv_menu,
                mDataList);
        mLeftMenuLV.setAdapter(adapter);
    }

    private void initListener() {
        mLeftMenuLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mListener.onChangeBookMark(mDataList.get(position));
            }
        });
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        MenuItem item1 = menu.add(1, 1, 1, "分享");
        item1.setShowAsAction(MenuItem.SHOW_AS_ACTION_WITH_TEXT
                | MenuItem.SHOW_AS_ACTION_ALWAYS);
        ImageView imageView = new ImageView(
                LeftMenuFragment.this.getActivity());
        imageView.setBackgroundResource(R.mipmap.ic_launcher);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(50, 50));
        item1.setActionView(imageView);
    }
}
