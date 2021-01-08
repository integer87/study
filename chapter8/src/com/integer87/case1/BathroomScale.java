package com.integer87.case1;

/**
 * 욕실저울(Bathroom Scale)
 */
public class BathroomScale implements Scale{
    double weight;

    public BathroomScale(double weight) {
        this.weight = weight;
    }

    @Override
    public void printWeight() {
        System.out.println("Weight : " + weight);
    }
}
