package bawei.com.zhoumengqi0903.model;

import java.io.IOException;

import bawei.com.zhoumengqi0903.app.App;
import bawei.com.zhoumengqi0903.contract.IHomeContract;
import bawei.com.zhoumengqi0903.utils.HttpUtil;

/**
 * <p>文件描述：<p>
 * <p>作者：黑匣子<p>
 * <p>创建时间：2019/9/3<p>
 * <p>更改时间：2019/9/3<p>
 */
public class HomeModel implements IHomeContract.Imodel {
    @Override
    public void getHomeData(String path, IModelHomeCallBack iModelHomeCallBack) throws IOException {
        //网络判断
        if (HttpUtil.getHttpUtil().isNetWork(App.context)){
            HttpUtil.getHttpUtil().getData(path, (HttpUtil.ICallBack) iModelHomeCallBack);
        }
    }
}
