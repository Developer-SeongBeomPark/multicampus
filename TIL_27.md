### DAY27(5/16 Mon)

---

[CallBack 함수의 개선](#callback-함수의-개선)

- [Promise 사용](#promise-사용)

- [async, await 사용](#async,-await-사용)

[XHR와 Promise 사용 실습](#xhr와-promise-사용-실습)









#### CallBack 함수의 개선

---

##### Promise 사용

- 참조사이트 : [MDN Web Docs](https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Global_Objects/Promise)

- Promise 객체는 자바스크립트에서 제공하며, 비동기를 간편하게 처리할 수 있도록 도와준다.
- 정해진 장시간의 기능을 수행 후 정상적인 수행 완료 또는 실패와 그 결과 값을 전달한다.
- javascript의 클래스로 생성자를 통해서 객체를 만든다.

- 비동기 연산이 종료 후의 결과값이나 실패 이유를 처리하기 위한 처리기를 연결할 수 있다. 

- 프로미스를 사용하면 비동기 메서드에서 마치 동기 메서드처럼 값을 반환할 수 있다. 

- 최종 결과를 반환하지는 않고, 대신 프로미스를 반환해서 미래의 어떤 시점에 결과를 제공한다.

- Promise는 다음 중 하나의 상태를 가집니다.

 대기(pending) : 이행하거나 거부되지 않은 초기 상태.

 이행(fulfilled) : 연산이 성공적으로 완료됨.

 거부(rejected) : 연산이 실패함.

 

- 대기 중인 프로미스는 값과 함께 이행할 수도, 어떤 이유(오류)로 인해 거부될 수 있다.
- 이행이나 거부될 때, 프로미스에 연결한 처리기는 그 프로미스의 then 메서드로 대기열에 오른다.

![1](TIL_27.assets/1.jpg)




(1) Promise 생성, 사용

 **const promise = new Promise((resolve, reject) =>{ 

  });**

- Promise 생성자에서 excutor 콜백함수는 또다른 resolve(정상수행 후 결과전달), reject(문제가 생기면 호출) 
 콜백함수를 받는다.
- Promise는 시간이 걸리는 비동기 처리를 구현할 수 있다.
- **Promise를 생성하면 executor 콜백함수가 자동으로 실행된다. (※)**
- Promise를 생성하여 비동기 처리를 구현 후 resolve(), reject() 콜백 함수를 호출하여 그결과를 전달한다.
- Promise 사용하는 곳에서 결과를 then, catch, finally 등으로 받을 수 있다.



```javascript
'use strict';
//Promise is a JavaScript object for asynchronous operation.
//State : pending -> fulfilled or rejected
//Producer vs Consumer
 
//1. Producer:제공자
// when new Promise is created, the executor runs automatically.
 
const promise = new Promise((resolve, reject)=>{
    //doing some heavy work(network, read files)
    console.log('doing something...');
    setTimeout(() => {
        resolve('study');
        //reject(new Error('no network'));
    }, 2000)
});
 
//2. Consumers : 사용자 , then, catch, finally
promise //
    .then((value)=>{ // value는 promise가 잘 처리되어 resolve호출하고 거기에 전달된 'study' 를 받는다.
        console.log(value);
    })
    .catch(error => { //error는 promise가 처리되다 오류가 발생하여 전될되는 Error객체를 받는다. 
        console.log(error);
    })
    .finally(() => { //무조건 실행되는 곳
        console.log('finally')
    });

```





(2) Promise chaning, error 처리
- Promise chaning, Promise error 예제 확인
- then은 값 또는 Promise 객체가 전달된다.

```javascript
//3. Promise chaining
const fetchNumber = new Promise((resolve, reject) => {
    setTimeout(() => resolve(1), 1000);
});
fetchNumber
    .then(num => num * 2)
    .then(num => num * 3)
    .then(num => {
        return new Promise((resolve, reject) => {
            setTimeout(() => resolve(num - 1), 1000);
        });
    })
    .then(num => console.log(num));
 
//4. Error Handling
const getHen = () =>
    new Promise((resolve, reject) => {
        setTimeout(() => resolve('hen'),1000);
    });
 
const getEgg = hen =>
    new Promise((resolve, reject) => {
       setTimeout(() => resolve(`${hen} => egg`),1000);
       //setTimeout(() => reject(new Error(`error! ${hen} => egg`)),1000);
    });
 
const cook = egg =>
    new Promise((resolve, reject) => {
        setTimeout(() => resolve(`${egg} => brunch`),1000);
    });
 
getHen() 
    .then(hen => getEgg(hen))
    .then(egg => cook(egg))
    .then(meal => console.log(meal))
    .then(err => console.log(err)); //getEgg 에서 에러 처리, 오류난 부분에서 catch부분으로 건너띈다. 
// 받아온 값 하나를 => 함수에 파라메터로 보낼때 간단히 표현방법.
// 간단히
// getHen() 
//     .then(getEgg)
//     .then(cook)
//     .then(console.log)  
//     .catch(console.log); 
 
// 중간에 오류처리하는 방법, 계란을 받아오다가 오류가 나면 다른재료로 대체한다.
// getHen() 
//     .then(getEgg) 
//     .catch(error => {
//         return 'bread';
//     })
//     .then(cook) 
//     .then(console.log)
//     .catch(console.log);
```





##### async, await 사용

- 참조 사이트 : [MDN Web Docs](https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Statements/async_function)
- 기존 Promise위에 좀더 간편하게 사용할 수 있는 방법이다.
- async function 선언은 AsyncFunction 객체를 반환하는 하나의 비동기 함수를 정의한다.

- 암시적으로 Promise를 사용하여 결과를 반환한다. 

- 비동기 함수를 사용하는 코드의 구문과 구조는, 동기 함수를 사용하는것 처럼 보인다.

- async 함수에는 await식이 포함될 수 있다. 

- await은 async 함수의 실행을 일시 중지하고 전달 된 Promise의 해결을 기다린 다음 async 함수의 실행을 다시 시작하고 완료후 값을 반환한다.

- await 키워드는 async 함수에서만 유효하다
- 너무많은 체인을 사용하면 callback함수를 겹겹히 사용하는 것처럼 가독성이 떨어지는데 async, await는 좀더 간결한 코드를 만들기 위해서 사용한다.



```javascript
//async & await
//clear style of using promise
//1. async : 코드블럭이 자동으로 promise로 변환
// function fetchUser() {
//   return new Promise((resolve, reject) => {
//     //do network request in 10 secs....
//     resolve('study');
//   });
// }
//위의 내용을 아래코드로 간단히 만든다.
async function fetchUser() {
  //do network request in 10 secs....
  return 'study';
}
 
const user = fetchUser();
user.then(console.log);
console.log(user);
 
//2. await
//async 함수 안에서 사용, promise가 fulfill or reject 될때까지 기다린다.
function delay(ms) {
  return new Promise((resolve) => setTimeout(resolve, ms));
}
 
async function getApple() {
  await delay(1000); //delay함수호출이 끝날때까지 기다린다.
  // throw 'error'; //임의의 에러발생시킴
  return 'apple';
}
 
async function getBanana() {
  await delay(1000);
  return 'banana';
}
 
//Promise도 중첩적으로 체인잉을 하면 콜백지옥 같은 문제점 발생
// function pickFruits() {
//   return getApple().then((apple) => {
//     return getBanana().then((banan) => `${apple} + ${banan}`);
//   });
// }
// pickFruits().then(console.log);
//좀더 개선된 코드
// async function pickFruits() {
//   try {
//     const apple = await getApple();
//     const banana = await getBanana();
//     return `${apple} + ${banana}`;
//   } catch {
//     console.log(new Error('error')); //getApple()의 에러처리
//   }
// }
// pickFruits().then(console.log);
//독립적인 처리기능을 순차적으로 하는 대신 병렬처리로 하면 좀더 개선된 코드가 된다.
//병렬처리를 위해서 Promise를 사용한다. 동시수행으로 총 1초가 소요된다.
// async function pickFruits() {
//   const applePromise = getApple(); //Promise 리턴, 바로 promise 실행
//   const banaaPromise = getBanana(); //Promise 리턴, 바로 promise 실행
//   const apple = await applePromise;
//   const banana = await banaaPromise;
//   return `${apple} + ${banana}`;
// }
 
// pickFruits().then(console.log);
 
//3. useful Promise APIs - 위의 병렬처리 코드를 좀더 개선하는 방법
//promise.all([]);배열형태로 함수를 전달하면 모든 함수가 병렬처리된다.
//then에 전달되는 결과 값도 배열형태이다.
// function pickAllFruits() {
//   return Promise.all([getApple(), getBanana()]) //배열로 병렬처리기능을 나열
//     .then((fruits) => fruits.join(' + '));
// }
// pickAllFruits().then(console.log);
 
//둘중에 먼저 수행되는 것 하나만 처리결과를 가져온다. apple의 시간을 늘려서 확인
function pickOnlyOne() {
  return Promise.race([getApple(), getBanana()]);
}
 
pickOnlyOne().then(console.log);
```



--> 수정 후:

```javascript
class UserStorage {
    loginUser(id, password) {
      return new Promise((resolve, reject) => {
        setTimeout(() => {
          if (
            (id === 'study' && password === 'aistudy') ||
            (id === 'coder' && password === 'academy')
          ) {
            resolve(id);
          } else {
            reject(new Error('not found'));
          }
        }, 2000);
      });
    }
  
    getRoles(user) {
      return new Promise((resolve, reject) => {
        setTimeout(() => {
          if (user === 'study') {
            resolve({ name: 'study', role: 'admin' });
          } else {
            reject(new Error('no access'));
          }
        }, 1000);
      });
    }
  
    // 추가된 곳 ?
    async getUserWithRole(user, password) {
      const id = await this.loginUser(user, password);
      const role = await this.getRoles(id);
      return role;
    }
  }
  
  const userStorage = new UserStorage();
  const id = prompt('enter your id');
  const password = prompt('enter your passrod');
 
//변경된곳
  userStorage
  .getUserWithRole(id, password) //
  .then(user => alert(`Hello ${user.name}, you have a ${user.role} role`))
  .catch(console.log)
```



##### XHR와 Promise 사용 실습

1. 서버의 응답 페이지

```jsp
<%@ page contentType="text/html; charset=UTF-8" %> 
<%
String[] titles = {
"  급  여  명  세  서 ", 
"기 본 급: 2,500,000 원",
"야근수당:   100,000 원",
"주말수당:   200,000 원",
"세금합계:   100,000 원",
"실수령액: 2,900,000 원",
"입금 예정일: 2021-10-01일 수고하셨습니다.",
};
%> 
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
          font-size: 20px; 
          color:green;
          font-weight: bold;
        } 
         
    </style>
</head>
<body>
    <ul>
<%
String id = request.getParameter("id");
String passwd = request.getParameter("passwd");
System.out.println(id);
if (id.equals("테스트") && passwd.equals("테스트")){
    for (int i = 0 ; i < titles.length ; i++) {
        out.println("<li>" + titles[i] + "<br/><br/>");
    }
}else{
    out.println("<li>인증 실패입니다.<br/><br/>");
    out.println("<li>다시 시도해 주세요.<br/><br/>");
}
%>    
</ul>
</body>
</html>
```



2. Promise를 이용한 비동기 통신구현 js

```javascript
class UserStorage {
  constructor() {
    if (window.XMLHttpRequest) {
      this.xhr = new XMLHttpRequest();
    } else {
      // code for IE6, IE5
      this.xhr = ActiveXObject('Microsoft.XMLHTTP');
    }
    console.log(this.xhr);
  }
 
  loginUser(id, passwd) {
    return new Promise((resolve, reject) => {
      this.xhr.onload = () => {
        // alert(this.xhr.responseText);
        resolve(this.xhr.responseText);
      };
      this.xhr.onerror = () => {
        reject(new Error(this.xhr.status));
      };
      //alert(`pay.jsp?id=${id}&passwd=${passwd}`);
      this.xhr.open('GET', `pay.jsp?id=${id}&passwd=${passwd}`, true);
      this.xhr.send();
    });
  }
}
```



3. id, passwd 입력후 비동기 통신 요청 페이지

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
 
    <title>Document</title>
    <script src="ajax.js" defer></script>
    <script>
        function send(id, passwd){
            const userStorage = new UserStorage();
            userStorage
                .loginUser(id,passwd)
                .then(text => {
                    //alert(text);
                    let payList = document.getElementById("payList");
                    payList.innerHTML = text;
                })
                .catch(console.log)
        }
    </script>
</head>
<body>
 
    <h2>급여 명세서</h2>
    <br>
    <div class="well well-sm" id="payList"></div>
    <br>
    <form class="form-inline">
        <div class="form-group">
          <label class="sr-only" for="id">사원id:</label>
          <input type="email" class="form-control" id="id" value="테스트" name="id">
        </div>
        <div class="form-group">
          <label class="sr-only" for="pwd">비밀번호:</label>
          <input type="password" class="form-control" id="pwd" value="테스트" name="passwd">
        </div>
        <button type="button" class="btn btn-default"
        onclick="send(this.form.id.value, this.form.passwd.value)">급여확인</button>
      </form>
    </div>
    
</body>
</html>
```

