package org.incoding.strongadapter;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

/**
 * 多种类型的适配器
 * @author 繁星
 * @qq 群  Android研究交流群 194802363
 * @param <T> 传入适配器的实体bean
 */
public class Strong_ListAdapterMType<T extends Strong_BaseBean> extends
        Strong_ListAdapter<T>
{
    protected SparseArray<Base_ViewObtain<T>> mViewObtains = new SparseArray<Base_ViewObtain<T>>();
    protected List<T> mBeans;
    protected int mTypeSizeMax = 10;

    public Strong_ListAdapterMType(Activity activity)
    {
        super(activity);
    }

    public void addViewObtains(int type, Base_ViewObtain<T> obt)
    {
        mViewObtains.put(type, obt);
        obt.setOnActivity(mActivity);
    }

    public List<T> getList()
    {
        return mBeans;
    }

    /**
     * 设置列表数据
     * @param beans
     */
    public void setList(List<T> beans)
    {
        mBeans = beans;
    }

    /**
     * 添加列表
     * @param beans
     */
    public void addList(List<T> beans)
    {
        if (mBeans == null)
            mBeans = new ArrayList<T>();
        mBeans.addAll(beans);
    }

    public void remove(T t)
    {
        mBeans.remove(t);
    }

    /**
     * 清除列表中的数据
     */
    public void clear()
    {
        if (mBeans != null)
            mBeans.clear();
    }

    @Override
    public int getCount()
    {
        return mBeans == null ? 0 : mBeans.size();
    }

    @Override
    public long getItemId(int position)
    {
        return 0;
    }

    @Override
    public T getItem(int position)
    {
        if (mBeans == null || mBeans.size() == 0)
            return null;
        return mBeans.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        Base_ViewObtain<T> obtain = mViewObtains.get(getItemViewType(position));
        if (convertView == null)
        {
            convertView = mViewObtains.get(getItemViewType(position))
                    .createView(getItem(position), position, convertView,
                            parent);
        }
        obtain.updateView(getItem(position), position, convertView);
        return convertView;
    }

    public View getView(T bean, View convertView, ViewGroup parent)
    {
        Base_ViewObtain<T> obtain = mViewObtains.get(bean.getFx_type());
        if (convertView == null)
        {
            convertView = mViewObtains.get(bean.getFx_type()).createView(bean,
                    1, convertView, parent);
        }
        obtain.updateView(bean, 1, convertView);
        return convertView;
    }

    @Override
    public int getViewTypeCount()
    {
        return mTypeSizeMax;
    }

    @Override
    public int getItemViewType(int position)
    {
        return getItem(position).getFx_type();
    }
}
