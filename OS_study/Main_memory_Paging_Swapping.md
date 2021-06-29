# Paging and Swapping



## Paging

- 앞서 CMA ( Contiguous Memory Allocation ) 에서 발생했던 External Fragment를 방지하고자

  Memory를 Contiguous 하지 않게, **크기를 나누어 할당**하는 방법

- Logical Memory 와 Physical Memory 를 일정한 비율로 나눠서 Mapping 

  > Logical Memory : 10KB
  >
  > Physical Memory : 10MB
  >
  > Logical 1KB ==> Physical 1MB

- 일정한 비율로 나눴을 때의 좋은 점

  - 나뉘어진 Physical Memory가 절대로 **Contiguous 할 필요가 없다**
  - Logical address와 Physical address 를 나눌 수 있다!!



***그렇다면 PAGE 크기는 어떻게 정할까 ??***

- 하드웨어에 의존적으로 나뉨.



 

