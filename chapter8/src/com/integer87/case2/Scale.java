package com.integer87.case2;

public interface Scale extends Pointer, Display{
    public static final String madeIn = "KOREA";

    public abstract double getMaxGram();          // 저울의 최대 측정가능 무게(gram)
    public abstract void putOn(double weight);    // 저울에 무게 추가
}
