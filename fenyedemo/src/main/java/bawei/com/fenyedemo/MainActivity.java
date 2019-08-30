package bawei.com.fenyedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.List;

import bawei.com.fenyedemo.adapter.Myadapter;
import bawei.com.fenyedemo.base.BaseActivity;
import bawei.com.fenyedemo.bean.Bean;
import bawei.com.fenyedemo.util.HttpUtil;

public class MainActivity extends BaseActivity {

    private PullToRefreshListView plv;
    private String url="http://172.17.8.100/movieApi/movie/v1/findReleaseMovieList";
    private int page=1;
    private int count=5;


    @Override
    protected int InitLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        plv = findViewById(R.id.plv);

        plv.setPullToRefreshOverScrollEnabled(true);
        plv.setPullToRefreshEnabled(true);
        plv.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> pullToRefreshBase) {
                page=1;

                initData();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> pullToRefreshBase) {
                page+=1;
                initData();
            }
        });

    }

    @Override
    protected void initData() {

        HttpUtil.getHttpUtil().getData("url?page=" + page + "&count" + count, new HttpUtil.ICallBack() {
            @Override
            public void Success(Object obj) {

                Gson gson = new Gson();
                Bean bean = gson.fromJson(obj.toString(), Bean.class);
                List<Bean.ResultBean> result = bean.result;

                Myadapter myadapter = new Myadapter(result,MainActivity.this);
                
                plv.setAdapter(myadapter);

            }

            @Override
            public void Error(int msg) {
            }
        });

    }
}
