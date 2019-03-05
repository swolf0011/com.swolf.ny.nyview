package com.swolf.ny.nyview.viewPage;

import java.io.Serializable;

/**
 * Banner
 * Created by LiuYi
 */
public class NYBanner implements Serializable {

    public int id;
    public String title = "";
    public String img_url;//图片url
    public int drawable;//资源图片
    public int type = 0;//类型 ：0资源图片，1图片URL


    public static final int TYPE_DRAWABLE = 0;//类型 ：0资源图片

    public static final int TYPE_URL = 1;//类型 ：1图片URL
}
