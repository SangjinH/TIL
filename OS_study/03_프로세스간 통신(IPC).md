# 프로세스간 통신(IPC)

---



프로세스의 통신의 방법은 독립적(Independent)이거나 종속적(Cooperating)이거나

독립적 - 아무런 데이터를 주고받지 않고 각각 실행됨

종속적 - 데이터를 서로 주고받으며 서로간에 간섭이 있음



## IPC( Inter-Process Communication ) - 프로세스간 통신 문제

- 결국엔 data를 주거나 받거나하는 과정을 뜻함!!



###  총 두 가지 모델 

- shared memory

- message passing

  A : 부모 프로세스, B : 자식 프로세스

<img src="C:\Users\Sang Jin Han\AppData\Roaming\Typora\typora-user-images\image-20210329225335437.png" alt="image-20210329225335437" style="zoom: 67%;" />



> 생산자-소비자 문제..! ( Producer-Consumer Problem )
>
> - Producer(생산자) : 정보를 생산
>
> - Consumer(소비자) : 정보를 소비
>
>   예) web server -> 브라우저가 request를 하면 web server가 렌더링



## Shared - Memory

- 두 개의 프로세스가 동시에(concurrently) 진행된다면 

- **buffer** 를 이용한다..! 

  Producer는 buffer를 채우고, 

  Consumer은 buffer를 사용하고,

- shared-memory는 공유하고 있는 영역을 의미하는데, 

  원래 각각의 프로세스는 각자의 메모리 영역을 갖고 있고 침범하면 많은 문제가 발생하기에

  특별한 메모리 영역인 shared-memory를 관리해줘야함!

  > buffer는 환형 queue를 이용해 two-pointer로 간단하게 구현



### 그럼 Shared Memory의 문제점은 무엇일까 ?

- 메모리 영역을 공유하게되면, 메모리를 쓸 공간을 개발자가 모두 설정 해주어야한다.

---



## Message-Passing

- 운영체제에게 협업을 도울 수 있는 Kernel을 만들고 관리하게 한 후, message만 전달
- Facility == send, receive  , 총 두 가지

- Prosumer(생산자+소비자) 와 Prosumer 가 서로 통신
- 통신 방식에는 직접적(direct), 간접적(indirect) 방법이 있다.

#### Direct

- 각 프로세스가 통신을 하고있는 서로(생산자, 소비자)를 알고있다
- 이 방식에선 **Link가 자동적으로 생성** , 1개의 연결

#### Indirect

- Port(포트)라는 것을 소유하고 있는데

  > Port(포트)란 ?
  >
  > - 메세지를 보내고 저장하는 장소, ex)용돈저금통

- Port 를 공유하는 프로세스가 정해졌을 때 Link가 생성되고,

  이 Link는 여러 개의 프로세스를 연결할 때도 아무런 문제가 없음.



#### 그럼 OS 입장에서 해줘야할 것은?

- Create Port, Delete Port
- Send message, Receive message