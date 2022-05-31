package com.retail.bill.pojo;

import java.util.List;

public class UserCart {

    private final User user;
    private final List<Item> items;


    public UserCart(User user, List<Item> items) {
        this.user = user;
        this.items = items;
    }

    public User getUser() {
        return user;
    }

    public List<Item> getItems() {
        return items;
    }
}
