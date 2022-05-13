//JSON(JavaScript Object Notation)
//1. Object to JSON
//stringify(obj) --> 직렬화
let json = JSON.stringify(true); //true -> 문자열
console.log(json);
 
json = JSON.stringify(['apple','banana']); //배열 -> 문자열
console.log(json);
 
const rabbit = {  //객체 -> 문자열, 메서드는 JSON으로 변환되지 않는다.
    name : 'tori',
    color : 'white',
    size : null,
    birthdate : new Date(),
    jump:() => { // JSON에 제외된다.
        console.log(`${name} can jump!`);
    },
};
 
json = JSON.stringify(rabbit);
console.log(json);

//JSON으로 변환시 통제, 두번째 파라메터에서 배열을 넘기면 첫번째 객체에서
//두번째 배열의 내용만 변환
json = JSON.stringify(rabbit,['name','color']);
console.log(json);
 
//JSON으로 변환시 통제, 두번째 파라미터에 함수를 사용한다.
json = JSON.stringify(rabbit, (key, value) => {
    console.log(`key: ${key}, value: ${value}`);
    return key === 'name' ? 'rab' : value;
});
console.log(json);