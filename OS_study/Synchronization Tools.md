# Synchronization Tools



우리가 흔히 이야기하는 Cooperating Processes는

- 서로에게 영향을 주는, 영향을 받는 것을 의미하고
- 논리적으로 메모리주소를 공유하거나 ( Thread ), Shared Data를 이용하거나( Shared Memory, Message Pass ) 



그러나,  공유된 메모리에 `concurrent access(동시적 접근)`은 data의 처리의 순서를 보장할 수 없을 수 있다.

따라서, `orderly execution` 이 필요하다, 



조금 더 면밀히 보자면,

### 여러개의 프로세스들이 같은 DATA를 공유하고 있을때, 어떤 일이 벌어지느냐

- Concurrent하게 실행될 때, 
  - 프로세스에선 Interrupt가 발생해 Context Switch가 일어난다
  - 메모리를 공유하기 때문에 문제들이 발생
- Parallel 일때도 문제가 발생
  - 분리된 CPU에서 작동하기 때문에



사실 생각해보면, concurrent하게 실행이 된다면 순차적으로 실행이 되는 것인데, 왜 메모리를 사용하는데 오류가 생길까 ?

- **Data Incosistency**

  - 두 개의 프로세스가 순차적으로 실행될 때, 기존에 공유하던 메모리에 5개의 메모리가 있고

    그 메모리들을 만들면 +1, 사용하면 -1 처리를 진행해주었을때, 우리 생각에는 5가 계속 유지되어야하지만

    실제로는 4, 5, 6 ... 많은 값들이 나온다. 



""" 왜 이런일들이 일어날까 ?

- 비록 우리가 생각하기에 `register_1` , `register_2` 가 각각 물리적으로 같은 레지스터라 생각하지만 

  중간에 interrupt handler가 저장하고 불러오는 과정에서 차이가 발생한다. 

- 다시말하면, context switch가 어디서 일어나는지 정확히 알 수 없기때문에, 값이 매번 달라지는 것



### 이러한 상황들을 Race Condition

- 상황
  - 몇 개의 process, or thread
  - 같은 data를 concurrency 하게 조작하거나 접근할때
  - 어떤 순서로 접근되는지에 따라 값이 달라짐
- 해결책
  - `Synchronization`
    - 오로지 하나의 process만 그 순간에는 메모리를 점유하게끔, 



## Critical Section Problem ( 임계영역 문제 )

- 어떠한 N 개의 Process가 있을 때, 각 프로세스의 어떠한 부분을 critical section이라고 정의하자
- 보통 access, update data를 할때,
- 가장 중요한 기능은
  - 어떠한 하나의 프로세스가 `critical section`을 사용하고 있을 때, 다른 프로세스는 `critical section`을 사용하지 않도록



그렇다면 소스소드 영역을 나눈다면 ?

- Entry-Section   : critical section에 들어가기 위한 허가를 요청
- Critical-Section : 일련의 과정들을 context switch 없이 수행
- Exit-Section      : 끝
- Remainder-Section



- Critical Section을 위한 세 가지 요구사항

1. Mutual Exclusion ( 상호배제 )
   - 당연하게, 하나의 프로세스가 진행될때, 다른 프로세스를 진행하면 안된다.
   - 문제점 : Deadlock, Starvation 



- 간단한 해결방안
  - Prevent Interrupt
    - Context Switch 를 막는 방법이 있다. 이 방법은 공유 데이터를 수정할때 발생하는 문제가 생기지 않으나
    - 멀티프로세스 환경에서는 적합하지 않다.



> 조금 더 일반적인 접근
>
> - preemptive kernel과 non-preemptive kernel

​	