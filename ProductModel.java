package com.example.myapplication50;

public class ProductModel {



    private String productId;
    private String productName;
    private String productPrice;
    private String productQty;
    private String CategoryId;
    private int id;

    // creating getter and setter methods

    public void setProductId(String productId)
    {
        this.productId = productId;
    }

    public String getProductId()
    {
        return productId;
    }

    public void setProductName(String productName)
    {
        this.productName = productName;
    }

    public String getProductName() { return productName; }

    public void setProductPrice(String productPrice)
    {
        this.productPrice = productPrice;
    }

    public String getProductPrice()
    {
        return productPrice;
    }

    public void
    setProductQty(String productQty)
    {
        this.productQty = productQty;
    }

    public String getProductQty()
    {
        return productQty;
    }

    public void
    setCategoryId(String CategoryId)
    {
        this.CategoryId = CategoryId;
    }

    public String getCategoryId()
    {
        return CategoryId;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    // constructor
    public ProductModel(String productId,
                       String productName,
                       String productPrice,
                       String productQty,
                        String CategoryId)
    {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQty = productQty;
        this.CategoryId = CategoryId;
    }


}
