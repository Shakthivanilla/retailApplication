package com.retail.bill.pojo;

/*
* To store product information for the billing
* */
public class Item {
    private final String name;
    private final double unitPrice;
    private final ItemType itemType;
    private final int quantities;


    public Item(String name, double unitPrice, ItemType itemType, int quantities) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.itemType = itemType;
        this.quantities = quantities;
    }

    public String getName() {
        return name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public int getQuantities() {
        return quantities;
    }
}
