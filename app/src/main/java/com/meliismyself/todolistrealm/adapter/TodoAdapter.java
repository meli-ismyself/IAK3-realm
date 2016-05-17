package com.meliismyself.todolistrealm.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.meliismyself.todolistrealm.R;
import com.meliismyself.todolistrealm.db.TodoItem;

import java.util.ArrayList;

/**
 * Created by Meli Oktavia on 5/14/2016.
 */
public class TodoAdapter extends BaseAdapter {
    private ArrayList<TodoItem> list;
    private Activity activity;

    public TodoAdapter(Activity activity, ArrayList<TodoItem> list) {
        this.activity = activity;
        this.list = list;
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
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null ){
            LayoutInflater inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_list_todo, null);
            holder = new ViewHolder();
            holder.txtTask = (TextView) convertView
                    .findViewById(R.id.text_item_task);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder)convertView.getTag();
        }

        TodoItem item = (TodoItem)getItem(position);
        holder.txtTask.setText(item.getTask());
        return convertView;
    }

    static class ViewHolder{
        TextView txtTask;
    }


}
