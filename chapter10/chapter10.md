# Chapter 10. 멀티쓰레드 프로그래밍
## Thread 클래스와 Runnable 인터페이스
***

## 쓰레드의 상태
***
|상태|설명|
|:------------:|-------------------------|
|NEW           |아직 시작되지 않은 쓰레드|
|RUNNABLE      |실행 가능한 쓰레드<br/>쓰레드가 JVM(Java Virtual Machine)에서 실행 중이지만 다른 리소스를 기다리고있을 수 있다.|
|BLOCKED       |Monitor lock을 기다리는 쓰레드|
|WAITING       |대기상태의 쓰레드<br/>다음 메서드 중 하나를 호출하여 대기상태에 있음<ul><li>Object.wait with no timeout</li><li>Thread.join with no timeout</li><li>LockSupport.park</li></ul>대기상태의 쓰레드는 다른 쓰레드가 다음과 같은 작업을 하기를 기다리고 있다<ul><li>해당 객체에서 Object.notify() 또는 Object.notifyAll()을 호출하기를 기다림</li><li>Thread.join()을 호출한 쓰레드가 지정된 쓰레드가 종료되길 기다림</li></ul>|
|TIMED_WAITING |지정된 대기 시간이 있는 대기상태의 쓰레드<br/>다음 메서드 중 하나를 호출하여 대기상태에 있음<ul><li>Thread.sleep</li><li>Object.wait with timeout</li><li>Thread.join with timeout</li><li>LockSupport.parkNanos</li><li>LockSupport.parkUntil</li></ul> |
|TERMINATED    |종료된 쓰레드<br/>쓰레드가 실행을 완료함|



## 쓰레드의 우선순위
***

## Main 쓰레드
***

## 동기화
***

## 데드락
***