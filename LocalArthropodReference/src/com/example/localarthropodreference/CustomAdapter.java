package com.example.localarthropodreference;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter<Bug> {
	Context context;
	int layoutResourceId;    
    List<Bug> data = null;
    
	public CustomAdapter(Context context, int resource, int textViewResourceId,  List<Bug> data) {
        super(context, resource, textViewResourceId, data);
        this.layoutResourceId = resource;
        this.context = context;
        this.data = data;
	}
	@Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        BugHolder holder = null;
        
        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            
            holder = new BugHolder();
            holder.common = (TextView)row.findViewById(R.id.common);
            holder.scientific = (TextView)row.findViewById(R.id.scientific);
            
            row.setTag(holder);
        }
        else
        {
            holder = (BugHolder)row.getTag();
        }
        
        Bug bug = data.get(position);
        holder.common.setText(bug.getComName());
        holder.scientific.setText(bug.getSciName());
        
        return row;
    }
	@Override
	public int getCount() {
	    return data.size();
	}
	public void swapBugs(List<Bug> bugs) {
	    this.data = bugs;
	    notifyDataSetChanged();
	}
	static class BugHolder
    {
        TextView common;
        TextView scientific;
    }

}
