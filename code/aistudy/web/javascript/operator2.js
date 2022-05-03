//조건절  if, else if, else
 
const name = 'js';
if(name === 'js'){
    console.log('Welcome, js!');
}else if(name === 'coder'){
    console.log("coder~");
}else{
    console.log('unknown');
}
 
//Ternary operator:? 셋으로 이루어진 연산
//condition ? value1 : value2;
console.log(name === 'js' ? 'yes' : 'no');
 
//switch statement
//use for multiple if checks
//use for enum-like value check
//use for multiple type checks in TS 
const browser = "IE";
switch (browser){
    case 'IE':
        console.log("이제 없어진다.");
        break;
    case 'Chrome':
    case 'Firefox':
        console.log('많이 사용');
        break;
    default:
        console.log("모두 브라우저");
        break;
}
 
//loops , while the condition is truthy,
//body code is executed
let i = 3;
while (i>0){
    console.log(`while:${i}`)
    i--;
}
 
//do while loop, body code is executed first,
//then check the condition.
do{
    console.log(`do while: ${i}`)
    i--;
} while(i > 0);
 
//for loop, for(begin; codition; step)
for (i = 3; i > 0 ; i--){
    console.log(`for: ${i}`);
}
 
//nested loops
for(let i=0; i < 10; i++){
    for(let j=0; j < 10; j++){
        console.log(`i: ${i}, j: ${j}`);
    }
}
 
//break, continue
for (let i=0; i < 11; i++){
    if(i % 2 !== 0){
        continue; //continue 대신  i값 출력해도 된다.
    }
    console.log(`i: ${i} `)
}
 
for(let i = 0; i <  11; i++){
    if(i > 8){
        break;
    }
    console.log(`i: ${i}`);
}

//false : 0, -0, ' ', null, undefined
//true : -1, 'hello', 'false'

let obj = {
     name  : 'hong'
};

if (obj) {
  console.log(obj.name);
}

obj && console.log(obj.name);