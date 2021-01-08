package com.integer87.case4;

public interface Scale extends Pointer {

    default void printWeight(){
        System.out.println("Weight : " + this.getWeight());
    }

    static boolean check(double setValue, double measureValue){
        return measureValue > setValue;
    }

}
