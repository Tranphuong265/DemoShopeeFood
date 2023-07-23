package com.example.shopee.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.shopee.Activity.CTQuanActivity;
import com.example.shopee.Model.Mon;
import com.example.shopee.Model.Quan;
import com.example.shopee.R;

import java.util.List;

public class AdapterQuan extends RecyclerView.Adapter<AdapterQuan.QuanViewHolder> {
    Context context;
    List<Quan> list;

    public AdapterQuan(Context context, List<Quan> list) {
        this.context = context;
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public QuanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_itemquan, parent, false);
        return new AdapterQuan.QuanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuanViewHolder holder, int position) {
        Quan quan = list.get(position);
        if (quan == null) {
            return;
        }
        holder.tvQuanName.setText(quan.getTENQ());
        Glide.with(context).load(quan.getIMGQ()).into(holder.imgQuan);
        holder.tvQuan_gg.setText("Giảm món");

    }

    @Override
    public int getItemCount() {
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public class QuanViewHolder extends RecyclerView.ViewHolder {
        TextView tvQuanName, tvQuan_gg;
        ImageView imgQuan;

        public QuanViewHolder(@NonNull View itemView) {
            super(itemView);
            tvQuanName = itemView.findViewById(R.id.tvNameQuan);
            tvQuan_gg = itemView.findViewById(R.id.quan_gg);
            imgQuan = itemView.findViewById(R.id.imgQuan);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    Quan quan = list.get(pos);
                    Intent ict= new Intent(context, CTQuanActivity.class);
                    ict.putExtra("ct",quan);
                    ict.putExtra("idq",quan.getMAQ());
                    ict.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(ict);
                }
            });
        }

    }
}