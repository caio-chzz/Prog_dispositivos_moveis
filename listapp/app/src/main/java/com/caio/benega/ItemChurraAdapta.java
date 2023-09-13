package com.caio.benega;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ItemChurraAdapta extends ArrayAdapter<ItemChurras> {
    Context mContext;
    int mResource;
    public ItemChurraAdapta(@NonNull Context context, int resource,
                            @NonNull List<ItemChurras> objects) {
        super(context, resource, objects);
        mContext= context;
        mResource= resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater infla = LayoutInflater.from(mContext);
        convertView = infla.inflate(mResource, parent, false);



        //return super.getView(position, convertView, parent);
    }
}
