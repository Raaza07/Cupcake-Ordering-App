package com.example.myapplication50;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OrderRvAdapter extends RecyclerView.Adapter<OrderRvAdapter.ViewHolder> {


    private ArrayList<OrderModel> OrderModelArrayList;
    private Context context;


    public OrderRvAdapter(ArrayList<OrderModel> OrderModelArrayList, Context context) {
        this.OrderModelArrayList = OrderModelArrayList;
        this.context = context;
    }


    @NonNull
    @Override
    public OrderRvAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_rv_item, parent, false);
        return new OrderRvAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderRvAdapter.ViewHolder holder, int position) {

        OrderModel modal = OrderModelArrayList.get(position);
        holder.U_id.setText("user id : "+modal.getUserId());
        holder.p_id.setText("product id : "+modal.getProductId());
        holder.p_qty.setText("product quantity : "+modal.getProductQty());


        // below line is to add on click listener for our recycler view item.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // on below line we are calling an intent.
                Intent i = new Intent(context, UpdateOrderActivity.class);

                // below we are passing all our values.
                i.putExtra("User_Id", modal.getUserId());
                i.putExtra("product_id", modal.getProductId());
                i.putExtra("product_qty", modal.getProductQty());


                // starting our activity.
                context.startActivity(i);
            }
        });


    }

    @Override
    public int getItemCount() {
        return OrderModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView U_id,p_id,p_qty;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            U_id = itemView.findViewById(R.id.U_id);
            p_id = itemView.findViewById(R.id.P_id);
            p_qty = itemView.findViewById(R.id.P_qty);


        }
    }
}