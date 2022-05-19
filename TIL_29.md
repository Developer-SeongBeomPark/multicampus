### DAY 29(5/18 Wed)

---

[jQuery](#jQuery)

- [jQuery로 작성된 스크립트]()

- [Selector]()

- [CSS2 Selector]()
- [CSS3 Selector]()



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

```html
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>empty demo</title>
  <style>
  td {
    text-align: center;
  }
  </style>
  <script src="https://code.jquery.com/jquery-3.5.0.js"></script>
</head>
<body>
 
<table border="1">
  <tr><td>TD #0</td><td></td></tr>
  <tr><td>TD #2</td><td></td></tr>
  <tr><td></td><td>TD#5</td></tr>
</table>
 
<script>
$( "td:empty" )
  .text( "Was empty!" )
  .css( "background", "rgb(255,220,200)" );
</script>
 
</body>
</html>
```



(4) jQuery( ":nth-child(index/even/odd/equation)" ) 

 - $("태그:nth-child(index)") : 특정 태그안에서 지정한 번호의 태그
 - 두 개의 <li>를 포함하는 단일 <ul>이 주어지면 $( "li:nth-child(1)" ) 첫 번째 <li> 를 선택하는 반면 $( "li" ).eq( 1 ) 는 두 번째 <li>를 선택한다.
 - .eq(n) 의 n은 0부터 시작한다. eq메소드는 해당하는 한가지만 적용시킨다.



```html
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>nth-child demo</title>
  <style>
  div {
    float: left;
  }
  span {
    color: blue;
  }
  </style>
  <script src="https://code.jquery.com/jquery-3.5.0.js"></script>
</head>
<body>
 
<div>
  <ul>
    <li>John</li>
    <li>Karl</li>
    <li>Brandon</li>
  </ul>
</div>
<div>
  <ul>
    <li>Sam</li>
  </ul>
</div>
<div>
  <ul>
    <li>Glen</li>
    <li>Tane</li>
    <li>Ralph</li>
    <li>David</li>
  </ul>
</div>
 
<script>
$( "ul li:nth-child(2)" ).append( "<span> - 2nd!</span>" );
$( "ul li" ).eq(2).append( "<span> - 3nd!</span>" );
</script>
 
</body>
</html>
```





(5) last-child selector 

 - $("태그:last-child") : 자식태그들 중에 마지막 자식태그 
 - .hover(handlerIn, handlerOut)

```html
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>last-child demo</title>
  <style>
  span.solast {
    text-decoration: line-through;
  }
  </style>
  <script src="https://code.jquery.com/jquery-3.5.0.js"></script>
</head>
<body>
 
<div>
  <span>John,</span>
  <span>Karl,</span>
  <span>Brandon,</span>
  <span>Sam</span>
</div>
<div>
  <span>Glen,</span>
  <span>Tane,</span>
  <span>Ralph,</span>
  <span>David</span>
</div>
 
<script>
$( "div span:last-child" )
  .css({ color:"red", fontSize:"80%" })
  .hover(function() {
    $( this ).addClass( "solast" );
  }, function() {
    $( this ).removeClass( "solast" );
  });
</script>
 
</body>
</html>
```





(6) only-child 유사클래스  

 - $("태그:only-child") : 부모의 자식이 하나인 태그 

```html
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>only-child demo</title>
  <style>
  div {
    width: 100px;
    height: 80px;
    margin: 5px;
    float: left;
    background: #b9e;
  }
  </style>
  <script src="https://code.jquery.com/jquery-3.5.0.js"></script>
</head>
<body>
 
<div>
  <button>Sibling!</button>
  <button>Sibling!</button>
</div>
 
<div>
  <button>Sibling!</button>
</div>
 
<div>
  None
</div>
 
<div>
  <button>Sibling!</button>
  <button>Sibling!</button>
  <button>Sibling!</button>
</div>
 
<div>
  <button>Sibling!</button>
</div>
 
<script>
$( "div button:only-child" ).text( "Alone" ).css( "border", "2px blue solid" );
</script>
 
</body>
</html>
```





###### Attribute

 (1) [attribute]  

  - $("[속성명]")  : 특정 속성을 가진 태그

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>속성 셀렉터</title>
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script>
$(function(){
  $("[id]").css("color","red");
});
</script>
</head>
<body>
<ul>
<li id="first"> 텍스트 텍스트 텍스트 텍스트 텍스트 </li>
<li class="second"> 텍스트 텍스트 텍스트 텍스트 텍스트 </li>
<li id="third"> 텍스트 텍스트 텍스트 텍스트 텍스트 </li>
<li class="fourth"> 텍스트 텍스트 텍스트 텍스트 텍스트 </li>
</ul>
</body>
</html>
```





(2) [attribute='value']

 - $("[속성명='값']")  "|=" : en으로 시작하면서 '-'가 있는 속성을 찾는다.

```html
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>attributeContainsPrefix demo</title>
<style>
a {
display: inline-block;
}
</style>
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
</head>
<body>
 
<a href="example.html" hreflang="en">Some text</a>
<a href="example.html" hreflang="en-UK">Some other text</a>
<a href="example.html" hreflang="english">will not be outlined</a>
 
<script>
$( "a[hreflang|='en']" ).css( "border", "3px dotted green" );
</script>
 
</body>
</html>
```





(3) [attribute^='value']

 - $("태그명[속성명^='값']")  : 특정 속성이 지정한 값으로 시작되는 태그

```html
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>attributeNotEqual demo</title>
  <script src="https://code.jquery.com/jquery-3.5.0.js"></script>
 
  <script type="text/javascript">
    $(function(){
      $("[title^='f']").css("color","red");
    });
  </script>
 </head>
<body>
    <ul>
    <li title="first"> 텍스트 텍스트 텍스트 텍스트 텍스트 </li>
    <li title="second"> 텍스트 텍스트 텍스트 텍스트 텍스트 </li>
    <li title="third"> 텍스트 텍스트 텍스트 텍스트 텍스트 </li>
    <li title="fourth"> 텍스트 텍스트 텍스트 텍스트 텍스트 </li>
    </ul>
</body>
</html>
```



(4) [attribute$='value']

- $("태그명[속성명$='값']")  : 특정 속성이 지정한 값으로 끝나는 태그

```html
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>attributeEndsWith demo</title>
  <script src="https://code.jquery.com/jquery-3.5.0.js"></script>
</head>
<body>
 
<input name="newsletter">
<input name="milkman">
<input name="jobletter">
 
<script>
$( "input[name$='letter']" ).val( "a letter" );
</script>
 
</body>
</html>
```



(5) [attribute*='value']

 - $("태그명[속성명*='값']") : 특정 속성이 지정한 값을 포함하고 있는 태그

```html
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>attributeContains demo</title>
  <script src="https://code.jquery.com/jquery-3.5.0.js"></script>
</head>
<body>
 
<input name="man-news">
<input name="milkman">
<input name="letterman2">
<input name="newmilk">
 
<script>
$( "input[name*='man']" ).val( "has man in it!" );
</script>
 
</body>
</html>
```



(6) [attribute~='value']  

 \- $("태그명[속성 ~= 값]")
 : 공백으로 구분된 주어진 단어를 포함하는 값으로 지정된 속성이 있는 요소를 선택

```html
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>attributeContainsWord demo</title>
  <script src="https://code.jquery.com/jquery-3.5.0.js"></script>
</head>
<body>
 
<input name="man-news">
<input name="milk man">
<input name="letterman2">
<input name="newmilk">
 
<script>
$( "input[name~='man']" ).val( "mr. man is in it!" );
</script>
 
</body>
</html>
```



###### jQuery 필터

(1) .frist()
 ; 일치하는 요소 집합을 집합의 첫 번째 요소로 줄인다.
 인수가 없는 함수이다.

```html
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>first demo</title>
  <style>
  .highlight {
    background-color: yellow;
  }
  </style>
  <script src="https://code.jquery.com/jquery-3.5.0.js"></script>
</head>
<body>
 
<ul>
  <li>Look:</li>
  <li>This is some text in a list.</li>
  <li>This is a note about it.</li>
  <li>This is another note about it.</li>
</ul>
 
<script>
$( "ul li" ).first().addClass( "highlight" );
</script>
 
</body>
</html>
```





(2) even()/odd() 필터

 - 일치하는 요소 집합을 0부터 번호가 지정된 집합의 짝수/홀수로 줄인다.

```html
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>even demo</title>
  <style>
  .highlight {
    background-color: yellow;
  }
  .highlight2 {
    background-color: aqua;
  }
  </style>
  <script src="https://code.jquery.com/jquery-3.5.0.js"></script>
</head>
<body>
 
<ul>
  <li>Look:</li>
  <li>This is some text in a list.</li>
  <li>This is a note about it.</li>
  <li>This is another note about it.</li>
</ul>
 
<script>
$( "ul li" ).even().addClass( "highlight2" );
$( "ul li" ).odd().addClass( "highlight" );
</script>
 
</body>
</html>
```





 

(3) .eq(index)/eq(indexFromEnd), slice(start [,end])

   index - 요소의 0부터 시작하는 위치를 나타내는 정수이다.
  indexFromEnd - 요소의 위치를 나타내는 정수로, 집합의 마지막 요소부터 거꾸로 계산
  eq : 일치하는 요소 집합을 지정된 인덱스에 있는 요소로 줄인다.
  slice : start ~ end까지 또는 start ~끝까지 일치하는 요소 집합으로 줄인다.

```html
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>eq demo</title>
  <style>
  div {
    width: 60px;
    height: 60px;
    margin: 10px;
    float: left;
    border: 2px solid blue;
  }
  .blue {
    background: blue;
  }
  </style>
  <script src="https://code.jquery.com/jquery-3.5.0.js"></script>
</head>
<body>
 
<div></div>
<div></div>
<div></div>
<div></div>
<div></div>
<div></div>
 
<script>
$( "body" ).find( "div" ).eq(2 ).addClass("blue");    
$( "body" ).find( "div" ).slice( 0, 2 ).css("background" ,"yellow" );
$( "body" ).find( "div" ).slice( 3 ).css("background" ,"orange" );
</script>
 
</body>
</html>
```



(4) header/contain/has/parent 필터

 - $(":header")  : h1 ~ h6까지의 heading태그

```html
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>header demo</title>
  <script src="https://code.jquery.com/jquery-3.5.0.js"></script>
</head>
<body>
 
<h1>Header 1</h1>
<p>Contents 1</p>
<h2>Header 2</h2>
<p>Contents 2</p>
 
<script>
$( ":header" ).css({ background: "#ccc", color: "blue" });
</script>
 
</body>
</html>
```



- $(":contains(text)")  : 특정 text를 포함하고 있는 태그

```html
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>contains demo</title>
  <script src="https://code.jquery.com/jquery-3.5.0.js"></script>
</head>
<body>
 
<div>John Resig</div>
<div>George Martin</div>
<div>Malcom John Sinclair</div>
<div>J. Ohn</div>
 
<script>
$( "div:contains('John')" ).css( "text-decoration", "underline" );
</script>
 
</body>
</html>
```





 - $(":has(태그)")    : 특정 태그를 포함하고 있는 태그 

```html
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>has demo</title>
  <style>
  .test {
    border: 3px inset red;
  }
  </style>
  <script src="https://code.jquery.com/jquery-3.5.0.js"></script>
</head>
<body>
 
<div><p>Hello in a paragraph</p></div>
<div>Hello again! (with no paragraph)</div>
 
<script>
$( "div:has(p)" ).addClass( "test" );
</script>
 
</body>
</html>
```



- $(":parent) 
: 하나 이상의 자식 노드(요소 또는 텍스트)가 있는 모든 요소를 선택한다.

```html
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>parent demo</title>
  <style>
  td {
    width: 40px;
    background: green;
  }
  </style>
  <script src="https://code.jquery.com/jquery-3.5.0.js"></script>
</head>
<body>
 
<table border="1">
  <tr><td>Value 1</td><td></td></tr>
  <tr><td>Value 2</td><td></td></tr>
</table>
 
<script>
$( "td:parent" ).fadeTo( 1500, 0.3 );
</script>
 
</body>
</html>
```

