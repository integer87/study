package com.integer87.case3;

public interface Scale extends Pointer {

    default void printWeight(){
        System.out.println("Weight : " + this.getWeight());
    }

}
