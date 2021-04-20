# CPU Scheduling



## 멀티프로그래밍을 하기위해선 무조건 필요한 존재

즉, 한개의 CPU와 Memory에 여러개의 프로세스가 올라가 동시에 동작하는 것을 멀티프로그래밍이라고함.

멀티프로그래밍을 하는 이유는 **cpu의 사용량을 최대화**하고 **Time Scheduling**을 이용함 ( Inter leaving )



### 그렇다면  CPU를 사용하는 시간이 많을까 ? 아니면 입력을 대기받는 시간이 많을까 ?

> CPU-Burst Time 이 많을까 ?  I/O-Burst Time이 많을까 ?



## CPU Scheduler 를 만들때 가장 중요하게 생각해야 하는 부분은 ?

- 메모리에 올라와있는 프로세스를 선택하는 것을 효율적으로

  즉, Ready 상태에 있는 Process에게 CPU를 빠르게 할당해주는 것

> 문제는 간단하나 해결은 간단하지 않다..!

### 그럼 어떻게, 어떤 녀석들을 선택할 것인가 ?

- Linked List ? , Binary Tree ?
- FIFO Queue    선입선출
- Priority Queue  우선순위



#### 본격적으로 알아보기 전에

> Preemptive VS Non-preemptive

- Non-preemptive( 비선점형 )
  - 기존에 실행중이던 프로세스가 CPU를 놔주기 전까지 기다리는 것
- Preemptive ( 선점형 )
  - 실행중이던 프로세스도 쫓아낼 수 있음



### CPU-Scheduling 할 때의 Decision Making

1. Runing --> Waiting
2. Running --> Ready
3. Waiting --> Ready
4. Terminate

| 상태  | 종류                                               |
| ----- | -------------------------------------------------- |
| 1,  4 | Non-preemptive                                     |
| 2,  3 | Preemptive or Non-preemptive ( 이 경우가 중요...!) |



### Dispatcher 란?

- 모듈인데 어떤 모듈이냐 ? CPU Core를 컨트롤 할 수 있는 모듈
- Process 에게 CPU를 넘겨주는 아이 

#### 기능

- 문맥교환
- 유저모드로의 전환..!
- 유저프로그램에 적당한 위치로 resume 시켜주는 역할

> Scheduler 와 Dispatcher의 차이 ??
>
> - Scheduler는 어떤 Process 선택할지 정해주고
> - Dispatcher는 실제로 그 바꿔주는 작업을 하는 역할

*문제는 Dispatcher가 빨라야한다..!*

![image-20210420213945063](C:\Users\Sang Jin Han\AppData\Roaming\Typora\typora-user-images\image-20210420213945063.png)

- 이러한 일련의 과정을 거치는데 이 역할을 Dispatcher 가 함



### 하는 목적

1. CPU utilization : CPU 사용의 최대화

2. Throughput : 단위 시간내의 프로세스의 완결 숫자를 의미

3. TurnAround TIme : 실행에서 종료까지의 시간을 최소화 시켜라

4. **Waiting time** : 어떤 프로세스가 Ready Queue 에서 대기하는 시간을 최소화 시키는 것

   ​						당연히 Waiting Time이 줄어들면 나머지 성능도 개선됨

5. Response time : 반응시간, (게임할때)



## CPU Scheduling Problem

- **FCFS** : First-Come, First-Served 
- **SJF** : Shortest Job First ( SRTF : Shortest Remaining Time First )
- **RR** : Round - Robin ( 시분할, 정해진 시간을 놓고 각각의 프로세스에게 할당 )
- **Priority-based**
- MLQ : Multi - Level - Queue



### FCFS

- CPU를 먼저 요청한 프로세스에게 먼저 제공함

- FIFO Queue를 하나 만들고 순서대로 할당해주는 방법

- 문제점..

  - 평균 waiting time이 FCFS를 사용할때 상대적으로 작지않다.

- 일단 FCFS는 Non-preemptive, 한 번 CPU를 사용하면 끝날때까지.

  - 만약 CPU-bound 하나에, 여러개의 I/O-bound가 있다면

    운이 좋아 처리시간이 짧은 프로세스들이 가장 긴 프로세스보다 앞쪽에 처리되면 다행이지만,

    뒤 쪽에 위치한다면, 그만큼 waiting 시간이 늘어남. ( Convoy Effect )

