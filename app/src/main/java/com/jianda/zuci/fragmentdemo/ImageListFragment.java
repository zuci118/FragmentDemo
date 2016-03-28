package com.jianda.zuci.fragmentdemo;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by zuci on 16/3/28.
 */
public class ImageListFragment extends ListFragment {

    public static final String TAG = "ImageListFragment";
    private Callbacks mCallbacks;
    //定义一个回调借口，该Fragment所在Activity需要实现该借口
    //该Fragment将通过该接口与它所在的Activity交互
    public interface Callbacks{
        public void onItemSelected(Integer id);
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<ImageContent.Image>(getActivity(),
                android.R.layout.simple_list_item_activated_1,
                android.R.id.text1, ImageContent.ITEMS));
    }

    //当Fragment被添加、显示到Activity时，回调改方法
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (!(activity instanceof Callbacks)){
            throw new IllegalStateException("ImageListFragment所在的Activity必须实现Callbacks接口");
        }
        mCallbacks = (Callbacks)activity;
    }

    //当Fragment从它所属的Activity中被删除时回调改方法
    @Override
    public void onDetach() {
        super.onDetach();
        mCallbacks = null;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        mCallbacks.onItemSelected(ImageContent.ITEMS.get(position).id);

    }

    public void setActivateOnItemClick(boolean activateOnItemClick){
        getListView().setChoiceMode(activateOnItemClick ?
        ListView.CHOICE_MODE_SINGLE : ListView.CHOICE_MODE_NONE);
    }

}
