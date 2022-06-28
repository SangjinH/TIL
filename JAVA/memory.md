# Java Memory관리방법

> 목차
>
> 	1. [JVM](##1.JVM)
>  	2. [JVM메모리 구조](##2.JVM메모리구조)

---



## 1. JVM

- JVM은 Java Virtual Machine의 약자로, Java와 운영체제(Linux, Window, ..) 사이에서 중개자 역할을 수행하며, 운영체제에 구애받지 않고 실행할 수 있게끔 도와줍니다. 다른 하드웨어와 달리 **스택 기반**으로 동작합니다.

- 실행 순서

   <img src="C:\Users\han\Github\TIL\assets\java-개발,수행과정.png" style="zoom: 67%;" />

> 먼저 .java 파일을 컴파일러로 자바 소스 파일이 byte코드로 변환.
>
> byte코드를 JVM에서 읽어들여 실행하게 됩니다. 이 부분에서는
>
> 기존 Compile방식이 아닌, 한 줄 한 줄 읽는 Interpreter방식을 사용



## 2. JVM 메모리구조

- JVM의 조금 더 상세한 구조를 알아봅시다. JVM은 크게 총 4가지로 구성 
- 구조
  - GC (Garbage Collector)
  - Execution Engine
  - Class Loader
  - Runtime Data Area

![](C:\Users\han\Github\TIL\assets\메모리구조.png)

Javac로 변환한 Byte파일이 JVM에 들어가며, **ClassLoader** 가 읽어들임

- Class Loader

  - JVM내로 클래스파일을 로드하고, 런타임시에 동적으로 클래스 로드

- Execution Engine

  - 초기에는 인터프리터 방식이기에 조금 느리다는 단점이 있었으나,

    일정한 기준이 넘어가면, JIT 컴파일러 방식을 이용

- Garbage Collector

  - GC는 힙 메모리 영역에 생성된 객체들 중에서 참조되지 않은 객체들을 탐색 후 제거하는 역할을 합니다. 

- Runtime Data Area

  - Method, Heap, Stack, PC Register, Native Method Stack

