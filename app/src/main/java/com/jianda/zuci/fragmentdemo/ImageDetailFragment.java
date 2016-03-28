package com.jianda.zuci.fragmentdemo;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by zuci on 16/3/28.
 */
public class ImageDetailFragment extends Fragment {
    public static final String ITEM_ID = "item_id";
    ImageContent.Image image;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //如果启动该Fragment时包含了ITEM_ID参数
        if (getArguments().containsKey(ITEM_ID)){
            image = ImageContent.ITEMS_MAP.get(getArguments().getInt(ITEM_ID));
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
        if (image != null){
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(),image.imageId);
            ((ImageView) rootView.findViewById(R.id.iv_detail)).setImageBitmap(bitmap);
        }

        return rootView;
    }
}
