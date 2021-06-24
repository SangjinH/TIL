# DeadLock ( 데드락 )



## 데드락이란 ?

- 일련의 프로세스들의 집합에서 이벤트가 발생해야 실행되는 프로세스들이 서로 waiting queue에 있을 때.
- waiting 상태의 쓰레드가 자신의 상태를 바꾸지 못할떄

각각의 쓰레드가 공유된 자원을 사용할 때, 발생할 수 있는 "데드락"

![image-20210624083324458](C:\Users\Sang Jin Han\AppData\Roaming\Typora\typora-user-images\image-20210624083324458.png)



###  데드락이 발생할 수 있는 조건 (  4가지를 모두 만족하는 경우 )

1. Mutual Exclusion
   - 적어도 하나의 자원은 non-sharable 상태여야 한다. ( 모두가 read라면 상관없지만 하나 이상이 write 면 발생 )
2. Hold and Wait
   - 특정 쓰레드가 적어도 하나의 자원을 Hold 하고 있으며 다른 자원은 Wait하며 기다림
3. No preemption
   - 자원들이 선점 불가능하다면,
4. Circular Wait
   - 의존관계가 서로 순환적으로 그래프가 그려질 때.



## Resource-Allocation-Graph

- 데드락을 확인하기 쉽게 Graph로 만들어놓은 것

- V와 E로 구성

  - V -->  T : {T_1, T_2 , ... , T_n } : Threads

    ​		  R : {R_1, R_2, ... , R_n}  : Resources

> 아래 그래프는 
>
> first_mutex  > thread_one > second_mutex > thread_two > first_mutex ...
>
> 순환이 발생하는 기초적인 그래프이다. 

![image-20210624083300761](C:\Users\Sang Jin Han\AppData\Roaming\Typora\typora-user-images\image-20210624083300761.png)

> 다음 그래프를 보자
>
> 오른쪽 아래에 설명이 돼있듯이 두개의 Cycle이 존재합니다.
>
> 그러면 DeadLock이 발생할까요 ?

![image-20210624083829712](C:\Users\Sang Jin Han\AppData\Roaming\Typora\typora-user-images\image-20210624083829712.png)

​			정답은 **발생한다** 입니다. R_2(Resource2) 를 보면 각각이 순환할 떄 필요한 자원 1개



> 그렇다면 이 cycle은 발생할까요 ?

![image-20210624084618828](C:\Users\Sang Jin Han\AppData\Roaming\Typora\typora-user-images\image-20210624084618828.png)

​	

​	정답은 **"발생하지 않는다"** 입니다.





## 그렇다면 데드락을 어떻게 회피할까 ( DeadLock Prevention ) ?

- 데드락은 4가지 조건

  - Mutual Exclusion
  - Hold and Wait
  - No Preemption
  - Circular Wait

  모두 만족이 되어야만 발생하는게 DeadLock이라면, 적어도 한 가지만 피해보자!



1. Mutual Exclusion

   - 모든 Resource가 sharable 하다면, 당연히 발생하지 않겠지만 그런 상황이 있을 수 없다.

     본질적으로 Mutex가 sharable하지 않기때문에 만들어진 것이므로 고려하지 않는다.

2. Hold and Wait

   - 어떤 하나의 쓰레드가 현재 가지고 있는 자원들을 모두 내려놓고 다시 새로운 자원을 받는다라고한다면,

     실질적이지 않은 일

3. No preemption
   - 더 우선순위에 있는 Thead가 선점하는 방식으로 한다고해도 굉장히 일반적이지 않음

4. CIrcular Wait

   - 떄로는 합리적인 방법이 될 수 있다.

   - 각각의 Resource에 **total ordering** 을 부여하자

     > file(1) - mem(2) - sdd(3) - monitor(4) - ...

   - 그렇게해서 만약 어떠한 자원이 점유중이라면 실행중이던 Thread 종료

   - 하지만 **Starvation**은 발생할 수 있음



#### `계좌이체 Transaction`

![image-20210624090126546](C:\Users\Sang Jin Han\AppData\Roaming\Typora\typora-user-images\image-20210624090126546.png)

