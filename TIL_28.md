### DAY 28(5/17 Tue)

---

[Fetch API 사용](#fetch-api-사용)

[]()

[]()

[]()



##### Fetch API 사용

- Fetch API를 사용하면 XMLHttpRequest(XHR)와 유사한 네트워크 요청을 만들 수 있다. 

- 가장 큰 차이점은 Fetch API가 Promises를 사용하므로 더 간단하고 깔끔한 API를 제공하여 콜백 지옥 피하고 XMLHttpRequest의 복잡한 API를 기억하지 않아도 된다.

- ajax.js 사용안함 pay.html만 수정



```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
 
    <title>Document</title>
    <script>
        function getItem(id, passwd) {
            return fetch(`pay.jsp?id=${id}&passwd=${passwd}`)
            .then(response => response.text());
        }
        function send(id, passwd){
            console.log(`pay.jsp?id=${id}&passwd=${passwd}`);
            getItem(id,passwd)
            .then(text => {
                let payList = document.getElementById("payList");
                    payList.innerHTML = text;
            }).catch(console.log);
        }
        
    </script>
</head>
<body>
 
 <h2>급여 명세서</h2> 
   <br>
   <div class="well well-sm" id="payList"></div>
   <form class="form-inline">
       <div class="form-group">
           <label class="form-group-lg" for='id'>사원id:</label>
           <input type="text" class="form-control" id="id" value="테스트" name="id">
       </div> 
       <div class="form-group">
        <label class="form-group-lg" for='pwd'>비밀번호:</label>
        <input type="password" class="form-control" id="pwd" value="테스트" name="passwd">
       </div>
       <div class="form-group">
       <button type="button" class="btn btn-default" 
       onclick="send(this.form.id.value, this.form.passwd.value)">급여확인</button>
        </div>
   </form>
    
</body>
</html>
```





