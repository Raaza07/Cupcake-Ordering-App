package com.example.myapplication50;


public class InvoiceClass {
    private String Userid;
    private String InvoiceId;

    private String ProductId;

    private  int Qty;

    private int Total;

    public String getUserid() {
        return Userid;
    }

    public void setUserid(String userid) {
        Userid = userid;
    }

    public InvoiceClass(String userid, String invoiceId, int qty) {
        Userid = userid;
        InvoiceId = invoiceId;

        Qty = qty;
        //Total = total;
    }

    public String getInvoiceId() {
        return InvoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        InvoiceId = invoiceId;
    }

    public String getProductId() {
        return ProductId;
    }

    public void setProductId(String productId) {
        ProductId = productId;
    }

    public int getQty() {
        return Qty;
    }

    public void setQty(int qty) {
        Qty = qty;
    }

    public int getTotal() {
        return Total;
    }

    public void setTotal(int total) {
        Total = total;
    }
}
