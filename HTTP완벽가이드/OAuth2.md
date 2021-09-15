# OAuth2



> 들어가기에 앞서, OAuth 를 이해하려면 결국 세 가지 관점에서 이해해야한다.
>
> 1. 사용자  - `User`
> 2. 서비스하려는 서버  - `Application`
> 3. 제 3의 서버 ( Google, Facebook, Kakao, Naver , ...)   - `3rd` 

> 가장 단순히, 만약 `Application` 입장에서 `User` 가 등록한 글을 `3rd`에 캘린더 같은 곳에 관련 부분을 기록하고 싶지 않나요 ?
>
> 그러기 위해서 `Application` 에서 `User` 의 ID, PW 를 모두 갖고 있다면 당연히 서비스를 제공할 수 있을 것입니다. 
>
> 이러한 상황에서 **OAuth** 를 이용한다면 상호작용과 안정성을 가져갈 수 있다!!

OAuth 를 이용하면 `3rd` 에 access Token을 `Application`  이 받을 수 있고,  그 `access Token` 으로 `3rd` 에 정보를 요청할 수 있다!



### 용어정리

- `3rd` --> `Resource Server` , `Authorization Server` 
- `User` --> `Resource Owner` 
- `Application` --> `Client` 



## 인증받는 방법

### 1. Resource Server 에 Client 가 OAuth 등록을 하면,

- `Resource Server` 에 `Client ID`, `Client PW` , `Redirect URL`  세 가지가 등록이 되고
- `Client` 에 `Client ID`, `Client PW`  두 가지가 저장이 된다



### 2. Client가 Owner에게 Server의 기능들을 사용하고 싶을 때

<img src="C:\Users\multicampus\AppData\Roaming\Typora\typora-user-images\image-20210915163335037.png" alt="image-20210915163335037" style="zoom:50%;" />

- 위 그림과 같은 화면은 만날 것이다. 위 화면은 단순히 로그인 화면 뿐 아니라, 

  해당 `Server` 에 필요한 기능들에 대한 권한 요청기능이다.

- 하나의 버튼에는 아래와 같은 정보들이 들어있다

  - `Client ID` : 서비스를 사용하고자 하는 Client의 ID
  - `Scope` : 어떤 기능을 사용할 것인지에 대한 정보
  - `Redirect URL` : 인증과 허가가 완료되면 응답을 보내줄 URL

- 만약, `Owner` 가 인증을 마무리한다면, 그 즉시 `Client` 에게 정보를 보내주지 않고,

  `Owner` 에게 `authorization code` 를 보내준다

  <img src="C:\Users\multicampus\AppData\Roaming\Typora\typora-user-images\image-20210915163927841.png" alt="image-20210915163927841" style="zoom: 67%;" />

> 위 그림은 인증이 완료된 `Owner` 에게 `Server` 가  HTTP Header 부분에 `Location` 을 담아서 `Owner` 의 웹브라우저로 하여금
>
> Redirection 하도록 명령하는 것입니다.  여기서 `authorization code` 는 임시 비밀번호같은 역할을 합니다.

---

<img src="C:\Users\multicampus\AppData\Roaming\Typora\typora-user-images\image-20210915164233421.png" alt="image-20210915164233421" style="zoom: 50%;" />

> 자연스럽게, `Owner` 가 `Client` 에게 해당 요청을 보내면서, **`Client`는 해당** **`authorization code` 를 저장**할 수 있습니다





<img src="C:\Users\multicampus\AppData\Roaming\Typora\typora-user-images\image-20210915164523380.png" alt="image-20210915164523380" style="zoom: 50%;" />

> 받은 `authorization code` 를 가지고 이제는 직접 `Server` 와 통신을 합니다. 
>
> 통신을 할 때, `authorization code`, `redirect URL`, `Client ID`, **`Client Secret`** 를 `Server` 에 넘겨주고
>
> `Server`는 해당 부분이 일치하는지 확인 후, **`access Token`** 을 발급합니다.



<img src="C:\Users\multicampus\AppData\Roaming\Typora\typora-user-images\image-20210915165026088.png" alt="image-20210915165026088" style="zoom:50%;" />

> 이제는 `Client` 가 `access Token` 으로 `Server` 와 통신할때, `access Token`으로 접근한다면,
>
> `user_id 가 1인`  Owner 의 `기능 b, c` 를 가능하게끔 하자 고 인식합니다.

 

