# Garbage Collector with JAVA



> 가장 먼저 GC 를 설명하기 전 알아야할 용어는 바로 `stop-the-world` 가 있다.
>
> `stop-the-world` 가 발생하면, GC 를 실행하는 쓰레드를 제외한 나머지 쓰레드는 모두 작업을 멈춘다. GC 작업이 끝난 이후에, 중단했던 작업을 다시 시작한다. 
>
> 대게 `GC튜닝` 이라함은 이 `stop-the-world` 시간을 줄이는 것이다. 



- GC란, 

  > 개발자가 프로그램 코드로 메모리를 명시적으로 해제하지 않기때문에, 
  >
  > 이러한 일련의 과정들을 대신해주는 작업을 하는 녀석이다.

  

  이러한 점에서 GC에는 **두 가지** 특징이 있다.

  1. 대부분의 객체는 금방 접근 불가능(unreachable) 상태가 된다.
  2. 오래된 객체에서 젊은 객체로의 참조는 아주 적게 존재한다.



위 가설을 토대로 GC를 구성할 때 `Young Generation(Young 영역)`, `Old Generation(Old 영역)` , 크게 두 가지 물리적 영역으로 나누었다.

![gc](C:\Users\multicampus\Desktop\gc.png)

- Young Generation
  - 새롭게 생성한 객체의 대부분이 여기에 위치한다. 대부분의 객체가 금방 접근 불가능 상태가 되기 때문에, 매우 많은 객체가 Young 영역에 생성되었다가 사라진다.
  - 이 영역에서 객체가 사라질 때, `Minor GC` 가 발생했다고 한다.



- Old Generation
  - 접근 불가능 상태로 되지 않아 Young 영역에서 살아남은 객체가 여기로 복사된다. 대부분 Young영역보다 크게 할당하며, 크기가 큰 만큼 GC는 적게 발생한다. 
  - 이 영역에서 객체가 사라질 때, `Major GC` 가 발생했다고 한다. 



## Young 영역의 구성

- Young 영역은 3개의 영역으로 나뉜다.
  - Eden 영역
  - Survivor 영역 ( 2개 )



#### 	*순서에 따른 영역 처리절차*

1. 새로 생성한 대부분의 객체는 Eden 영역에
2. Eden 영역에서 GC가 한 번 발생한 후 살아남은 객체는 Survivor 영역 중 하나로
3. Eden 영역에서 GC가 발생하면, 이미 살아남은 객체가 존재하는 Survivor 영역으로
4. 하나의 Survivor 영역이 다 차면, GC 이후 살아남은 객체를 다른 Survivor 영역으로
5. 이 과정을 반복하다 계속해서 살아남은 객체가 Old 영역으로 



## Old 영역에 대한 GC

- Old 영역은 기본적으로 데이터가 가득차면 GC를 실행한다. 

  Old 영역에서 처리하는 GC



> GC 알고리즘
>
> 1. Serial GC
> 2. Parallel GC
> 3. Parallel Old GC
> 4. Concurrent Mark & Sweep GC (CMS)
> 5. G1 GC

