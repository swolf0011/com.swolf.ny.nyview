package com.swolf.ny.nyview.wheelView;

/**
 * 数组WheelView适配器
 * Created by LiuYi
 */
public class NYArrayWheelAdapter<T>{

    /**
     * The default items length
     */
    public static final int DEFAULT_LENGTH = -1;

    // items
    private T items[];

    // length
    private int length;

    /**
     * Constructor
     *
     * @param items  the items
     * @param length the max items length
     */
    public NYArrayWheelAdapter(T items[], int length) {
        this.items = items;
        this.length = length;
    }

    /**
     * Contructor
     *
     * @param items the items
     */
    public NYArrayWheelAdapter(T items[]) {
        this(items, DEFAULT_LENGTH);
    }

    public String getItem(int index) {
        if (index >= 0 && index < items.length) {
            return items[index].toString();
        }
        return null;
    }

    public int getItemsCount() {
        return items.length;
    }

    public int getMaximumLength() {
        return length;
    }

}
