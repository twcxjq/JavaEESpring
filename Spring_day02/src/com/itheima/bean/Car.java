package com.itheima.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by tcj on 2019/6/7.
 */

@Component("car")
public class Car {

    @Value("aodi")
    private String name;
    @Value("red")
    private String color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" + "name='" + name + '\'' + ", color='" + color + '\'' + '}';
    }
}
