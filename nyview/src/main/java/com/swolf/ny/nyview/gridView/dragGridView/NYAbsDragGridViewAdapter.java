package com.swolf.ny.nyview.gridView.dragGridView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;


import com.swolf.ny.nyview.R;

import java.util.Collections;
import java.util.List;

/**
 * 可移动GridView适配器
 * Created by LiuYi
 */
@SuppressLint({ "ViewHolder", "InflateParams" }) 
public abstract class NYAbsDragGridViewAdapter<T> extends BaseAdapter{
	private Context context;
	private List<T> list;
	private int itemLayout;
	private IHandlerView handlerView;
	private int mHidePosition = -1;

	public NYAbsDragGridViewAdapter(Context context, List<T> list, int itemLayout,IHandlerView handlerView) {
		super();
		this.context = context;
		this.list = list;
		this.itemLayout = itemLayout;
		this.handlerView = handlerView;
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public T getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	/**
	 * 由于复用convertView导致某些item消失了，所以这里不复用item，
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			LayoutInflater li = LayoutInflater.from(context);
			convertView = li.inflate(itemLayout, null);
		}
		handlerView.getView(position, convertView);
		if (position == mHidePosition) {
			viewINVISIBLE(convertView);
		}
		return convertView;
	}

	public abstract  void initView(View convertView,T t);

	public abstract  void viewINVISIBLE(View convertView);

	public void reorderItems(int oldPosition, int newPosition) {
		T temp = list.get(oldPosition);
		if (oldPosition < newPosition) {
			for (int i = oldPosition; i < newPosition; i++) {
				Collections.swap(list, i, i + 1);
			}
		} else if (oldPosition > newPosition) {
			for (int i = oldPosition; i > newPosition; i--) {
				Collections.swap(list, i, i - 1);
			}
		}

		list.set(newPosition, temp);
	}


	public void setHideItem(int hidePosition) {
		this.mHidePosition = hidePosition;
		notifyDataSetChanged();
	}
	public interface IHandlerView {
		/**
		 * TextView textView_name = ViewHolder.get(convertView, textView_nameId);
		 */
		View getView(final int position, View convertView);
	}

	public static class ViewHolder {
		@SuppressWarnings("unchecked")
		public static <T extends View> T get(View view, int id) {
			SparseArray<View> sparseArray = (SparseArray<View>) view.getTag();
			if (sparseArray == null) {
				sparseArray = new SparseArray<View>();
				view.setTag(sparseArray);
			}
			View childView = sparseArray.get(id);
			if (childView == null) {
				childView = view.findViewById(id);
				sparseArray.put(id, childView);
			}
			return (T) childView;
		}
	}
}
