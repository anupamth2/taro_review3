package com.example.my_card_view_andrecyclel_view;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class adapter extends RecyclerView.Adapter {

    private  String[] data;
    public adapter(String[] strings)
    {
        this.data=data;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from( parent.getContext() );
        View view=inflater.inflate(R.layout.llist_view,parent,false);

        return new viewholder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        String title=data[position];


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return data.length;
    }
    public class viewholder extends RecyclerView.ViewHolder{
        TextView t1;

        public viewholder(@NonNull View itemView) {
            super( itemView );
            t1=(TextView) t1.findViewById( R.id.label );
        }
    }
}
