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





