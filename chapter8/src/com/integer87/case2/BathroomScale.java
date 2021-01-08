package com.integer87.case2;

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

    @Override
    public void printWeight() {
        System.out.println("Weight : " + this.getWeight());
    }
}
