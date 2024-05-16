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

public class ProductRvAdapter extends RecyclerView.Adapter<ProductRvAdapter.ViewHolder> {


    private ArrayList<ProductModel> ProductModalArrayList;
    private Context context;

    public ProductRvAdapter(ArrayList<ProductModel> ProductModalArrayList, Context context) {
        this.ProductModalArrayList = ProductModalArrayList;
        this.context = context;
    }




    @NonNull
    @Override
    public ProductRvAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductRvAdapter.ViewHolder holder, int position) {

        ProductModel modal = ProductModalArrayList.get(position);
        holder.pro_id.setText("product id : "+modal.getProductId());
        holder.pro_name.setText("product name : "+modal.getProductName());
        holder.pro_price.setText("product price : "+modal.getProductPrice());
        holder.pro_qty.setText("product quantity : "+modal.getProductQty());
        holder.pro_cat_id.setText("product category id : "+modal.getCategoryId());

        // below line is to add on click listener for our recycler view item.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // on below line we are calling an intent.
                Intent i = new Intent(context, UpdateProductActivity.class);

                // below we are passing all our values.
                i.putExtra("P_Id", modal.getProductId());
                i.putExtra("P_Name", modal.getProductName());
                i.putExtra("P_Price", modal.getProductPrice());
                i.putExtra("P_Qty", modal.getProductQty());
                i.putExtra("P_Cat_Name", modal.getCategoryId());

                // starting our activity.
                context.startActivity(i);
            }
        });





    }

    @Override
    public int getItemCount() {
        return ProductModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private TextView pro_id, pro_name, pro_price, pro_qty,pro_cat_id;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // initializing our text views
            pro_id = itemView.findViewById(R.id.Update_Pro_Id);
            pro_name = itemView.findViewById(R.id.Update_Pro_Name);
            pro_price = itemView.findViewById(R.id.Update_Pro_price);
            pro_qty = itemView.findViewById(R.id.Update_Pro_Qty);
            pro_cat_id = itemView.findViewById(R.id.Update_Pro_Cat_Id);



        }
    }
}
