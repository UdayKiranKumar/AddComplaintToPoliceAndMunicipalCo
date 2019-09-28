package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class policeadapter   extends BaseAdapter {

    Context context;
    ArrayList<String> userID;
    ArrayList<String> UserName;
    ArrayList<String> User_PhoneNumber;
    ArrayList<String> UserAddress ;
    ArrayList<String> UserComplaint;


    public policeadapter(
            Context context2,
            ArrayList<String> id,
            ArrayList<String> name,
            ArrayList<String> phone,
            ArrayList<String> address,
            ArrayList<String> complaint
    )
    {

        this.context = context2;
        this.userID = id;
        this.UserName = name;
        this.User_PhoneNumber = phone;
        this.UserAddress = address ;
        this.UserComplaint=complaint;
    }

    public int getCount() {
        // TODO Auto-generated method stub
        return userID.size();
    }

    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    public View getView(int position, View child, ViewGroup parent) {

        Holder holder;

        LayoutInflater layoutInflater;

        if (child == null) {
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            child = layoutInflater.inflate(R.layout.policexml, null);

            holder = new Holder();

            holder.textviewid = (TextView) child.findViewById(R.id.id_edit_police);
            holder.textviewname = (TextView) child.findViewById(R.id.name_edit_police);
            holder.textviewphone_number = (TextView) child.findViewById(R.id.number_edit_police);
            holder.textviewaddress = (TextView) child.findViewById(R.id.address_edit_police);
            holder.textcomplaint=(TextView)child.findViewById(R.id.policecomplaint);

            child.setTag(holder);

        } else {


            holder = (Holder) child.getTag();
        }
        holder.textviewid.setText(userID.get(position));
        holder.textviewname.setText(UserName.get(position));
        holder.textviewphone_number.setText(User_PhoneNumber.get(position));
        holder.textviewaddress.setText(UserAddress.get(position));
        holder.textcomplaint.setText(UserComplaint.get(position));

        return child;
    }

    public class Holder {
        TextView textviewid;
        TextView textviewname;
        TextView textviewphone_number;
        TextView textviewaddress;
        TextView textcomplaint;
    }
}
