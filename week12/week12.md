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
java.lang 과 java.lang.annotation에 각각 정의되어 있다.
### Java 언어에서 사용되는 주석유형
#### @Deprecated
```java
/**
 * 해당 애노테이션이 표시된 요소는 더이상 사용되지 않는것을 나타낸다.
 * 컴파일러는 프로그램에서 해당 메서드, 클래스 또는 필드를 사용할 때마다 경고를 표시한다.
 * 요소가 더 이상 사용됮 않는다고 @Deprecated 애노테이션을 사용한 경우 다음 예외 같이 Javadoc 태그를 사용하여 문서화 해야한다.
 * 
 *   @deprecated 
 *   deprecated 이유 설명
 *   
 *   ※ Javadoc 의 태그는 소문자 d로 시작하고 애노테이션은 대문자 D로 시작하는것에 유의
 *   
 * @since 1.5
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(value={CONSTRUCTOR, FIELD, LOCAL_VARIABLE, METHOD, PACKAGE, PARAMETER, TYPE})
public @interface Deprecated {}
```

#### @Override
```java
/**
 * 해당 애노테이션이 표시된 요소는 요소가 수퍼 클래스에 선언 된 요소를 재정의한다는 것을 컴파일러에 알린다.
 * 매서드를 재정의 할 떼 필수로 이 애노테이션을 사용할 필요는 없지만 오류를 방지하는 데 도움이 된다.
 * 만약 매서드를 올바르게 재정의하지 못하면 컴파일러에서 오류가 발생한다.
 * 
 * @since 1.5
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)
public @interface Override {}
```

#### @SuppressWarnings
```java
/**
 * 해당 애노테이션은 특정 경고를 표시하지 않도록 한다.
 * 
 * @since 1.5
 */
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
@Retention(RetentionPolicy.SOURCE)
public @interface SuppressWarnings {
    String[] value();
}
```

#### @SafeVarargs
```java
/**
 * 해당 애노테이션은 가변인수 메서드에 대해서 메서드 작성자가 가변인수에 대해서 타입 안전함을 보장한다는것을 표시한다.
 * 
 * @since 1.7
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD})
public @interface SafeVarargs {}
```

#### @FunctionalInterface
```java
/**
 * 해당 애노테이션이 사용된 요소는 Functional Interface임을 나타낸다.
 * ※ Functional Interface : 구현해야할 추상 메서드가 하나만 정의된 인터페이스
 * 
 * @since 1.8
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface FunctionalInterface {}
```

### 다른 애노테이션에 적용되는 애노테이션(meta-annotation)
####@Retention
```java
/**
 * 해당 메타 애노테이션은 애노테이션이 저장되는 방법을 지정한다.
 *  - RetentionPolicy.SOURCE : 소스레벨에서만 유지되며, 컴파일러에서 무시된다.
 *  - RetentionPolicy.CLASS : 컴파일 시간에는 유지되지만 JVM 에서는 무시된다.
 *  - RetentionPolicy.RUNTIME : JVM 에서 유지되므로, 런타임 환경에서 사용할 수 있다.
 *  
 * @since 1.5
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface Retention {
    RetentionPolicy value();
}
```

####@Documented
```java
/**
 * 해당 메타 애노테이션이 표시된 애노테이션은 Javadoc 도구을 사용하여 문서화 되어야 함을 나타낸다.
 * 기본적으로 애노테이션은 Javadoc에 포함되지 않는다.
 * 
 * @since 1.5
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface Documented {}
```

####@Target
```java
/**
 * 해당 메타 애노테이션은 애노테이션이 적용될 수 있는 JAVA 요소를 제한하기 위해 사용한다.
 *  - ElementType.ANNOTATION_TYPE : 애노테이션 유형에 적용 할 수 있다.
 *  - ElementType.CONSTRUCTOR : 생성자에 적용 할 수 있다.
 *  - ElementType.FIELD : 필드 또는 속성에 적용 할 수 있다.
 *  - ElementType.LOCAL_VARIABLE : 지역 변수에 적용 할 수 있다.
 *  - ElementType.METHOD : 메서드 수준 주석에 적용 할 수 있다.
 *  - ElementType.PACKAGE : 패키지 선언에 적용 할 수 있다.
 *  - ElementType.PARAMETER : 메소드의 매개 변수에 적용 할 수 있다.
 *  - ElementType.TYPE : 클래스의 모든 요소에 적용 할 수 있다.
 * 
 * @since 1.5
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface Target {
    ElementType[] value();
}
```

####@Inherited
```java
/**
 * 해당 메타 애노테이션은 애노테이션을 적용한 클랙스가 상속될때 서브 클래스에서도 해당 애노테이션을 갖도록 한다.
 * 
 * @since 1.5
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface Inherited {}
```

####@Repeatable
```java
/**
 * 해당 메타애노테이션은 애노테이션이 지정한 요소에 두번이상 적용될 수 있음을 나타낸다.
 * 
 * @since 1.8
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface Repeatable {
    Class<? extends Annotation> value();
}
```

## 애노테이션 프로세서
***
애노테이션 프로세서는 자바 컴파일러 플러그인의 일종으로 애노테이션에 대한 코드를 검사, 수정, 생성하는 역할을 가지는 플러그인을 말한다.  
자주시용되는 Lombok 또한 이 애노테이션 프로세서를 이용한 API 이다

javax.annotation.processing.AbstractProcessor 를 상속 받아서 커스텀 애노테이션 프로세서를 만들 수 있다.


### 애노테이션 프로세서 만들기
1. 어노테이션 클래스를 생성한다.
2. 어노테이션 파서 클래스를 생성한다.
3. 어노테이션을 사용한다.
4. 컴파일하면, 어노테이션 파서가 어노테이션을 처리한다.
5. 자동 생성된 클래스가 빌드 폴더에 추가된다.






## TODO
***
- safevarargs 관련해서 추가로 확인필요  
  참고 : https://jaehun2841.github.io/2019/01/28/effective-java-item32/#safevarargs
  
- Lombok 추가 확인
- 애노테이션 프로세서 공부
- 애노테이션 프로세서 샘플 만들기

## 참고
***
- https://docs.oracle.com/javase/tutorial/java/annotations/predefined.html 
- https://andole98.github.io/java/java-annotation-process/#
- https://free-strings.blogspot.com/2015/12/lombok.html