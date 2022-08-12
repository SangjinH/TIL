# Item9. try-finally 대신, try-resource 를 사용해라



자바 라이브러리에는 `close` 메소드를 사용해야하는 자원이 많다. 

- InputStream
- OutputStream
- java.sql.Connecion



# Item10. equals는 일반 규약을 지켜 재정의하라.

우리가 보통 equals 메소드를 재정의 하는 경우는 많이 없다. 사실 내가 안해서 그런지도 모른다.. ㅎ 

정의하지 않는다면, 해당 인스턴스가 같은 경우( 원래 equals ), 오직 자기 자신과만 같다.

그렇다면, 필자는 왜 equals메소드를 재정의하는 것보다 정의하지 않는 것이 좋다고 권유할까.

1. 각 인스턴스가 본질적으로 고유하다.

   - 값을 표현하는 것이 아닌, 동작하는 개체를 표현하는 클래스가 여기 속한다. ex) Thread 

2. 인스턴스의 '논리적 동시성' 을 검사할 일이 없다.

3. 상위 클래스에서 재정의한 equals메소드가 하위 클래스에도 딱 들어맞는다.

   - 대부분의 List 구현체는 AbstractList로부터, Set 구현체는 AbstractSet으로부터 상속받아 그대로 쓴다.

4. 클래스가 private이거나 package-private하고 equals메소드를 호출할 일이 없다.

   - 만약에 위험을 회피하고 싶다면 다음과 같이 재정의해두자

   - ```java
     @Override public boolean equals(Object o) {
       throw new AssertionError(); // 호출금지!!
     }
     ```



그렇다면, 언제 equals메소드를 재정의 해야할까 ?

- 