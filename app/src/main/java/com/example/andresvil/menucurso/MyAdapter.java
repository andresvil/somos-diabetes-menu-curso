package com.example.andresvil.menucurso;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by andresvil on 3/9/16.
 */
public class MyAdapter extends ArrayAdapter {

    private List myList = new ArrayList();
    private Context context;

    public MyAdapter(Context context, int resource) {
        super(context, resource);
        this.context = context;
    }

    public void add(Modulo object) {
        myList.add(object);
        super.add(object);
    }

    static class ImgHolder
    {
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ImgHolder holder;

        if(row == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.row_layout, parent, false);
            holder = new ImgHolder();
            holder.CAPNUM = (TextView) row.findViewById(R.id.num_capitulo);
            holder.CAPNOMBRE = (TextView) row.findViewById(R.id.nombre_capitulo);

            row.setTag(holder);
        }

        else
        {
            holder = (ImgHolder) row.getTag();
        }

        final Modulo mod = (Modulo) getItem(position);

        // Set background image and change its alpha
        row.setBackgroundResource(mod.getImg_rsc());
        Drawable bg = row.getBackground();
        bg.setAlpha(50);

        // Set textView texts
        holder.CAPNUM.setText(mod.getModulo());
        holder.CAPNOMBRE.setText(mod.getNombre_capitulo());

        // Load font and set TextViews to that font
        AssetManager am = getContext().getApplicationContext().getAssets();
        Typeface myFont = Typeface.createFromAsset(am, String.format(Locale.US, "fonts/%s", "AvenirLTStd-Light_0.otf"));
        holder.CAPNUM.setTypeface(myFont);
        holder.CAPNOMBRE.setTypeface(myFont);

        // Set OnClickListener
        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*Class className = null;
                try {
                    className = Class.forName("Mod" + (position + 1) + ".class");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                Intent i = new Intent(getContext(), className);
                getContext().startActivity(i);*/

                Toast.makeText(getContext(), "Mod" + (position + 1) + ".class", Toast.LENGTH_SHORT).show();
            }
        });

        return row;
    }
}
