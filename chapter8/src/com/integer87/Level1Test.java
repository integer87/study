package com.integer87;

import com.integer87.level1.Vehicle;
import com.integer87.level1.impl.Bus;
import com.integer87.level1.impl.SportsCar;

public class Level1Test {
    public static void main(String[] args) {
        Vehicle sportsCar = new SportsCar();
        Vehicle bus = new Bus();

        System.out.println("sportsCar의 속력은 " + sportsCar.getSpeed() + "km/h 입니다.");
        System.out.println("bus의 속력는 " + sportsCar.getSpeed() + "km/h 입니다.");
    }
}
