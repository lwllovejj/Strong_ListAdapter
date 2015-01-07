package org.incoding.strongadapter.bean;

import org.incoding.strongadapter.Strong_BaseBean;
import org.incoding.strongadapter.commont.TypeManager;

public class Bean_Image extends Strong_BaseBean
{
    public String img_url;

    public Bean_Image()
    {
        fx_type = TypeManager.TYPE_IMG;
    }
}
