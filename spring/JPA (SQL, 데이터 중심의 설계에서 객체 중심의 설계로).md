## JPA (SQL, 데이터 중심의 설계에서 객체 중심의 설계로)

*<u>JPA는 인터페이스로 표준 라이브러리, 구현은 여러 곳에서 구현</u>*



> ### SETTING(설정)

- `build.gradle`
  - `implementation 'org.springframework.boot:spring-boot-starter-data-jpa'` 추가



- `application.properties` 
  - `spring.jpa.show-sql=true` 추가
  - `spring.jpa.hibernate.ddl-auto=none`, 
    -  `none` 대신 `create` 라 하면 DB에 객체 테이블을 알아서 생성해줌

---



> ### Anotation

- ##### `domain.Member` 클래스

  ```java
  @Entity
  public class Member {
      
      @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;
      
      @Column(name = "username")  // 만약 데이터베이스 내의 컬럼이름이 다를경우
      private String name;
      
      ...
  }
  ```

  - `@Entity` : 클래스 위에 설정되며, JPA가 관리하는 도메인 설정할 때,

  - `@ID @GeneratedValue` : column에 pk를 의미하며 자동으로 증가하는 전략 - IDENTITY

    

- ##### `repository.JpaMemberRepository`  클래스

  ```java
   public class JpaMemberRepository implements MemberRepository{
       
       private final EntityManager em;
       
       public JpaMemberRepository(EntityManager em){
       // Repository내에 선언한 이후 스프링에서 올라오는 EntityManager를 생성자로 주입
           this.em = em    }
       
       @Override
       public Member save(Member member) {
           em.persist(member);
           return member;
       }
       
       @Override
       public Oprional<Member> findById(Long id) {
           Member member = em.find(Member.class, id);
           return Optional.ofNullable(member);
       }
       
       @Override
       public Optional<Member> findByName(String name) {
           
       }
       ...
       
   }
  ```

  - 주의할 점. JPA를 사용하는 Service층이나 다른 곳에서는 항상  `@Transactional` 이 필요함.



