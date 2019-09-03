package bawei.com.zhoumengqi0903.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.List;
import bawei.com.zhoumengqi0903.R;
import bawei.com.zhoumengqi0903.model.ShopBean;
import bawei.com.zhoumengqi0903.view.MainActivity;

/**
 * <p>文件描述：<p>
 * <p>作者：黑匣子<p>
 * <p>创建时间：2019/9/3<p>
 * <p>更改时间：2019/9/3<p>
 */
public class Myadapter extends BaseAdapter {

    Context context;
    List<ShopBean.DataBean> list;

    public Myadapter(List<ShopBean.DataBean> list, MainActivity context) {
        this.context=context;
        this.list=list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null){
            convertView = View.inflate(context, R.layout.child_item, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.te1.setText(list.get(position).currency_price);
        viewHolder.te2.setText(list.get(position).goods_name);
        Glide.with(context).load(list.get(position).goods_thumb).into(viewHolder.img);
        return convertView;
    }

    private class ViewHolder {
        ImageView img;
        TextView te1,te2;
        private ViewHolder(View v) {
            img = v.findViewById(R.id.img);
            te1 = v.findViewById(R.id.te1);
            te2 = v.findViewById(R.id.te2);
        }
    }
}
