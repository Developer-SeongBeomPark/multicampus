### DAY 22(5/4 Wed)

---

[제어문](#제어문)

[Function(함수)](#function)



##### 제어문

1. if, else if, else
2. switch
3. while
4. for
5. do-while
6. 제어문의 중첩
7. continue
8. break



##### Function

1. Arrow function

   ```javascript
   //always anonymous , {} 생략 , 리턴 키워드 생략
   // const simplePrint = function(){
   //     console.log('simplePrint');
   // };
    
   const simplePrint = ()  =>  console.log('simplePrint');
   const add = (a, b) => a + b;
   const simpleMultiply = (a, b) => { //{}사용하면 리턴 키워드 사용해야 함
       //do something more
       return a + b;
   }
    
   //IIFE: Immediately Invoked Function Expression
   //함수선언과 동시에 호출하기
   (function hello(){
       console.log('IIFE')
   })();
   ```

2. confirm 내장함수

   ```javascript
   <!DOCTYPE html>
   <html lang="en">
   <head>
       <meta charset="UTF-8">
       <meta http-equiv="X-UA-Compatible" content="IE=edge">
       <meta name="viewport" content="width=device-width, initial-scale=1.0">
       <title>Document</title>
       <style>
           * {
               font-family: gulim;
               font-size: 20px;
           }
       </style>
       <script src=./utility.js> </script>
   </head>
   <body>
       <h2>confirm의 사용 예제</h2>
       <hr>
       <script>
           let temp = window.confirm('확인 또는 취소를 선택하세요');
           
           if(temp){
               pl(`확인 선택: ${temp}`);
           }else{
               pl(`취소 선택: ${temp}`);
           }
       </script>
   </body>
   </html>
   ```

3. escape unescape 내장 함수

   ```javascript
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
       <script src='./utility.js'></script>
   </head>
   <body>
       <h1>escape, unescape 내장 함수</h1>
       <hr>
       <script>
           pl(`원본: 123-ABC-abc-미합중국/러시아/중국-!?#$% <br><br>`);
           let temp1 = escape('123-ABC-abc-미합중국/러시아/중국-!?#$%');
           let temp2 = unescape(temp1);
           pl(`escape: ${temp1}`);
           pl(`unescape: ${temp2}`);
       </script>
   </body>
   </html>
   ```

4. isFinite 내장 함수

   ```javascript
   <!DOCTYPE html>
   <html>
   <head>
   <meta charset="UTF-8">
   <TITLE>자바 스크립트 예제</TITLE>
   <style type="text/css"> 
   *{ 
     font-family: gulim; 
     font-size: 22px; 
   } 
   </style> 
   <script  src="./utility.js"></script>
   </HEAD>
    
   <BODY>
   <h2>isFinite 함수 예제</h2>
   <hr>
       <script>
           let temp1;
           temp1 = prompt('값을 입력하세요',100);
    
           // alert(`${temp1}`);
    
           if(isFinite(temp1)==true){
               pl(`${temp1} 은 유한한 숫자`);
           }else{
               pl(`${temp1} 은 무한대이거나 숫자가 아님`);
           }
    
       </script>
    
   </H2>
   </BODY>
   </HTML>
   ```

5. isNaN 내장 함수

   ```javascript
   <!DOCTYPE html>
   <html>
   <head>
   <meta charset="UTF-8">
   <TITLE>자바 스크립트 예제</TITLE>
   <style type="text/css"> 
   *{ 
     font-family: gulim; 
     font-size: 22px; 
   } 
   </style> 
   <script  src="./utility.js"></script>
   </HEAD>
    
   <BODY>
       <h1> isNaN 함수 예제</h1>
       <hr>
       <script>
           let temp1 = prompt('값을 입력하세요',100.5);
           //문자:true, 숫자:false
           if(isNaN(temp1)){
               pl(`${temp1} 은 문자 이다.`);
           }else{
               pl(`${temp1} 은 숫자 이다.`);
           }
    
       </script>
   </BODY>
   </HTML>
   ```

6. 문자열 관련 함수 응용

   ```javascript
   <!DOCTYPE html>
   <html>
   <head>
   <meta charset="UTF-8">
   <TITLE>자바 스크립트 예제</TITLE>
   <style type="text/css"> 
   *{ 
     font-family: gulim; 
     font-size: 22px; 
   } 
   </style> 
   <script src="utility.js"></script>
   </head>
    
   <body>
       <h1>문자열함수 예제</h1>
       <hr>
       <strong>
       <script>
           let wc = 'KOREA VICTORY';
           let prn = wc.charAt(0);
    
           pl(prn);
           pl(wc.charAt(1));
           pl(wc.charAt(2));
           pl();
           pl(`V의 위치: ${wc.indexOf('V')}`);
           pl(`R이 마지막으로 나타난 위치: ${wc.lastIndexOf('R')}`);
           pl(`문자열의 길이: ${'대한민국 WBC'.length}`);
           let tot = 10;
           pl(`tot+tot: ${tot+tot}`);
           pl(`parseInt: ${parseInt('10') + parseInt('10')}`);
    
    
       </script>
       </strong>
   </body>
   </html>
   ```

7. 입력 값의 이동

   ```javascript
   <!DOCTYPE html>
   <html lang="en">
   <head>
       <meta charset="UTF-8">
       <meta http-equiv="X-UA-Compatible" content="IE=edge">
       <meta name="viewport" content="width=device-width, initial-scale=1.0">
       <title>Document</title>
       <script>
           let oldVal = '';
           let newVal = '';
    
           function ok(f){
               if(oldVal === '' && newVal === ''){
                   newVal = f.keyword.value;
               }else if(f.keyword.value === ''){
                   return;
               }else{
                   oldVal = newVal;
                   newVal = f.keyword.value;
               }
    
               let divTag = document.getElementById('panel');
    
               let str = `oldVal: ${oldVal} /newVal: ${newVal}`;
    
              // divTag.innerHTML = divTag.innerHTML + '<br>' + str;
               divTag.append(`${str}`);
               divTag.innerHTML = divTag.innerHTML + '<br>'
    
           }
    
       </script>
   </head>
   <body>
       <form>
           <input type='search' name='keyword' value='' style='width:90%'>
           <button type='button' onclick='ok(this.form)'>확인</button>
       </form>
       <br>
       <div id='panel' style="font-size:24px"></div>
   </body>
   </html>
   ```

8. split 함수 응용

   ```javascript
   <!DOCTYPE html>
   <html lang="en">
   <head>
       <meta charset="UTF-8">
       <meta http-equiv="X-UA-Compatible" content="IE=edge">
       <meta name="viewport" content="width=device-width, initial-scale=1.0">
       <title>Document</title>
       <link rel="stylesheet" href="../style.css">
       <script src="utility.js"></script>
   </head>
   <body>
       <h2>split 함수</h2>
       <hr>
       <script>
       let dtolist = '가길동,100,90/나길동,100,80/다길동,90,80';
       let arraydto = dtolist.split('/');
       console.log(`배열의 길이:${arraydto.length}`);
       arraydto.forEach((dto) => pl(dto));
       pl('<hr>');
       pl('<h1><성적 계산 목록></h1>');
       let i=0;
       arraydto.forEach((dto) => {
            let str = dto.split(',');
            console.log(`배열의 타입:${i+1}:${typeof str[i++]}`);
            pl(`성명: ${str[0]}`);
            pl(`영어점수: ${str[1]}`);
            pl(`수학점수: ${str[2]}`);
            pl(`총점: ${parseInt(str[1]) + parseInt(str[2])}`);
            pl(`평균: ${(parseInt(str[1]) + parseInt(str[2]))/2}`);
            pl('-------------------------------------------------')
       });
    
       </script>
    
   </body>
   </html>
   ```

   
