## HTML / CSS





![image-20210203131139156](C:\Users\Sang Jin Han\AppData\Roaming\Typora\typora-user-images\image-20210203131139156.png)



### Flex에 대하여.

- `justify-content`
- `align-items`
- `flex-direction`
- `order`
- `align-self`
- `flex-wrap`
- `flex-flow`
- `align-content`



#### Flex의 속성들

1. ##### display: flex; 

   해당 스타일이 flex라는 것을 처음 지정해주는 문구

   

2. ##### justify-content : [ flex-start(default), flex-end, center, space-between, space-around ]

   - flex-start, flex-end

     - start는 주축을 기준으로 처음, end는 끝에 위치시킴

     

   - center

     - 너무 당연하게도 가운데 정렬

     

   - space-between 과  space-around

     - 둘다 공간을 기준으로 나누는건 비슷하지만

       space-between =  [ * |   |   |   | *  ]        양쪽을 꽉 채워서 정렬

       space-around    =  [   | * |   | * |   ]         일정한 간격으로 정렬

       

3. ##### align-items : [ flex-start, flex-end, center, baseline, stretch(default) ]

4. ##### flex-direction : [ row, row-reverse, column, column-reverse ]

5. ##### order : [ -1, 0, ... (int) ]

6. ##### align-self : [ flex-start, flex-end, center, baseline, stretch ]

7. ##### flex-wrap : [ nowrap(default), wrap, wrap-reverse ]

8. ##### flex-flow : [ flex-direction, flex-wrap ]

9. ##### align-content : [ flex-start, flex-end, center, space-between, space-around, stretch(default) ]