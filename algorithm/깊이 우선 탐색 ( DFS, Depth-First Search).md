# 깊이 우선 탐색 ( DFS, Depth-First Search)



### 깊이우선탐색은

정해진 방향으로 가장 깊은 곳까지 탐색하는 방법을 뜻한다. ![Depth-First-Search](C:\Users\Sang Jin Han\Downloads\Depth-First-Search.gif)

위의 그림과 같이 순서가 깊은 곳을 우선으로 탐색을 진행한다. 



### 특징

- 자기자신을 호출하는 **순환 알고리즘(재귀)의 형태** 를 가지고 있다.

- 가장 큰 차이점은, **어떤 노드를 방문했는지 여부 검사가 반드시 필요**



### 구현

- #### Stack 이용

1. 시작할 노드를 스택에 push

2. 스택에서 노드 하나를 pop

3. pop한 노드와 인접한 노드가 있는지 검사

   3-1. 만약 pop한 노드와 인접노드를 스택에 push하고 ( 이미 push했던 노드는 push하지 않음)

4. else pop한 노드를 출력

5.  위 2번 부터 Queue가 비워질때까지 반복



- #### 재귀 이용

1. 파라미터로 넘어온 정점이 이미 방문한 정점일 경우 return하도록 base condition을 설정
2. 마라미터로 넘어온 정점이 방문하지 않은 정점일 경우 방문표시
3. 인접 정점에 대해 재귀적으로 함수를 호출



### 코드

```python
# 1. 스택을 이용한 DFS
def dfs_stack(graph, start):
    visited = []
    stack = []
    
    # 시작노드 stack에 담기
    stack.append(start)
    
    # stack에 방문하지 않은 인접 정점들을 담은 후 하나씩 빼오면서 탐색
    while stack:
        now = stack.pop()
        if now not in visited:
            visited.append(now)
            stack.extend(graph[now])
    
    return ' '.join(visited)

# 2. 재귀함수를 이용한 DFS
visited = []
def def_recursive(graph, start):
    # 이미 방문한 노드라면 탐색 종료
    if start in visited:
        return
    
    # 방문 표시
    visited.append(start)
    print(start, end = ' ')
    
    # 인접 정점들에 대해 재귀호출
    for now in graph[start]:
        dfs_recursive(graph, now)
    
```



