package com.example.dark_dash;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ActivityAdapter extends BaseAdapter {

    private Context context;
    private List<Task> activityList;
    public ActivityAdapter(Context context, List<Task> activityList) {
        this.context = context;
        this.activityList = activityList;
    }

    @Override
    public int getCount() {
        return activityList.size();
    }

    @Override
    public Object getItem(int position) {
        return activityList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        }

        TextView titleTextView = convertView.findViewById(R.id.taskTitle);
        TextView descriptionTextView = convertView.findViewById(R.id.taskDescription);


        Task activity = activityList.get(position);

        descriptionTextView.setText(activity.getDescription());
        titleTextView.setText(activity.getTitle());

        return convertView;
    }
}
