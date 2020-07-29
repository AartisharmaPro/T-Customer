package com.aarti.onboard_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CheckPointsAdapter extends RecyclerView.Adapter<CheckPointsAdapter.ProgrammingViewHolder>{

    private Context context;






    public CheckPointsAdapter(Context context) {
        this.context = context;
    }
    @NonNull
    @Override
    public ProgrammingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater Inflater=LayoutInflater.from(parent.getContext());
        View view=Inflater.inflate(R.layout.trip,parent,false);
        return new CheckPointsAdapter.ProgrammingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProgrammingViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class ProgrammingViewHolder extends RecyclerView.ViewHolder {
        ImageView i,i1,i2,i3;
        TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t11;
        Button req;

        public ProgrammingViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }
}
