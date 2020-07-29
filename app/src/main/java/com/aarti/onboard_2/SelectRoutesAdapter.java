package com.aarti.onboard_2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;



public class SelectRoutesAdapter extends RecyclerView.Adapter<SelectRoutesAdapter.ProgrammingViewHolder>  {


    private Context context;







    public SelectRoutesAdapter(Context context) {
        this.context = context;
    }
    @NonNull
    @Override
    public SelectRoutesAdapter.ProgrammingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater Inflater=LayoutInflater.from(parent.getContext());
        View view=Inflater.inflate(R.layout.way,parent,false);
        return new ProgrammingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SelectRoutesAdapter.ProgrammingViewHolder holder, int position)
    {
        holder.route_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context,RouteOptions.class);
                context.startActivity(i);
            }
        });
    }
    @Override
    public int getItemCount() {
        return 4;
    }



    public class ProgrammingViewHolder extends RecyclerView.ViewHolder {
        ImageView i,i1,i2,i3;
        TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t11,duration;

        RelativeLayout route_card;

        public ProgrammingViewHolder(@NonNull View itemView) {
            super(itemView);
            route_card=(RelativeLayout)itemView.findViewById(R.id.route_card);
            t1=(TextView)itemView.findViewById(R.id.mode_one);
            t2=(TextView)itemView.findViewById(R.id.mode_two);
            t3=(TextView)itemView.findViewById(R.id.mode_three);
            duration=(TextView)itemView.findViewById(R.id.duration);






        }
    }
}
