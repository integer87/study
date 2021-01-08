package com.integer87.case4;

/**
 * Interface Default Method 예제, JAVA 8
 */
public class TestCase4 {
    public static void main(String[] args) {
        Scale bathroomScale    = new BathroomScale(70);
        Scale robervalBalance1 = new RobervalBalance(60, 70);
        Scale robervalBalance2 = new RobervalBalance(70, 60);

        bathroomScale.printWeight();
        robervalBalance1.printWeight();
        robervalBalance2.printWeight();


    }
}
