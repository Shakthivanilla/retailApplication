package com.retail.bill.pojo;

import java.time.LocalDate;

/* User class to bill the user for shopping with
* userName, joiningDate and userType
* to calculate the discount
* */
public class User {
    private final String userName;
    private final LocalDate joiningDate;
    private final UserType userType;

    public User(String userName, LocalDate joiningDate, UserType userType) {
        this.userName = userName;
        this.joiningDate = joiningDate;
        this.userType = userType;
    }

    public String getUserName() {
        return userName;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public UserType getUserType() {
        return userType;
    }
}
