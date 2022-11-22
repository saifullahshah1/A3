package com.i191980_i192200.a3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context c;
    List<MyChat> ls;

    public MyAdapter(Context c, List<MyChat> ls) {
        this.c = c;
        this.ls = ls;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row= LayoutInflater.from(c).inflate(R.layout.row,parent,false);
        return new MyViewHolder(row);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.msg.setText(ls.get(position).getMsg());
        holder.senderID.setText(ls.get(position).getSenderID());
        holder.recieverID.setText(ls.get(position).getRecieverID());
        holder.rv_row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(c,position+"", Toast.LENGTH_LONG).show();
                ls.remove(position);
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return ls.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView msg,senderID,recieverID;
        LinearLayout rv_row;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            msg=itemView.findViewById(R.id.msg);
            senderID=itemView.findViewById(R.id.senderID);
            recieverID=itemView.findViewById(R.id.recieverID);
            rv_row=itemView.findViewById(R.id.rv_row);
        }
    }
}