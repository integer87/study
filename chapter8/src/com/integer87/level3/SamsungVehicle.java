package com.integer87.level3;

public interface SamsungVehicle extends Vehicle {
    public static final String maker = "삼성";

    default void printMaker(){
        System.out.println("제조사 : " + this.getMaker());
    }

    default void printModelNumber(){
        System.out.println("모델번호 : " + this.getModelNumber());
    }

    default void printName(){
        System.out.println("이름 : " + this.getName());
    }

    // Maker 가져오기
    default String getMaker(){
        return this.maker;
    }

    // Name 가져오기
    public abstract String getName();

    // Model Number 가져오기
    public abstract String getModelNumber();

    // 모델번호 생성
    static String generateModelNumber(String subModelNumber) {
        String newModelNumber = "SAMSUNG-" + subModelNumber;
        return newModelNumber;
    }
}
