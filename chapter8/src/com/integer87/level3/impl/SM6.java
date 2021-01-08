package com.integer87.level3.impl;

import com.integer87.level3.SamsungVehicle;

public class SM6 implements SamsungVehicle {
    private static final String name = "SM6";
    private String modelNumber;

    public SM6(String modelNumber) {
        this.modelNumber = generateModelNumber(modelNumber);
    }

    @Override
    public String getModelNumber() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }
}
