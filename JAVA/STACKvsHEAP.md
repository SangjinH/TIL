# Stack 과 Heap

> 평소 Stack과 Heap 에 대해 자주 헷갈렸었는데,한번 정리를 해보도록 하겠습니다.

------

기본적으로 stack과 heap은 Java의 메모리 구조를 이야기합니다.

자료구조의 stack과 heap과는 조금 영역이 다릅니다.

- What is Java Heap Space ?

  자바의 힙 영역이란, JVM이 시작시에 생성되는 공간입니다.

  주로, Java runtime 이 메모리를 사용하는데, 객체에 대한 메모리를 할당할 때 사용합니다. 그리고 JRE class 까지.

  [JRE 란](https://www.ibm.com/kr-ko/cloud/learn/jre)

  객체가 생성될 때, 항상 힙 영역에 할당되고, 전역으로 접근할 수 있습니다. 이 것은 어떤 어플리케이션이든 항상 접근할 수 있다는 것을 의미합니다.

  - Garbage Collector

  모든 객체가 항상 사용되는 것이 아니기에 사용이 완료된 객체는

  Garbage Collector를 통해 관리됩니다.

  결국 Heap영역에서 GC가 실행됩니다.

- What is Java Stack Memory?

  자바의 스택 메모리는, 해당 메소드가 실행되었을 때, 잠시 저장하는 메모리입니다. 하나의 메소드가 끝났을 때, 메소드에 포함되어있던 모든 value들은 다음 메소드를 위해 제거됩니다.

  새로운 메소드가 호출되면, 새로운 메모리 블록이 스택에 생성될 것입니다. 이러한 새로운 블록은 해당 메소드에 value 값들과 참조변수들의 주소값을 가지고 있을 것입니다.

  현재 실행되는 메소드에 있는 value들은 메소드 내에서는 접근이 가능하지만 메소드가 끝난 이후에는 모두 제거가 돼, 어떤 것도 참조할 수 없을 것 입니다.

  Last In, First Out (LIFO) 구조로 작동됩니다. ***자료구조 stack과 동일\***

이제 Heap과 Stack의 역할을 잘 알았다면, 실제로 어떻게 작동하는지 알아보겠습니다..!

***한 줄 한 줄 확인해보시면서, 맞는지 확인해보세요!\***

```java
package com.journaldev.test;

public class Memory {

	public static void main(String[] args) { // Line 1
		int i=1; // Line 2
		Object obj = new Object(); // Line 3
		Memory mem = new Memory(); // Line 4
		mem.foo(obj); // Line 5
	} // Line 9

	private void foo(Object param) { // Line 6
		String str = param.toString(); //// Line 7
		System.out.println(str);
	} // Line 8
}
```

- 프로그램을 실행함과 동시에 Heap 영역에 JRE 생성

- Line1

  main() 함수가 실행되면서, Stack영역에 블록 생성  ***편의상 JRE는 생략하겠습니다\***

  | Stack       | Heap |
  | ----------- | ---- |
  | Main() 블록 |      |

- Line2

  현재 main()  Stack블록에, int 변수 i=1 이 저장됨

  | Main()  in Stack |
  | ---------------- |
  | int i = 1        |
  |                  |

- Line3

  객체가 생성되었으므로, Heap 영역에 Object가 생기고, Stack영역에 해당 Object를 참조하는 값이 생성됨, Line4도 비슷하게 작동함

  | Stack      | Heap         |
  | ---------- | ------------ |
  | Main stack |              |
  | obj        | new Object() |
  | mem        | new Memory() |

- Line5

  새로운 함수 `foo(Object param)`  이 실행될 때, 마찬가지로 stack영역에 새로운 `foo()` 블록이 생기고, 인자로 들어가는 param 이 힙 영역에 생기고, 참조하는 값이 스택에 저장됩니다. Line6

  **Only foo**

  | foo() in stack | Heap       |
  | -------------- | ---------- |
  | param          | new Object |

- Line7

  param변수를 문자열로 바꾼 새로운 문자열이 Heap영역에 생기고,  참조하는 변수가 foo() 블록 스택에 생성됩니다.

  | foo() in stack | Heap             |
  | -------------- | ---------------- |
  | param          | Object           |
  | str            | param.toString() |

- Line8

  `foo()` 메서드가 끝나면서, Stack에 지정되었던 메모리가 해제됩니다.

  | Stack  | Heap |
  | ------ | ---- |
  | Main() | ...  |

- Line9

  `Main()` 메서드가 끝나면서, Stack에 지정되었던 메모리가 해제됩니다.