package org.incoding.strongadapter;

/**
 * 让你的Bean继承这个超类吧
 * @author 繁星
 * @qq 群  Android研究交流群 194802363
 * @param <T> 传入适配器的实体bean
 *
 */
public class Strong_BaseBean
{

    /**
     * 标志当前的View的类型
     */
    public int fx_type = 0;

    public int getFx_type()
    {
        return fx_type;
    }

    public void setFx_type(int fx_type)
    {
        this.fx_type = fx_type;
    }

}
