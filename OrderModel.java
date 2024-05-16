package com.example.myapplication50;

public class OrderModel {


    private String UserId;
    private String productId;
    private String productQty;

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

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
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



    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    // constructor
    public OrderModel(
            String UserId,
            String productId,
            String productQty
                        )
    {
        this.UserId = UserId;
        this.productId = productId;
        this.productQty = productQty;

    }


}
