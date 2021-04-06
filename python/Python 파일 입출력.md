# Python 파일 입출력



## 파일을 읽고 쓰기

`open` 이라는 함수를 쓸 것

예) ` f = open('filename', 'mode')` 

- ' filename ' : 열고자하는 파일의 이름
- ' mode ' : ' r ' - read , ' w ' - write , ...

json 파일을 open 하면 Wrapper로 반환하기때문에 json을 dictionary로 변환해야함

`json.load('jsonfile', encoding = 'utf-8')` , 추가로 `encoding = 'utf-8'` 은 한글도 표현할 수 있게끔.



