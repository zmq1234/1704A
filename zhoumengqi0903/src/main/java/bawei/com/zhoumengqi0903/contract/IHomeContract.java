package bawei.com.zhoumengqi0903.contract;

import java.io.IOException;

/**
 * <p>文件描述：<p>
 * <p>作者：黑匣子<p>
 * <p>创建时间：2019/9/3<p>
 * <p>更改时间：2019/9/3<p>
 */
public interface IHomeContract {

    //view interface
    interface Iview{
        void onSuccess(String data);
        void onFairute(String e);
    }
    // model interface
    interface Imodel{

        void getHomeData(String path,IModelHomeCallBack iModelHomeCallBack) throws IOException;

        interface IModelHomeCallBack{
            void onSuccess(String data);
            void onFairute(String e);
        }
    }

    //presenter interface
    interface Ipresenter{
        //绑定view
        void attach(IHomeContract.Iview iview);
        //解绑view
        void detach();

        void getmodel(String path);
    }
}
