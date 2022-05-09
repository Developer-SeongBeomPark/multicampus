// Q1. make a string out of an array
{
    const fruits = ['apple', 'banana', 'orange'];
    const result = fruits.join(','); // 아무것도 적지 않으면 콤마가 기본 값.
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