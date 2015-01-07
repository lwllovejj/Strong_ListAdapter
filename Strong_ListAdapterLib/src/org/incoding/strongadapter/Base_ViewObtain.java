package org.incoding.strongadapter;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

/**
 * 基于碎片思想抽象的listview item 控制器
 * @author 繁星
 * @qq 群  Android研究交流群 194802363
 * @param <T> 传入适配器的实体bean
 */
public abstract class Base_ViewObtain<T>
{
    protected OnClickListener mListener;
    protected Activity mActivity;

    public Base_ViewObtain(OnClickListener listener)
    {
        mListener = listener;
    }

    /**
     * 设置当前的Activity上下文
     * @param activity
     */
    public void setOnActivity(Activity activity)
    {
        mActivity = activity;
    }

    public Activity getActivity()
    {
        return mActivity;
    }

    public View getView(int layoutid)
    {
        return getActivity().getLayoutInflater().inflate(layoutid, null);
    }

    /**
     * 创建当前指定的View
     * @param t
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    public abstract View createView(T t, int position, View convertView,
            ViewGroup parent);

    /**
     * 更新指定的View
     * @param t
     * @param position
     * @param convertView
     */
    public abstract void updateView(T t, int position, View convertView);

}
