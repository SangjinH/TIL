# 유니온 파인드 ( Union-Find )



### 유니온파인드 알고리즘이란 ?

그래프 알고리즘의 일종으로서 상호 배타적 집합, 

여러노드가 존재할 때, 어떤 두 개의 노드를 같은 집합으로 묶어주고

다시 어떤 두 노드가 같은 집합에 있는지 확인하는 알고리즘

1. **Find**

   노드 x 가 어느 집합에 포함되어 있는지 찾는 연산

2. **Union**

   노드 x 가 포함된 집합과 노드 y가 포함된 집합을 합치는 연산



### 구현...!

구현은 간단한 트리로 이뤄진다.

처음엔 간단하지 않았다 ㅎㅎ

`parent[i]` 를 i노드의 부모노드라고 정의하고 초기화

`parent[i] = i` 는 자기자신이 부모노드임을 의미.

```python
# V 라는 숫자가 주어졌을때,
V = int(input()) 

# i번째 노드의 부모 노드는 자기자신으로 초기화
parent = {i:i for i in range(V+1)}
```



#### **Find함수 구현**

```python
def find_parent(x):
    # 자기자신이 부모노드이면 그대로 반환
    if x == parent[x]:
        return x
    # 그게 아니라면 부모노드로 갖고 있는 노드를 재귀.
    return find_parent(parent[x])
```

하지만 위의 경우 재귀로 이뤄지기때문에 시간복잡도 측면에서 조금 걸릴 수 있다.

**따라서** 재귀를 진행하기전에 

```python
def find_parent(x):
    # 자기자신이 부모노드이면 그대로 반환
    if x == parent[x]:
        return x
    
    y = find_parent(parent[x])
    parent[x] = y
    return y
```





#### Union 함수 구현

union함수는 매개변수로 두 개의 값을 받고, 

두개의 값을 합쳐주는 역할

바로구현해보겠습니다.

```python
def union(x, y):
    x = find_parent(x)
    y = find_parent(y)
    if x != y:
        parent[y] = x
```



예제 문제는 백준의 **공항** (10775번)

https://www.acmicpc.net/problem/10775