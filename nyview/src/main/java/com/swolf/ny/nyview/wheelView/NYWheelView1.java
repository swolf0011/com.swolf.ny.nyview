package com.swolf.ny.nyview.wheelView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.swolf.ny.nyview.R;


/**
 * 一个WheelView
 * Created by LiuYi
 */
public class NYWheelView1 {
    /**
     * 最终显示View，需要加要使用者的视图中。
     */
    public View view;

    public interface INYWheelView1Hander {
        public void onChanging(String value1);
    }

    private String[] values1 = {};

    int index1 = 0;

    NYWheelView NYWheelView1;

    INYWheelView1Hander hander;

    public NYWheelView1(Context context, String[] strs1, String value1, INYWheelView1Hander hander) {

        view = LayoutInflater.from(context).inflate(R.layout.ny_view_wheel_view_1, null);

        this.NYWheelView1 = (NYWheelView) view.findViewById(R.id.wheelView1);

        this.values1 = strs1;

        this.hander = hander;

        initData(value1);
        resume();
    }

    /**
     * 如果UI显示有出问题，可以在Activity的onResume()中调用。
     */
    public void resume() {

        initWheelView1();

        setWheelViewChangingListener();
    }

    private void initData(String value1) {
        for (int i = 0; i < values1.length; i++) {
            if (values1[i].equals(value1)) {
                index1 = i;
                break;
            }
        }
    }

    private void initWheelView1() {
        NYWheelView1.setAdapter(new NYArrayWheelAdapter<String>(values1));
        NYWheelView1.setVisibleItems(5);
        NYWheelView1.setItemTextLength(6);
        NYWheelView1.setCyclic(false);
        NYWheelView1.setCurrentItem(index1);
    }

    private void setWheelViewChangingListener() {

        NYWheelView1.addChangingListener(new NYWheelView.OnWheelChangedListener() {
            @Override
            public void onChanged(NYWheelView wheel, int oldValue, int newValue) {
                index1 = newValue;

                if (hander != null) {
                    hander.onChanging(values1[NYWheelView1.getCurrentItem()]);
                }
            }
        });
    }
}
