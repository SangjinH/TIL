# Synchronization의 해결책



## Peterson's solution

- 두 개의 프로세스에서 `critical section` 과 `remainder section` 을 어떻게 번갈아 실행할 것인지

- 두 개의 프로세스를 flag와 true/false값을 이용해 하나의 프로세스가 critical section을 진행할때,

  침범하지 않도록

### 그러나,

​	해당 솔루션에도 완전히 동기화가 이뤄지지는 않는다. 조금 더 기계어 적인 부분에서 본다면,

​	어느 부분에서 Context Switch가 일어날지 모르기 때문.

​	하지만 

 1. Mutual exclusion

 2. No deadlock

 3. No starvation

    ​	위 세 가지를 보장한다.



### Atomicity ( 원자성 )

- 더 이상 쪼갤 수 없는 물리적 단위
- uninterruptible unit of operation

