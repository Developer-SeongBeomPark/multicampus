### DAY 19(4/29 Fri)

---

[Table](#table)

[Lists](#lists)

[Forms](#forms)

[Semantic Tags](#semantic-tags)





#### HTML

---

##### Table

1. border

   ```html
   <!DOCTYPE html>
   <html>
    
   <head>
   <style>
   table, th, td {
       border: 1px solid black;
   }
   </style>
   </head>
    
   <body>
    
   <table style="width:100%">
     <tr>
       <td>Jill</td>
       <td>Smith</td> 
       <td>50</td>
     </tr>
     <tr>
       <td>Eve</td>
       <td>Jackson</td> 
       <td>94</td>
     </tr>
     <tr>
       <td>John</td>
       <td>Doe</td> 
       <td>80</td>
     </tr>
   </table>
    
   </body>
   </html>
   ```

2. border-collapse : collapse;

   ```html
   <!DOCTYPE html>
   <html>
    
   <head>
   <style>
   table, th, td {
       border: 1px solid black;
       border-collapse: collapse;
   }
   </style>
   </head>
    
   <body>
    
   <table style="width:100%">
     <tr>
       <td>Jill</td>
       <td>Smith</td> 
       <td>50</td>
     </tr>
     <tr>
       <td>Eve</td>
       <td>Jackson</td> 
       <td>94</td>
     </tr>
     <tr>
       <td>John</td>
       <td>Doe</td> 
       <td>80</td>
     </tr>
   </table>
    
   </body>
   </html>
   
   ```

3. th tag

   ```html
   <!DOCTYPE html>
   <html>
    
   <head>
   <style>
   table, th, td {
       border: 1px solid black;
       border-collapse: collapse;
   }
   th, td {
       padding: 5px;
   }
   </style>
   </head>
    
   <body>
    
   <table style="width:100%">
     <tr>
       <th>Firstname</th>
       <th>Lastname</th> 
       <th>Points</th>
     </tr>
     <tr>
       <td>Jill</td>
       <td>Smith</td> 
       <td>50</td>
     </tr>
     <tr>
       <td>Eve</td>
       <td>Jackson</td> 
       <td>94</td>
     </tr>
     <tr>
       <td>John</td>
       <td>Doe</td> 
       <td>80</td>
     </tr>
   </table>
    
   </body>
   </html>
   ```

4. colgroup, col

   ```html
   <!DOCTYPE html>
   <html>
   <head>
   <style>
   table, th, td {
       border: 1px solid black;
   }
   </style>
   </head>
   <body>
    
   <table>
     <colgroup>
       <col span="2" style="background-color:red">
       <col style="background-color:yellow">
     </colgroup>
     <tr>
       <th>ISBN</th>
       <th>Title</th>
       <th>Price</th>
     </tr>
     <tr>
       <td>3476896</td>
       <td>My first HTML</td>
       <td>$53</td>
     </tr>
     <tr>
       <td>5869207</td>
       <td>My first CSS</td>
       <td>$49</td>
     </tr>
   </table>
    
   </body>
   </html>
   ```

5. Cell Padding

   ```html
   <!DOCTYPE html>
   <html>
    
   <head>
   <style>
   table, th, td {
       border: 1px solid black;
       border-collapse: collapse;
   }
   th, td {
       padding: 15px;
   }
   </style>
   </head>
    
   <body>
    
   <table style="width:100%">
     <tr>
       <td>Jill</td>
       <td>Smith</td> 
       <td>50</td>
     </tr>
     <tr>
       <td>Eve</td>
       <td>Jackson</td> 
       <td>94</td>
     </tr>
     <tr>
       <td>John</td>
       <td>Doe</td> 
       <td>80</td>
     </tr>
   </table>
    
   <p>Try to change the padding to 5px.</p>
    
   </body>
   </html>
   ```

6. border-spacing

   ```html
   <!DOCTYPE html>
   <html>
    
   <head>
   <style>
   table, th, td {
       border: 1px solid black;
       padding: 5px;
   }
   table {
       border-spacing: 15px;
   }
   </style>
   </head>
    
   <body>
    
   <table style="width:100%">
     <tr>
       <td>Jill</td>
       <td>Smith</td> 
       <td>50</td>
     </tr>
     <tr>
       <td>Eve</td>
       <td>Jackson</td> 
       <td>94</td>
     </tr>
     <tr>
       <td>John</td>
       <td>Doe</td> 
       <td>80</td>
     </tr>
   </table>
    
   <p>Try to change the border-spacing to 5px.</p>
    
   </body>
   </html>
   ```

7.  colspan, rowspan

   ```html
   Colspan
   
   <!DOCTYPE html>
   <html>
    
   <head>
   <style>
   table, th, td {
       border: 1px solid black;
       border-collapse: collapse;
   }
   th, td {
       padding: 5px;
       text-align: left;    
   }
   </style>
   </head>
    
   <body>
    
   <h2>Cell that spans two columns:</h2>
   <table style="width:100%">
     <tr>
       <th>Name</th>
       <th colspan="2">Telephone</th>
     </tr>
     <tr>
       <td>Bill Gates</td>
       <td>555 77 854</td>
       <td>555 77 855</td>
     </tr>
   </table>
    
   </body>
   </html>
   ```

   ```html
   Rowspan
   
   <!DOCTYPE html>
   <html>
    
   <head>
   <style>
   table, th, td {
       border: 1px solid black;
       border-collapse: collapse;
   }
   th, td {
       padding: 5px;
       text-align: left;    
   }
   </style>
   </head>
    
   <body>
    
   <h2>Cell that spans two rows:</h2>
   <table style="width:100%">
     <tr>
       <th>Name:</th>
       <td>Bill Gates</td>
     </tr>
     <tr>
       <th rowspan="2">Telephone:</th>
       <td>555 77 854</td>
     </tr>
     <tr>
       <td>555 77 855</td>
     </tr>
   </table>
    
   </body>
   </html>
   
   ```

8. CSS를 적용한 Table

   ```html
   <!DOCTYPE html>
   <html>
    
   <head>
   <style>
   table, th, td {
       border: 1px solid black;
       border-collapse: collapse;
   }
   th, td {
       padding: 5px;
       text-align: left;
   }
   table#t01 {
       width: 100%;    
       background-color: #f1f1c1;
   }
   </style>
   </head>
    
   <body> 
   <table id="t01">
     <tr>
       <th>First Name</th>
       <th>Last Name</th> 
       <th>Points</th>
     </tr>
     <tr>
       <td>Jill</td>
       <td>Smith</td> 
       <td>50</td>
     </tr>
     <tr>
       <td>Eve</td>
       <td>Jackson</td> 
       <td>94</td>
     </tr>
     <tr>
       <td>John</td>
       <td>Doe</td> 
       <td>80</td>
     </tr>
   </table>
    
   </body>
   </html>
   ```

   ```html
   <!DOCTYPE html>
   <html>
    
   <head>
   <style>
   table {
       width:100%;
   }
   table, th, td {
       border: 1px solid black;
       border-collapse: collapse;
   }
   th, td {
       padding: 5px;
       text-align: left;
   }
   table#t01 tr:nth-child(even) {
       background-color: #eee;
   }
   table#t01 tr:nth-child(odd) {
      background-color:#fff;
   }
   table#t01 th {
       background-color: black;
       color: white;
   }
   </style>
   </head>
    
   <body>
    
   <table id="t01">
     <tr>
       <th>First Name</th>
       <th>Last Name</th> 
       <th>Points</th>
     </tr>
     <tr>
       <td>Jill</td>
       <td>Smith</td> 
       <td>50</td>
     </tr>
     <tr>
       <td>Eve</td>
       <td>Jackson</td> 
       <td>94</td>
     </tr>
     <tr>
       <td>John</td>
       <td>Doe</td> 
       <td>80</td>
     </tr>
   </table>
    
   </body>
   </html>
   ```

   



##### Lists

1. Unordered Lists

   ```html
   <!DOCTYPE html>
   <html>
   <body>
    
   <h2>Unordered List with Disc Bullets</h2>
    
   <ul style="list-style-type:disc">
     <li>Coffee</li>
     <li>Tea</li>
     <li>Milk</li>
   </ul>  
    
   <ul style="list-style-type:circle">
     <li>Coffee</li>
     <li>Tea</li>
     <li>Milk</li>
   </ul>
     
   <ul style="list-style-type:square">
     <li>Coffee</li>
     <li>Tea</li>
     <li>Milk</li>
   </ul>  
    
   <ul style="list-style-type:none">
     <li>Coffee</li>
     <li>Tea</li>
     <li>Milk</li>
   </ul>  
    
   </body>
   </html>
   ```

2. Ordered Lists

   ```html
   <!DOCTYPE html>
   <html>
   <body>
    
   <h2>Ordered List with Numbers</h2>
    
   <ol type="1">
     <li>Coffee</li>
     <li>Tea</li>
     <li>Milk</li>
   </ol>  
    
   <ol type="A">
     <li>Coffee</li>
     <li>Tea</li>
     <li>Milk</li>
   </ol>  
    
   <ol type="a">
     <li>Coffee</li>
     <li>Tea</li>
     <li>Milk</li>
   </ol>  
    
   <ol type="I">
     <li>Coffee</li>
     <li>Tea</li>
     <li>Milk</li>
   </ol>  
    
   <ol type="i">
     <li>Coffee</li>
     <li>Tea</li>
     <li>Milk</li>
   </ol>  
    
   </body>
   </html>
   ```

3. Description Lists

   ```html
   <!DOCTYPE html>
   <html>
   <body>
    
   <h2>A Description List</h2>
    
   <dl>
     <dt>Coffee</dt>
     <dd>- black hot drink</dd>
     <dt>Milk</dt>
     <dd>- white cold drink</dd>
   </dl>
    
   </body>
   </html>
   ```

4. Lists inside Lists

   ```html
   <!DOCTYPE html>
   <html>
   <body>
    
   <h2>A Nested List</h2>
    
   <ul>
     <li>Coffee</li>
     <li>Tea
       <ul>
       <li>Black tea</li>
       <li>Green tea</li>
       </ul>
     </li>
     <li>Milk</li>
   </ul>
    
   </body>
   </html>
   ```

5. Horiziontal Lists

   ```html
   <!DOCTYPE html>
   <html>
    
   <head>
   <style>
   ul#menu li {
       display:inline;
   }
   </style>
   </head>
    
   <body>
    
   <h2>Horizontal List</h2>
    
   <ul id="menu">
     <li>HTML</li>
     <li>CSS</li>
     <li>JavaScript</li>
     <li>PHP</li>
   </ul>  
    
   </body>
   </html>
   ```

   ```html
   <!DOCTYPE html>
   <html>
    
   <head>
   <style>
   ul#menu {
       padding: 0;
   }
    
   ul#menu li {
       display: inline;
   }
    
   ul#menu li a {
       background-color: black;
       color: white;
       padding: 10px 20px;
       text-decoration: none;
       border-radius: 4px 4px 0 0;
   }
    
   ul#menu li a:hover {
       background-color: orange;
   }
   </style>
   </head>
    
   <body>
    
   <h2>Horizontal List</h2>
    
   <ul id="menu">
    <li><a href="/html/default.asp">HTML</a></li>
    <li><a href="/css/default.asp">CSS</a></li>
    <li><a href="/js/default.asp">JavaScript</a></li>
    <li><a href="/php/default.asp">PHP</a></li>
   </ul>  
    
   </body>
   </html>
   ```





##### Forms

1. fieldset : 폼 안에서 관련있는 data를 분류

   legend : fieldset의 타이틀

   ```html
   <!DOCTYPE html>
   <html>
   <head>
   <meta charset="UTF-8">
   <title>Insert title here</title>
   </head>
   <body>
   	<form action = "action_page.jsp", method="get">
   		<fieldset>
   			<legend>Personal infromation</legend>
   			First name:<br>
   			<input type = "text" name = "firstname" value = "Mickey">
   			<br>
   			Last name : <br>
   			<input type = "text" name = "Lastname" value = "Mouse">
   			<br><br>
   			<input type = "submit" value = "Submit">
   		
   		</fieldset>
   	</form>
   </body>
   </html>
   ```

2. input

   ```html
   <!DOCTYPE html>
   <html>
   <head>
   <meta charset="UTF-8">
   <title>Insert title here</title>
   </head>
   <body>
   	<form>
   		<!-- label input : inline--> <!--label을 사용하면 이름을 클릭해도 동작이 진행되게 만듬-->
   		<label for="i_name">name : </label>
   		<input id='i_name'type='text'>
   		<br>
   		
   		<label>성별 : </label>
   		<input id='i_gender'type='checkbox' id = "a"><label for = "a">남자</label>
   		<input id='i_gender'type='radio' id = "b"><label for = "b">여자</label> <!--radio : 한번 선택하면 못 무름 checkbox : 선택, 선택취소 가능-->
   		<br>
   
   		<input id='i_name'type='color'>
   		<input id='i_name'type='file'>
   		<input id='i_name'type='password'>
   
   		<input id='i_name'type='button' value="확인">
   		<button type = "reset">초기화</button>
   		<br><br>
   		
   		<select>
   			<option>학생</option>
   			<option>공무원</option>
   			<option>회사원</option>
   		</select>
   	</form>
   </body>
   </html>
   ```



##### Semantic Tags

- header
- nav
- footer
- main(article, section, aside)
- figure,figcaption
- details,summary
- mark
- time
- em vs i
- b vs strong
- button vs a

