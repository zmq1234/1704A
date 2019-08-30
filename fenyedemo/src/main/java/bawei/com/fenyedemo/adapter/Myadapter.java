package bawei.com.fenyedemo.adapter;

import android.content.Context;
import android.graphics.PostProcessor;
import android.media.Image;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import bawei.com.fenyedemo.MainActivity;
import bawei.com.fenyedemo.R;
import bawei.com.fenyedemo.bean.Bean;

/**
 * <p>文件描述：<p>
 * <p>作者：黑匣子<p>
 * <p>创建时间：2019/8/30<p>
 * <p>更改时间：2019/8/30<p>
 */
public class Myadapter extends BaseAdapter {

    List<Bean.ResultBean> list;
    Context context;

    public Myadapter(List<Bean.ResultBean> list, MainActivity context) {
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
        ViewHolder viewHolder =  null;
        if (convertView == null){
            convertView = View.inflate(context, R.layout.item, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.te1.setText(list.get(position).name);
        viewHolder.te2.setText(list.get(position).summary);
        return convertView;
    }

    private class ViewHolder {

        TextView te1,te2;
        ImageView img;

        public ViewHolder(View view) {
            img = view.findViewById(R.id.img);
            te1 = view.findViewById(R.id.te1);
            te2 = view.findViewById(R.id.te2);
        }
    }
}
