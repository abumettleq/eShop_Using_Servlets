package com.example.demo;

public class itemCreator {
    private String item_name;
    private int item_amount, item_price;

    public itemCreator()
    {
        item_name = "";
        item_amount = 0;
        item_price = 0;
    }

    public void setItem_amount(int amount) {
        this.item_amount = amount;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public void setItem_price(int price) {
        this.item_price = this.item_amount * price;
    }

    public int getItem_amount() {
        return item_amount;
    }

    public String getItem_name() {
        return item_name;
    }

    public int getItem_price() {
        return item_price;
    }
}
