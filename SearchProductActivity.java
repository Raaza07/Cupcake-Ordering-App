package com.example.myapplication50;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class SearchProductActivity extends AppCompatActivity {

    EditText EditTextProductId,EditProductName,EditTextPrice,EditTextCategory,EditTextQuantity,EditTextUserId,EditTextBuyQuantity,EditTextInvoiceId;

    Button ButtonSearchProduct,ButtonBuyProduct;

    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_product);

        EditTextProductId = (EditText) findViewById(R.id.txt_I_ProductId);
        EditProductName = (EditText) findViewById(R.id.txt_I_ProductName);
        EditTextPrice = (EditText) findViewById(R.id.txt_I_Price);
        EditTextQuantity = (EditText) findViewById(R.id.txt_I_Qty);
        EditTextCategory = (EditText) findViewById(R.id.txt_I_Category);
        ButtonSearchProduct = (Button) findViewById(R.id.btn_I_SearchProduct);
        EditTextBuyQuantity = (EditText) findViewById(R.id.txt_I_BuyQty);

        EditTextUserId = (EditText) findViewById(R.id.txt_I_Userid);
        EditTextInvoiceId = (EditText) findViewById(R.id.txt_I_InvoiceId);
        ButtonBuyProduct = (Button) findViewById(R.id.btn_I_Buy);

        dbHandler = new DBHandler(SearchProductActivity.this);

        ButtonSearchProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pid = EditTextProductId.getText().toString();
                ArrayList<ProductClass> productList = dbHandler.SearchProduct(pid);
                if (productList.size() != 0) {
                    ProductClass product = productList.get(0);
                    EditProductName.setText(product.getProductName());
                    EditTextPrice.setText((String.valueOf(product.getPrice())));
                    EditTextQuantity.setText((String.valueOf(product.getQuantity())));
                    EditTextCategory.setText(product.getCategoryId());
                    Toast.makeText(getApplicationContext(), "Product found", Toast.LENGTH_LONG).show();


                } else {
                    Toast.makeText(getApplicationContext(), "no Product found", Toast.LENGTH_LONG).show();
                }
            }
        });

        ButtonBuyProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dbHandler.BuyProduct(EditTextInvoiceId.getText().toString(), Integer.parseInt(EditTextBuyQuantity.getText().toString()));

               int Total = Integer.parseInt(EditTextBuyQuantity.getText().toString())* Integer.parseInt(EditTextPrice.getText().toString());

                int qty = Integer.parseInt(EditTextBuyQuantity.getText().toString());

              /* InvoiceClass invoice=new InvoiceClass(EditTextUserId.getText().toString(),EditTextInvoiceId.getText().toString(),
                        EditTextProductId.getText().toString(),qty,Total);
                if(dbHandler.InsertInvoice(invoice))
                {
                    Toast.makeText(getApplicationContext(), "Buy:"+EditTextProductId.getText().toString()+
                            "Total"+Total, Toast.LENGTH_LONG).show();
                }
            }*/


                InvoiceClass invoiceClass = new InvoiceClass(EditTextUserId.getText().toString(), EditTextInvoiceId.getText().toString(), qty);

                if (dbHandler.InsertInvoice(invoiceClass)) {
                    Toast.makeText(getApplicationContext(), "Thank you! For your purchase", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Please try again", Toast.LENGTH_LONG).show();
                }


            }


        });
    }
}