package com.swolf.ny.nyview.gridView.dragGridView;

import java.io.Serializable;

/**
 * 可移动GridViewItem
 * Created by LiuYi
 */
@SuppressWarnings("serial")
public class NYDragGridViewItem implements Serializable {

    public int _id;
    public String name;
    public String url;
    public String action;
    public String icon;
    public EDragItemType type = EDragItemType.NATIVE;

    public enum EDragItemType {
        HTML, NATIVE;
    }

}