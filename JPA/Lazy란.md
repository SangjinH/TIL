# Lazy란

> 인프런 강의에서 들었을 때, Lazy를 설정함으로써, 얻을 수 있었던 장점이 어떻게 나왔는지를 정리해보려고 합니다. 

---

#### 들어가기 앞서,

JPA를 사용한다는 것의 가장 큰 장점은 `DB(데이터베이스)` 와 `Java` 의 패러다임의 차이를 해소시켜준다는 점입니다.

패러다임의 해소는 결국, `상속, 연관관계, 객체 그래프 탐색, 비교하기`와 같은 불일치 문제를 해결한다고 말하고 있습니다. 그러나 아직 책의 초반부인만큼 이러한 말들이 피부로 와닿진 않는 것 같습니다,, 허허 



그 중에서, Lazy를 한 번 다뤄보겠습니다. 

![ERD-GRAPH](../assets\ERD.PNG)

다뤄보기에 앞서, 위와 같은 `Entity graph`가 있다고 가정하겠습니다. 

첫번째로, 

```java
class MemberService {
    ...
    public void process() {
        Member member = memberDAO.find(memberId);
        member.getTeam();  // member->team 객체 그래프 탐색이 가능한가 ?
        member.getOrder().getDelivery(); // 그렇다면 ...??
    }
}
```

위 코드를 보면 JPA를 사용하지 않고, 기존 SQL Mapper를 통해 조회를 하게 된다면, 처음 `find(memberId)` 메소드를 실행할 때, 과연 어디까지 Join을 설정해야할 지 모를 것입니다... 그렇다고 모든 연관관계를 다 끌고 올라오는 것또한 매우 비효율적 일 것입니다... `예로 위에 테이블만 보더라도 족히 6개를 JOIN해야합니다..`

따라서, SQL의 범위에 따라 실제, 비즈니스 로직을 짜는 것이 굉장히 비효율적이라 생각이 되는데,,

**여기서 나온 개념이 바로 `JPA의 LAZY` 입니다** 

Lazy는 결국, 자신이 원하는 객체의 값이 필요할 때, Join해서 들고오는 것을 뜻합니다.

```java
// 처음 조회 시점에 SELECT MEMBER SQL
Member member = jpa.find(Member.class, memberId);

Order order = member.getOrder();
order.getOrderDate(); // Order를 사용하는 시점에 SELECT ORDER SQL
```

 

### 정리

- LAZY는 SQL Mapper의 종속된 개발에서 벗어나, 

  해당 객체가 필요한 시점에 Join을 하여 조회하는 JPA의 전략 중 하나. 