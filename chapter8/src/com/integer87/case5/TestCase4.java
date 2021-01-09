package com.integer87.case5;

/**
 * Interface를 구현하고 사용하는 예제
 */
public class TestCase4 {
    public static void main(String[] args) {
        System.out.println("100 Under Weight : " + Scale.checkUnderWeight(100, 50));
        System.out.println("100 Under Weight : " + Scale.checkUnderWeight(100, 100));
        System.out.println("100 Under Weight : " + Scale.checkUnderWeight(100, 150));
    }
}
