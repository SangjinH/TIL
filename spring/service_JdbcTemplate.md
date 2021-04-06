# ***2021.01.19 스프링공부***

> #### 순수 Jdbc를 이용한 Service

#### MemberServiceIntegration (테스트케이스 작성시)

- 스프링통합 테스트케이스를 만들 때는 ( Spring과 관련된 테스트 작성시 )

  - ``` java
    @SpringBootTest
    @Transactional
    class MemberServiceIntegrationTest ...
    ```

  - `@SpringBootTest` 와 `@Transactional` 을 추가로 입력

- memberservice를 주입받을 때, 생성자 주입을 받을 수도 있지만, 

  test는 `@Autowired` 를 사용해도 괜찮음



#### @Transactional의 역할

- 이전에 `@BeforeEach`와 `@AfterEach`로 DB를 새로 만들었지만,

  Transactional은 자동으로 rollback을 제공함, 따라서 모든 테스트를 개별로 진행할 수 있음

---

> #### JdbcTemplate을 사용한 Repository



- 생성자 주입을 해줘야함 

```java
private final JdbcTemplate jdbcTemplate;

@Autowired
public JdbcTemplateRepository(DataSource dataSource) {
    this.jdbcTemplate = new JdbcTemplate(dataSource);
}
```



- 객체를 받는 Rowmapper가 필요함

```java
private RowMapper<Member> memberRowMapper() {
    return new RowMapper<Member>() {
        @Override
        public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
            
            Member member = new Member();
            member.setId(rs.getLong("id")) // 각 객체별 parameter로 결정
            memger.setName(rs.getString("name"))
                
            return member;
        }
    }
}
```





- 예제


``` java
  @Override
  public Optional<Member> findById(Long id) {
      List<Member> result = jdbcTemplate.query("select * from member where id = ?", memberRowMapper(), id);
          return result.stream().findAny();
      }
  
  @Override
  public Optional<Member> findByName(String name) {
      List<Member> result = jdbcTemplate.query("select * from member where name = ?", memberRowMapper(), name);
      return result.stream().findAny();
```

  