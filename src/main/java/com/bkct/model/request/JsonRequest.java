package com.bkct.model.request;

import java.util.Date;

public class JsonRequest {

    String name;
    double price;
//    Date creatDatetime;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "JsonRequest{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

//    public Date getCreatDatetime() {
//        return creatDatetime;
//    }
//
//    public void setCreatDatetime(Date creatDatetime) {
//        this.creatDatetime = creatDatetime;
//    }
}
