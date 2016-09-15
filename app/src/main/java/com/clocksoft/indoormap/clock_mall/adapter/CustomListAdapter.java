package com.clocksoft.indoormap.clock_mall.adapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.clocksoft.indoormap.clock_mall.MainActivity;
import com.clocksoft.indoormap.clock_mall.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by admin on 9/14/2016.
 */
public class CustomListAdapter extends BaseAdapter {
    Context context ;
    int viewType;
    int fragid = 0;
    private ArrayList<String> listname = new ArrayList<String>();
    private ArrayList<String> listadd = new ArrayList<String>();
    private ArrayList<String> listphone = new ArrayList<String>();
    private static LayoutInflater inflater=null;
    public CustomListAdapter(int viewType,Activity mainActivity, ArrayList<String> listname, ArrayList<String> listadd) {
        // TODO Auto-generated constructor stub
        this.listname=listname;
        this.listadd=listadd;
        this.viewType=viewType;
        context=mainActivity;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    public CustomListAdapter(int viewType,Activity mainActivity, ArrayList<String> listname, ArrayList<String> listadd, ArrayList<String> listphone,int fragid) {
        // TODO Auto-generated constructor stub
        this.listname=listname;
        this.listadd=listadd;
        this.listphone=listphone;
        this.viewType=viewType;
        this.fragid=fragid;
        context=mainActivity;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        if(viewType == 1)
        return listname.size()+1;
        else
            return listname.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder3
    {
        TextView add;
        TextView tv;
        ImageView img;
    }
    public class Holder1
    {
        TextView add;
        TextView tv;
        TextView phone;
        ImageView img;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        switch (viewType) {
            case 1: {
                Log.e("position",""+position+" "+fragid);
                if((position==0)&&(fragid==1)) {
                    View top1 = inflater.inflate(R.layout.fav_create_account,null);
                    return top1;
                }
                else if((position==0)&&(fragid==2)) {
                    View top2 = inflater.inflate(R.layout.event_create_account,null);
                    return top2;
                }
                else {
                    Holder1 holder1 = new Holder1();
                    View rowView1;
                    rowView1 = inflater.inflate(R.layout.cardview1, null);
                    holder1.add = (TextView) rowView1.findViewById(R.id.Desc);
                    holder1.tv = (TextView) rowView1.findViewById(R.id.top_heading);
                    holder1.phone = (TextView) rowView1.findViewById(R.id.Link);
                    //    holder.img=(ImageView) rowView.findViewById(R.id.image3);
                    holder1.phone.setText(listphone.get(position-1));
                    holder1.tv.setText(listname.get(position-1));
                    holder1.add.setText(listadd.get(position-1));

                    // holder.img.setImageResource(imageId[position]);
                    rowView1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // TODO Auto-generated method stub
                            if(position>0)
                                Toast.makeText(context, "You Clicked " + listname.get(position-1), Toast.LENGTH_LONG).show();
                        }
                    });
                    return rowView1;
                }
            }
            case 3:
                Holder3 holder = new Holder3();
                View rowView;
                rowView = inflater.inflate(R.layout.cardview3, null);
                holder.add = (TextView) rowView.findViewById(R.id.Desc3);
                holder.tv = (TextView) rowView.findViewById(R.id.Link3);
                //    holder.img=(ImageView) rowView.findViewById(R.id.image3);
                holder.tv.setText(listname.get(position));//result[position]);
                holder.add.setText(listadd.get(position));

                // holder.img.setImageResource(imageId[position]);
                rowView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        Toast.makeText(context, "You Clicked " + listname.get(position), Toast.LENGTH_LONG).show();
                    }
                });
                return rowView;

        }return null;
    }

}