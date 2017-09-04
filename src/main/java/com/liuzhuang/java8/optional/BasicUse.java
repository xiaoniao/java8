package com.liuzhuang.java8.optional;


/**
 * Created by liuzhuang on 2017/9/4.
 */
public class BasicUse {

    public static void main(String[] args) {


    }

    public static String getInsuranceName(Person person) {
        return person.getCar().getInsurance().getName();
    }

    public static String getInsuranceName2(Person person) {
        if (person != null) {
            Car car = person.getCar();
            if (car != null) {
                Insurance insurance = car.getInsurance();
                if (insurance != null) {
                    return insurance.getName();
                }
            }
        }
        return "Unknown";
    }

    public static String getInsuranceName3(Person person) {
        if (person == null) {
            return "Unknown";
        }
        Car car = person.getCar();
        if (car == null) {
            return "Unknown";
        }
        Insurance insurance = car.getInsurance();
        if (insurance == null) {
            return "Unknown";
        }
        return insurance.getName();
    }
}
