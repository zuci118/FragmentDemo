package com.jianda.zuci.fragmentdemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zuci on 16/3/28.
 */
public class ImageContent {

    //定义一个内部类，作为系统的业务对象
    public static class Image{
        public Integer id;
        public String title;
        public Integer imageId;

        public Image(Integer id, String title,Integer imageId) {
            this.id = id;
            this.title = title;
            this.imageId = imageId;
        }

        @Override
        public String toString() {
            return title;
        }
    }

    //使用List集合纪录系统所包含的Image对象
    public static List<Image> ITEMS = new ArrayList<Image>();

    //使用Map集合纪录系统所包含的Image对象
    public static Map<Integer,Image> ITEMS_MAP = new HashMap<Integer,Image>();

    static {//使用静态初始化代码，将Image对象添加到List集合、Map集合中
        addItem(new Image(1,"玫瑰花",R.drawable.meigui));
        addItem(new Image(2,"红莲",R.drawable.honglian));
        addItem(new Image(3,"百合",R.drawable.baihe));
        addItem(new Image(4,"菊花",R.drawable.ju));
        addItem(new Image(5,"满天星",R.drawable.mantianxin));
        addItem(new Image(6,"迎春花",R.drawable.yingchun));
        addItem(new Image(7,"樱花",R.drawable.yinghua));
        addItem(new Image(8,"水仙",R.drawable.shuixian));


    }

    private static void addItem(Image image){
        ITEMS.add(image);
        ITEMS_MAP.put(image.id,image);
    }


}
