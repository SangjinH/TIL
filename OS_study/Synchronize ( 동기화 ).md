# Synchronize ( 동기화 )

---

## 동기화란 ?

동기화란 프로세스, 혹은 쓰레드들이 수행되는 시점을 조절해 서로가 알고 있는 정보가 일치하는 것을 의미



- *그렇다면 동기화 작업을 하지 않으면 발생하는 문제점은 무엇일까 ?*

프로세스같은 경우에는 각각의 프로세스마다 자원을 독립적으로 갖고있기때문에 문제가 생기지 않겠지만

쓰레드는 `데이터`, `힙`, `텍스트` 를 공유하고 `스택` 만 따로 소유하므로 자원을 공유한다. 

따라서 쓰레드에서 `race condition( 경쟁상황 )` 이 발생할 것이다.



각각의 쓰레드가 공유된 데이터를 변경하는 코드 블럭이 있는데, 이 부분을 `critical section(임계영역)`이라고한다.

임계영역문제 : 각각의 프로세스, 쓰레드 별로 임계영역을 접근하는 갯수를 지정하자 

**임계영역을 어떻게 누가 어떻게 접근할 것인지 정하는 방법**이 여러가지 있다.

해결책을 위한 요구조건 3가지

- Mutual Exclusion ( 상호배제 )
- Progress ( avoid DeadLock )
- Bounded Waiting ( avoid Starvation )



- ### 동기화 방법론 총  4 가지 

1. 뮤텍스 ( Mutex )
   - Mutex Locks ( 임계영역을 들어갈 때, Mutex(key)를 가지고 사용할 수 있도록 함) ==> 2개
2. 세마포어 ( Semapore )
   - 뮤텍스의 단점을 보완한 방법론으로 n 개를 해결할 수 있음
3. 모니터 ( Monitor )
4. 자바 동기화 



---

## Mutex ( Mutual Exclusion )

임계영역을 진입하기 위해 Lock ( 열쇠 )를 이용하고 임계영역을 빠져나오면 Lock을 반납

**수도코드**

```java
while (true) {
    // acquire lock
    critical section 
    // realease lock
    remainder section 
}
```

- `acquire()` , `release()` 를 이용하는데 `available` 변수를 사용

  특징으로는 `acquire` 작업을 하기위해 `busy waiting` 을 함

​	  `busy waiting` 은 while 문에서 계속 기다리는 것을 의미

​	그러나 `busy waiting`이 항상 나쁜 것은 아님. 할당할 수 있는 cpu가 여러개 있으면 오버헤드를 감소시킬 수 있음

---

## Semaphore ( 신호장치 )

세마포어인 `S` 는 숫자 변수이고 `wait()` 와 `signal()` 을 이용.

```java
wait(S) {
    while ( S <= 0 );
    	// busy wait
    S--;
}

signal(S) {
    S++;
}
```

위에 나와있는 Mutex와의 차이점은 Mutex는 key 하나를 가지고 권한을 줬다면, 

세마포어(S)는 숫자를 처음에 설정해준 값을 기준으로 동시에 작동할 수 있는 것을 가능하게 함.

>  세마포어도 Mutex와 비슷하게 `busy wait` 문제를 겪을 수 있으나, `wait`을 이용해 `waiting queue` 를 이용한다. 

---

## Monitors 

- 모니터란
  - 어떤 변수를 사용해서 

