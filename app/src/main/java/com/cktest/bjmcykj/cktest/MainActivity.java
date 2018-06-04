package com.cktest.bjmcykj.cktest;



import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.cktest.bjmcykj.cktest.base.FirstFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.fl_main)
    FrameLayout flMain;
    private Unbinder bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bind = ButterKnife.bind(this);
        setSelect();
    }
    private FirstFragment firstFragment;
    private void setSelect() {
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        if(firstFragment==null) {
            firstFragment=new FirstFragment();
            transaction.add(R.id.fl_main,firstFragment);
        }
        transaction.commit();


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }
}
