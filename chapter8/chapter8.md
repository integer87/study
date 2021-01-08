# Chapter 8. Interface

### 인터페이스 정의하는 방법
***
`interface` 키워드를 사용하여 정의
```java
public interface Vehicle {
  public abstract int getSpeed();
}
```
* 참고
  * 모든 멤버변수는 public static final 
  * 모든 메소드는 public abstract
  * Java 8부터 default 메소드, static 메소드 사용가능

  
### 인터페이스 구현하는 방법
***
`implements` 키워드를 사용하여 인터페이스 구현
```java
public class SportsCar implements Vehicle{

    int speed = 10;

    @Override
    public int getSpeed() {
        return this.speed;
    }
}
```


### 인터페이스 레퍼런스를 통해 구현체를 사용하는 방법
***

```java
public class Test {
  public static void main(String[] args) {
    Vehicle sportsCar = new SportsCar();
    Vehicle bus = new Bus();
    
    System.out.println("sportsCar의 속력은 " + sportsCar.getSpeed() + "km/h 입니다.");
    System.out.println("bus의 속력는 " + sportsCar.getSpeed() + "km/h 입니다.");
  }
}
```


### 인터페이스 상속
***


### 인터페이스의 기본 메소드 (Default Method), 자바 8
***


### 인터페이스의 static 메소드, 자바 8
***


### 인터페이스의 private 메소드, 자바 9
***
