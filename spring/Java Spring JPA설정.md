> 오늘 공부한 목록
>
> 1. 알고리즘 (삼각형 DP)
> 2. JAVA spring JPA



# Java Spring JPA설정

- repository.SpringDataJpa

```java
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository{
    
    @Override
    Optional<Member> findByname(String name);
}
```

SpringDataJpa는 Interface로 구현하고, `JpaRepository` 와 `MemberRepository` 구현할 메서드가 있는 인터페이스 repository를 동시에 상속하고, 메서드를 선언만 해주면 됨.



- java.SpringConfig ( Bean 등록 파일 )

```java
@Configuration
public class SpringConfig {
    
    private final MemberRepository memberRepository;
    
    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
}
```

얼핏보면 인터페이스인 `MemberRepository` 를 어떻게 주입할 수 있을까 생각하지만 위에 `SpringDataJpa`를 상속받을 때, 그에 해당하는 JpaRespository를 통해 자동으로 DI 를 해줌. 따라서 생성자 주입만 해주면 된다. 매우 편리함..



