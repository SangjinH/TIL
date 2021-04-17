# Type of Thread

## - User Thread ( 사용자 모드 ) - Java ...

## - Kernel Thread ( 운영체제 ) 

​	

> User Thread는 user모드에서 실행되는 것을 의미하고
>
> Kernel Thread는 운영체제에서 관리하는 Thread라고 한다면
>
> 과연 이 두 쓰레드 간에는 어떤 관계를 형성하고 있을까 ?
>
> ​	   	User  -  Kernel
>
> 1.  Many - to - One
> 2.   One  - to - One
> 3.  Many - to - Many



## 쓰레드를 만드는 게 굉장히 어렵기때문에 ,,,, ( User가 )

알아서 만드는 **Implicit Threading** 을 설계함!  ex) Java 에서는 Executor를 만듦



### Implicit Threading

- Thread Pools 
  - 쓰레드를 만들어 Pool에 저장해서 필요시마다 꺼내서 쓰는 방법
- Fork & Join
- OpenMP
- GCD



#### OpenMp

- Java나 다른 언어에서는 라이브러리를 만들어 새로운 쓰레드를 생성했지만,

  OpenMp 는 이 모든 작업을 Compliler한테 모두 시킴

- 즉, 동시에 진행되어야 하는 곳을 OpenMp library가 알아서 지정해줌 

