# Raw 타입은 사용하지 마라



제네릭이란 ? 

- 클래스와 인터페이스 선언에 타입 매개변수가 쓰이는 것.

​		예 ) List<E> , E : 제네릭

제네릭 타입하나를 정의하게 되면 그에 딸린 `Raw Type` 도 함께 정의됩니다.



Raw 타입이란 ? 

- 제네릭 타입에서 매개변수를 전혀 사용하지 않는 때를 말합니다. 

​		예) List<E> 의 Raw 타입은  List 가 됩니다.



##### Raw타입을 사용하게 되면 Compile 시점에서는 잡지 못하는 에러가 발생할 수 있다

```java
public class Temp {
  
  // Stamp 를 담는 Collection
  private static final Collection stamps = ... ;  /// .... (1) 
  
  public static void main(String[] args) {

        // 실수로 동전을 넣는다
        stamps.add(new Coin()); /// ... (2)

        for (Iterator i = stamps.iterator(); i.hasNext(); ) {
            Stamp stamp = (Stamp) i.next(); // 캐스팅 시 에러발생!
            stamp.cancel();
        }
    }  
}
```



따라서,  `(1)` 에서 **Collection** 대신 **Collection<Stamp>** 를 사용하면, `(2)` 에서 컴파일 오류를 던져줄 것 입니다. 

<img src="/Users/hansangjin/Library/Application Support/typora-user-images/image-20221126192852141.png" alt="image-20221126192852141" style="zoom:50%;" />

​																											*인텔리제이 친절하네요 ...*



##### Raw타입을 사용하게되면, 제네릭이 안겨주는 안정성, 표현력을 모두 잃게 됩니다.

절대 써서는 안되는 Raw 타입을 왜 만들어 놨을까요 ? 

그 이유는, 바로 제네릭이 만들어지기전, 작성되었던 코드들을 모두 수용할 수 있어야하기 때문입니다 ㅜ 

기존 코드를 모두 수용하면서, 제네릭을 사용하는 모든 코드들과도 맞물려 돌아가게 해야하기때문이죠.



List 같은 Raw 타입은 사용해선 안되나, List<Object> 처럼 임의 객체를 허용하는 매개변수는 괜찮습니다.



여기서 또 하나 알게된 용어는 바로 **와일드 카드** 입니다.

제네릭에서 사용되는 와일드카드는 바로, `?`  입니다. 



**아까 Collection Raw 타입으로 확인해보겠습니다.** 

```java
Colletion c = ...  ; // String 만 받고싶은 Collection인데,

c.add(Integer.valueOf(42));  // Integer 를 추가한다면 ? 
```

Complie 시점에는 에러가 발생하지 않습니다. 그 이유는, *Collection 이 Raw 타입이기 때문입니다.*



해당 코드를 어떻게하면, 불변식을 유지하도록 할 수 있을까요 ?  방법은 다음과 같습니다.

```java
Colletion<?> c = ...  ; // 제네릭에 "?" 와일드 카드 사용

c.add(Integer.valueOf(42)); // 절대 Collection c 에 추가되지 않습니다. **null 제외
```

이렇게 된다면, Collection c 에 `null`이외의 값은 아무것도 들어가지 않습니다.



---

### 정리하자면,

Raw 타입은 결국 제네릭이 생기기 이전에 코드와 맞물려 동작하기 위해 만들어진 타입이고,

절대 Raw 타입을 사용하지 말고, 제네릭으로 명시하는 것이 중요합니다.
