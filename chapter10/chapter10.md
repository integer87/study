# Chapter 10. 멀티쓰레드 프로그래밍
## Thread 클래스와 Runnable 인터페이스
***
자바에서 새 실행 쓰레드를 만드는 방법에는 두가지가 있다.
1. `Thread`를 상속 받아 Thread 클래스의 run 메서드를 재정의 하고, 인스턴스를 생성하여 start 메소드를 호출
1. `Runnable` 인터페이스를 구현하는 클래스를 선언하여 run 메서드를 구현하고, 인스턴스를 생성하여 Thread를 만들 때 인수로 전달 하여 해당 Thread의 start 메소드를 호출  

아래 예제를 보면  
`Test1Thread` 클래스에서는 Thread 클래스를 상속받아 run 메소드를 재정의 하였고,  
`TestRunnable` 클래스에서는 Runnable 인터페이스를 구현하였다.  

실행 시  
`Test1Thread` 클래스는 단독으로 인스턴스를 생성하여 실행하였고,  
`TestRunnable` 클래스는 Thread 인스턴스 생성시 인자로 해당 클래스의 인스턴스를 전달하여 실행 하였다.

실행결과를 보면 코드가 순차적으로 실행되지 않은 것을 확인 할 수 있고, 매번 실행할 때마다 순서도 변경되는 것을 확인할 수 있다.
```java
public class Test{
    public static void main(String[] args) {
        Thread th1 = new TestThread();
        Thread th2 = new Thread(new TestRunnable());

        System.out.println("Start !!!");

        th1.start();
        th2.start();

        System.out.println("End !!!");
    }
}

class TestThread extends Thread {
    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            System.out.println(i + " Hello Thread ~");
        }
    }
}

class TestRunnable implements Runnable {
    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            System.out.println(i + " Hello Runnable ~");
        }
    }
}
```
```text
실행결과

Start !!!
End !!!
0 Hello Thread ~
0 Hello Runnable ~
1 Hello Thread ~
2 Hello Thread ~
3 Hello Thread ~
1 Hello Runnable ~
4 Hello Thread ~
2 Hello Runnable ~
5 Hello Thread ~
3 Hello Runnable ~
6 Hello Thread ~
4 Hello Runnable ~
7 Hello Thread ~
5 Hello Runnable ~
8 Hello Thread ~
6 Hello Runnable ~
9 Hello Thread ~
7 Hello Runnable ~
8 Hello Runnable ~
9 Hello Runnable ~
```

## 쓰레드의 상태
***
|상태|설명|
|:------------:|-------------------------|
|NEW           |아직 시작되지 않은 쓰레드|
|RUNNABLE      |실행 가능한 쓰레드<br/>쓰레드가 JVM(Java Virtual Machine)에서 실행 중이지만 다른 리소스를 기다리고있을 수 있다.|
|BLOCKED       |Monitor lock을 기다리는 차단된 쓰레드<br/>차단된 상태의 쓰레디는 모니터잠금이 동기화 된 블록에 들어가거나, Object.wait를 호출 한 후 동기화 된 블록에 다시 들어가기를 기다림.|
|WAITING       |대기상태의 쓰레드<br/>다음 메서드 중 하나를 호출하여 대기상태에 있음<ul><li>Object.wait with no timeout</li><li>Thread.join with no timeout</li><li>LockSupport.park</li></ul>대기상태의 쓰레드는 다른 쓰레드가 다음과 같은 작업을 하기를 기다리고 있다<ul><li>해당 객체에서 Object.notify() 또는 Object.notifyAll()을 호출하기를 기다림</li><li>Thread.join()을 호출한 쓰레드가 지정된 쓰레드가 종료되길 기다림</li></ul>|
|TIMED_WAITING |지정된 대기 시간이 있는 대기상태의 쓰레드<br/>다음 메서드 중 하나를 호출하여 대기상태에 있음<ul><li>Thread.sleep</li><li>Object.wait with timeout</li><li>Thread.join with timeout</li><li>LockSupport.parkNanos</li><li>LockSupport.parkUntil</li></ul> |
|TERMINATED    |종료된 쓰레드<br/>쓰레드가 실행을 완료함|



## 쓰레드의 우선순위
***
모든 쓰레드는 우선순위를 가지며, 우선순위가 높은 쓰레드는 우선순위가 낮은 쓰레드보다 우선적으로 실행된다.  
일부 쓰레드에서 새로운 쓰레드 객체를 생성할 때 새 쓰레드는 처음 쓰레드의 우선순위와 동일하게 설정된 우선순위를 가진다.

우선순위는 1 ~ 10 까지의 정수만 가질 수 있으며, 숫자가 높을수록 우선순위가 높다
* MIN_PRIORITY = 1
* NORM_PRIORITY = 5
* MAX_PRIORITY = 10

아래 예제에서 th1 쓰레드의 우선순위를 3으로 설정했고, th1 쓰레드 내부에서 Test2Thread 쓰레드를 생성하므로 Test2Thread 의 인스턴스인 th2의 우선순위 값은 3이다.
```java
public class Test{
    public static void main(String[] args) {
        Thread th1 = new Test1Thread();
        th1.setPriority(3);
        th1.start();
    }
}

class Test1Thread extends Thread {
    @Override
    public void run() {
        Thread th2 = new Test2Thread();
        th2.start();

        for(int i = 0; i < 10; i++){
            System.out.println("Test 1 Thread Priority : " + this.getPriority());
        }
    }
}

class Test2Thread extends Thread {
    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            System.out.println("Test 2 Thread Priority : " + this.getPriority());
        }
    }
}
```



## Main 쓰레드
***
Main 쓰레드는 프로그램이 시작될때 JVM(Java Virtual Machine) 에 의해 자동으로 생성된다.  
Main 쓰레드는 먼저 main 메서드의 존재를 확인한 다음 클래스를 초기화 한다. (JDK 6 부터는 독립형 Java 어플리케이션에서 main 메서드는 필수)



## 동기화
***
쓰레드가 객체의 변수를 공유하게 되면 `쓰레드 간섭` 및 `메모리 일관성 오류`를 발생시킬 수 있다. 이러한 오류를 방지하는데 필요한 도구가 동기화 이다.  
하지만 동기화를 사용하게 되면 `Starvation` 또는 `Livelock` 같은 쓰레드 경합을 유발할 수도 있다.
* `Starvation`은 쓰레드가 공유 리소스에 정기적으로 액세스 할 수 없고, 진행할 수 없는 상황을 말한다.  
  동기화 메서드에서 공유리소스를 반환하기 까지 오랜 시간이 걸리거나, 너무 자주 호출하여 우선순위가 낮은 쓰레드가 접근할 수 없는 상태를 예로 들 수 있다.   
* `Livelock`은 한쓰레드가 다른 쓰레드의 응답으로 동작하고, 다른 쓰레드 또한 또 다른 쓰레드의 응답으로 동작한다고 했을 때 더 이상 진행 할 수 없는 상태가 될 수 있다.  
  예를 들어 A, B 사람이 복도에서 서로 지나간다고 했을때 서로 비켜주기 위해 A는 왼쪽으로 B는 오른쪽으로 비켜주면 다시 서로 마주하게 된다, 이상태에서 또 서로가 비켜주기 위해 A는 오른쪽으로 B는 왼쪽으로 비켜주는것 처럼 계속해서 서로 비켜주기만 하지 서로를 통과하지를 못한다.
  이처럼 다른 쓰레드가 서로 응답하기에만 바쁘고 진행되지 않는다.
  
### 쓰레드 간섭
```java
public class Test{
    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread th1 = new IncrementThread(counter);
        Thread th2 = new DecrementThread(counter);

        th1.start();
        th2.start();
    }
}

class Counter {
    private int c = 0;

    public void increment() {
        c++;
    }

    public void decrement() {
        c--;
    }

    public int value() {
        return c;
    }
}

class IncrementThread extends Thread {
    private Counter counter = null;

    public IncrementThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for(int i = 0; i < 1000; i++){
            counter.increment();
        }

        System.out.println("IncrementThread Result : " + counter.value());
    }
}

class DecrementThread extends Thread {
    private Counter counter = null;

    public DecrementThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for(int i = 0; i < 1000; i++){
            counter.decrement();
        }

        System.out.println("DecrementThread Result : " + counter.value());
    }
}
```
### 메모리 일관성 오류
메모리 일관성 오류는 


## 데드락
***


## 데몬 쓰레드(Daemon Thread), 일반 쓰레드(Non-Daemon Thread)
***
