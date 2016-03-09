package com.example.andresvil.menucurso;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andresvil on 3/9/16.
 */
public class MyAdapter extends ArrayAdapter {

    private List myList = new ArrayList();

    public MyAdapter(Context context, int resource) {
        super(context, resource);
    }

    public void add(Character object) {
        myList.add(object);
        super.add(object);
    }

    static class ImgHolder
    {
        ImageView IMG;
        TextView CAPNUM;
        TextView CAPNOMBRE;
    }

    @Override
    public int getCount() {
        return this.myList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.myList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        row = convertView;
        ImgHolder holder;

        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.row_layout, parent, false);
            holder = new ImgHolder();
            holder.IMG = (ImageView) row.findViewById(R.id.icon_img);
            holder.CAPNUM = (TextView) row.findViewById(R.id.num_capitulo);
            holder.CAPNOMBRE = (TextView) row.findViewById(R.id.nombre_capitulo);

            row.setTag(holder);
        }

        else
        {
            holder = (ImgHolder) row.getTag();
        }

        Modulo mod = (Modulo) getItem(position);
        holder.IMG.setImageResource(mod.getImg_rsc());
        holder.CAPNUM.setText(mod.getModulo());
        holder.CAPNOMBRE.setText(mod.getNombre_capitulo());

        return row;
    }
}
