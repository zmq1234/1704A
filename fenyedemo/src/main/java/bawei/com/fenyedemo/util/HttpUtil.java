package bawei.com.fenyedemo.util;

import android.os.Handler;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

/**
 * <p>文件描述：<p>
 * <p>作者：黑匣子<p>
 * <p>创建时间：2019/8/30<p>
 * <p>更改时间：2019/8/30<p>
 */
public class HttpUtil {

    private Handler handler=new Handler();

    private static HttpUtil httpUtil = new HttpUtil();

    public HttpUtil() {
    }

    public static HttpUtil getHttpUtil() {
        return httpUtil;
    }

    public interface ICallBack{
        void Success(Object obj);
        void Error(int msg);
    }

    public void getData(final String path, final ICallBack iCallBack){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(path);
                    HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();

                    httpsURLConnection.setRequestMethod("GET");

                    httpsURLConnection.setReadTimeout(5000);
                    httpsURLConnection.setConnectTimeout(5000);

                    int code = httpsURLConnection.getResponseCode();

                    if (code == 200){
                        InputStream inputStream = httpsURLConnection.getInputStream();

                        final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

                        byte[] bytes = new byte[1024];

                        int len;

                        while ((len=inputStream.read(bytes))!=-1){
                            outputStream.write(bytes,0,len);
                        }

                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                iCallBack.Success(outputStream);
                            }
                        });
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
