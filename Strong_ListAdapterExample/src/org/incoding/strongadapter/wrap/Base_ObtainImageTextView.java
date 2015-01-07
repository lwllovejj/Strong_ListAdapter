package org.incoding.strongadapter.wrap;

import org.incoding.strongadapter.Base_ViewObtain;
import org.incoding.strongadapter.Strong_BaseBean;
import org.incoding.strongadapter.bean.Bean_Image_Text;
import org.mini.strong_listadapterexample.R;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class Base_ObtainImageTextView extends Base_ViewObtain<Strong_BaseBean>
{

    public Base_ObtainImageTextView(OnClickListener listener)
    {
        super(listener);
    }

    @Override
    public View createView(Strong_BaseBean t, int position, View convertView,
            ViewGroup parent)
    {
        convertView = getView(R.layout.imgtext_view);
        Tag tag = new Tag();
        tag.img = (ImageView) convertView.findViewById(R.id.img);
        tag.text = (TextView) convertView.findViewById(R.id.text);
        convertView.setTag(tag);
        return convertView;
    }

    @Override
    public void updateView(Strong_BaseBean t, int position, View convertView)
    {
        Bean_Image_Text bean = (Bean_Image_Text) t;
        Tag tag = (Tag) convertView.getTag();
        // 
        tag.text.setText(bean.text);
    }

    private class Tag
    {
        ImageView img;
        TextView text;
    }
}
