package com.integer87.case2;

/**
 * Interface 상속 예제
 */
public class TestCase2 {
    public static void main(String[] args) {
        Scale bathroomScale   = new BathroomScale(70);
        Scale robervalBalance = new RobervalBalance(60, 70);

        bathroomScale.printWeight();
        robervalBalance.printWeight();
    }
}
