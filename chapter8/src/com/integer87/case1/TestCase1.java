package com.integer87.case1;

/**
 * Interface를 구현하고 사용하는 예제
 */
public class TestCase1 {
    public static void main(String[] args) {
        Scale smallScale = new SmallScale();
        Scale largeScale = new LargeScale();

        smallScale.putOn(3000);
        largeScale.putOn(3000);

        smallScale.print();
        largeScale.print();
    }
}
