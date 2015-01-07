package org.incoding.strongadapter.bean;

import org.incoding.strongadapter.Strong_BaseBean;
import org.incoding.strongadapter.commont.TypeManager;

public class Bean_Image_Text extends Strong_BaseBean
{
    public String img_url;
    public String text;
    public Bean_Image_Text()
    {
        fx_type = TypeManager.TYPE_TEXT_IMG;
    }
}
