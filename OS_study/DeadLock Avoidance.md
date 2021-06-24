# DeadLock Avoidance 

> 앞서 DeadLock을 해결하려고 했지만 
>
> 4가지 조건을 위배하면서 해결하기란 쉽지않음
>
> 따라서 **DeadLock Avoidance**를 이용한다.



## DeadLock Avoidance란

- 시스템이 각각의 request를 받기전에, 미리 future deadlock이 발생할 수 있다면 잠시 wait하라고 명령
- 그렇게 하기위해선 추가적인 정보가 필요
  - 각각의  자원과 쓰레드의 연결상태에 대한 graph가 필요
  - 최대 Resource의 갯수
  - available, allocated 한 resource의 갯수
  - 쓰레드의 최대 수요



### Safe State:

- 시스템이 자원을 각 쓰레드에 할당할 수 있는 상황 ( 최대 Resource 갯수 까지 )
- 각 Thread인 T_i 가 순차적으로 실행이 될때



### Revisit the RAG

- 시스템이 하나의 resource-type을 갖고있다고 생각
- **claim edge** : 과연 지금 내가 이 resource를 받아도 safe 한가 ? 를 확인해주는 장치
- 시스템애 cycle이 없다면: 바로 allocate
- 시스템에 cycle이 있다면 : claim edge를 통해 wait 신호를 받음



## Banker's Algorithm 

- RAG는 Single Instance일때는 효율적이지만 Multiple Instance일 때는 적용할 수 없다. 
- 따라서 Multiple instance를 가능케하는 Banker Algorithm을 알아보자



### 자료구조 

- N : Thread의 갯수
- M : Resource Type의 갯수
- Available : 사용가능한 Resource types의 갯수
- Max : 각 Thread가 앞으로 각각 요청할 resource의 최대 갯수
- Allocation : 각 Thread가 currently allocated하는 갯수
- Need : 앞으로 요청할 Resource의 갯수

![image-20210624092700260](C:\Users\Sang Jin Han\AppData\Roaming\Typora\typora-user-images\image-20210624092700260.png)

![image-20210624092724511](C:\Users\Sang Jin Han\AppData\Roaming\Typora\typora-user-images\image-20210624092724511.png)

