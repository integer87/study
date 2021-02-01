# Week 12. 애노테이션
## 애노테이션 정의하는 방법
***
`metadata`의 한 형태인 `애노테이션`은 프로그램에 대한 데이터를 제공한다.

`애노테이션`은 다음과 같은 용도로 사용되어 진다.
1. 컴파일러를 위한 정보  
   애노테이션을 이용하여 컴파일러에서 오류를 감지하거나, 경고를 억제할 수 있다.
2. 컴파일 또는 배포 시점에 사용  
   애노테이션정보를 이용하여 코드를 생성하거나, XML 파일을 생성하는 등의 행위를 할 수 있다.  
3. 런타임 사용  
   애노테이션 정보를 런타임에서 사용할 수 있다.

`애노테이션`을 정의하는 방법은 다음과 같다.  
`interface` 키워드 앞에 `@`기호를 사용하여 애노테이션을 정의하고, `애노테이션`의 본문에는 `요소`들을 포함할 수 있으며
`default` 키워드를 이용하여 기본값을 지정할 수도 있다.
```java
public class Test {
    @ClassPreamble( author = "홍길동"
                  , date   = "2021-02-01"
                  , member = {"이순신", "장보고"}
                  )
    public static void main(String[] args) {
       System.out.println("애노테이션 정의!!");
    }

    @interface ClassPreamble{
        String group() default "integer87";
        String author(); 
        String date();
        int revision() default 1;
        String[] member();
    }
}
```

## 미리 정의된 애노테이션 세트
***
Java SE API에 `애노테이션 세트`가 미리 정의되어 있으며, 일부 애노테이션은 Java 컴파일러에서 사용되고, 일부는 다른 애노테이션에 적용된다. 
### Java 언어에서 사용되는 주석유형
#### @Deprecated
#### @Override
#### @SuppressWarnings
#### @SafeVarargs
#### @FunctionalInterface

### 다른 애노테이션에 적요되는 애노테이션
####@Retention
####@Documented 
####@Target
####@Inherited 
####@Repeatable

https://docs.oracle.com/javase/tutorial/java/annotations/predefined.html

## @retention
***

## @target
***

## @documented
***

## 애노테이션 프로세서
***