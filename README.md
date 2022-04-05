# multicampus

## TIL

### Day 1 (4/4 Mon)
```
String str = "data";
int a = 10;
```
* 기본 자료형의 경우, 해당 변수에 a = 10과 같은 값이 들어가 있고 참조형 변수의 경우, heap에 "data"가 저장되어있고 str이라는 객체가 이를 가르키게 된다. 변수 str에는 hashcode 값이 직접적으로 들어가 있다.


### Day 2 (4/5 Tue)
* 다차원 배열은 1차원 배열의 합이다.
ex)
```
String[] arr = new String[2][3];
```
Stack에 arr이 저장되고 Heap에 크기가 2인 배열 a와 크기가 3인 배열 b와 c가 생성된다.<br>
배열 a[0]은 배열 b[0]을 가리키게 되고 a[1]은 c[0]을 가리키게 된다.<br>
따라서 n차원 배열은 n값이 커짐에 따라 사용되는 메모리가 더 많아진다.
