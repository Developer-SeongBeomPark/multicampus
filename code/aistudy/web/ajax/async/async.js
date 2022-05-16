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