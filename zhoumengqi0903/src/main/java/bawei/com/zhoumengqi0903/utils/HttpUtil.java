package bawei.com.zhoumengqi0903.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * <p>文件描述：<p>
 * <p>作者：黑匣子<p>
 * <p>创建时间：2019/9/3<p>
 * <p>更改时间：2019/9/3<p>
 */
public class HttpUtil {

    //懒汉式
    private static HttpUtil httpUtil = new HttpUtil();

    private HttpUtil() {
    }

    public static HttpUtil getHttpUtil() {
        return httpUtil;
    }

    Handler handler = new Handler();

    public interface ICallBack{
        void onSuccess(Object obj);
    }

    //网络判断
    public boolean isNetWork(Context context){
        //得到管理工具类
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        //得到网络判断类
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo!=null){
            return networkInfo.isAvailable();
        }
        return false;
    }

    //网络
    public void getData(final String path, final ICallBack iCallBack){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //初始化定位符
                    URL url = new URL(path);
                    Log.e("qwe","nimasile");
                    //打开网络连接
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

                    //网络请求方式
                    urlConnection.setRequestMethod("GET");
                    //网络连接超时
                    urlConnection.setConnectTimeout(5000);
                    if (urlConnection.getResponseCode()==200){

                        //初始化输入流
                        InputStream inputStream = urlConnection.getInputStream();
                        //转换流
                        final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                        //定义shuzu
                        byte[] bytes = new byte[1024];
                        int len;
                        while ((len=inputStream.read(bytes))!=-1){
                            outputStream.write(bytes,0,len);

                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    iCallBack.onSuccess(outputStream);
                                }
                            });
                    }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
