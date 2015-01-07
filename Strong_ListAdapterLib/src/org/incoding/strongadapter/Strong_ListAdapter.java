package org.incoding.strongadapter;

import android.app.Activity;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;

/**
 * 基础的适配器
 * @author 繁星
 * @qq 群  Android研究交流群 194802363
 * @param <T> 传入适配器的实体bean
 */
public abstract class Strong_ListAdapter<T> extends BaseAdapter
{
    OnClickListener mListener;
    ListView mListView;
    Activity mActivity;

    public Strong_ListAdapter(Activity activity)
    {
        mActivity = activity;
    }

    // option
    public void setOptionOnClickListener(OnClickListener listener)
    {
        mListener = listener;
    }

    public abstract T getItem(int position);
}
