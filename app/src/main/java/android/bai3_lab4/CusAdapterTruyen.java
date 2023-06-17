package android.bai3_lab4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CusAdapterTruyen extends ArrayAdapter {
    Context context;
    int layoutItem;
    ArrayList<Truyen> arrayListTruyen;

    public CusAdapterTruyen(@NonNull Context context, int layoutItem,ArrayList<Truyen> arrayListTruyen ) {
        super(context, layoutItem, arrayListTruyen);
        this.context=context;
        this.layoutItem=layoutItem;
        this.arrayListTruyen=arrayListTruyen;
    }
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Truyen truyen=arrayListTruyen.get(position);
         if(convertView==null)
        {
            convertView= LayoutInflater.from(context).inflate(layoutItem,null);
        }
        ImageView imgTruyen = (ImageView) convertView.findViewById(R.id.imgTruyen);
        imgTruyen.setImageResource(truyen.getIdAnh());
        TextView tvTenTruyen = (TextView) convertView.findViewById(R.id.tvTen);
        tvTenTruyen.setText(truyen.getTenTruyen());
        return convertView;
    }
}
