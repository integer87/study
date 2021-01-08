package com.integer87.case3;

/**
 * 양팔저울(Roberval's Balance)
 */
public class RobervalBalance implements Scale {
    private double leftWeight;
    private double rightWeight;

    public RobervalBalance(double leftWeight, double rightWeight) {
        this.leftWeight = leftWeight;
        this.rightWeight = rightWeight;
    }

    @Override
    public double getWeight() {
        return (leftWeight - rightWeight) * -1;
    }

}
