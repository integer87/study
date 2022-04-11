# Chapter 1. JVM은 무엇이며 자바 코드는 어떻게 실행하는 것인가.

##JVM이란 무엇인가
### JVM(Java Virtual Machine)
>JVM은 자바가상머신(Java Virtual Machine)의 줄임말로 JVM이 설치된 OS가 컴파일된 Java Byte Code를 
기계어로 변환 시켜주는 징검다리 역활을 한다.   
**이 때문에 OS에 맞는 JVM이 설치되어 있다면 어는 OS에서라도, 어느 기기에서라도 코드를 실행 할 수 있다.**

<div align="center">   

![img_1.png](img_1.png)   
<그림> Java VM을 통해 동일한 애플리케이션을 여러 플랫폼에서 실행할 수 있다.

</div>
 
 


* Java 플랫폼용 가상머신
* Java 바이트코드를 해석하고 실행
* JVM은 구성은 다음과 같다
    * 클래스 로더 (Class Loader)
    * 실행엔진 (Execution Engine)
        * 인터프리터(Interpreter)
        * JIT 컴파일러(Just-In-Time Compiler)
        * 가비지 콜렉터(Garbage Collector)
    * 런타임 데이터 영역 (Runtime Data Area)
***

##컴파일 하는 방법 & 실행하는 방법
### 1. java 파일 생성
```java
class HelloWorldApp {
    public static void main(String[] args) {
        System.out.println("Hello World !!!");
    }
}
```
### 2. java 컴파일러를 이용하여 컴파일
```bash
> javac HelloWorldApp.java 
```

### 3. 생성된 class 파일 실행
```bash
> java HelloWorldApp 
```
```bash
실행결과
Hello World !!! 
```
***

##바이트코드란 무엇인가
> 특정 하드웨어가 아닌 가상 컴퓨터에서 돌아가는 실행 프로그램을 위한 이진 표현법으로 즉, Java에서의 바이트 코드는
JVM에서 돌아가는 실행 프로그램을 의미한다.


### 바이트코드 보는법






***
##JIT 컴파일러란 무엇이며 어떻게 동작하는지
***
##JVM 구성 요소
***
##JDK와 JRE의 차이
