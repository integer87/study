package com.integer87.case2;

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

    @Override
    public void printWeight() {
        double weightDifference = this.getWeight();

        if(weightDifference == 0){
            System.out.println("Both sides have the same weight.");
        }else if(weightDifference > 0){
            System.out.println("The left side is " + weightDifference + " heavier than the right side.");
        }else {
            System.out.println("The right side is " + weightDifference + " heavier than the left side.");
        }
    }
}
