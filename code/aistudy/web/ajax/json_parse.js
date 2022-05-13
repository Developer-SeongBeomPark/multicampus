//JSON(JavaScript Object Notation)
//2. JSON to Object
//parse(json)
console.clear();
json = JSON.stringify(rabbit); //object -> JSON
const obj = JSON.parse(json); //JSON -> object
console.log(obj);
rabbit.jump(); 
//obj.jump()// JSON 변환에서는 jump()가 없기때문에
// object로 변환해도 object에 jump()가 없다. 
 
console.log(rabbit.birthdate.getDate());
//JSON으로 변환할때 문자열로 변환되어 object로 파싱될때도 string값을 가진다
//console.log(obj.birthdate.getDate()); 
 
//파싱될때 추가적인 파라미터로 birthdate를 Date객체로 변환하게 할 수 있다.
const obj2 = JSON.parse(json, (key, value) => {
    console.log(`key: ${key}, value: ${value}`);
    return key === 'birthdate' ? new Date(value) : value;
});
console.log(obj2.birthdate.getDate()); 