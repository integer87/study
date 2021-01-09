# Chapter 8. Interface

### 인터페이스 정의하는 방법
***
`interface` 키워드를 사용하여 정의.

아래는 저울(Scale) 구성요소와 필요기능을 인터페이스로 정의한 예제.   
```java
public interface Scale {
  public static final String madeIn = "KOREA";
  
  public abstract double getMaxGram();        // 저울의 최대 측정가능 무게(gram)
  public abstract double getWeight();         // 저울의 현재 무게(gram)
  public abstract void putOn(double weight);  // 저울에 무게 추가(gram)
  public abstract void print();               // 저울 무게 출력
}
```
* 참고
  * 모든 멤버변수는 `public static final` (생략가능) 
  * 모든 메소드는 `public abstract` (생략가능)
  * Java 8부터 `default 메소드`, `static 메소드` 사용가능

  
### 인터페이스 구현하는 방법
***
`implements` 키워드를 사용하여 인터페이스를 구현

아래는 저울(Scale) 인터페이스를 이용하여 소형저울(SmallScale) 과 대형저울(LargeScale)을 구현한 예제.
```java
/**
 * 소형저울(최대무게 1kg)
 */
public class SmallScale implements Scale {
  private final double maxGram = 1000;   // 1Kg
  private double weight = 0;

  @Override
  public double getMaxGram() {
    return this.maxGram;
  }
  
  @Override
  public double getWeight() {
    return this.weight;
  }
  
  @Override
  public void putOn(double weight) {
    if(weight > maxGram){
      this.weight = maxGram;
    }else {
      this.weight = weight;
    }
  }

  @Override
  public void print() {
    System.out.println("SmallScale Weight : " + weight + "g");
  }
}


/**
 * 대형저울(최대무게 100kg)
 */
public class LargeScale implements Scale {
  private final double maxGram = 100000;    // 100kg
  private double weight = 0;

  @Override
  public double getMaxGram() {
    return this.maxGram;
  }

  @Override
  public double getWeight() {
    return this.weight;
  }

  @Override
  public void putOn(double weight) {
    if(weight > maxGram){
      this.weight = maxGram;
    }else {
      this.weight = weight;
    }
  }

  @Override
  public void print() {
    System.out.println("LargeScale Weight : " + weight + "g");
  }
}
```


### 인터페이스 레퍼런스를 통해 구현체를 사용하는 방법
***
인터페이스로 구현한 구현체를 사용할 때는 구현체를 인터페이스 타입으로 인스턴스화 하여 사용 ?

아래 예제는 소형저울(SmallScale) 과 대형저울(LargeScale)을 각각 저울(Scale) 인터페이스 타입으로 인스턴스화 시켜
사용하는 예제로 동일한 기능인 `putOn`과 `print`를 사용하지만 실제 동작 결과는 각각 구현된 로직에 따라 동작함

```java
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
```
```text
출력결과
SmallScale Weight : 1000.0g
LargeScale Weight : 3000.0g
```


### 인터페이스 상속
***
인터페이스간에 `extends`키워드로 상속이 가능하고, 인터페이스끼리 상속할때는 다중상속도 가능함

아래 기존의 저울(Scale) 인터페이스에, 눈금자(Pointer) 와 출력창(Display)을 상속하고 기존의 인터페이스를 세분화 한 예제  
기존의 `getWeight 메소드` 와 `print 메소드`를 각각 `Pointer`와 `Display`인터페이스로 이동시킴

```java
public interface Pointer {
  public abstract double getWeight();           // 저울의 현재 무게(gram)
}


public interface Display {
  public abstract void print();                 // 저울 무게 출력(gram)
}


public interface Scale extends Pointer, Display {
  public static final String madeIn = "KOREA";

  public abstract double getMaxGram();          // 저울의 최대 측정가능 무게(gram)
  public abstract void putOn(double weight);    // 저울에 무게 추가(gram)
}
```


### 인터페이스의 기본 메소드 (Default Method), 자바 8
***
JAVA 8 부터 인터페이스에 `default 메소드`를 정의할 수 있으며, 해당 메소드는 구현부에서 Override 가능

* Why created ?  
  * 인터페이스에서 기본적으로 제공되어야 하는 단순기능을 제공해 줄 수 있다.
  * 인터페이스에 새로운 기능이 추가됨에 따른 인터페이스를 구현 모든 클래스의 수정을 피할 수 있다.


아래는 출력부부인 `print 메소드`를 default 메소드로 지정하고, 신규 기능인 `Beep 메소드`를 작성한 예제, 저울(Scale) 인터페이스 구현체에서 `print 메소드`에 대해 Override
하지 않았다면 기본제공되는 print 기능을 사용할 것이고, 기존 구현체에 신규 기능인 Beep 메소드 추가하고 Override 하지 않았지만 기능상 문제가 없고, 기본제공된 기능으로 잘 동작 할 것이다.


```java
public interface Scale extends Pointer, Display {
  public static final String madeIn = "KOREA";

  public abstract double getMaxGram();          // 저울의 최대 측정가능 무게(gram)
  public abstract void putOn(double weight);    // 저울에 무게 추가

  @Override
  default void print() {
    System.out.println("Default Scale Print : " + this.getWeight() + "g");
  }

  // 저울의 최대 측정가능 무게를 초과할 경우 경고음 출력
  public default void beep() {
    if(this.getWeight() > this.getMaxGram()){
      System.out.println("Bepp~~Bepp~~Bepp~~Bepp~~");
    }
  }
}
```



### 인터페이스의 static 메소드, 자바 8
***
JAVA 8 부터 인터페이스에 `static 메소드` 를 정의할 수 있다.  
아래는 저울 인터페이스에 무게를 초과하지 않는지 체크하는 기능을 구현한 예제이다.
```java
public interface Scale extends Pointer, Display {
  public static final String madeIn = "KOREA";

  public abstract double getMaxGram();          // 저울의 최대 측정가능 무게(gram)
  public abstract void putOn(double weight);    // 저울에 무게 추가

  @Override
  public default void print() {
    System.out.println("Default Scale Print : " + this.getWeight() + "g");
  }

  // 무게를 초과하지 않는지 체크
  public static boolean checkUnderWeight(double setting, double weight){
    return weight <= setting;
  }

}


public class TestCase4 {
  public static void main(String[] args) {
    System.out.println("100 Under Weight : " + Scale.checkUnderWeight(100, 50));
    System.out.println("100 Under Weight : " + Scale.checkUnderWeight(100, 100));
    System.out.println("100 Under Weight : " + Scale.checkUnderWeight(100, 150));
  }
}

```
```text
100 Under Weight : true
100 Under Weight : true
100 Under Weight : false
```
* 참고
  * 인터페이스에 구현부를 작성 가능
  * Override 불가
  * 클래스명으로 메소드를 호출하여 사용





### 인터페이스의 private 메소드, 자바 9
***
JAVA 9 부터 인터페이스에 private 메소드를 생성할 수 있다.
* Why created ?
  * JAVA 8 부터 `default 메소드`와 `static 메소드`가 사용가능해 지면서 인터페이스에 구현부를 작성할 수 있게 되었지만
    인터페이스 내부 코드가 복잡해지고, 재사용성이 떨어지는 코드가 발생하게 됨
  * private 메소드를 통해서 이런 문제들을 해결 가능함

아래는 무게를 초과하는지 체크하는 `checkUnderWeight` 메소드에 측정결과를 저장하는 메소드를 분리하여 작성한 예제이다  
지금은 로직이 없어서 간단해 보이지만 saveHistory 메소드의 로직이 복잡하다면 첫번째보다 2번째 상황이 간결하고 유지보수가 좋은 코드가 될 것이다.
```java
/**
 * 첫번째(private static 메소드 미사용)
 */
public interface Scale extends Pointer, Display {
  public static final String madeIn = "KOREA";

  public abstract double getMaxGram();          // 저울의 최대 측정가능 무게(gram)
  public abstract void putOn(double weight);    // 저울에 무게 추가

  // 무게를 초과하지 않는지 체크
  public static boolean checkUnderWeight(double setting, double weight){
    boolean result = weight <= setting;
    
    // TODO 측정결과 저장(복잡한 로직들)
    
    return result;
  }
}

/**
 * 두번째(private static 메소드 사용)
 */
public interface Scale extends Pointer, Display {
  public static final String madeIn = "KOREA";

  public abstract double getMaxGram();          // 저울의 최대 측정가능 무게(gram)
  public abstract void putOn(double weight);    // 저울에 무게 추가

  // 무게를 초과하지 않는지 체크
  public static boolean checkUnderWeight(double setting, double weight){
    boolean result = weight <= setting;
    saveHistory(setting, weight, result);
    return result;
  }

  // 측정결과를 저장
  private static void saveHistory(double setting, double weight, boolean result){
    // TODO 측정결과 저장(복잡한 로직들)
  }
}
```
