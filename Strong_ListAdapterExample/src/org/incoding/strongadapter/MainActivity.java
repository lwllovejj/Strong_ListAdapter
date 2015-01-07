package org.incoding.strongadapter;

import java.util.ArrayList;

import org.incoding.strongadapter.bean.Bean_Image;
import org.incoding.strongadapter.bean.Bean_Image_Text;
import org.incoding.strongadapter.bean.Bean_Text;
import org.incoding.strongadapter.commont.TypeManager;
import org.incoding.strongadapter.wrap.Base_ObtainImageTextView;
import org.incoding.strongadapter.wrap.Base_ObtainImgView;
import org.incoding.strongadapter.wrap.Base_ObtainTextView;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.widget.ListView;

public class MainActivity extends Activity
{
    Handler mHandler;
    ListView mListView;
    Strong_ListAdapterMType<Strong_BaseBean> mAdapterMType;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        mHandler = new Handler();

        setContentView(org.mini.strong_listadapterexample.R.layout.main);
        mListView = (ListView) findViewById(org.mini.strong_listadapterexample.R.id.main_list);
        // 初始化适配器
        mAdapterMType = new Strong_ListAdapterMType<Strong_BaseBean>(this);

        // 添加Base_ObtainImgView 控制器，参数是监听事件处理用的
        mAdapterMType.addViewObtains(TypeManager.TYPE_IMG,
                new Base_ObtainImgView(null));
        mAdapterMType.addViewObtains(TypeManager.TYPE_TEXT_IMG,
                new Base_ObtainImageTextView(null));
        mAdapterMType.addViewObtains(TypeManager.TYPE_TEXT,
                new Base_ObtainTextView(null));

        // 添加测试数据，当然你可以异步添加数据
        testDat();
        mListView.setAdapter(mAdapterMType);
    }

    public void testDat()
    {
        ArrayList<Strong_BaseBean> beans = new ArrayList<Strong_BaseBean>();
        Bean_Image_Text image_Text = new Bean_Image_Text();
        image_Text.text = "这个美女是谁啊，这么漂酿";
        beans.add(image_Text);
        Bean_Text beanT = new Bean_Text();
        beanT.text = "布林线由4条线构成，分为 B1线、B2线、B3线及B4线。B1线为指数（或股价）阻力线，B4线是支撑线，从布林线的宽度可以看出指数或股价的变动区间，股价盘整时，四线收缩，称收口；股价向上或向下突破时，四线打开，称为开口。当股价向上击穿B1阻力线时，卖点出现，向下击穿B4线时，买点出现，当股价沿着阻力线（支撑线）上升（下降），虽并未击穿支撑线（压力线），但已回头突破B2线（B3线）时，也是较佳卖（买）点。";
        beans.add(beanT);
        beans.add(new Bean_Image());
        beans.add(new Bean_Image());
        beanT = new Bean_Text();
        beanT.text = "小龙女幼时被抛弃在重阳宫前，因为是女孩之故而被林朝英的丫环带走。由于被抱走时身上有一块龙纹玉佩，因而被称为“小龙女”。后于活死人墓中长大，由林朝英的丫环传授武功。";
        beans.add(beanT);
        beans.add(new Bean_Image());
        image_Text = new Bean_Image_Text();
        image_Text.text = "小龙女，金庸武侠小说《神雕侠侣》中的女主人公，出生时被遗弃在终南山下，被古墓派林朝英的丫环收为弟子，十八年来始终与孙婆婆为伴。";
        beans.add(image_Text);
        beans.add(new Bean_Image());
        beans.add(new Bean_Image());
        mAdapterMType.addList(beans);
    }
}
