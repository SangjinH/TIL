# 1.6 불필요한 객체 생성을 피하라



똑같은 기능을 재사용할시에는 객체를 매번 생성하는 것보다 
하나의 객체를 재사용하는 것이 편리할 때가 많다. Util 성 class.

다음의 예는 절대로 하지 말아야할 예시이다.

```java
String s = new String("bikini");
```

위 코드는 실행될 때마다, 새로운 `String` 객체를 만들어낸다. 이는 매우 불필요한 자원의 낭비를 초래한다.

따라서, 아래의 코드처럼 바꿀 수 있을 것이다.

```java
String s = "bikini"; 
```

이렇게 된다면, 전에 배웠던 팩토리 메서드로 객체의 불변성 또한 보장할 수 있을 것이다.

마찬가지로, 불필요한 객체를 생성하는 대신, 정적 팩토리 메서드를 사용한다면 비용을 절감할 수 있을 것 이다.

```java
// 생성자 wrapper class 대신
Boolean(String);

// 정적 팩토리 메서드
Boolean.valueOf(String) 
```



- 또한 생성할 때, **비싼 비용이 드는 객체**도 있을 것이다.

```java
static boolean isRomanNumeral(String s) {
    return s.matches( .... );
}
```

 위 방법의 문제점은 `String.matches()`를 사용하는데 있다. 

해당 메서드(matches) 내부에는 정규표현식을 사용하기위한 Pattern 인스턴스가 사용된다. 

이 Pattern 인스턴스를 사용하기 위해서는 상당히 많은 생성 비용이 요구되므로, 성능이 중요시되는 서비스에서는 치명적일 것이다.

따라서, 비용을 많이 소모하는 생성비용을 class 초기화 과정에서 캐싱해두고 해당 인스턴스를 필요할때마다 사용하는 방식을 사용하겠다.



```java
public class RomanNumerals {
    private static final Pattern ROMAN = Pattern.compile(...);
  
    static boolean isRomanNumeral(String s) {
      return ROMAN.matcher(s).matches();
    }
}
```

여기서도, 하나의 단점은 존재한다. 그것은 바로 `해당 class를 초기화할때 생성되고 사용하지 않는다면 ?` 이다.

이는 분명한 단점이 될 수 있고, 이를 최대한 사용할때까지 미루는 Lazy 로딩이 있지만 크게 권장하지 않는다..



다음으로는 불필요한 객체를 만들어내는 것 중 하나인 `오토박싱`이다. 다음의 예를 보자.

```java
private static long sum() {
    Long sum = 0L;
  	for ( long i = 0; i <= Integer.MAX_VALUE; i++ ) {
        sum += i;
    }
}
```

위 코드는 매우 정확한 결과를 return하게 될 것이다.

그러나 여기에는 꽤나 큰 단점이 존재한다.  그것은 바로,

기본타입이 아닌 `Long` 때문이다. 

- 기본 `long`타입인 `i` 가, `Long`타입인 `sum`에 더해질때마다 새로운 객체가 생성될 것이다.

따라서 `Long` 타입 `sum`을 `long`으로 바꿔주는 것만으로도 큰 차이를 가져올 수 있다. 저자는 약 6.5배(?)의 효과를 봤다고한다 ..

<img src="/Users/hansangjin/Library/Application Support/typora-user-images/image-20220722003721710.png" alt="image-20220722003721710" style="zoom:33%;" />

> 맥북 m1pro기준으로 약 5배 가까운 성능을 보이니, 생각보다 유의미한 차이가 있는 것으로 판단이 된다..