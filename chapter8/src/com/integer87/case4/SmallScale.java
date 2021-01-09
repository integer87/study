package com.integer87.case4;

/**
 * 소형저울(최대무게 1kg)
 */
public class SmallScale implements Scale {
    private final double maxGram = 1000;   // 1Kg
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
}
