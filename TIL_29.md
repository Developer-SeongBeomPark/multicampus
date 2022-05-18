### DAY 29(5/18 Wed)

---

[]()

[]()

[]()

[]()



#### Jquery

---

장점

 - jQuery는 JavaScript Library 입니다.

 - jQuery는 상당히 단순한 JavaScript programming 입니다.  또한 간결하게 코딩하고
 많은 일을 해주는 JavaScript Library 입니다.

 - CSS의 selecter를 사용하고 있어서 습득하기 쉬우며,  브러우저의 다양성을 처리해
    줌으로  호환성 처리에 시간을 소비할 필요가 없습니다. 

 - 복잡한 Javascript의 구현시 DOM 문법을 매우 간결하게 해주어 개발 속도를  향상
    할 수 있습니다.

 - jQuery의 기능을 확장할 수 있는 plugin 구조를 지원합니다.

 - Ajax를 지원해 줍니다. 





##### jQuery로 작성된 스크립트

 - $(function () {
    의미 : 페이지가 로딩될때를 나타낸다.

 - $("dd:not(:first)").css("display","none");

  의미:첫번째 dd태그를 제외한 나머지 dd태그의 display를 none로 한다.

 - $("+dd", this).slideDown("slow"); 
    의미: 현재 dd의 뒤에 dd를 천천히 올린다. *+dd : 지금 누르는 그 dd 말고 가 다음 dd들*



```html
<!DOCTYPE html>
<html>
 
<head>
  <meta charset="UTF-8" />
  <title> 아코디언판넬 </title>
  <script src="https://code.jquery.com/jquery-3.5.0.js"></script>
  <script type="text/javascript">
    $(function () {
      $("dd:not(:first)").css("display", "none");
      $("dl dt").click(function () {
        if ($("+dd", this).css("display") == "none") {
          $(this).siblings("dd").slideUp("slow");
          $("+dd", this).slideDown("slow");
        }
      });
    });
  </script>
  <style type="text/css">
    * {
      margin: 0;
      padding: 0;
    }
 
    dl {
      width: 400px;
      margin: 50px auto;
    }
 
    dl dt {
      background: #7CADB6;
      border-bottom: 1px solid #FFFFFF;
      cursor: pointer;
    }
 
    dl dd {
      border: 1px solid #7CADB6;
      border-top: none;
      height: 300px;
    }
  </style>
</head>
 
<body>
  <div id="container">
    <dl>
      <dt> 텍스트1</dt>
      <dd>
        <p> 텍스트 텍스트 텍스트 텍스트 텍스트 텍스트 텍스트 텍스트 텍스트
          텍스트 텍스트 텍스트 텍스트 텍스트 텍스트 텍스트 텍스트 텍스트 텍스트 </p>
      </dd>
      <dt> 텍스트 2</dt>
      <dd>
        <p> 텍스트 텍스트 텍스트 텍스트 텍스트 텍스트 텍스트 텍스트 텍스트
          텍스트 텍스트 텍스트 텍스트 텍스트 텍스트 텍스트 텍스트 텍스트 텍스트 </p>
      </dd>
      <dt> 텍스트 3</dt>
      <dd>
        <p> 텍스트 텍스트 텍스트 텍스트 텍스트 텍스트 텍스트 텍스트 텍스트
          텍스트 텍스트 텍스트 텍스트 텍스트 텍스트 텍스트 텍스트 텍스트 텍스트 </p>
      </dd>
    </dl>
  </div>
</body>
 
</html>
```





##### Selector

 - selector를 이용하여 DOM Element를 검색한다.
 - 

1. Selector 기본 문법

 - 사용법: $("")

 - 용어 : 태그 = Element, 속성 = Attribute

 

2. CSS Selector

 (1) tag selector  

  - $("태그명")  : HTML tag를 제어

 (2) id selector

  - $("#id명")   : id 속성을 가진 tag를 제어

 (3) class selector  

  - $(".class명") : class속성을 가진 tag를 제어

 (4) 자손 selector  

  - $("태그1 태그2") : 태그안의 자식태그 제어 



```html
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8" />
<title>자손 셀렉터</title>
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script type="text/javascript">
$(function(){
$(".first strong").css("color","red");
});
</script>
</head>
<body>
<ul>
<li class="first"><strong> 텍스트 </strong> 텍스트 텍스트 텍스트 텍스트 </li>
<li class="second"><strong> 텍스트 </strong> 텍스트 텍스트 텍스트 텍스트 </li>
<li class="third"><strong> 텍스트 </strong> 텍스트 텍스트 텍스트 텍스트 </li>
<li class="fourth"><strong> 텍스트 </strong> 텍스트 텍스트 텍스트 텍스트 </li>
</ul>
 
</body>
</html>
```



(5) 유니버셜 selector 

 - $("*") : 전체태그

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체태그</title>
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script type="text/javascript">
$(function(){
$("li *").css("color","red");
});
</script>
</head>
<body>
<ul>
<li><strong> 텍스트 </strong> 텍스트 텍스트 텍스트 텍스트 </li>
<li><em> 텍스트 </em> 텍스트 텍스트 텍스트 텍스트 </li>
<li><span> 텍스트 </span> 텍스트 텍스트 텍스트 텍스트 </li>
<li> 텍스트텍스트텍스트텍스트 </li>
</ul>
 
</body>
</html>
```



(6) 그룹 selector

 - $("셀렉터1, 셀렉터2") :복수의 셀렉터

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>그룹 셀렉터</title>
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script type="text/javascript">
$(function(){
$("#first , #third").css("color","red");
});
</script>
</head>
<body>
<ul>
<li id="first"> 텍스트 텍스트 텍스트 텍스트 텍스트 </li>
<li id="second"> 텍스트 텍스트 텍스트 텍스트 텍스트 </li>
<li id="third"> 텍스트 텍스트 텍스트 텍스트 텍스트 </li>
<li id="fourth"> 텍스트 텍스트 텍스트 텍스트 텍스트 </li>
</ul>
</body>
</html>
```



##### CSS2 Selector

 (1) 자식 selector 

  - $("부모태그명 > 자식태그명") : 특정 태그의 바로 밑에 자식태그

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자식 셀렉터</title>
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script type="text/javascript">
$(function(){
$("li > strong").css("color","red");
});
</script>
</head>
<body>
<ul>
<li><strong> 텍스트</strong> 텍스트 텍스트 텍스트 텍스트</li>
<li> 텍스트 텍스트 텍스트 텍스트 텍스트 </li>
<li><div><strong> 텍스트 </strong> 텍스트 텍스트 텍스트 텍스트
<span> 텍스트 </span></div></li>
<li> 텍스트 텍스트 텍스트 텍스트 텍스트 </li>
</ul>
</body>
</html>
```



(2) 다음 인접 selector 

 - $("이전+다음")  : 이전의 인접한 다음 태그 선택

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인접 셀렉터</title>
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script type="text/javascript">
$(function(){
$("#second + li").css("color","red");
});
</script>
</head>
<body>
<ul>
<li id="first"> 텍스트 텍스트 텍스트 텍스트 텍스트 </li>
<li id="second"> 텍스트 텍스트 텍스트 텍스트 텍스트 </li>
<li id="third"> 텍스트 텍스트 텍스트 텍스트 텍스트 </li>
<li id="fourth"> 텍스트 텍스트 텍스트 텍스트 텍스트 </li>
 
</ul>
</body>
</html>
```



(3) :first-child Selector

 - $("태그:first-child")  : 동일 태그 안의 첫 태그
```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>first-child 클래스</title>
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script type="text/javascript">
$(function(){
$("li:first-child").css("color","red");
});
</script>
</head>
<body>
<ul>
<li> 텍스트 텍스트 텍스트 텍스트 텍스트 </li>
<li> 텍스트 텍스트 텍스트 텍스트 텍스트 </li>
<li> 텍스트 텍스트 텍스트 텍스트 텍스트 </li>
<li> 텍스트 텍스트 텍스트 텍스트 텍스트 </li>
 
</ul>
<ul>
<li> 텍스트 텍스트 텍스트 텍스트 텍스트 </li>
<li> 텍스트 텍스트 텍스트 텍스트 텍스트 </li>
<li> 텍스트 텍스트 텍스트 텍스트 텍스트 </li>
<li> 텍스트 텍스트 텍스트 텍스트 텍스트 </li>
</ul>
</body>
</html>
```





##### CSS3 Selector

(1) Next Siblings Selector (“prev ~ siblings”) 

   : "prev" 요소 다음에 오는 모든 "siblings" 요소를 선택하고 동일한 부모를 가지며
    필터링 "siblings" 선택기와 일치한다.


```html
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>next siblings demo</title>
  <style>
  div, span {
    display: block;
    width: 80px;
    height: 80px;
    margin: 5px;
    background: #bfa;
    float: left;
    font-size: 14px;
  }
  div#small {
    width: 60px;
    height: 25px;
    font-size: 12px;
    background: #fab;
  }
  </style>
  <script src="https://code.jquery.com/jquery-3.5.0.js"></script>
</head>
<body>
 
<div>div (doesn't match since before #prev)</div>
<span id="prev">span#prev</span>
<div>div sibling</div>
<div>div sibling <div id="small">div niece</div></div>
<span>span sibling (not div)</span>
<div>div sibling</div>
 
<script>
$( "#prev ~ div" ).css( "border", "3px groove blue" );
</script>
 
</body>
</html>
```



(2) :not() Selector

 - $(":not(selector)") : 주어진 selector에 매치되지 않는 모든 요소를 선택한다.

```
```

