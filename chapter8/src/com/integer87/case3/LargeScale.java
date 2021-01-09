package com.integer87.case3;

/**
 * 대형저울(최대무게 100kg)
 */
public class LargeScale implements Scale {
    private final double maxGram = 100000;    // 100kg
    private double weight = 0;

    @Override
    public double getMaxGram() {
        return this.maxGram;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public void putOn(double weight) {
        this.beep(weight);

        if(weight > maxGram){
            this.weight = maxGram;
        }else {
            this.weight = weight;
        }
    }

    @Override
    public void print() {
        System.out.println("LargeScale Weight : " + weight + "g");
    }
}
