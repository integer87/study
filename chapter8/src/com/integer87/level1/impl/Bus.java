package com.integer87.level1.impl;

import com.integer87.level1.Vehicle;

public class Bus implements Vehicle {

    int speed = 5;

    @Override
    public int getSpeed() {
        return this.speed;
    }
}
