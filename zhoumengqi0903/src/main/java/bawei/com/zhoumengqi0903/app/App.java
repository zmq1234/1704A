package bawei.com.zhoumengqi0903.app;

import android.app.Application;
import android.content.Context;

/**
 * <p>文件描述：<p>
 * <p>作者：黑匣子<p>
 * <p>创建时间：2019/9/3<p>
 * <p>更改时间：2019/9/3<p>
 */
public class App extends Application {

    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        //创建公共工具
        context=this;
    }
}
