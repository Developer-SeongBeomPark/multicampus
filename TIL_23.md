### DAY 23(5/9 Mon)

---

[함수 활용하기](#함수-활용하기)

[객체(Object)](#객체)



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
    
      





