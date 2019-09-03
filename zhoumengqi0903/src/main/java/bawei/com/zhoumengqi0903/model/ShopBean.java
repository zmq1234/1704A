package bawei.com.zhoumengqi0903.model;

import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：黑匣子<p>
 * <p>创建时间：2019/9/3<p>
 * <p>更改时间：2019/9/3<p>
 */
public class ShopBean {

    public List<DataBean> data;

    public static class DataBean {

        public String currency_price;
        public String goods_name;
        public String goods_thumb;
    }
}
