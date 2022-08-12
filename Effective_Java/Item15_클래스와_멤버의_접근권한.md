# Item15. 클래스와 멤버의 접근 권한을 최소화하라



### Public 클래스의 인스턴스 필드는 되도록 public이 아니어야 한다.

필드가 가변 객체를 참조하거나, final이 아닌 인스턴스 필드를 public으로 선언하면 그 필드에 담을 수 있는 값을 제한할 힘을 잃게 된다.그 필드와 관련된 모든 불변식을 보장할 수 없게된다. 

**추가로, 필드가 수정될 때 ( Lock 같은 ), 다른 작업을 할 수 없게 되므로 public 가변필드를 갖는 클래스는 일반적으로 스레드 안전하지 않다. 

정적필드도 마찬가지이나, 예외가 하나있다. 

클래스가 표현하는 추상 개념을 완성하는데 꼭 필요한 구성요소로써의 상수라면 `public static final` 필드로 공개해도 좋다. 이런 필드는 반드시 기본 타입 값이나 불변 객체를 참조해야 한다. 가변 객첼르 참조한다면 final이 아닌 필드에 적용되는 모든 불이익이 그대로 적용된다.

길이가 0이 아닌 배열은 모두 변경 가능하니 주의하자. 따라서 클래스에서 public static final 필드를 두거나 이 필드를 반환하는 접근자 메서드를 제공해서는 안된다. 예컨데, 다음 코드에는 허점이 존재한다.

```java
// 보안 허점이 숨어 있다.
public static final Thing[] VALUES = {...};
```

위 코드의 해결책은 두 가지이다.

1. public 배열을 private으로 만들고, public 불변 리스트를 추가하는 것

   ```java
   private static final Thing[] PRIVATE_VALUES = { ... };
   public static final List<Thing> VALUES = 
     Collections.unmodifiableList(Arrays.asList(PRIVATE_VALUES));
   ```

2. 배열을 private으로 만들고, 그 복사본을 반환하는 public 메서드를 추가( 방어적 복사 )

   ```java
   private static final Thing[] PRIVATE_VALUES = { ... };
   public static final Thing[] values() {
     return PRIVATE_VALUES.clone();
   }
   ```



#### 자바 9에서는 모듈 시스템이라는 개념이 도입되면서 두 가지 암묵적 접근 수준이 추가되었다.

패키지가 클래스들의 묶음이듯, 모듈은 패키지들의 묶음이다. 

모듈은 자신에 속한 패키지 중 공개할 것들을 관례상 `module-info.java` 파일에 선언한다.

protected 혹은 public멤버라도 해당 패키지를 공개하지 않았다면 모듈 외부에서는 접근할 수 없다. 물론 모듈 안에서는 exports로 선언했는지 여부에 아무런 영향도 받지 않는다. 

#### 앞서 다룬 4가지 기존 접근 수준과 달리, 모듈에 적용되는 새로운 두 접근 수준은 상당히 주의해서 사용해야한다.

 여러분 모듈의 JAR파일을 자신의 모듈경로가 아닌 애플리케이션의 클래스패스에 도무녀 그 모듈안의 모든 패키지는 마치 모듈이 없는 것처럼 행동한다. 이러한 방법을 적용시킨 것이 바로 **JDK** 그 자체다. 자바 라이브러리에서 공개하지 않은 패키지들은 해당 모듈 밖에서는 절대로 접근할 수 없다.