package com.integer87;


import com.integer87.level3.Vehicle;
import com.integer87.level3.impl.SM6;

public class Level3Test {
    public static void main(String[] args) {
        Vehicle sm6 = new SM6("0001");


        sm6.printMaker();
        sm6.printName();
        sm6.printModelNumber();

    }
}
