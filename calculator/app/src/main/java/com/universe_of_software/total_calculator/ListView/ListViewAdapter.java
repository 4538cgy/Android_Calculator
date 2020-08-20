package com.universe_of_software.total_calculator.ListView;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.universe_of_software.total_calculator.R;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {

    private ArrayList<ListViewItem> listViewItems = new ArrayList<ListViewItem>();

    public ListViewAdapter()
    {

    }



    @Override
    public int getCount() {
        return listViewItems.size();
    }

    @Override
    public Object getItem(int position) {
        return listViewItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final int pos = position;
        final Context context = parent.getContext();

        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listviewitem,parent,false);

        }

        ImageView imageView = (ImageView)convertView.findViewById(R.id.listviewitem_imageview_title);
        TextView textView = (TextView)convertView.findViewById(R.id.listviewitem_textview_title);

        ListViewItem listViewItem = listViewItems.get(position);

        imageView.setImageDrawable(listViewItem.getDrawable());
        textView.setText(listViewItem.getTitle());

        return convertView;
    }

    public void addItem(Drawable icon, String title ){

        ListViewItem item = new ListViewItem();

        item.setDrawable(icon);
        item.setTitle(title);

        listViewItems.add(item);

    }
}
