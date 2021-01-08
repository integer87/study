package com.integer87.case3;

/**
 * 욕실저울(Bathroom Scale)
 */
public class BathroomScale implements Scale {
    private double weight;

    public BathroomScale(double weight) {
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

}
