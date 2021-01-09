package com.integer87.case4;

public interface Scale extends Pointer, Display {
    public static final String madeIn = "KOREA";

    public abstract double getMaxGram();          // 저울의 최대 측정가능 무게(gram)
    public abstract void putOn(double weight);    // 저울에 무게 추가

    @Override
    public default void print() {
        System.out.println("Default Scale Print : " + this.getWeight() + "g");
    }

    // 저울의 최대 측정가능 무게를 초과할 경우 경고음 출력
    public default void beep(double weight) {
        if(weight > this.getMaxGram()){
            System.out.println("Bepp~~Bepp~~Bepp~~Bepp~~");
        }
    }

    // 무게를 초과하지 않는지 체크
    public static boolean checkUnderWeight(double setting, double weight){
        return weight <= setting;
    }

}
