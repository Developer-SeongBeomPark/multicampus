### DAY 24(5/11 Tue)

---

[]()

[]()



##### 이벤트의 처리

Anchor 태그에서 click 이벤트를 받는 소스

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        *{ 
            font-family: gulim; 
            font-size: 22px; 
        } 
    </style>
    <script>
    function sendit(){
        let str = document.getElementById('url').value; //id 로 검색
        console.log(`str: ${str}`);
 
        if(str == ''){
            alert('주소를 입력하세요');
            document.regiform.url.focus(); //name속성으로 검색
        }else{
            location.href = str; //주소 요청
        }
    }
    </script>
</head>
<body>
    <form name='regiform'>
        <input type='text' id='url' name='url' size= '50'>
        <a href="javascript:sendit();">주소이동</a>
        
    </form>
</body>
</html>
```



\>>> Upgrade: 'https://' 이 문자열이 없으면 주소 이동이 안됨으로, 입력이 없을시 자동으로 주소에 'https://'가 추가되도로 해주세요


\>>> Upgrade:  미리 버튼에 [DAUM], [기상청], [교보문고]를 준비하여 클릭시 주소가 자동으로 입력창에 할당 되도록 해주세요.

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        *{ 
            font-family: gulim; 
            font-size: 22px; 
        } 
    </style>
    <script>
   function sendit(){
        let str = document.getElementById('url').value; //id 로 검색
        //let str = document.regiform.url.value; --> name속성으로 검색
        console.log(`str: ${str}`);

        if(str == ''){
            alert('주소를 입력하세요');
            document.regiform.url.focus(); //name속성으로 검색
        }else{
            if(str.indexOf("https://") < 0){
                str = "https://" + str;
            }
            location.href = str; //주소 요청
        }
    }

    function direct_sendit(str){
        location.href = str;
    }
    </script>
</head>
<body>
    <form name='regiform'>
        <input type='text' id='url' name='url' size= '50'>
        <a href="javascript:sendit();">주소이동</a>
        <button type = "button" onclick = "sendit()">주소이동</button>
        <button type = "button" onclick = "direct_sendit('https://www.daum.net')">DAUM</button>
        <button type = "button" onclick = "direct_sendit('https://www.weather.go.kr')">기상청</button>
        <button type = "button" onclick = "direct_sendit('https://www.kyobobook.co.kr')">교보문고</button>
    </form>
</body>
</html>
```



입력값을 검사하는 기본 자바스크립트

- button 태그는 항상 자바스크립트 함수와 같이 사용됩니다.
- onClick='check(this.form)': this.form은 폼 태그를 말합니다.

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="../style.css">
    <script>
        function check(f){
            if(f.wname.value == "" | f.wname.value.length == 0){
                alert("이름을 입력하세요");
                f.wname.focus();
            }else if(f.subject.value == "" | f.subject.value.length == 0){
                alert("제목을 입력하세요");
                f.subject.focus();
            }else if(f.wcotent.value == ""){
                alert("내용을 입력하세요")
                f.wcontent.focus();
            }else{
                alert("데이터 정상 입력. 계속 진행합니다");
                f.submit();
            }
        }

    </script>
</head>
<body>
    <form method="post" action = "" name = "myform">
        <h2>방명록;</h2>
        이름 : <input type="text" name = "wname"><br>
        제목 : <input type="text" name = "subject"><br>
        내용 : <textarea name="wcontent" cols="54" rows="8"></textarea><br>
        <button onclick = "check(this.form)">저장</button> <!--this.form -> 해당 form태그가 parameter로 들어감-->
        <input type='image' src='disks.jpg'></input>
    </form>
</body>
</html>
```



실습

문제 : Input 태그에서 행의 수와 열의 수를 입력받아 자바스크립트로 테이블을 생성하는 예제를 작성하세요. 입력되는 값은 수만 입력가능하며, 문자열 입력시 에러 메시지를 출력하세요. 입력 가능 값의 범위는 3 ~ 10 만 가능하며 이 값의 범위를 벗어나면 역시 에러메세지를 출력하세요.

 조건: 1) 숫자 입력 여부 검사, 2) 입력되는 수의 범위 검사

 힌트: 함수 안에서 다른 함수를 호출할 수 있습니다. 



```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../style.css">
<script>
    function check(f){
            let row = f.row.value;
            let col = f.col.value;
            console.log(`row:${row}, col:${col}`);
            if(isFinite(row)==false){
                alert("숫자를 입력하세요");
                f.row.value = '';
                f.row.focus();
                return false;
            }else if(row<3 || row>10){
                alert('3~10 사이의 수만 입력하세요');
                f.row.value = '';
                f.row.focus();
                return false;
            }else if(isFinite(col)==false){
                alert("숫자를 입력하세요");
                f.col.value = '';
                f.col.focus();
                return false;
            }else if(col<3 || col>10){
                alert('3~10 사이의 수만 입력하세요');
                f.col.value = '';
                f.col.focus();
                return false;
            }else{
                makeTable(row,col);
                return false;
            }
        }

    function makeTable(row, col){
        let html = "<table>";
        for (let i = 0; i < row; i++){
            html += "<tr>"
                for(let j = 0; j < col; j++){
                    html += "<td>&nbsp</td>";
                }
            html += "</tr>";
            }

        html += "</table>"

        let panel = document.getElementById('panel').innerHTML = html;
    }
</script>
</head>
<body>
    <form name='myform' onsubmit="return check(this)">
        행의수:<input type="text" name="row" id="row" value="5" size="20"><br>
        열의수:<input type="text" name="col" id="col" value="5" size="20"><br>
        <button>테이블 생성</button>
    </form>
    <div id="panel"></div>
</body>
</html>
```

















##### Onload 이벤트 처리

1. split()함수를 이용하여 입력된 값을 분리하여 출력한다.
- onload event: 페이지 로딩시 자동실행 함수 선언, BODY 태그 실행후 실행

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="../style.css">
    <script>
        function searchW(){
            let str = "기획자/설계자/개발자/디자이너";
            let strout = '';
            let strSplit = str.split("/");
            
            for(let i = 0; i < strSplit.length; i++){
                strout += `❤ ${strSplit[i]}`;
            }

            let panel = document.getElementById("panel");
            panel.innerHTML = strout;
        }

    </script>
</head>
<body onload = "searchW()">
    <div id = "panel">

    </div>
</body>
</html>
```





2. 파일의 확장자를 검사하는 함수

 ```html
 <!DOCTYPE html>
 <html lang="en">
 <head>
     <meta charset="UTF-8">
     <meta http-equiv="X-UA-Compatible" content="IE=edge">
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <title>Document</title>
     <link rel="stylesheet" href="../style.css">
     <script>
         window.onload = function(){
             let word1 = document.getElementById("word1");
             let result1 = document.getElementById("result1");
 
             word1.innerHTML = "test.jsp";
             let str = word1.innerHTML;
 
             if(str.lastIndexOf(".jsp") >= 0){
                 result1.innerHTML = "전송할 수 없는 확장자입니다";
             }
         }
     </script>
 </head>
 <body>
     <h1>자바 스크립트 확장자 검사</h1><br><br>
 
     <div id = "panel">
         <span id = "word1"></span> : <span id = "result1"></span><br>
 
     </div>
 </body>
 </html>
 ```





##### Select 이벤트 처리

1. select 태그 자바스크립트에서 연동하기

 ```html
 <!DOCTYPE html>
 <html lang="en">
 <head>
     <meta charset="UTF-8">
     <meta http-equiv="X-UA-Compatible" content="IE=edge">
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <title>Document</title>
     <link rel="stylesheet" href="../style.css">
     <script>
         function ansquChange(f){
             let frm = document.frmData;
             let str = f.title.value + f.ansqu.options[f.ansqu.selectedIndex].text;
             f.title.value = str;
             f.title.focus();
 
             frm.ansqu.value = f.ansqu.options[f.ansqu.selectedIndex].value;
         }
 
         function partChange(f){
             let frm = document.frmData;
             let str = f.title.value + f.pt.options[f.pt.selectedIndex].text;
 
             f.title.value = str;
             f.title.focus();
 
             frm.pt.value = f.pt.options[f.pt.selectedIndex].value;
         }
 
     </script>
 </head>
 <body>
     <form name = "frmSelect">
         <select name="ansqu" onchange="ansquChange(this.form)">
             <option value=''> [종류 선택] </option>
             <option value='A001'> [질문] </option>     
             <option value='A002'> [답변] </option>
             <option value='A003'> [참고] </option>
             <option value='A004'> [공지] </option>
             <option value='A005'> [추천] </option>
             <option value='A006'> [선택 안함] </option>
         </select>
         
 
         <select name="pt" onchange='partChange(this.form)'>
             <option value=''> [분야 선택] </option>
             <option value='P001'> [JAVA] </option>
             <option value='P002'> [JSP] </option>
             <option value='P003'> [Spring] </option>
             <option value='P004'> [JavaScript] </option>
             <option value='P005'> [ORACLE] </option>
             <option value='P006'> [선택 안함] </option>
         </select>
         <br>
         <input type="text" name = "title" size = "85" class = "title" maxlength = "100">
 
     </form>
 
     <hr>
 
     <form name = "frmData">
         분야 선택 전송값: <input type='text' name='ansqu' value='' size='50'><br>
         언어 선택 전송값: <input type='text' name='pt' value='' size='50'>
 
     </form>
 </body>
 </html>
 ```



2. substring 함수

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="../style.css">
    <script src = "../utility.js">
    </script>
</head>
<body>
    <script>
        let str = '123ABC 가나다/가나다';
        pl(`${str}`);
        pl(`${str.substring(0,3)}`);
        pl(str.substring(7));
        pl(str.lastIndexOf('가나다'));

    </script>
</body>
</html>
```



3. 문자열에서 공백을 제거하는 스크립트

```html
```

