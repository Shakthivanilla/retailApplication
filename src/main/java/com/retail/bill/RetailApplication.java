package com.retail.bill;

import com.retail.bill.discount.Discount;
import com.retail.bill.pojo.*;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.*;

public class RetailApplication {
    private static final DecimalFormat df = new DecimalFormat("0.00");
    public static void main(String[] args) {
        User user = new User("Sam", LocalDate.of(2020,12,10), UserType.AFFILIATE);
        Item item1 = new Item("MILK", 47.50, ItemType.GROCERIES,10);
        Item item2 = new Item("BULBS", 50, ItemType.ELECTRONICS,25);
        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);

        UserCart userCart = new UserCart(user,items);

        Discount discount = new Discount(userCart);
        df.setRoundingMode(RoundingMode.UP);
        System.out.println(userCart.getUser().getUserName()+" Your total Bill: $"+df.format(discount.calculateDiscount()));


    }
}
