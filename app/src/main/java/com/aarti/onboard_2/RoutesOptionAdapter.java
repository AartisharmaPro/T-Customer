package com.aarti.onboard_2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RoutesOptionAdapter extends RecyclerView.Adapter<RoutesOptionAdapter.ProgrammingViewHolder> {
    private Context context;

    public RoutesOptionAdapter(Context context)
    {
        this.context=context;
    }

    @NonNull
    @Override
    public ProgrammingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater Inflater=LayoutInflater.from(parent.getContext());
        View view=Inflater.inflate(R.layout.trip,parent,false);
        return new RoutesOptionAdapter.ProgrammingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProgrammingViewHolder holder, int position) {


     holder.status.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             holder.status.setBackgroundColor(context.getResources().getColor(R.color.colorPrimary));
             holder.status.setText("BOOKED");
         }
     });

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class ProgrammingViewHolder extends RecyclerView.ViewHolder {
        ImageView i,i1,i2,i3;
        TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t11,duration;
        Button status;
        RelativeLayout route_card;

        public ProgrammingViewHolder(@NonNull View itemView) {
            super(itemView);

            status=itemView.findViewById(R.id.status);




        }
    }

}
