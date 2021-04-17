# Thread



- 가벼운 프로세스 !
- CPU활용에 가장 기초적인 단위
- thread_ID, program_counter, register_set, stack // 총 4가지로 구성 되어있음

![image-20210405230523475](C:\Users\Sang Jin Han\AppData\Roaming\Typora\typora-user-images\image-20210405230523475.png)



## 멀티쓰레드 프로그래밍의 장점은?

### 1. Responsiveness ( )

- 만약에 blocking issue가 발생한다면, 원래라면 요청이 마무리될 때까지 기다렸다 처리해야하지만

  **멀티쓰레드**가 된다면 바로바로 새로운 쓰레드를 생성해 해결,  ex) ```user interface```

### 2. Resource Sharing

- `code, data, files` 이 세 가지를 늘 공유함

### 3. Economy

### 4. Scalability( 확장성 )





## Multicore Programming 

- 그러면 멀티쓰레드가 멀티코어 시스템에선 어떻게 작동할까
  - '코어가 많아진다' 는 곧 동시성의 향상을 의미한다, 
  
  - 즉, 하나의 코어에서 4개의 쓰레드가 실행되는 것( **Interleaving ) 보다 당연히
  
    여러개의 코어에서 나눠서 진행하는 것이 훨씬 효율적이다.  예) 10만개의 덧셈을 4개로 나눠 계산 후 합치기
  
  - 하지만 여러개를 나누는 과정에서 많이 어려움이 발생한다..!



## Programming Challenges in Multicore Systems

- Identifying tasks

  - 100만개의 합은 나눠서 진행하는 것이 효율적이지만,

    정렬(sort)는 나눠서 진행하는 것이 비효율적일 수 있다.

- Balance

  - thread별로 

- Data Splitting

- Data dependency

- Testing and debugging이 어려워짐



### 병렬처리하는 방법 중, 크게 두 가지는 Data Parallelism, Task Parallelism



`Amdahl's Law` 

> 과연 코어는 무조건 많을수록 좋은가 ?

