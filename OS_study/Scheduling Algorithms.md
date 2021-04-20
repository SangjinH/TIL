# Scheduling Algorithms

## - FCFS ( First Come First Served)

## - SJF ( Shortest Job First )

>  앞서 두 가지의 알고리즘을 알아봤는데 확실히 FCFS보다 SJF가 더 빠른 모습을 보였다
>
> 그런데 사실 생각해보면 각각의 Process마다 자신이 얼마나 실행하는지 시간을 알고 들어오는 경우는 없다.
>
> 따라서, 정확한 SJF 를 구할 수는 없고 근사적으로 한 번 구해보자.

- 예측하는 방법은 
  - 과거에 사용했던 시간들을 exponential 로 측정



### SJF 는 Preemptive 할 수도 있고 Non-Preemptive 할 수도 있다.

- 예로는 10초 짜리 P0 가 실행중일 때, 5초정도 실행된 상태에서 1초짜리 P1이 들어왔을 때,
  1. 남은 5초를 P0가 실행하고 P1 이 실행하는 경우 ( Preemptive )
  2. 실행시간이 더 짧은 P1을 실행하고 나머지 P0를 실행하는 경우 ( Non-Preemptive )

###  SRTF는 SJF에서 선점을 추가하는데, 

​	새로 도착한 프로세스의 Running Time이 기존에 진행중이던 프로세스의 Remaining Time보다 적을 때 바꿔버림



## - RR Scheduling

- Round - Robin : preemptive FCFS 를 실행하는데 일정한 시간을 잡고 순환시킨다.

- 굉장히 작은 시간을 할당 == 10 to 100 milliseconds

- Average Waiting TIme은 RR에서 일반적으로 좀 높을 순 있으나,

  SJF 와 같이 사용한다면 좋은 효율을 낼 수 있음

- Preemptive

- Time Quantum을 얼마나 주느냐에 따라 성능이 확확 달라짐..!





## - Priority - base

- 우선순위를 결정해, 그 순서대로 결정..!

- 그럼 우선순위가 어떤 것이냐

  - SJF의 특이 case인데, SJF에서는 도착시간과 CPU - burst가 크면 클수록 우선순위를 높게 줬었으면

    Priority-base는 CPU-Burst만 가지고



그렇다면 이것또한, **Preemptive ( SRTF ) ? or Non-Preemptive ( SJF ) ?**

### 이 것을 고려하려면  " Problem of Starvation ( indefinite blocking ) " 을 고려해야함

- 만일 Ready Queue 에 5초 정도 남은 프로세스가 있는데, 계속 이보다 짧은 수행시간을 가진 Process 가 들어올때

  이것을 Starvation.

- **Starvation**을 해결하기 위한 방법은 "**Aging**"

  - RR 과 Priority Scheduling을 combine



## - MLQ ( Multi-Level Queue )

- 스마트폰 같은 경우에는 내가 게임을 하다 전화가 오는 경우가 있고 네이버 홈페이지에 요청을 보내는 

  여러가지 일들을 동시에 처리하는데 그렇게 할때는

  여러개의 Priority 를 두고 각각에 Ready Queue를 따로 주자..!

![image-20210420224300439](C:\Users\Sang Jin Han\AppData\Roaming\Typora\typora-user-images\image-20210420224300439.png)

![image-20210420224342215](C:\Users\Sang Jin Han\AppData\Roaming\Typora\typora-user-images\image-20210420224342215.png)

​		

## Multi-Level Feedback Queue ( MLFQ )

- 아까 Priority에서 Starvation을 해결했던 방법으로 Aging을 사용한 것처럼 

  MLQ 에도 Aging을 적용한 것이 MLFQ



## 현대의 컴퓨터에서는 프로세스보다는 쓰레드를 스케줄링하는 경우가 많음

- Kernel Thread만 관리해주면됨, User Thread는 라이브러리가 해줌