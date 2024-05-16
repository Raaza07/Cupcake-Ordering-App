package com.example.myapplication50;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Vector;

public class DBHandler extends SQLiteOpenHelper {

    // creating a constant variables for our database.
    // below variable is for our database name.
    private static final String DB_NAME = "CakeApp";
    // below int is our database version
    private static final int DB_VERSION = 1;

    // below variable is for our table name.
    private static final String Register_Table = "Reg_table";
    private static final String Product_Table = "product_table";
    private static final String Category_Table = "Category_table";
    private static final String Order_Table = "Order_table";
    private static final String Invoice_Table = "Invoice_table";



    // below variable is for Register Table  column.
    private static final String Register_Id = "R_Id";
    private static final String Register_Password = "R_Password";
    private static final String Register_User = "R_User";

    // below variable is for Product Table  column.
    private static final String Product_Id = "P_Id";
    private static final String Product_Name = "P_Name";
    private static final String Product_price = "P_Price";
    private static final String Product_qty = "P_Qty";
    private static final String category_name = "P_Cat_Name";

    // below variable is for Product Table  column.

    private static final String Category_Id = "C_Id";
    private static final String Category_Name = "C_Name";

    // below variable is for Order Table  column.

    private static final String user_id = "User_Id";
    private static final String product_id = "product_id";
    private static final String product_qty = "product_qty";

    // below variable is for invoice Table  column.

    private static final String I_user_id = "User_Id";
    private static final String I_product_id = "product_id";
    private static final String I_product_qty = "product_qty";
    private static final String I_product_qty_Total = "pro_qty_total";
    private Context con;


    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // on below line we are creating
        // an sqlite query and we are
        // setting our column names
        // along with their data types.


        String query = "CREATE TABLE " + Register_Table + " ("
                + Register_Id + " INTEGER PRIMARY KEY, "
                + Register_Password + " TEXT,"
                + Register_User + " TEXT)";

        String query01 = "CREATE TABLE " + Product_Table + " ("
                + Product_Id + " INTEGER PRIMARY KEY, "
                + Product_Name + " TEXT,"
                + Product_price + " TEXT,"
                + Product_qty + " INTEGER,"
                + category_name + " TEXT)";


        String query02 = "CREATE TABLE " + Category_Table + " ("
                + Category_Id + " INTEGER PRIMARY KEY, "
                + Category_Name + " TEXT)";


        String query03 = "CREATE TABLE " + Order_Table + " ("
                + user_id + " INTEGER PRIMARY KEY, "
                + product_id + " TEXT , "
                + product_qty + " TEXT)";

        String query04 = "CREATE TABLE " + Invoice_Table + " ("
                + I_user_id + " INTEGER PRIMARY KEY, "
                + I_product_id + " TEXT , "
                + I_product_qty + " TEXT , "
                + I_product_qty_Total + " TEXT)";

        // at last we are calling a exec sql




        // method to execute above sql query
        db.execSQL(query);
        db.execSQL(query01);
        db.execSQL(query02);
        db.execSQL(query03);
        db.execSQL(query04);




    }

    public void addNewUser(String userId, String user_password, String userType) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(Register_Id, userId);
        values.put(Register_Password, user_password);
        values.put(Register_User, userType);


        // after adding all values we are passing
        // content values to our table.
        db.insert(Register_Table, null, values);

        // at last we are closing our
        // database after adding database.



    }

    public ArrayList<UserClass> ValidLogin(String UserName, String Password)//U001 111
    {

        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<UserClass> userList=new ArrayList<UserClass>();
        try
        {
            Cursor cursor=db.rawQuery("select * from Reg_table where R_Id='"+UserName+"'and R_Password='"+Password+"'",null);
            if(cursor.moveToFirst())//T
            {
                do{
                    UserClass user=new UserClass();
                    user.setUserId(cursor.getString(0));//U001
                    user.setPassword(cursor.getString(1));//111
                    user.setUserType(cursor.getString(2));//Admin
                    userList.add(user);

                }while (cursor.moveToNext());//F
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return  userList;
    }

    public String getCategory_Id(String CategoryName)//Books
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String CategoryId=null;
        try
        {
            Cursor cursor=db.rawQuery("Select C_Id from Category_table where C_Name='"+CategoryName+"'",null);
            if(cursor.moveToFirst())
            {
                CategoryId=cursor.getString(0);//C001
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return CategoryId;
    }



    public Vector<String> getCategory_Name()
    {
        SQLiteDatabase db = this.getReadableDatabase();

        Vector<String> vecCategory =new Vector<String>();
        try{
            Cursor cursor=db.rawQuery("Select C_Name from Category_table",null);
            if(cursor.moveToFirst())//T
            {
                do{
                    vecCategory.add(cursor.getString(0));//books pen flowers

                }while (cursor.moveToNext());
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return vecCategory;
    }


    //addNewCourse
    public void addNewProduct(String p_id, String p_name,String p_price,String p_qty,String cat_name){

        SQLiteDatabase db = this.getWritableDatabase();


        ContentValues values = new ContentValues();


        values.put(Product_Id, p_id);
        values.put(Product_Name, p_name);
        values.put(Product_price, p_price);
        values.put(Product_qty, p_qty);
        values.put(category_name, cat_name);


        db.insert(Product_Table, null, values);


    }



    public void addnewcat(String id, String name) {

        SQLiteDatabase db = this.getWritableDatabase();


        ContentValues values = new ContentValues();


        values.put(Category_Id, id);
        values.put(Category_Name, name);


        db.insert(Category_Table, null, values);

    }

    public ArrayList<ProductModel> readProduct() {

        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to
        // read data from database.
        Cursor cursorProducts
                = db.rawQuery("SELECT * FROM " + Product_Table, null);

        // on below line we are creating a new array list.
        ArrayList<ProductModel> ProductModalArrayList
                = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorProducts.moveToFirst()) {
            do {
                // on below line we are adding the data from
                // cursor to our array list.
                ProductModalArrayList.add(new ProductModel(
                        cursorProducts.getString(0),
                        cursorProducts.getString(1),
                        cursorProducts.getString(2),
                        cursorProducts.getString(3),
                        cursorProducts.getString(4)));
            } while (cursorProducts.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorProducts.close();
        return ProductModalArrayList;


    }

    public void updateProduct(String originalProductId, String U_product_id,String U_product_Name, String U_product_Price,
                             String U_product_Qty, String U_product_Cat_iD) {

        // calling a method to get writable database.
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(Product_Id, U_product_id);
        values.put(Product_Name, U_product_Name);
        values.put(Product_price, U_product_Price);
        values.put(Product_qty, U_product_Qty);
        values.put(category_name, U_product_Cat_iD);

        // on below line we are calling a update method to update our database and passing our values.
        // and we are comparing it with name of our course which is stored in original name variable.
        db.update(Product_Table, values, "P_Id=?", new String[]{originalProductId});
        db.close();
    }

    public void updateOrder(String original_user_id, String User_id, String Product_id, String Product_qty) {

        // calling a method to get writable database.
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(user_id, User_id);
        values.put(product_id, Product_id);
        values.put(product_qty, Product_qty);



        // on below line we are calling a update method to update our database and passing our values.
        // and we are comparing it with name of our course which is stored in original name variable.
        db.update(Order_Table, values, "User_Id=?", new String[]{original_user_id});
        db.close();
    }



    // below is the method for deleting our Product.
    public void deleteProduct(String original_product_id) {

        // on below line we are creating
        // a variable to write our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are calling a method to delete our
        // Product and we are comparing it with our course name.
        db.delete(Product_Table, "P_Id=?", new String[]{original_product_id});
        db.close();
    }
    public void deleteOrder(String Original_User_id) {

        // on below line we are creating
        // a variable to write our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are calling a method to delete our
        // Product and we are comparing it with our course name.
        db.delete(Order_Table, "User_Id=?", new String[]{Original_User_id});
        db.close();


    }






    public ArrayList<ProductClass> SearchProduct(String ProductID)
    {
        SQLiteDatabase db = this.getReadableDatabase();


        ArrayList<ProductClass> productList = new ArrayList<ProductClass>();
        try {
            Cursor cursor = db.rawQuery("Select * from product_table where P_Id='" + ProductID + "' ", null);
            if (cursor.moveToFirst()) {
                do {
                    ProductClass product = new ProductClass();
                    product.setProductId(cursor.getString(0));
                    product.setProductName(cursor.getString(1));
                    product.setPrice(cursor.getInt(2));
                    product.setQuantity(cursor.getInt(3));
                    product.setCategoryId(cursor.getString(4));
                    productList.add(product);

                } while (cursor.moveToNext());
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return productList;
    }


    public void addNewOrder(String u_id, String p_id, String p_qty) {

        SQLiteDatabase db = this.getWritableDatabase();


        ContentValues values = new ContentValues();


        values.put(user_id, u_id);
        values.put(product_id, p_id);
        values.put(product_qty, p_qty);



        db.insert(Order_Table, null, values);

    }

    public ArrayList<OrderModel> readOrder() {

        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to
        // read data from database.
        Cursor cursorOrders
                = db.rawQuery("SELECT * FROM " + Order_Table, null);

        // on below line we are creating a new array list.
        ArrayList<OrderModel> orderModelArrayList
                = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorOrders.moveToFirst()) {
            do {
                // on below line we are adding the data from
                // cursor to our array list.
                orderModelArrayList.add(new OrderModel(
                        cursorOrders.getString(0),
                        cursorOrders.getString(1),
                        cursorOrders.getString(2)));
            } while (cursorOrders.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorOrders.close();
        return orderModelArrayList;



    }

    public void BuyProduct(String Product_ID, int Qty) {

        SQLiteDatabase db = this.getWritableDatabase();


        try {
            db.execSQL("update product_table set P_Qty=P_Qty-" + Qty + " where P_Id= '" + Product_ID + "' ");
            Toast.makeText(con, "Thank you For Purchase", Toast.LENGTH_SHORT).show();
        } catch (Exception ex) {
            //Toast.makeText(con, "Try again" + ex.getMessage(), Toast.LENGTH_LONG).show();
        }

    }

 /*   public void BuyProduct(String Product_Id, int Qty) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();


        int  product_l_id= Integer.parseInt(Product_qty);
        int product_less=product_l_id-Qty;

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(Product_qty, product_less);



        // on below line we are calling a update method to update our database and passing our values.
        // and we are comparing it with name of our course which is stored in original name variable.
        db.update(Product_Table, values, "P_Id=?", new String[]{Product_Id});
        db.close();




/*
        try
        {
            db.execSQL("update product_table set P_Qty=P_Qty-"+
                    Qty+" where P_Id= '"+Product_Id+"'");
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }*/



    public boolean InsertInvoice(InvoiceClass invoice) {


        try {

            SQLiteDatabase db = this.getWritableDatabase();


            ContentValues values = new ContentValues();


            values.put(I_user_id, invoice.getUserid());
            values.put(I_product_id, invoice.getProductId());
            values.put(I_product_qty, invoice.getQty());
            values.put(I_product_qty_Total, invoice.getTotal());


            db.insert(Invoice_Table, null, values);

            return true;
        }  catch (Exception ex)
        {
            ex.printStackTrace();
            return false;
        }

/*


            db.execSQL("insert into Invoice_table values('"+ invoice.getUserid()+"','"+ invoice.getProductId()+"',"+ invoice.getQty()+","+ invoice.getTotal()+")");

            return true;
        }

        */


    }

    public ArrayList<Order> SearchOrder(String Oid) {

        SQLiteDatabase db = this.getReadableDatabase();


        ArrayList<Order> OrderList = new ArrayList<Order>();
        try {
            Cursor cursor = db.rawQuery("Select * from Order_table where product_id='" + Oid + "' ", null);
            if (cursor.moveToFirst()) {
                do {
                    Order order = new Order();
                    order.setOrderProduct_id(cursor.getString(1));
                    order.setOrderUserId(cursor.getString(0));
                    order.setOrderProduct_qty(cursor.getString(2));
                    OrderList.add(order);

                } while (cursor.moveToNext());
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return OrderList;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Register_Table);
        db.execSQL("DROP TABLE IF EXISTS " + Product_Table);
        db.execSQL("DROP TABLE IF EXISTS " + Category_Table);
        db.execSQL("DROP TABLE IF EXISTS " + Order_Table);
        onCreate(db);
    }



}
