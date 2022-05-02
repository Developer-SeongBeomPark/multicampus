### DAY 20(5/2 Mon)

---

[]()

[]()

[]()



#### CSS

---

##### Selectors

Universal : *

Type : Tag

ID : #id

Class : .class

State : :

Attribute : []



```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	* {
		color : green; /* '*' : 전부 다 적용   */
	}

	li {
	color : blue;
	}
	
	li#special { /* '#' : id 적용*/
	color : pink;
	}
	
	.red {   /*  '.' : class 적용  */
	width : 100px;
	height: 100px;
	background : yellow;
	}
	
	
	button:hover { /* ':' : state(상태) */
	color : red;
	background : beige;
	}
	
	/* [] */
	
	a[href] {
	color : purple;
	}
	
	
	a[href='naver.com'] {
	color : skyblue;
	}
	
	a[href^='naver'] { /* '^' : naver로 시작하는 링크 */
	color : red;
	}
	
	a[href$='.com'] { /*  '$' : .com으로 끝나는 링크 */
	color : purple;
	}

</style>

</head>
<body>
	<ol>
		<li id='special'>First</li>
		<li>second</li>
	</ol>
	<h1 id='special'>Hello</h1>
	<button>Button 1</button>
	<button>Button 2</button>
	<div class='red'></div>
	<div class='blue'></div>
	<a href="naver.com">Naver</a>
	<a href="googlenaver.com">Google</a>
	<a>Empty</a>
</body>
</html>
```



##### Background

* background-color

* background-image

* background-repeat : 배경이미지의 반복

  - repeat : 반복 적용(default)
  - repeat-x : 배경이미지가 가로방향으로만 적용
  - repeat-y : 배경이미지가 세로방향으로만 적용
  - no-repeat : 한번만 적용

  ```html
  <!DOCTYPE html>
  <html>
  <head>
  <style>
  	body {
  		background-image: url("tree.jpg");
  		background-repeat: no-repeat;
  	}
  </style>
  </head>
  <body>
   
  	<h1>Hello World!</h1>
  	<p>W3Schools background image example.</p>
  	<p>The background image is only showing once, but it is disturbing the reader!</p>
  	
  </body>
  </html>
  ```

* background-position --> background-repeat : no-repeat 일때, 이미지의 위치를 변경.

  - top left / top center / top right
  - center left / center center / center right
  - bottom left / bottom center / bottom right

  ```html
  <!DOCTYPE html>
  <html>
  <head>
  <style>
  	body {
  		background-image: url("tree.jpg");
  		background-repeat: no-repeat;
  		background-position: right top;
  		margin-right: 200px;
  	}
  </style>
  </head>
  <body>
   
  	<h1>Hello World!</h1>
  	<p>W3Schools background no-repeat, set position example.</p>
  	<p>Now the background image is only shown once, and positioned away from the text.</p>
  	<p>In this example we have also added a margin on the right side, so the background image will never disturb the text.</p>
  </body>
  </html>
  ```

* background-attachment : 배경 이미지를 뷰포트 내에서 고정할지, 아니면 자신의 컨테이닝 블록과 함께 스크롤할지 지정한다.

  ```html
  <!DOCTYPE html>
  <html>
  <head>
  <style> 
  #myDIV {
      width: 300px;
      height: 300px;
      background: lightblue url('tree.jpg') no-repeat;
      color: white;
      overflow: auto;
  }
  </style>
  </head>
  <body>
   
  <p>Click the radio buttons and scroll the DIV element to see the effect of the background-attachment property:</p>
   
  <form name="myForm">
    <input type="radio" name="myAtt" value="scroll" onclick="myFunction()" checked>scroll <!-- submit하면 value속성에 해당하는 값이 전송된다. -->
    <input type="radio" name="myAtt" value="local" onclick="myFunction()">local
  </form>
   
  <div id="myDIV">
    <h1>Hello</h1>
    <h1>Hello</h1>
    <h1>Hello</h1>
    <h1>Hello</h1>
    <h1>Hello</h1>
    <h1>Hello</h1>
    <h1>Hello</h1>
    <h1>Hello</h1>
    <h1>Hello</h1>
    <h1>Hello</h1>
    <h1>Hello</h1>
    <h1>Hello</h1>
    <h1>Hello</h1>
    <h1>Hello</h1>
    <h1>Hello</h1>
    <h1>Hello</h1>
    <h1>Hello</h1>
    <h1>Hello</h1>
    <h1>Hello</h1>
    <h1>Hello</h1>
  </div>
   
  <script>
  function myFunction() {
      if (document.forms["myForm"]["myAtt"][0].checked) {
        document.getElementById("myDIV").style.backgroundAttachment = "scroll";
      } else {
        document.getElementById("myDIV").style.backgroundAttachment = "local";
      }
  }
  </script>
   
  </body>
  </html>
  ```

  

##### 테두리

![img](http://lectureblue.pe.kr/ckstorage/images/was/html_css/08/css01.jpg)

