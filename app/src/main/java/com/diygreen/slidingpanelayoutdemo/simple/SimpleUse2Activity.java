package com.diygreen.slidingpanelayoutdemo.simple;

import android.os.Bundle;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.diygreen.slidingpanelayoutdemo.R;

public class SimpleUse2Activity extends AppCompatActivity implements
        LeftMenuFragment.BookMarkListener, SlidingPaneLayout.PanelSlideListener {

    private SlidingPaneLayout mRootSPL;
    private LeftMenuFragment mLeftFragment;
    private RightContentFragment mRightFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simpleuse2);

        initView();
        initListener();
    }

    private void initView() {
        mRootSPL = (SlidingPaneLayout) findViewById(R.id.spl_root);
        mLeftFragment = (LeftMenuFragment) getFragmentManager().findFragmentById(R.id.fragment_leftmenu);
        mRightFragment = (RightContentFragment) getFragmentManager().findFragmentById(R.id.fragment_rightcontent);
    }

    private void initListener() {
        mRootSPL.setPanelSlideListener(this);
        mLeftFragment.setListener(this);
    }

    @Override
    public void onChangeBookMark(String bookMark) {
        mRightFragment.setContent(bookMark);
    }

    @Override
    public void onPanelSlide(View panel, float slideOffset) {
    }

    @Override
    public void onPanelOpened(View panel) {
        mLeftFragment.setHasOptionsMenu(true);
    }

    @Override
    public void onPanelClosed(View panel) {
        mLeftFragment.setHasOptionsMenu(false);
    }
}
