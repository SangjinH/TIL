# 자바를 이용한 세션 로그인 구현

---



## 순서

1. Java.util 의 UUID 를 이용하여 임의의 `sessionId` 를 생성한다.

2. 생성한` sessionId` 를 Key로 갖고 해당 `Member` 를 Value로 갖는 Table(Map) 에 저장한다. 

   - | Key ( SessionId )   | Value ( Member 객체) |
     | ------------------- | -------------------- |
     | asdhf123asldkjfh123 | Member()             |
     | asdnfnjqhwjk23najsn | Member()             |
     | ...                 | ...                  |

     

3. HttpServletResponse에 쿠키를 담아준다 
   - 쿠키의 Key 는 `mySessionId` , Value 는 `ashdkfjlhadh123kjshfka` 