package bawei.com.fenyedemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * <p>文件描述：<p>
 * <p>作者：黑匣子<p>
 * <p>创建时间：2019/8/30<p>
 * <p>更改时间：2019/8/30<p>
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(InitLayout());

        initView();

        initData();
    }

    protected abstract int InitLayout();

    protected abstract void initView();

    protected abstract void initData();
}
