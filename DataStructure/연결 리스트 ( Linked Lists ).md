# 연결 리스트 ( Linked Lists )

- 추상적 자료구조
  - Data
  - A set of operations



- Node ( Data와 Link(Next) )

  - Node 내의 데이터는 다른 구조로 이루어 질 수 있음
  - (예) 문자열, 레코드, 또 다른 연결 리스트

  

<img src="C:\Users\Sang Jin Han\AppData\Roaming\Typora\typora-user-images\image-20210312205319483.png" alt="image-20210312205319483" style="zoom:50%;" />

​	두 개의 클래스를 이용 ( Node, Link )

```python
# Node Class
class Node:
    def __init__(self, item):
        self.data = item
        self.next = None

# Linked List
class LinkedList:
    def __init__(self):
        self.nodeCount = 0
        self.head = None
        self.tail = None
```



## 연산 정의

> 1. 특정 원소 참조 (k번째)
> 2. 리스트 순회
> 3. 길이 얻어내기
> 4. 원소 삽입
> 5. 원소 삭제
> 6. 두 리스트 합치기

#### 1. 특정원소 참조

```python
def getAt(self, pos):
    if pos <= 0 or pos > self.nodeCount:
        return None
    i = 1
    curr = self.head
    while i < pos:
        curr = curr.next
        i += 1
```



|                |    배열     |   연결 리스트   |
| :------------: | :---------: | :-------------: |
|    저장공간    | 연속한 위치 |   임의의 위치   |
| 특정 원소 지칭 |  매우 간편  | 선형탐색과 유사 |
|   시간복잡도   |    O(1)     |      O(N)       |



### **찾는 시간도 더 느린데 왜 연결리스트(Linked List)를 사용할까 ?**