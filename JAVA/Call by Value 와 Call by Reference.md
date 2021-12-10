# Call by Value 와 Call by Reference

많이 들어는 봤었지만, 정확히는 알지 못하던 개념을 정리해보려고 합니다..!



먼저, call by value, call by reference 모두 메서드에 인자를 전달할 때, 사용되는 말입니다. 



**Call by Value는** 인자를 전달할 때, 값을 전달하는 방식이다.

**Call by Reference는** 인자를 전달할 때, 참조하는 객체를 전달하는 방식이다.



두 가지의 차이를 알아보자.

```java
class Member {
    String name;

    Member(String name) {
        this.name = name;
    }
}

public class Main {

    public static void main(String[] args) {

        Member member1 = new Member("Member1");
        Member member2 = new Member("Member2");

        System.out.println("member1.name = " + member1.name);  // Line1
        System.out.println("member2.name = " + member2.name);  // Line2
        System.out.println("============================ after swap");
        swap(member1, member2);
        System.out.println("member1.name = " + member1.name);  // Line3
        System.out.println("member2.name = " + member2.name);  // Line4
    }
    // 두 Member의 이름을 SWAP하는 메서드
    public static void swap(Member member1, Member member2) {
        String name = member1.name;
        member1.name = member2.name;
        member2.name = name;
    }
```

먼저 위의 코드를 이해해보자면, Member 클래스의 name 변수를 가지고 있는데, 

해당 swap 메소드를 실행시킨 이후에 실행결과를 먼저 보겠습니다!





![img](https://blog.kakaocdn.net/dn/uBxpK/btrnBLT2KeV/SylO38gCG2Wxgtflgdkkb1/img.png)실행결과 화면

***그렇다면, 다음 코드의 결과는 어떨까 ?\***

```java
class Member { ... }

public class Main {

    public static void main(String[] args) {

        Member member1 = new Member("Member1");
        Member member2 = new Member("Member2");

        System.out.println("member1.name = " + member1.name);
        System.out.println("member2.name = " + member2.name);
        change(member1, member2);
        System.out.println("============== Change 메서드 실행!!!");
        System.out.println("member1.name = " + member1.name);
        System.out.println("member2.name = " + member2.name);

    }
    // 두 멤버의 이름을 Change 하는 메서드
    public static void change(Member copyMember1, Member copyMember2) {
        copyMember1.name = "변경된_Name";  // Line1
        copyMember2 = copyMember1;            // Line2
    }
}
```

```html
<details>
<summary>한 번 생각해보시고 해당 결과를 눌러보세요!

    <details>
    <summary>접기/펼치기 버튼</summary>
    <div markdown="1">
        ![img](https://blog.kakaocdn.net/dn/cohCym/btrnAYmogJY/TGReTlFQmWKPo3Geo1jt0k/img.png)
        
    맞추셨나요 ?? 맞추셨다면 정말 대단하십니다..!!

※프로그램 동작 순서

주된 메소드인 Change 메소드만 다루겠습니다.

먼저, 각각의 copyMember1, copyMember2는 Call by Value로 객체의 주소값을 복사해 가지고 있을 것 입니다.

 - Line1 에서는 copyMember1이 member1의 주소값을 참조하고 있는 상태에서 name 값을 바꿨으니,

  원래 Main 함수의 member1의 name 또한 변경되었을 것입니다.

 - Line2 에서는 member2의 주소값을 참조하고 있는 복사된 값, copyMember2 의 주소를 copyMember1의 주소   로 바뀌는 것을 의미합니다. 결국, Main 함수의 member2의 name에는 아무런 영향이 없는 것이죠.



해당 동작순서를 JVM을 통하여 정리해놓은 POST가 있으니 보시면 도움이 될 것입니다!

https://deveric.tistory.com/92

[
Java] Java는 Call by reference가 없다Call by Value와 Call By Reference가 뭘까? 프로그래밍을 하다 보면 꼭 알고 넘어가야 하는 개념이 있습니다. 바로 Call By Value, Reference입니다. 어떤 언어를 공부하든 나오는 개념이기도 합니다. Call by va..deveric.tistory.com

https://kim-jong-hyun.tistory.com/81#comment21371056

[
JAVA] - Call By Value vs Call By ReferenceJava에서 메서드를 호출할 때 인자를 넘기는 방법은 Call By Value와 Call By Reference두가지가 있다. Call By Value는 값에 의한 호출이며 메서드로 인자값을 넘길 때 그 값을 복사해서 넘긴다. 이 방식으로kim-jong-hyun.tistory.com





    
    </div>
    </details>
</summary>
<div markdown="1">

|제목|내용|
|--|--|
|1|1|
|2|10|

</div>
</details>
```



이상 Call By Value 와 Call By Reference의 정리였습니다! 



**감사합니다** :)