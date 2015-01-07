package org.incoding.strongadapter.wrap;

import org.incoding.strongadapter.Base_ViewObtain;
import org.incoding.strongadapter.Strong_BaseBean;
import org.incoding.strongadapter.bean.Bean_Image;
import org.mini.strong_listadapterexample.R;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class Base_ObtainImgView extends Base_ViewObtain<Strong_BaseBean>
{

    public Base_ObtainImgView(OnClickListener listener)
    {
        super(listener);
    }

    @Override
    public View createView(Strong_BaseBean t, int position, View convertView,
            ViewGroup parent)
    {
        convertView = getView(R.layout.img_view);
        Tag tag = new Tag();
        tag.img = (ImageView) convertView.findViewById(R.id.img);
        convertView.setTag(tag);
        return convertView;
    }

    @Override
    public void updateView(Strong_BaseBean t, int position, View convertView)
    {
        Bean_Image bean = (Bean_Image) t;
        Tag tag = (Tag) convertView.getTag();
    }
    private class Tag
    {
        ImageView img;
        TextView text;
    }
}
