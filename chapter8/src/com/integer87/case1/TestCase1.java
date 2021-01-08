package com.integer87.case1;

/**
 * Interface를 구현하고 사용하는 예제
 */
public class TestCase1 {
    public static void main(String[] args) {
        Scale bathroomScale   = new BathroomScale(70);
        Scale robervalBalance = new RobervalBalance(60, 70);

        bathroomScale.printWeight();
        robervalBalance.printWeight();
    }
}
