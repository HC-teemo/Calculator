package com.example.huchuan.calculator.style;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.huchuan.calculator.R;

import java.util.List;

/**
 * Created by huchuan on 2017/10/19.
 */

public class MyAdapter extends BaseAdapter{

    private List<ImgItem> list;
    private Context context;

    public MyAdapter(List<ImgItem> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        LayoutInflater _LayoutInflater=LayoutInflater.from(context);
        convertView=_LayoutInflater.inflate(R.layout.item_custom, null);
        if(convertView!=null) {
            ImageView imageView = (ImageView)convertView.findViewById(R.id.imageView1);
            if(list.get(i).getImgSrc()==0){
                imageView.setVisibility(View.GONE);
            }else {
                imageView.setImageResource(list.get(i).getImgSrc());
            }

            TextView _TextView1=(TextView)convertView.findViewById(R.id.textView1);
            _TextView1.setText(list.get(i).getItemName());
        }
        return convertView;
    }
}
