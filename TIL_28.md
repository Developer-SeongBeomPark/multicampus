### DAY 28(5/17 Tue)

---

[Fetch API 사용](#fetch-api-사용)

[STS에서 Dynamic Web Project 실습](#sts에서-dynamic-web-project-실습)

- [BackEnd](#backend)

- [FrontEnd](#frontend)



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





#### STS에서 Dynamic Web Project 실습

##### BackEnd

DAO 작성

```java
package suggest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utility.DBClose;
import utility.DBOpen;

public class SuggestDAO {
	public int getCount(String keyword) {
		int count = 0;
		
		Connection con = DBOpen.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		StringBuffer sql = new StringBuffer();
		sql.append(" select count(sqlquery) as cnt ");
		sql.append(" from suggest ");
		sql.append(" where sqlquery like '"+keyword+"%' ");
		
		try {
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt("cnt");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(rs, pstmt, con);
		}
		
		return count;
	}
	
	public List<String> getSqlquery(String keyword){
		List<String> list = new ArrayList<>();
		
		Connection con = DBOpen.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		StringBuffer sql = new StringBuffer();
		sql.append(" select sqlquery");
		sql.append(" from suggest ");
		sql.append(" where sqlquery like '"+keyword+"%' ");
		sql.append(" order by sqlquery ");
		
		try {
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String str = rs.getString("sqlquery");
				list.add(str);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(rs, pstmt, con);
		}
		
		
		
		
		return list;
	}
}
```



비동기 요청할 JSP페이지 작성

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.List" %>
<%-- 자바 문에서 List를 쓰기 위한 코드 --%>
<jsp:useBean id = "dao" class = "suggest.SuggestDAO"/>
<%
	request.setCharacterEncoding("utf-8"); //요청지에서 Post방식으로 보낸 한글을 처리하는 코드
	String keyword = request.getParameter("keyword");
	int count = dao.getCount(keyword);
	List<String> list = dao.getSqlquery(keyword);
	
	out.print(count + "|");
	
	for(int i = 0; i < list.size(); i++){
		count = count - 1;
		String key = list.get(i);
		out.print(key);
		if(count > 0){
			out.print(",");
		}
	}
%>
```



##### FrontEnd

1. 비동기 요청 js

- fetch, promise, request 사용

```javascript
function sendKeyword(params) {
     return fetch(new Request('suggest.jsp', {
     method: 'post',
     headers: {
       "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"
     },
     body: params
       }))
       .then(response => response.text());   
}
function select(selectedKeyword) {
    document.search.keyword.value = selectedKeyword;
     
    hide('suggest');
}
function show(id){
    if(id) {
        document.getElementById(id).style.display='';
    }
}
function hide(id){
    if(id) {
        document.getElementById(id).style.display='none';
    }
}
```





2. suggest 이용 JSP 페이지

```jsp
<%@ page  contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제시어</title>
<script src="ajax.js"></script>
<style> 
#suggest {
display: block;
position: static;
left: 0px;
top: 30px;
color: #000000;
background: #EAEAEA;
width: 500px"
}
</style>
<script src = "ajax.js"></script>
<script>
    function send(){
        let keyword = document.search.keyword.value; 
        console.log(`.... : \${keyword.length}`);
        let params = `keyword=\${keyword}`; //suggest.jsp의 keyword와 같은 놈
        console.log(`params:\${params}`);
        if(keyword.length > 0){
			sendKeyword(params)   // 비동기 통신 요청
            .then(text =>
         {
          //  3|자바001,자바002,자바003
         let result = text.split('|');
         
         // 갯수, 문자열을 정수로 변환
         let count = parseInt(result[0]);
         
         let keywordList = null;
         
         if (count > 0) {
             // ,를 구분한 1차원 배열 생성
             keywordList = result[1].split(',');
             
             let html = '';
             html += "등록된 쿼리 목록(선택하세요.)<br>";
             
             for (var i = 0; i < keywordList.length; i++) { 
             
             //※ 특수 문자 표현: " --> \", \ --> \\ 
             //※ jsp에서 js의 template literal 사용시 앞에 '\' 사용
             html += `<a href=\"javascript:select(\'\${keywordList[i]}\')\">\${keywordList[i]}</a><br>`;
             
             }
             
             // 목록을 출력할 DIV 태그
             let listView = document.getElementById('suggestList');
             
             // DIV 태그 값 저장
             listView.innerHTML = html;
             
             // 목록을 가지고 있는 DIV 태그 출력
             show('suggest');
         } else {
           hide('suggest');
         }
         
            }) //then end
            .catch(console.log);
 
            }//if end
            else{
             hide('suggest');
            }
       }//send end
    
</script>
 
 
</head>
<body>
 
<form name="search" action="./proc.jsp" method="post">
<input type="text" name="keyword" id="keyword" onkeyup="send()" size="70" /> 
<button>검색</button>
 
<!-- 서버로부터 검색된 목록 출력 -->
<div id="suggest">
<div id="suggestList"></div>
</div>
</form>
</body>
</html>
```


