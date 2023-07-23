package com.example.shopee.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.shopee.Activity.CTMonActivity;
import com.example.shopee.Model.Mon;
import com.example.shopee.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.List;

public class AdapterMon extends RecyclerView.Adapter<AdapterMon.MonViewHolder> {
    Context context;
    List<Mon> list;

    OnItemClickListener onItemClickListener;
    public AdapterMon(Context context, List<Mon> list) {
        this.context = context;
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_itemmon,parent,false);
        return new MonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MonViewHolder holder, int position) {
        Mon mon = list.get(position);
        if (mon == null){
            return;
        }
        holder.tvMonName.setText(mon.getTENMON());
        holder.tvMonPrice.setText(String.valueOf(mon.getGIAMON()));
        Glide.with(context).load(mon.getIMGMON()).into(holder.imgMon);
        holder.btnDat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });


    }
    private void setItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }


    @Override
    public int getItemCount() {
        if (list != null){
            return list.size();
        }
        return 0;
    }

    public class MonViewHolder extends RecyclerView.ViewHolder{
        TextView tvMonName,tvMonPrice;
        ImageView imgMon;
        AppCompatButton btnDat;

        public MonViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMonName= itemView.findViewById(R.id.nameMon);
            tvMonPrice = itemView.findViewById(R.id.giaMon);
            imgMon = itemView.findViewById(R.id.imgMon);
            btnDat = itemView.findViewById(R.id.btndat);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent ictm = new Intent(context, CTMonActivity.class);
                    ictm.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(ictm);
                }
            });

        }
    }
}
