### DAY 23(5/9 Mon)

---

[함수 활용하기](#함수-활용하기)

[객체(Object)](#객체)

[배열](#배열)



##### 함수 활용하기

Math의 함수

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
    <script src="./utility.js"></script>
 
</head>
<body>
    <h2>Math.round, Math.pow 함수 사용</h2>
    <hr>
    <script>
        pl(Math.round(3.4595));
        pl(Math.round(3.5595));
        p('<hr>');
 
        let digits = Math.pow(10,1);
        let t = Math.round(3.5595 * digits);
 
        pl(`10^1 거듭제곱: ${digits}`);
        pl(`t: ${t}`);
        pl(`t/digits : ${t/digits}`);
 
        digits = Math.pow(10,2);
        t = Math.round(3.5595 * digits);
        
        pl(`10^2거듭제곱: ${digits}`);
        pl(`t: ${t}`);
        pl(`t/digits : ${t/digits}`);
    </script>
</body>
</html>
```



함수 매개변수 전달 및 함수 리턴

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script>
        //함수선언
        function callTenTimes(callback){ //callback 매개변수,지역변수
 
            for (let i = 0; i < 10 ; i ++){
                callback(i);
            }
 
        }
        //함수표현식
        let callback = function(i){
            alert(`함수 호출 ${i}`);
        }
 
        //함수호출
        callTenTimes(callback); //callback 실인수, 전역변수의 값
    </script>
</head>
<body>
    
</body>
</html>
```

```html
<!DOCTYPE html>
<html>
<head>
    <script>
        // 함수를 생성합니다.
        function returnFunction() {
            return function () {
                alert('Hello Function .. !');
            };
        }
 
        // 함수를 호출합니다.
        returnFunction()();
    </script>
</head>
<body>
 
</body>
</html>
```



클로저

- 함수 안에 선언된 변수는 지역변수 이므로 함수 외부에서 사용할 수 없다.
- 클로저는 위 규칙을 위반할 수 있다.
- 흔히 함수 내에서 함수를 정의하고 사용하면 클로저라고 할 수 있다.
- 정의한 함수를 리턴하고 사용은 바깥에서 한다. 

```html
<!DOCTYPE html>
<html>
<head>
    <script>
        // 함수를 선언합니다.
        function test(name) {
            var output = 'Hello ' + name + ' .. !';
        }
 
        // 출력합니다.(호출안됨)
        alert(output);
    </script>
</head>
<body>
 
</body>
</html>

```

```html
<!DOCTYPE html>
<html>
<head>
    <script>
        // 함수를 선언합니다.
        function test(name) {
             let output = `Hello ${name} ...!`;
 
             return function() {
                   console.log(output);
              };
        }
 
        // 출력합니다. 호출됨
        test('JavaScript')();
    </script>
</head>
<body>
 
</body>
</html>

```

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script>
        function test(name){
            let output = `Hello ${name} ...!`;
 
            return function() {
                console.log(output);
            };
        }
 
        let test1 = test('Web');
        let test2 = test('Ajax');
 
        test1();
        test2();
    </script>
</head>
<body>
    
</body>
</html>
```



중첩함수와 익명의 자기 호출 함수

```html
<!DOCTYPE html>
<html>
<body>
 
<p>Counting with a local variable.</p>
 
<button type="button" onclick="myFunction()">Count!</button>
 
<p id="demo">0</p>
 
<script>
var add = (function () {
    var counter = 0;
    return function () {return counter += 1;}
})();
 
function myFunction(){
    document.getElementById("demo").innerHTML = add();
}
</script>
 
</body>
</html>
```



타이머 함수

- 타이머 함수는 특정한 시간에 특정한 함수를 실행할 수 있게 하는 함수이다.
- setTimeout()함수는 특정한 시간 후에 함수를 한 번 실행한다.
- setInterval()함수는 특정한 시간마다 함수를 실행한다.
- 지속적인 실행은 컴퓨터 자원을 소비함으로 타이머가 더이상 필요없을때는 타이머를 멈춤니다.
- clearTimeout(), clearInterval() 사용

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script>
        // setTimeout(function (){
        //     alert('3 초가 지났습니다.');
        // },3000);
        setTimeout(() => {alert('3초가 지났습니다.')},3000);
    </script>
</head>
<body>
    
</body>
</html>
```

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
 
    <script>
        let intervalId = setInterval(() => {
            alert(`${new Date()}`);
        }, 1000);
 
        setTimeout(() => {clearInterval(intervalId)},10000);
    </script>
</head>
<body>
    
</body>
</html>
```

```html
- 자바스크립트의 실행순서 ( A->C->B)
- 타이머 함수는 웹브라우저가 처리하고 완료된것을 자바스크립트에 알려준다.
- 배열의 forEach() 메소드를 이용한 배열값 출력

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
 
    <script>
        console.log('A');
        setTimeout(()=>{console.log('B');},0);
        console.log('C');

        for(let i = 0; i < 3; i++){
            setTimeout(() => {console.log(i);},0);
        }
 
        [0,1,2].forEach((i) => {
            setTimeout(() => { console.log(i);},0);
        });
    </script>
</head>
<body>
    
</body>
</html>
```

```html
- 함수 -> 클래스 없는 객체 -> 클래스 선언, 생성자 선언 후  클래스를 객체 생성
 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script>
        function Counter(){
            this.sum = 0;
            this.count = 0;
        }
        Counter.prototype.add = function(array){
            array.forEach(entry => {
                this.sum += entry;
                ++this.count;
            },this);
        };
 
        let obj = new Counter();
        obj.add([2,5,9]);
        console.log(`count : ${obj.count}`);
        console.log(`sum: ${obj.sum}`);
 
    </script>
</head>
<body>
    
</body>
</html>
```





##### 객체

```javascript
'use strict';
// Objects
// object = { key : value };
const obj1 = {}; // 'object literal' syntax
const obj2 = new Object(); // 'object constructor' syntax
 
function print(person) {
  console.log(person.name);
  console.log(person.age);
}
 
const baby = { name: 'hong', age: 4 };
print(baby);
 
// with JavaScript magic (dynamically typed language)
// can add properties later
baby.hasJob = true;
console.log(baby.hasJob);
 
// can delete properties later
delete baby.hasJob;
console.log(baby.hasJob);
 
// 2. Computed properties
// key should be always string
console.log(baby.name);
console.log(baby['name']);
baby['hasJob'] = true;
console.log(baby.hasJob);
 
function printValue(obj, key) {
  console.log(obj[key]);
}
printValue(baby, 'name');
printValue(baby, 'age');
 
// 3. Property value shorthand
const person1 = { name: 'bob', age: 2 };
const person2 = { name: 'steve', age: 3 };
const person3 = { name: 'dave', age: 4 };
const person4 = new Person('baby', 30);
console.log(person4);
 
// 4. Constructor Function
function Person(name, age) {
  // this = {};
  this.name = name;
  this.age = age;
  // return this;
}
 
// 5. in operator: property existence check (key in obj)
console.log('name' in baby);
console.log('age' in baby);
console.log('random' in baby);
console.log(baby.random);
// 6. for..in vs for..of
// for (key in obj)
//console.clear();
for (let key in baby) {
  console.log(key);
}
 
// for (value of iterable), 배열
const array = [1, 2, 4, 5];
for (let value of array) {
  console.log(value);
}
 
// 7. 복사
// Object.assign(dest, [obj1, obj2, obj3...])
const user = { name: 'bob', age: '20' };
const user2 = user;
console.log(user);
user2.name = 'coder';
console.log(user);
 
// old way
const user3 = {};
for (let key in user) {
  user3[key] = user[key];
}
console.clear();
console.log(user3);
 
// another example
const user4 = Object.assign({}, user);
console.log(user4);
 
 
const fruit1 = { color: 'red' };
const fruit2 = { color: 'blue', size: 'big' };
const mixed = Object.assign({}, fruit1, fruit2);
console.log(mixed.color); //같은 속성인 color : 'blue'가  color : 'red'를 덮어 쓴다.
console.log(mixed.size);
```



1. 객체값 접근

   ```html
   <!DOCTYPE html>
   <html lang="en">
   <head>
       <meta charset="UTF-8">
       <meta http-equiv="X-UA-Compatible" content="IE=edge">
       <meta name="viewport" content="width=device-width, initial-scale=1.0">
       <title>Document</title>
   </head>
   <body>
    
   <p>Creating a JavaScript Object.</p>
    
   <p id="demo"></p>
    
   <script>
   let person = {
       firstName : "John",
       lastName  : "Doe",
       age       : 50,
       eyeColor  : "blue"
   };
    
       document.getElementById('demo').innerHTML = 
       // `${person.firstName} is ${person.age}  years old.`;
       `${person['firstName']} is ${person['age']} years old`;
   </script>
    
   </body>
   </html>
   ```

2. 객체의 반복문 for( key in obj)

   ```html
   <html lang="en">
   <head>
       <meta charset="UTF-8">
       <meta http-equiv="X-UA-Compatible" content="IE=edge">
       <meta name="viewport" content="width=device-width, initial-scale=1.0">
       <title>Document</title>
   </head>
   <body>
   <p>Creating a JavaScript Object.</p>
    
   <p id="demo"></p>
   
   <script>
           // 변수를 선언합니다.
          let person = {
              firstName : "John",
              lastName  : "Doe",
              age       : 50,
              eyeColor  : "blue"
           };
    
       let output = '';
       for (let key in person){
           output += `● ${key} : ${person[key]} <br>`;
           //output += `● ${key} : ${person.key} <br>`; //undifined
       }
    
       document.getElementById('demo').innerHTML = output;
       </script>
   </body>
   </html>
   ```

3. in 과 with
- in : 속성이 객체안에 있는지를 확인할 수 있다. 존재하면 true값을 리턴한다.

- with : 객체의 속성을 출력할 때 여러번 사용되는 객체명을 줄여준다.
  
   ```html
   <!DOCTYPE html>
   <html lang="en">
   <head>
       <meta charset="UTF-8">
       <meta http-equiv="X-UA-Compatible" content="IE=edge">
       <meta name="viewport" content="width=device-width, initial-scale=1.0">
       <title>Document</title>
       <script>
           let output = ''
           let student = {
                이름 :'연하진',
                국어 : 92, 
                수학 : 98,
                영어 : 96,
                과학 : 98
           };
    
           output += `이름 in student (${'이름' in student}) \n`;
           output += `성별 in student (${'성별' in student}) `;
           console.log(output);
       </script>
   </head>
   <body>
    
   </body>
   </html>
   ```
   
   ```html
   <!DOCTYPE html>
   <html lang="en">
   <head>
       <meta charset="UTF-8">
       <meta http-equiv="X-UA-Compatible" content="IE=edge">
       <meta name="viewport" content="width=device-width, initial-scale=1.0">
       <title>Document</title>
       <script>
           let student = {
                이름 :'연하진',
                국어 : 92, 
                수학 : 98,
                영어 : 96,
                과학 : 98
           };
           
          //with 사용안한 경우 출력
           let output2 = '';
           output2 += `이름: ${student.이름} \n`;
           output2 += `국어: ${student.국어} \n`;
           output2 += `수학: ${student.수학} \n`;
           output2 += `영어: ${student.영어} \n`;
           output2 += `과학: ${student.과학} \n`;
           output2 += `총점: ${(student.국어 + student.수학 + student.영어 + student.과학)} \n`;
           
           console.log(output2);
    
         let output3 = '';
           with(student){
               output3 += `이름: ${이름} \n`;
               output3 += `국어: ${국어} \n`;
               output3 += `수학: ${수학} \n`;
               output3 += `영어: ${영어} \n`;
               output3 += `과학: ${과학} \n`;
               output3 += `총점: ${(국어 + 수학 + 영어 + 과학)} \n`;
           }
           console.log(output3)
   
   </head>
   </body>
   </html>
   ```

 4. push 함수를 사용하여 객체 생성

    ```html
    <!DOCTYPE html>
    <html>
    <head>
        <script>
            let students = [];
            students.push({
                이름: '홍길동', 국어: 87,
                수학: 98, 영어: 88, 과학: 95,
                장래희망: '생명공학자'
            });
            students.push({
                이름: '김길순', 국어: 92,
                수학: 98, 영어: 96, 과학: 98,
                특기: '요리', 취미: '일렉 기타'
            });
            students.push({
                이름: '이길동', 국어: 76,
                수학: 96, 영어: 94, 과학: 90,
                장래희망: '프로그래머'
            });
    
            console.log(students);
         
        </script>
    </head>
    <body>
     
    </body>
    </html>
    ```

 5. 속성과 메소드

    - 배열 내부에 있는 값을 요소라고 하며, 객체 내부의 값을 속성이라 한다.
    
    - 객체 속성중 기능 처리를 메서드라 부른다.
    
    - 메소드 내에서 자신의 속성을 출력하고 싶을 때는 this 키워드를 사용한다.
    
      ```html
      <!DOCTYPE html>
      <html>
      <head>
          <script>
               let object = { //속성과 메소드 선언
                  number: 273,
                  string: 'RintIanTta',
                  boolean: true,
                  array: [52, 273, 103, 32],
                  method: function () {
       
                  }
              };
          </script>
      </head>
      <body>
       
      </body>
      </html>
      ```
    
      ```html
      <!DOCTYPE html>
      <html>
      <body>
       
       
      <p id="demo"></p>
       
      <script>
      let person = {
          firstName: "John",
          lastName : "Doe",
          id       : 5566,
          fullName : function() {
             return this.firstName + " " + this.lastName;
          }
      };
       
      document.getElementById("demo").innerHTML = person.fullName();
      </script>
      </body>
      </html>
      ```
    
      ```html
      <!DOCTYPE html>
      <html>
      <head>
          <script>
              // 변수를 선언합니다.
              var person = {
                  name: '홍길동',
                  eat: function (food) {
                      alert(this.name + '이 ' + food + '을/를 먹습니다.');
                  }
              };
       
              // 메서드를 호출합니다.
              person.eat('밥');
          </script>
      </head>
      <body>
       
      </body>
      </html>
      ```
    
 6.  생성자 함수

    ```html
    <!DOCTYPE html>
    <html>
    <body>
     
    <p id="demo"></p>
     
    <script>
    function Person(first, last, age, eye) {
        this.firstName = first;
        this.lastName = last;
        this.age = age;
        this.eyeColor = eye;
    }
     
    var myFather = new Person("John", "Doe", 50, "blue");
    var myMother = new Person("Sally", "Rally", 48, "green");
     
    document.getElementById("demo").innerHTML =
    `My father is ${myFather.age}. My mother is ${myMother.age}`;
     
    </script>
     
    </body>
    </html>
    ```

 7.  프로토 타입

    - 프로토타입은 생성자함수로 생성된 객체가 공통으로 가지는 공간이다.
    
    - 프로토타입을 사용하지 않고 메소드를 만들경우는 객체가 생성될때 마다
     속성과 메소드를 계속 만들어 메모리가 비효율적이 된다.
    
     ```html
     <!DOCTYPE html>
     <html lang="en">
     <head>
         <meta charset="UTF-8">
         <meta http-equiv="X-UA-Compatible" content="IE=edge">
         <meta name="viewport" content="width=device-width, initial-scale=1.0">
         <title>Document</title>
     </head>
     <body>
         <p id="demo"></p>
         <p id="demo2"></p>
      
     <script>
     function Person(first, last, age, eye) {
         this.firstName = first;
         this.lastName = last;
         this.age = age;
         this.eyeColor = eye;
     }
     var myFather = new Person("John", "Doe", 50, "blue");
     var myMother = new Person("Sally", "Rally", 48, "green");
      
      
     Person.prototype.name = function() {
         return this.firstName + " " + this.lastName
     };
      
     document.getElementById("demo").innerHTML =
     `My father is ${myFather.name()}`; 
      
     document.getElementById("demo2").innerHTML =
     `My Mother is ${myMother.name()}`; 
     </script>
      
     </body>
     </html>
     ```
    
 8. 클래스 사용

    - 연관있는 메소드와 필드를 묶어 놓은것을 클래스라 한다.
    
    - 객체를 만들 수 있는 틀(template)이다.
    
    - 데이터가 들어있지 않다. 한번만 선언한다.
    
      ```html
      <!DOCTYPE html>
      <html lang="en">
      <head>
          <meta charset="UTF-8">
          <meta http-equiv="X-UA-Compatible" content="IE=edge">
          <meta name="viewport" content="width=device-width, initial-scale=1.0">
          <title>Document</title>
          <script src='class.js'></script>
      </head>
      <body>
          
      </body>
      </html>
      
      >>> class.js
      'use strict';
      //class : template
      //object : instance of a class
       
      //class declarations
      class Person{
          //constructor
          constructor(name, age){
              //fields
              this.name = name;
              this.age = age;
          }
       
          //methods
          speak(){
              console.log(`${this.name}: hello! `);
          }
      }
       
      const hong = new Person('hong', 20);
      console.log(hong.name)
      console.log(hong.age);
      hong.speak();
      
      ```
    





##### 배열

```javascript
// 1. Declaration
const arr1 = new Array();
const arr2 = [1, 2];
 
// 2. Index position
const fruits = ['사과', '바나나'];
console.log(fruits);
console.log(fruits.length);
console.log(fruits[0]);
console.log(fruits[1]);
console.log(fruits[2]);
console.log(fruits[fruits.length - 1]);
console.clear();
// 3. Looping over an array
// print all fruits
// a. for
for (let i = 0; i < fruits.length; i++) {
  console.log(fruits[i]);
}
 
// b. for of
for (let fruit of fruits) {
  console.log(fruit);
}
 
// c. forEach
fruits.forEach((fruit) => console.log(fruit));
 
// 4. Addtion, deletion, copy
// push: add an item to the end
fruits.push('딸기', '복숭아');
console.log(fruits);
 
// pop: remove an item from the end
const poped = fruits.pop();
fruits.pop();
console.log(fruits);
 
// unshift: add an item to the benigging
fruits.unshift('딸기', '레몬');
console.log(fruits);
 
// shift: remove an item from the benigging
fruits.shift();
fruits.shift();
console.log(fruits);
 
// note!! shift, unshift are slower than pop, push
// splice: remove an item by index position
fruits.push('딸기', '복숭아', '레몬');
console.log(fruits);
fruits.splice(1, 1);//1인덱스에서 삭제 갯수 지정, 지정하지 않으면 인덱스 이후 다지워짐
console.log(fruits);
fruits.splice(1, 0, '배', '수박'); //1인덱스에서 삭제 없이 배,수박 추가
console.log(fruits);
 
// combine two arrays
const fruits2 = ['메론', '배'];
const newFruits = fruits.concat(fruits2);
console.log(newFruits);
 
// 5. Searching
// indexOf: find the index
//console.clear();
console.log(fruits);
console.log(fruits.indexOf('사과'));
console.log(fruits.indexOf('수박'));
console.log(fruits.indexOf('코코넛'));
 
// includes (true/false)
console.log(fruits.includes('수박'));
console.log(fruits.includes('코코넛'));
 
// lastIndexOf
//console.clear();
fruits.push('사과');
console.log(fruits);
console.log(fruits.indexOf('사과'));
console.log(fruits.lastIndexOf('사과'));
 
console.log(fruits.lastIndexOf('코코넛'));
```



```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>JavaScript Arrays</h1>
    <p id="demo"></p>
    <script>
        let fruits, text, fLen, i;
        fruits = ['Banana', 'Orange', 'Apple', 'Mango'];
        fLen = fruits.length;
        text = '<ul>';
 
        //for
        for (i=0; i<fLen; i++)    {
            text += `<li> ${fruits[i]} </li>`
        }
 
        //for of
        for (let fruit of fruits){
            console.log(fruit);
        }
 
        //forEach
        fruits.forEach((fruit)=>{console.log(fruit);})
 
        text += "</ul>";
        document.getElementById('demo').innerHTML = text;
 
 
    </script>
</body>
</html>
```





배열 API



```javascript
// Q1. make a string out of an array
{
  const fruits = ['apple', 'banana', 'orange'];
  const result = fruits.join(',');
  console.log(result);
}
 
// Q2. make an array out of a string
{
  const fruits = '사과, 키위, 바나나, 체리';
  //const result = fruits.split(',');//,단위로 나누어 배열에저장
  const result = fruits.split(',',2);//2 리턴받을 사이즈지정
  
  console.log(result);
}
 
// Q3. make this array look like this: [5, 4, 3, 2, 1]
{
  const array = [1, 2, 3, 4, 5];
  array.reverse();
  console.log(array);
}
 
// Q4. make new array without the first two elements
{
  const array = [1, 2, 3, 4, 5];
  //const result = array.splice(0, 2); //삭제된 값 리턴(1,2)
  console.log(result);
  console.log(array);
  const result = array.slice(2, 5); //새로운 배열 생성
  console.log(result);
  console.log(array);
}
 
class Student {
  constructor(name, age, enrolled, score) {
    this.name = name;
    this.age = age;
    this.enrolled = enrolled;
    this.score = score;
  }
}
const students = [
  new Student('A', 29, true, 45),
  new Student('B', 28, false, 80),
  new Student('C', 30, true, 90),
  new Student('D', 40, false, 66),
  new Student('E', 18, true, 88),
];
 
// Q5. find a student with the score 90
{
  const result = students.find((student) => student.score === 90);
  console.log(result);
}
 
// Q6. make an array of enrolled students
{
  const result = students.filter((student) => student.enrolled);
  console.log(result);
}
 
// Q7. make an array containing only the students' scores
// result should be: [45, 80, 90, 66, 88]
// 데이터를 변환할 때 쓸 수 있다.
{
 // const result = students.map((student) => student.score);
  const result = students.map((student) => student.score * 2);
  console.log(result);
}
 
// Q8. check if there is a student with the score lower than 50
// some : 배열요소 하나라도 조건이 만족하면 true
// every : 배열요소 모두가 조건이 만족하면 true
{
  //console.clear();
  const result = students.some((student) => student.score < 50);
  console.log(result);
 
  const result2 = !students.every((student) => student.score >= 50);
  console.log(result2);
}
console.clear();
// Q9. compute students' average score
// reduce((prev(이전), curr(현재)) => 처리구현, prev의 초기값)
// 처리구현의 결과값이 prev에 전달된다.
{
   const result = students.reduce((prev, curr) => {
     console.log('--------------');
     console.log(prev);
     console.log(curr);
     return prev + curr.score;
   },0);
  //const result = students.reduce((prev, curr) => prev + curr.score, 0);
  //console.log(result / students.length);
}
 
// Q10. make a string containing all the scores
// result should be: '45, 80, 90, 66, 88'
{
  const result = students
    .map((student) => student.score)
    .filter((score) => score >= 50) //점수가 50이상
    .join(); //배열을 문자열로 변환
  console.log(result);
}
 
// Bonus! do Q10 sorted in ascending order
// result should be: '45, 66, 80, 88, 90'
{
  const result = students
    .map((student) => student.score)
    .sort((a, b) => a-b)
    .join();
  console.log(result);
}
```





toString()

```html
<!DOCTYPE html>
<html>
<body>
 
<p>The toString() method returns an array as a comma separated string.</p>
 
<p id="demo"></p>
 
<script>
 let fruits = ["Banana", "Orange", "Apple", "Mango"];
document.getElementById("demo").innerHTML = fruits.toString();
</script>
 
</body>
</html>
```



join()

```html
<!DOCTYPE html>
<html>
<body>
 
<p>the join() method joins array elements into a string.</p>
 
<p id="demo"></p>
 
<script>
var fruits = ["Banana", "Orange", "Apple", "Mango"];
document.getElementById("demo").innerHTML = fruits.join(" * ");
</script>
 
</body>
</html>
```





추가 삭제

- push() : push는 배열의 마지막 요소로 추가되며 추가후 배열의 길이를 가져옴
- pop() : pop은 배열의 마지막 요소값을 삭제하며 삭제한 값을 가져옴

```html
<!DOCTYPE html>
<html>
<body>
 
<p>The push method returns the new array length.</p>
 
<button onclick="myFunction()">Try it</button>
 
<p id="demo"></p>
 
<script>
var fruits = ["Banana", "Orange", "Apple", "Mango"];
document.getElementById("demo").innerHTML = fruits;
 
function myFunction() {
    document.getElementById("demo").innerHTML = fruits.push("Kiwi");
}
</script>
 
</body>
</html>
```

```html
<!DOCTYPE html>
<html>
<body>
 
<p>The pop method returnes the removed item.</p>
 
<button onclick="myFunction()">Try it</button>
 
<p id="demo"></p>
 
<script>
var fruits = ["Banana", "Orange", "Apple", "Mango"];
document.getElementById("demo").innerHTML = fruits;
 
function myFunction() {
    document.getElementById("demo").innerHTML = fruits.pop();
}
</script>
 
</body>
</html>
```



push 이외의 다른 방법

```html
<!DOCTYPE html>
<html>
<body>
 
<button onclick="myFunction()">Try it</button>
 
<p id="demo"></p>
 
<script>
var fruits = ["Banana", "Orange", "Apple", "Mango"];
document.getElementById("demo").innerHTML = fruits;
 
function myFunction() {
    fruits[fruits.length] = "Kiwi";
    document.getElementById("demo").innerHTML = fruits;
}
</script>
 
</body>
</html>
```





shift / unshift

-  unshift()는 배열의 첫번째 요소에 값을 추가하며 배열의 길이를 리턴
- shift()는 배열 첫번째 요소값을 제거하며 제거된 값을 가져온다.
- 요소를 추가/삭제 할 때 마다 기존 자리를 변경해야 하므로 시간이 걸린다.

```html
<!DOCTYPE html>
<html>
<body>
 
<button onclick="myFunction()">Try it</button>
 
<p id="demo"></p>
 
<script>
var fruits = ["Banana", "Orange", "Apple", "Mango"];
document.getElementById("demo").innerHTML = fruits;
 
function myFunction() {
    document.getElementById("demo").innerHTML = fruits.unshift("Lemon");
}
</script>
 
 
</body>
</html>
```

```html
<!DOCTYPE html>
<html>
<body>
 
<button onclick="myFunction()">Try it</button>
 
<p id="demo"></p>
 
<script>
var fruits = ["Banana", "Orange", "Apple", "Mango"];
document.getElementById("demo").innerHTML = fruits;
 
function myFunction() {
    document.getElementById("demo").innerHTML = fruits.shift();
}
</script>
 
</body>
</html>
```



splice()

- splice() : item을 지정된 위치에서 지운다.
- splice(start:number, deleteCount?:number, 추가될 요소값:string[]) :string[] deleteCount? 옵션으로 생략가능, 생략하면 start 뒤로 다 지워진다.

```html
<!DOCTYPE html>
<html>
<body>
 
<p>The splice() method adds new elements to an array.</p>
 
<button onclick="myFunction()">Try it</button>
 
<p id="demo"></p>
 
<script>
var fruits = ["Banana", "Orange", "Apple", "Mango"];
document.getElementById("demo").innerHTML = fruits;
 
function myFunction() {
    fruits.splice(2, 0, "Lemon", "Kiwi");
    document.getElementById("demo").innerHTML = fruits;
}
</script>
 
</body>
</html>
```



concat()

```html
<!DOCTYPE html>
<html>
<body>
 
<h1>Joining Two Arrays</h1>
 
<p id="demo"></p>
 
<script>
let myGirls = ["Cecilie", "Lone"];
let myBoys = ["Emil", "Tobias", "Linus"];
let myChildren = myGirls.concat(myBoys);
 
document.getElementById("demo").innerHTML = myChildren;
</script>
 
</body>
</html>
```

```html
<!DOCTYPE html>
<html>
<body>
 
<h1>Joining Three Arrays</h1>
 
<p id="demo"></p>
 
<script>
let arr1 = ["Cecilie", "Lone"];
let arr2 = ["Emil", "Tobias", "Linus"];
let arr3 = ["Robin", "Morgan"];
 
let myChildren = arr1.concat(arr2, arr3); 
 
document.getElementById("demo").innerHTML = myChildren;
</script>
 
</body>
</html>
```



slice()

```html
<!DOCTYPE html>
<html>
<body>
 
<h1>JavaScript slice()</h1>
 
<p>This  example slices out a part of an array starting from array element 3 ("Apple")</p>
 
<p id="demo"></p>
 
<script>
var fruits = ["Banana", "Orange", "Lemon", "Apple", "Mango"];
var citrus = fruits.slice(3);
document.getElementById("demo").innerHTML = `${fruits} <br> ${citrus}`;
</script>
 
</body>
</html>
```





sort()

```html
<!DOCTYPE html>
<html>
<body>
 
<p>The sort() method sorts an array alphabetically.</p>
 
<button onclick="myFunction()">Try it</button>
 
<p id="demo"></p>
 
<script>
let fruits = ["Banana", "Orange", "Apple", "Mango"];
document.getElementById("demo").innerHTML = fruits;
 
function myFunction() {
    fruits.sort();
    document.getElementById("demo").innerHTML = fruits;
}
</script>
 
</body>
</html>
```

