const obj1 = {};
const obj2 = new Object();

function print(person){
    console.log(person.name);
    console.log(person.age);
}

const baby = { name: 'hong', age: 4 };
print(baby);

baby.hasJob = true;
console.log(baby.hasJob);

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
  console.log(obj.key); // --> 인식 못함
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