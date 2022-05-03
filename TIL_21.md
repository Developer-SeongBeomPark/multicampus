### Day 21(5/3 Tue)

---

[반응형 웹](#반응형-웹)

[반응형 CSS Units](#반응형-css-units)

[Javascript](#javascript)

[Data Type](#data-type)

[Operator](#operator)



#### CSS

---

##### 반응형 웹

```css
//적어도 스크린이 800px이상이면 container의 width를 50%로 해줘라
@media screen and (min-width: 800px){
   .container {
       width : 50%;
    }
}
```

- 유동적인 layout을 위해서 flex grid, flexbox, %, vw, vh등을 사용한다.





##### 반응형 CSS Units

1. em

   1em == 16px

   em은 부모의 폰트 사이즈의 상대적으로 크기가 계산된다.(parent 안에 child가 있을 경우)

   ```css
   .parent {
       font-size : 8em;  /* 16px * 8 = 128 px/   == 800%,  */
   }
   
   .child {
       font-size : 0.5em; /* 128px(부모) * 0.5 =  64px/ == 50%*/
   }
   ```

2. rem

   root에 지정된 폰트 사이즈에 따라 크기가 결정된다.(parent안에 child가 있을 경우)

   ```css
   .parent {
       font-size : 8rem;  /* 16px * 8 = 128 px
   }
   
   .child {
       font-size : 0.5rem; /* 16px(root) * 0.5 = 8px */
   }
   ```

3. vw

   viewport width(브라우저 너비)의 크기를 나타낸다.

   100vw는 viewport width 크기를 다 사용

4. vh

   viewport height(브라우저의 높이)의 크기를 나타낸다

5. vmin

   viewport의 withd와 height의 작은 값을 사용
   50vmin은 브라우저의 높이보다 너비가 작기 때문에 너비의 50 % 크기 값이 지정된다.

6. vmax

   viewport의 width와 height의 큰값을 사용
   50vmax는 브라우저의 높이가 너비보다 크기 때문에 높의 50% 크기 값이 지정된다.

7. %

   부모 요소에 상대적으로 크기가 계산되어진다.
   em대신에 %로 대신 지정할 수 있다.



- em / rem

  (1) em과 rem을 나누어 사용하는 기준

  \- 부모 요소의 사이즈에 따라서 사이즈가 변경이 되면 %나 em을 사용한다.
  \- 부모와 상관없이 브라우저 사이즈에 반응해야 한다면 뷰포트(v*)와 rem을 사용한다.

  \- 요소의 너비와 높이에 따라서 사이즈가 변경되야 한다면 %나 뷰포트(v*)을 사용한다.
  \- font 사이즈에 따라서 사이즈가 변경되야 한다면 em과 rem을 사용한다.



##### 실습

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Nav bar</title>
    <link rel="stylesheet" href="style.css">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@100&family=Source+Sans+Pro:wght@300&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/ef10e1d82d.js" crossorigin="anonymous"></script>
    <script src="main.js" defer></script>
</head>
<body>
    <nav class="navbar">
        <div class="navbar__log">
            <i class="fa-solid fa-cat"></i>
            <a href="#">ResponsiveCoding</a>
        </div>
        <ul class="navbar__menu">
           <li><a href="">Home</a></li>
           <li><a href="">Gallery</a></li>
           <li><a href="">Weddings</a></li>
           <li><a href="">FAQ</a></li>
           <li><a href="">Bookings</a></li>
        </ul>
        <ul class="navbar__icons">
            <li><i class="fa-brands fa-twitter"></i></li>
            <li><i class="fa-brands fa-facebook-f"></i></li>
        </ul>
 
        <a href="#" class="navbar__toggleBtn">
            <i class="fa-solid fa-bars"></i>
 
        </a>
    </nav>
</body>
</html>
```

```css
:root { /* 변수선언 */
    --text-color: #f0f4f5;
    --backround-color: #263343;
    --accent-color: #d49466;
  }
   
  body {
    margin: 0;
    font-family: 'Source Sans Pro';
  }
  a {
    text-decoration: none;
    color: var(--text-color);
  }
  .navbar {
    display: flex;
    justify-content: space-between;
    align-items: center;
    background-color: var(--backround-color);
    padding: 8px 12px;
  }
   
  .navbar__log {
    font-size: 24px;
    color: var(--text-color);
  }
   
  .navbar__log i {
    color: var(--accent-color);
  }
   
  .navbar__menu {
    display: flex;
    list-style: none;
    padding-left: 0;
  }
   
  .navbar__menu li {
    padding: 8px 12px;
  }
   
  .navbar__menu li:hover {
    background-color: var(--accent-color);
    border-radius: 4px;
  }
  .navbar__icons {
    list-style: none;
    color: var(--text-color);
    display: flex;
    padding-left: 0;
  }
   
  .navbar__icons li {
    padding: 8px 12px;
  }
   
  .navbar__toggleBtn {
    display: none;
    position: absolute;
    right: 32px;
    font-size: 24px;
    color: var(--accent-color);
  }
   
  @media screen and (max-width: 768px) {
    .navbar {
      flex-direction: column;
      align-items: flex-start;
      padding: 8px 24px;
    }
    .navbar__menu {
      display: none;
      flex-direction: column;
      align-items: center;
      width: 100%;
    }
    .navbar__menu li {
      width: 100%;
      text-align: center;
    }
    .navbar__icons {
      display: none;
      justify-content: center;
      width: 100%;
    }
    .navbar__toggleBtn {
      display: block;
    }
   
    .navbar__menu.active,
    .navbar__icons.active {
      display: flex;
    }
  }
```

```javascript
const toggleBtn = document.querySelector('.navbar__toggleBtn');
const menu = document.querySelector('.navbar__menu');
const icons = document.querySelector('.navbar__icons');
 
toggleBtn.addEventListener('click', () => {
    menu.classList.toggle('active');
    icons.classList.toggle('active');
});
```







#### Javascript

---

##### Data Type

■ primitive - 더이상 작은 단위로 나눠지지 않는 타입, single item

 \- number: 정수, 실수, 숫자 0으로 시작하는 8진수, 0x로 시작하는 16진수등을

​        저장할 수 있는 복합적인 데이터 타입이다.

 

 \- string : "" , ''를 이용해서 문자열을 표현한다. 또한 [template literals](https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Template_literals)도 문자열로 표현한다.


 \- boolean : true, false를 값으로 가지며, 0, null, undefined, NaN, '' 는 false로 해석되고
        그 외의 값은 true로 해석된다.
        [참조사이트](https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Global_Objects/Boolean)

 

 \- null: 데이터의 형식이 알려지지 않았거나 데이터가 없음을 나타내는데 사용한다.

 

 \- undefined: 변수를 선언후 데이터를 할당하지 않은 경우 갖는 값이다.

 \- symbol : 고유한 식별자가 필요할때 사용한다. 출력할때는 description 속성을 사용해서 
        string으로 변환해야 한다.




■ object : single item을 묶어서 한 단위나 box로 관리할 수 있다.

■ function : 함수는 작업을 수행하거나 값을 계산하는 문장 집합 같은 자바스크립트 절차
           함수를 사용하려면 함수를 호출하고자 하는 범위 내에서 함수를 정의해야한다.

 \- [함수](https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Functions)
 \- [화살표 함수](https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Functions/Arrow_functions)

```javascript
//1.use strict (added in ES 5)
'use strict';
//2.Variable 
//let (added in ES6)
let name =  '홍';
const maxNumber = 5;
console.log(name);

//3. Variable types
let a = 12;
let b = 12.1;
console.log(`value:${a}, type: ${typeof a}`)
console.log(`value:${b}, type: ${typeof b}`)

const infinity = 1/0;  //무한대
const negativeInfinity = -1/0;  //-무한대
const nAn = 'not a number' / 2; //nan
console.log(infinity);
console.log(negativeInfinity);
console.log(nAn)

//string
const char = 'c';
const brendan = 'brendan';
const greeting = 'hello' + 'brendan';
console.log(`value: ${greeting}, type:${typeof greeting}`)
const helloBob = `hi ${brendan}!`;//template literals(string)
console.log(`value: ${helloBob} type: ${typeof helloBob}`);
console.log('value: ' + helloBob + ' type: '+typeof helloBob);

// boolean
// false : 0, null, undefined, NaN, ''
// true : any other value

const canRead = true;
const test = 3 < 1;
console.log(`value: ${canRead}, type: ${typeof canRead}`)
console.log(`value: ${test}, type: ${typeof test}`)

//null : empty value

let nothing = null;
console.log(`value: ${nothing}, type: ${typeof nothing}`)

//undefined : 정해지지 않은 값
let x;
console.log(`value: ${x}, type: ${typeof x}`)

//symbol, create unique identifiers for objects , 고유식별자
const symbol1 = Symbol('id');
const symbol2 = Symbol('id');
console.log(symbol1 === symbol2)
const gsymbol1 = Symbol.for('id');
const gsymbol2 = Symbol.for('id');
console.log(gsymbol1 === gsymbol2)
console.log(`value: ${symbol1.description}, type: ${typeof symbol1}`)  //symbol를 문자열로 변환해서 출력
 
//Dynamic typing : dynamically typed language
let text = 'hello';
console.log(text.charAt(0)); //'h'
console.log(`value: ${text}, type: ${typeof text}`);
text = 1
console.log(`value: ${text}, type: ${typeof text}`);
 
text = '7' + 5; //+때문에 5가 문자열로 변환
console.log(`value: ${text}, type: ${typeof text}`);
text = '8' / '2'; // 8,2는 숫자로 변환
console.log(`value: ${text}, type: ${typeof text}`);
//console.log(text.charAt(0)); //오류

//object 
const obj = {name:'obj', age:20}
console.log(`name: ${obj.name}, age: ${obj.age}, type:${typeof obj}`)
```

##### Operator

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style type="text/css"> 
        *{ 
          font-family: gulim; 
          font-size: 22px; 
        } 
        </style> 
</head>
<body>
    <H2>연산자</H2>
<HR>
<script type="text/javascript">
  var i = 10;
  var j = 3;
 
  pl("더하기: " + (i + j));
  pl("빼기: " + (i - j));
  pl("곱하기: " + (i * j));
  pl("나누기: " + (i / j)); // 정수/정수=실수 (*)
  pl("나머지: " + (i % j));
 
  function pl(str){
    document.write(str + "<br><br>");
  }
 
</script>
</body>
</html>
```

```javascript
console.log('my' + ' dog');
console.log('1' + 2); // 2는 문자열로 변환
console.log(`string literals: 1 + 2 = ${1 + 2}`)
 
console.log( 1 + 1); 
console.log( 1 - 1);
console.log( 1 / 1);
console.log( 1 * 1);
console.log( 5 % 2); //나머지
console.log( 2 ** 3); //거듭제곱
 
let counter = 2;
const preIncrement = ++counter; //counter값이 먼저 증가된후  할당된다.
console.log(`preIncrement: ${preIncrement}, counter:${counter}`)
 
const postIncrement = counter++; //할당먼저 된후  counter값이 1증가한다.
console.log(`postIncrement : ${postIncrement }, counter:${counter}`)
 
//연산 후 할당연산
let x = 3;
let y = 6;
x += y; // x = x + y;
x -= y;
x /= y;
x *= y;
 
//비교연산
console.log(10 < 6);
console.log(10 <= 6);
console.log(10 > 6);
console.log(10 >=6);
 
//논리 연산  || (or), && (and), ! (not)
const value1 = true;
const value2 = 4 < 2;
 
// or  연산 (첫번째 값이 true이면 뒤에 두개는 확인하지 않는다 check()함수 실행 안함)
console.log(`or: ${value1 || value2 || check()}`);
 
// and 연산 (check() 처럼 내용이 긴 경우 마지막 비교 부분에 넣는것이 좋다.)
console.log(`and: ${value1 && value2 && check()}`); 
 
//객체가 널 인지 확인후 널이 안닐경우만 객체의 속성이나 함수를 호출한다.
// if(nullableObject != null){
//     nullableObject.something;
// }
 
function check(){
    for (let i = 0; i < 10; i++) {
        console.log('wating ?');
    }
    return true;
}
 
// !(not)
console.log(!value1)
 
 
//Equality (==, ===)
const stringfive = '5';
const numberfive = 5;
 
//== loose equality, with type conversion (타입변환을 사용한 약한 비교)
console.log(stringfive == numberfive);
console.log(stringfive != numberfive);
 
//=== strict equality, no type convrsion(타입변환을 하지 않는 엄격한 비교)
console.log(stringfive === numberfive);
console.log(stringfive !== numberfive);
 
// object equality by reference
const js1 = {name:'js'};
const js2 = {name:'js'};
const js3 = js1;
console.log(js1 == js2);
console.log(js1 === js2)
console.log(js1 === js3)

//equality 확인 
console.log(0 == false);
console.log(0 === false);
console.log('' == false);
console.log('' === false);
console.log(null == undefined);
console.log(null === undefined);

```

