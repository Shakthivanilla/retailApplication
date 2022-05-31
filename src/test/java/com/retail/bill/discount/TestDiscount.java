package com.retail.bill.discount;

import com.retail.bill.RetailApplication;
import com.retail.bill.pojo.*;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestDiscount {

    UserCart userCart;
    Discount discount;
    List<Item> items;


    @Before
    public void setUp(){
        Item item1 = new Item("MILK", 47.50, ItemType.GROCERIES,10);
        Item item2 = new Item("BULBS", 50, ItemType.ELECTRONICS,25);
        items = new ArrayList<>();
        items.add(item1);
        items.add(item2);

    }

    @Test
    public void testCoverageMainMethod(){
        RetailApplication.main(new String[] {"arg1", "arg2", "arg3"});
    }

    @Test
    public void test_AffiliateCustomer(){
        User user = new User("Sam", LocalDate.of(2018,12,10), UserType.AFFILIATE);
        userCart = new UserCart(user,items);

        discount = new Discount(userCart);
        assertEquals(1600.00,discount.calculateDiscount(), 0.01);

    }

    @Test
    public void test_EmployeeCustomer(){
        User user = new User("Sam", LocalDate.of(2018,12,10), UserType.EMPLOYEE);
        userCart = new UserCart(user,items);

        discount = new Discount(userCart);
        assertEquals(1350.00,discount.calculateDiscount(), 0.01);

    }

    @Test
    public void test_NormalCustomerMoreThan2YearsOld(){
        User user = new User("Sam", LocalDate.of(2018,12,10), UserType.NORMAL);
        userCart = new UserCart(user,items);

        discount = new Discount(userCart);
        assertEquals(1662.50,discount.calculateDiscount(), 0.01);

    }

    @Test
    public void test_NormalCustomerEqualTo2YearsOldPriceGreaterThan100(){
        User user = new User("Sam", LocalDate.of(2020,12,10), UserType.NORMAL);
        userCart = new UserCart(user,items);

        discount = new Discount(userCart);
        assertEquals(1638.75,discount.calculateDiscount(), 0.01);

    }

    @Test
    public void test_NormalCustomerEqualTo2YearsOldPriceLessThan100(){
        User user = new User("Sam", LocalDate.of(2020,12,10), UserType.NORMAL);

        Item item1 = new Item("MILK", 10, ItemType.GROCERIES,1);
        Item item2 = new Item("BULBS", 10, ItemType.ELECTRONICS,1);
        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        userCart = new UserCart(user,items);
        discount = new Discount(userCart);
        assertEquals(20,discount.calculateDiscount(), 0.01);

    }

    @Test
    public void test_NullTo2YearsOldPriceLessThan100(){
        User user = new User("Sam", LocalDate.of(2020,12,10), null);

        Item item1 = new Item("MILK", 10, ItemType.GROCERIES,1);
        Item item2 = new Item("BULBS", 10, ItemType.ELECTRONICS,1);
        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        userCart = new UserCart(user,items);
        discount = new Discount(userCart);
        assertEquals(0.00,discount.calculateDiscount(), 0.01);

    }

    @Test
    public void test_Default2YearsOldPriceLessThan100(){
        User user = new User("Sam", LocalDate.of(2020,12,10), UserType.UNDEFINED);

        Item item1 = new Item("MILK", 10, ItemType.GROCERIES,1);
        Item item2 = new Item("BULBS", 10, ItemType.ELECTRONICS,1);
        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        userCart = new UserCart(user,items);
        discount = new Discount(userCart);
        assertEquals(0.00,discount.calculateDiscount(), 0.01);

    }

}
