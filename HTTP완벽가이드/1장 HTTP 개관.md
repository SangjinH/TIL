

# 1장 HTTP 개관

## 1. 웹 클라이언트와 서버

<img src="https://yurimkoo.github.io/assets/img/http-1-1/1-1.png" alt="HTTP 완벽 가이드 [1-1] - HTTP 개관" style="zoom:50%;" />

- 위 그림에서 볼 수 있듯이, 

  `클라이언트` 가 서버에게 `HTTP 요청`을 보내고, 

  `서버` 는 요청된 데이터를 `HTTP 응답` 으로 돌려준다.

## 2. 리소스

- Mime ( Multipurpose Internet Mail Extensions )
  - Mime을 통하여 어떤 타입의 데이터 인지 확인할 수 있고, 사선( / ) 으로 구분되며 주 타입, 부 타입으로 구분됨
    - `application/json` , `multipart/formdata` , `text/html` ...
- URI ( uniform resource identifier ), URL ( uniform resource locator )
  - 서버에서의 Resource의 위치를 나타내는 방법
    - `http://www.joes-hardware.com/specials/saw-blade.gif` 



## 3. Transaction ( 트랜잭션 )

- 트랜잭션 중에서도 HTTP 트랜잭션은

  >1. 요청 명령 ( 클라이언트 > 서버 )
  >
  >2. 응답 결과 ( 서버 > 클라이언트 ) 로 이루어 지는데
  >
  >   이 때, 반환으로는 정형화된 데이터를 반환해준다.

  - 메서드
    - GET, PUT, DELETE, POST, HEAD 
  - 상태코드
    - 200 좋다
    - 302 다시 보내라, 다른 곳에가서 리소스를 가져가라
    - 404 없다. 리소스를 찾을 수 없다.
  - 또한 웹페이지는 여러 HTTP 트랜잭션을 수행하기도 한다.



## 4. 메시지

- HTTP 메시지는 일반 텍스트 형식의 데이터이다. 따라서 사람이 읽기 쉬운 형태를 갖는다.

  

1. HTTP 메세지의 구성

   - 시작줄 :  요청이라면 무엇을 해야하는지, 응답이라면 무슨 일이 일어났는지
   - 헤더
     - 0 개 이상의 헤더가 이어짐
     - ` : `으로 구분이 됨
     - 빈 줄로 끝남
   - 본문
     - 어떤 종류의 데이터든 들어갈 수 있는 메시지 본문
     - 요청 : 데이터를 실어 보냄 / 응답 : 클라이언트로 데이터를 보냄 

   <img src="https://t1.daumcdn.net/cfile/tistory/21282E3B554A0A1B2C" alt="http request message"  />



## 5. TCP 커넥션

- TCP 란 
  - `Transmission Control Protocol , 전송 제어 프로토콜` 



>  	그렇다면 어떻게 메세지가 TCP 커넥션을 통해 한 곳에서 다른 곳으로 옮겨가는지 확인해보자

​	먼저, HTTP 는 `애플리케이션 계층` 프로토콜 이다. 따라서 `네트워크 통신` 의 세부사항에 대해선 신경쓰지않고, 

​	이 부분들을 `TCP/IP` 에게 맡긴다. `TCP` 는 `오류없는 데이터전송`, `순서에 맞는 전달`, `조각나지 않는 데이터`를 제공한다.



-  접속, IP주소, 포트번호

  - HTTP 클라이언트가 서버에 메세지를 전송하기 전에, IP 주소와 포트번호를 사용해 클라이언트와 서버 사이에 TCP/IP 커넥션을 맺어야한다. 

  > 그렇다면 어떻게 HTTP 서버의 IP 주소와 포트번호를 알 수 있을까 ? 
  >
  > - `URL` 을 이용함
  >
  >   1. `http://207.200.83.29:80/index.html`
  >   2. `http://www.netscape.com:80/index.html`
  >   3. `http://www.netscape.com/index.html` 
  >
  >   위 세가지 주소에서 
  >
  >   ​	첫번째로 `IP주소 207.200.83.29` 에 `포트번호 80`번을 찾아가 index.html 리소스를 가져온다. 
  >
  >   ​	두번째로 `www.netscape.com` 이라는 주소는 DNS( Domain Name Service (포트번호:53) ) 를 통해 쉽게 IP주소로 변환이 된다.
  >
  >   ​	세번째로 포트번호가 없는 경우는 기본값 80(HTTP), 443(HTTPS) 이라고 생각하면 된다.



### HTTP 요청과정

	1. 웹브라우저가 URL 에서 `호스트 명을 호출` 
	2. 웹브라우저가 서버의 호스트명을 `IP주소로 변환 ( DNS 이용 )`
	3. 웹브라우저가 `(포트번호가 있다면) 포트 번호 추출` 
	4. 웹브라우저가 웹서버와 `TCP 커넥션 형성`
	5. 웹브라우저가 웹서버에 `HTTP 요청`
	6. 서버가 웹브라우저에게 `HTTP 응답`
	7. 커넥션이 닫히면 웹브라우저는 문서를 보여준다



## 6. 웹의 구성요소 

- **프락시**

  - 클라이언트와 서버사이에 위치한 HTTP 중재자
  - `웹 보안`, `애플리케이션 통합`, `성능 최적화`를 위한 중요한 구성요소
  - <img src="https://img1.daumcdn.net/thumb/R720x0.q80/?scode=mtistory2&fname=http%3A%2F%2Fcfile23.uf.tistory.com%2Fimage%2F996F8D455A5049630B9408" alt="프록시(Proxy)란 무엇인가?" style="zoom: 50%;" />
- 사용자를 대신해 서버에 접근함 
  - 주로 보안을 담당하는 역할을 함, `신뢰할만한 중재자`
  - Forward Proxy, NginX( reverse Proxy ) 파이썬 언어가 아니라 조금 더 빠른 처리속도, wsgi

  

- **캐시**
  
  - 많이 찾는 웹페이지를 클라이언트 가까이에 보관하는 HTTP 창고
  - `웹 캐시`, `캐시 프락시` 
    - 자신을 거쳐가는 문서들 중 `자주 찾는 것의 사본을 저장`하는 특별한 종류의 프락시 서버



- **게이트웨이**

  - 다른 애플리케이션과 연결된 특별한 웹 서버

  - 다른 서버들의 중개자의 역할

  - 주로, `HTTP 트래픽을 다른 프로토콜로 변환하기 위해` 사용됨

  - `HTTP 를 FTP 로 변환하는 GATEWAY`

    <img src="https://blog.kakaocdn.net/dn/qFLyD/btq3UkPNAGZ/D6Fen5xwHhMM5KbslETdrk/img.png" alt="1. HTTP 개관" style="zoom:50%;" />



- **터널**
  - 단순히 HTTP 통신을 전달하기만하는 특별한 프락시
- **에이전트**
  - 자동화된 HTTP 요청을 만드는 준지능적 웹클라이언트