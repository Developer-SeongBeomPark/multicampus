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

//배열의 길이가 1일때 그 값을 출력하려고 하면 인식을 못함.