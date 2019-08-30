package bawei.com.fenyedemo.bean;

import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：黑匣子<p>
 * <p>创建时间：2019/8/30<p>
 * <p>更改时间：2019/8/30<p>
 */
public class Bean {

    public List<ResultBean> result;

    public static class ResultBean {

        public String imageUrl;
        public String name;
        public String summary;

    }
}
