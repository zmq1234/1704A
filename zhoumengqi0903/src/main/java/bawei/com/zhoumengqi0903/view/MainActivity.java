package bawei.com.zhoumengqi0903.view;

import android.widget.Toast;
import com.google.gson.Gson;
import com.qy.xlistview.XListView;

import java.util.ArrayList;
import java.util.List;
import bawei.com.zhoumengqi0903.R;
import bawei.com.zhoumengqi0903.adapter.Myadapter;
import bawei.com.zhoumengqi0903.base.BaseActivity;
import bawei.com.zhoumengqi0903.model.ShopBean;
import bawei.com.zhoumengqi0903.utils.HttpUtil;

public class MainActivity extends BaseActivity {


    private XListView xlv;
    private String path="http://blog.zhaoliang5156.cn/api/shop/shop1.json";
    private List<ShopBean.DataBean> list = new ArrayList<>();
    int page=1;

    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        xlv = findViewById(R.id.xlv);
    }

    @Override
    protected void initData() {
        if (HttpUtil.getHttpUtil().isNetWork(MainActivity.this)){
            Toast.makeText(this, "有网", Toast.LENGTH_SHORT).show();
            HttpUtil.getHttpUtil().getData("http://blog.zhaoliang5156.cn/api/shop/shop"+page+".json", new HttpUtil.ICallBack() {

                @Override
                public void onSuccess(Object obj) {
                    //新建gson工具
                    Gson gson = new Gson();
                    ShopBean shopBean = gson.fromJson(obj.toString(), ShopBean.class);
                    List<ShopBean.DataBean> data = shopBean.data;
                    list.addAll(data);
                    //新建适配器
                    Myadapter myadapter = new Myadapter(list,MainActivity.this);
                    xlv.setAdapter(myadapter);
                }
            });
        }else {
            Toast.makeText(this, "没有网", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void initEvent() {
        xlv.setPullLoadEnable(true);
        xlv.setPullRefreshEnable(true);
        xlv.setXListViewListener(new XListView.IXListViewListener() {
            @Override
            public void onRefresh() {
                page=1;
                list.clear();
                initData();
                xlv.stopRefresh();
            }

            @Override
            public void onLoadMore() {
                page+=1;
                initData();
                xlv.stopLoadMore();
            }
        });
    }
}
