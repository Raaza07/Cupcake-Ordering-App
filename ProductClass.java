package com.example.myapplication50;

public class ProductClass {


    private String ProductId;
    private String ProductName;
    private String CategoryId;
    private int Price;
    private int Quantity;

    public ProductClass(){}

    public ProductClass(String productId, String productName, int price , int quantity,String categoryId) {
        ProductId = productId;
        ProductName = productName;
        Price = price;
        Quantity = quantity;
        CategoryId = categoryId;
    }

    public String getProductId() {
        return ProductId;
    }

    public void setProductId(String productId) {
        ProductId = productId;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(String categoryId) {
        CategoryId = categoryId;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }


}
