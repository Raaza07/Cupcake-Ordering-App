package com.example.myapplication50;

public class Order {

    private String OrderUserId;
    private String OrderProduct_id;
    private String OrderProduct_qty;



    public String getOrderUserId() {
        return OrderUserId;
    }

    public void setOrderUserId(String orderUserId) {
        OrderUserId = orderUserId;
    }

    public String getOrderProduct_id() {
        return OrderProduct_id;
    }

    public void setOrderProduct_id(String orderProduct_id) {
        OrderProduct_id = orderProduct_id;
    }

    public String getOrderProduct_qty() {
        return OrderProduct_qty;
    }

    public void setOrderProduct_qty(String orderProduct_qty) {
        OrderProduct_qty = orderProduct_qty;
    }
}
