package com.integer87.level1.impl;

import com.integer87.level1.Vehicle;

public class SportsCar implements Vehicle {

    int speed = 10;

    @Override
    public int getSpeed() {
        return this.speed;
    }
}
