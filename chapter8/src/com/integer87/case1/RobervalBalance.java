package com.integer87.case1;

/**
 * 양팔저울(Roberval's Balance)
 */
public class RobervalBalance implements Scale{
    double leftWeight;
    double rightWeight;

    public RobervalBalance(double leftWeight, double rightWeight) {
        this.leftWeight = leftWeight;
        this.rightWeight = rightWeight;
    }

    @Override
    public void printWeight() {
        if(leftWeight == rightWeight){
            System.out.println("Both sides have the same weight.");
        }else if(leftWeight > rightWeight) {
            System.out.println("The left side is heavier than the right side.");
        }else {
            System.out.println("The right side is heavier than the left side.");
        }
    }
}
