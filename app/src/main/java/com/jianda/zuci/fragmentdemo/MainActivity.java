package com.jianda.zuci.fragmentdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ImageListFragment.Callbacks{


    public static final String TAG = "zuci";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //实现Callbacks接口必须实现的方法
    @Override
    public void onItemSelected(Integer id) {
        //创建bundle准备向Fragment传入参数
        Bundle bundle = new Bundle();
        bundle.putInt(ImageDetailFragment.ITEM_ID,id);
        ImageDetailFragment fragment = new ImageDetailFragment();
        //向Fragment传入参数
        fragment.setArguments(bundle);
        getFragmentManager().beginTransaction().replace(R.id.show_image,fragment)
                .commit();
    }
}
