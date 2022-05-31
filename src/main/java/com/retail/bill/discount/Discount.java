package com.retail.bill.discount;

import com.retail.bill.pojo.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class Discount {

    private final UserCart userCart;

    public Discount(UserCart userCart) {
        this.userCart = userCart;
    }


    public double calculateDiscount() {
        double discountPrice = 0;
        if (null != userCart && null != userCart.getUser() && null != userCart.getUser().getUserType()) {
            switch (userCart.getUser().getUserType()) {
                case EMPLOYEE: {
                    //apply 30 percent discount for employee
                    discountPrice = 0.3;
                    return calculatePrice(userCart, discountPrice);
                }
                case AFFILIATE: {
                    //apply 10 percent discount for affiliate
                    discountPrice = 0.1;
                    return calculatePrice(userCart, discountPrice);
                }
                case NORMAL: {
                    //apply 5 percent discount for normal customer greater than and equal to 2 years
                    if (ChronoUnit.YEARS.between(userCart.getUser().getJoiningDate(), LocalDate.now()) >= 2) {
                        discountPrice = 0.05;
                        return calculatePrice(userCart, discountPrice);
                    } else {
                        //apply $5 discount for every $100 if there is not falling under Employee, Affiliate, Normal
                        double price = calculatePrice(userCart, discountPrice);
                        if (price >= 100) {
                            price -= ((price / 100) * 5);
                            return price;
                        } else {
                            //if bill is less than $100 do not apply discount
                            return price;
                        }
                    }
                }
                default: {
                    return discountPrice;
                }

            }
        }
        return discountPrice;
    }


    public double calculatePrice(UserCart cart, double discountPrice){
        double price = 0.0;

        for(Item item: cart.getItems()){
            //if it is percentage based; apply discount except for groceries
            if(!item.getItemType().equals(ItemType.GROCERIES) && (discountPrice != 0.0)){
                double itemPrice = (item.getUnitPrice() * item.getQuantities());
                itemPrice -= (itemPrice * discountPrice);
                price += itemPrice;
            }
            //if there is no discount percentage; calculate asis
            else{
                price += item.getUnitPrice() * item.getQuantities();
                }
        }

        return price;
    }

}
