package com.integer87.case1;

public interface Scale {
    public static final String madeIn = "KOREA";

    public abstract double getMaxGram();          // 저울의 최대 측정가능 무게(gram)
    public abstract double getWeight();           // 저울의 현재 무게
    public abstract void putOn(double weight);    // 저울에 무게 추가
    public abstract void print();                 // 저울 무게 출력
}
