# Synchronize 예제



>c 코드를 보여주면서 
>어떤 두개의 쓰레드가 있다. 
>int value = 0; 전역변수로 있고
>
>thread{
>for i in range(5억):
>	value += 2
>}
>
>thread1 = new()
>thread2 = new()
>thread1.start()
>thread2.start()
>
>print( c out 'value' ) 
>이 쓰레드의 역할은 1부터 5억까지 2를 증가시키는 코드.

## 쓰레드를 두 개 썼을때의 값이 20억이 예상되나 실제로는 19억 ... 18억 ....

>  쓰레드를 3개 썼을때는 33억 ... 32억 ...  왜그런가 ?

## 이것의 작동 원리는 ? ( 힌트 숫자가 어떻게 더해지는지 아세요 ? )

​	register에 주소에 있는 값을 불러오고

   register 에 더하고

   다시 주소에 할당한다. 

   Context Switch 가 언제 발생할지 몰라 할당된 이후인지 할당되기 전인지 확실하게 알 수 없다.

   따라서 예상되는 값보다 다른 값이 나온다.











## TLS ?

> 네트워크에서 패키지를 주고받는 과정을 생각해보면 굉장히 많은 부분에서 원래 보내고자하는 
>
> 내용과 다른 내용이 전송될 수 있고, 위조된 내용을 받을 수 있는 등
>
>  보안 상의 문제를 해결하고자 나타난것이 `TLS` 이다.

- TLS 란
  - Transport Layer Security, 전송계층보안
  - 응용계층 데이터의 암호화, 복호화
  - TCP 443



- TLS 가 제공하는 기능 3 가지
  - 암호화 ( Encryption)
  - 인증 ( Authentication )
  - 무결성 ( Integrity )



- TLS, SSL