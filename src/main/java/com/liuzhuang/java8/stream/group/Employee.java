package com.liuzhuang.java8.stream.group;

/**
 * Created by liuzz on 2017/9/27.
 */
public class Employee {

    private String name;

    private String city;

    private Integer sales;

    public Employee() {

    }

    public Employee(String name, String city, Integer sales) {
        this.name = name;
        this.city = city;
        this.sales = sales;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }
}
