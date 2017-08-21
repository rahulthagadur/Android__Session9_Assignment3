package com.example.thagadur.android__session9_assignment3;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Thagadur on 8/20/2017.
 */

public class CustomArrayAdapter extends BaseAdapter {

    //Initialise or declare the objects and Variables
    private Context activity;
    private static LayoutInflater inflater=null;
    private String contactName[], contactPhnum[];

    //Constructor of Customozied adapter to initialise the names and phoneNumber
    public CustomArrayAdapter(Activity a, String[] names,String[] phNum){
        activity=a;
        contactName=names;
        contactPhnum=phNum;
        inflater = (LayoutInflater)activity.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    //declare a holder class which holds 2 TextView
    public class Holder{
        TextView name;
        TextView phNum;

    }
    @Override
    public int getCount() {
        return contactName.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View vi =view;
        Holder holder=new Holder();
        vi=inflater.inflate(R.layout.custom_array_adapter,null);
            //getting the Textview id and assigning it to the Holder
            holder.name=(TextView)vi.findViewById(R.id.name);
            holder.phNum=(TextView)vi.findViewById(R.id.phNum);
            //Setting the text on name and phone number
            holder.name.setText(contactName[i]);
            holder.phNum.setText(contactPhnum[i]);

        return vi;
    }
}
