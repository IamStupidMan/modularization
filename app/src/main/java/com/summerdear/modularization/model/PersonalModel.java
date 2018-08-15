package com.summerdear.modularization.model;

import java.io.Serializable;

/**
 * Created by SummerDear on 2018/7/31.
 */

public class PersonalModel implements Serializable {

    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;

    }


}
