### DAY 30(5/19 Thu)

---

[jQuery 명령어](#jquery-명령어)

[jQuery 이벤트](#jquery-이벤트)

[jQuery Ajax](#jquery-ajax)

[jQuery Effects](#jquery-effects)



###### jQuery 명령어

(1) 텍스트 변경과 가져오기  

 - text(...)/text()/text(function)
 ; function 

  Type: Function( Integer index, String text ) => String

```html
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>text demo</title>
  <style>
  p {
    color: blue;
    margin: 8px;
  }
  b {
    color: red;
  }
  </style>
  <script src="https://code.jquery.com/jquery-3.5.0.js"></script>
</head>
<body>
 
<p><b>Test</b> Paragraph.</p>
<p></p>
 
<script>
var str = $( "p" ).first().text();
$( "p" ).last().html( str );
</script>
 
</body>
</html>
```

```html
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>text demo</title>
  <style>
  p {
    color: blue;
    margin: 8px;
  }
  </style>
  <script src="https://code.jquery.com/jquery-3.5.0.js"></script>
</head>
<body>
 
<p>Test Paragraph.</p>
<ul>
    <li>list item 1</li>
    <li>list <strong>item</strong> 2</li>
</ul>
 
<script>
$( "p" ).text( "<b>Some</b> new text." );
$( "ul li" ).text(function( index ) {
  return "item number " + ( index + 1 );
});
</script>
 
</body>
</html>
```





(2) HTML 변경과 취득

 - html(...)/html()/html(funtion) 

```html
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>html demo</title>
  <style>
  p {
    margin: 8px;
    font-size: 20px;
    color: blue;
    cursor: pointer;
  }
  b {
    text-decoration: underline;
  }
  button {
    cursor: pointer;
  }
  </style>
  <script src="https://code.jquery.com/jquery-3.5.0.js"></script>
</head>
<body>
 
<p>
  <b>Click</b> to change the <span id="tag">html</span>
</p>
<p>
  to a <span id="text">text</span> node.
</p>
<p>
  This <button name="nada">button</button> does nothing.
</p>
 
<script>
$( "p" ).click(function() {
  var htmlString = $( this ).html();
  $( this ).text( htmlString );
});
</script>
 
</body>
</html>
```

```html
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>html demo</title>
  <style>
  .red {
    color: red;
  }
  </style>
  <script src="https://code.jquery.com/jquery-3.5.0.js"></script>
</head>
<body>
 
<span>Hello</span>
<div></div>
<div></div>
<div></div>
 
<div class="demo-container">
    <div class="demo-box">Demonstration Box</div>
 </div>
 
<script>
$( "div" ).html( "<span class='red'>Hello <b>Again</b></span>" );
$( "div.demo-container" ).html("<p>All new content. <em>You bet!</em></p>");
$( "div.demo-container" ).html(function() {
  var emphasis = "<em>" + $( "p" ).length + " paragraphs!</em>";
  return "<p>All new content for " + emphasis + "</p>";
});
</script>
 
</body>
</html>
 
```





(3) HTML 삽입

 - prepend(...)/append(...)  : 태그 안의 맨앞/맨뒤에 HTML을 삽입함

```html
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>prepend demo</title>
  <style>
  p {
    background: yellow;
  }
  </style>
  <script src="https://code.jquery.com/jquery-3.5.0.js"></script>
</head>
<body>
 
<p>there, friend!</p>
<p>amigo!</p>
 
<script>
$( "p" ).first().prepend( "<b>Hello </b>" );
$( "p" ).last().append( "<strong>Hello</strong>" );
 
</script>
 
</body>
</html>
```

- before(...)/after(...)   : 태그 앞/뒤에 HTML을 삽입함
- p 태그는 앞뒤로 한줄의 공간을 가진다.

```html
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>before demo</title>
  <style>
  p {
    background: yellow;
  }
  </style>
  <script src="https://code.jquery.com/jquery-3.5.0.js"></script>
</head>
<body>
 
<p> is what I said...</p>
<p> is what I said...</p>
<script>
$( "p" ).first().before( "<b>Hello</b>" );
$( "p" ).last().after( "<b>Hello</b>" );
</script>
 
</body>
</html>
```





(4) HTML 이동

 - prependTo()/appendTo(...) 
 - $( "span" ).prependTo( "#foo" );
    : 'span' 를 #foo요소 안의 앞으로 이동
 - $( "span" ).appendTo( "#foo2" );
    : 'span' 를 #foo2요소 안의 뒤로 이동

```html
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>prependTo demo</title>
  <style>
  div {
    background: yellow;
  }
  </style>
  <script src="https://code.jquery.com/jquery-3.5.0.js"></script>
</head>
<body>
 
<div id="foo">FOO!</div>
<div id="foo2">FOO!</div>
<span>I have something to say... </span>
<span>I have not something to say... </span>
<script>
$( "span" ).first().prependTo( "#foo" );
$( "span" ).eq(1).appendTo( "#foo2" );
</script>
 
</body>
</html>
```





 - $( "p" ).first().insertBefore( "#foo" ); p가 #foo요소 앞에 이동
 - $( "p" ).last().insertAfter( "#foo2" );  p가 #foo2요소 뒤로 이동

```html
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>insertBefore demo</title>
  <style>
  #foo,#foo2 {
    background: yellow;
    width:200px;
    height:100px;
  }
  </style>
  <script src="https://code.jquery.com/jquery-3.5.0.js"></script>
</head>
<body>
 
<div id="foo">FOO!</div>
<div id="foo2">FOO!~~</div>
<p>I have something to say... </p>
<p>I have not something to say... </p>
 
<script>
$( "p" ).first().insertBefore( "#foo" );
$( "p" ).last().insertAfter( "#foo2" );
</script>
 
</body>
</html>
```



(5) 다른 태그로 묶음

 - .wrap('<div></div>') ; 각 요소를 <div></div> 태그로 각각 감싼다.
 - .wrapAl('<div></div>')   ; 요소 전체를 <div></div> 태그로 한번에 감싼다.

 - .wrapInner(.'<b></b>')  ; 자식 요소 각각을 <b></b> 태그로 각각 감싼다.

```html
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>wrap demo</title>
  <style>
  div {
    border: 2px solid blue;
  }
  p {
    background: yellow;
    margin: 4px;
  }
  </style>
  <script src="https://code.jquery.com/jquery-3.5.0.js"></script>
</head>
<body>
 
<p>Hello</p>
<p>cruel</p>
<p>World</p>
<hr>
<p>Hello</p>
<p>cruel</p>
<p>World</p>
<hr>
<p>Hello</p>
<p>cruel</p>
<p>World</p>
<script>
$( "p" ).slice(0,3).wrap( "<div></div>" );
$( "p" ).slice(3,6).wrapAll( "<div></div>" );
$( "p" ).slice(6,10).wrapInner( "<b></b>" );
</script>
 
</body>
</html>
```





(6) 태그변경/제거

 

- $( this ).replaceWith( "<div>" + $( this ).text() + "</div>" );
  this 요소를 "<div>" + $( this ).text() + "</div>" 로 바꾼다.


- .remove() : 태그를 제거

```html
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>replaceWith demo</title>
  <style>
  button {
    display: block;
    margin: 3px;
    color: red;
    width: 200px;
  }
  div {
    color: red;
    border: 2px solid blue;
    width: 200px;
    margin: 3px;
    text-align: center;
  }
  </style>
  <script src="https://code.jquery.com/jquery-3.5.0.js"></script>
</head>
<body>
 
<button>First</button>
<button>Second</button>
<button>Third</button>
<button id='rem'>del</button>
 
<div class='rem'>삭제될 요소</div>
 
<script>
$( "button" ).click(function() {
    console.log($(this).attr('id'));
    if($(this).attr('id')=='rem'){
        $('div.rem').remove();
    }
    $( this ).replaceWith( "<div>" + $( this ).text() + "</div>" );
 
});
 
</script>
 
</body>
</html>
```





 

(7) 속성값 변경과 취득

 

 - attr(...,...)  : 지정한 속성값 변경

 - attr(...)    : 지정한 속성값 가져옴

 - removeAttr(...) : 지정한 속성값 제거

```html
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>attr demo</title>
  <style>
 
  </style>
  <script src="https://code.jquery.com/jquery-3.5.0.js"></script>
  <script type="text/javascript">
    $(function(){
        $("a").first().attr("href","http://daum.net/");
        
        $("a").first().text( $("a").attr("href") );
        
        $("a").last().removeAttr("target");
    });
 </script>
 </head>
 <body>
 
    <a href="http://naver.com">링크</a>
    <a href="http://naver.com/" target="_blank">링크</a>
</body>
</html>
 
 
 
 
 
(8) class속성 추가/제거
 
  - addClass(...)    : class 속성 추가
  - removeClass(...) : class 속성 제거
 
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>addClass demo</title>
  <style>
  p {
    margin: 8px;
    font-size: 16px;
  }
  .selected {
    color: blue;
  }
  .highlight {
    background: yellow;
  }
  </style>
  <script src="https://code.jquery.com/jquery-3.5.0.js"></script>
</head>
<body>
 
<p>Hello</p>
<p>and</p>
<p>Goodbye</p>
 
<script>
$( "p" ).addClass( "selected" );
$( "p" ).first().removeClass( "selected" );
 
</script>
</body>
</html>
```



(9) css 제어

 

 \- css(...,...)   : 지정한 CSS 속성값 설정

 \- css(..)    : 지정한 CSS 속성값 가져옴

```html
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>css demo</title>
  <style>
  div {
    width: 60px;
    height: 60px;
    margin: 5px;
    float: left;
  }
 
  p {
    clear:left;
  }
  </style>
  <script src="https://code.jquery.com/jquery-3.5.0.js"></script>
</head>
<body>
 
<span id="result">&nbsp;</span>
 
<div style="background-color:blue;"></div>
<div style="background-color:rgb(15,99,30);"></div>
<div style="background-color:#123456;"></div>
<div style="background-color:#f11;"></div>
 
<p>Just roll the mouse over me.</p>
<p>Or me to see a color change.</p>
<script>
 
$( "div" ).click(function() {
  var color = $( this ).css( "background-color" );
  $( "#result" ).html( "That div is <span style='color:" +
    color + ";'>" + color + "</span>." );
});
 
$( "p" ).mouseover( function() {
  $( this ).css( "color", "red" );
}).mouseout(function() {
  $( this ).css( "color", "black" );
});
 
 
</script>
 
</body>
</html>
```



###### jQuery 이벤트

1.  이벤트가 발생한 태그 얻기

 

- $(function(){........})  : 아래 명령어의 생략형

 $(document).ready(function()(......)  : 웹 페이지를 모두 읽어드리고, 준비가 되었다는 뜻

```
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>click demo</title>
  <style>
  p {
    color: red;
    margin: 5px;
    cursor: pointer;
  }
  p:hover {
    background: yellow;
  }
  </style>
  <script src="https://code.jquery.com/jquery-3.5.0.js"></script>
</head>
<body>
 
<p>First Paragraph</p>
<p>Second Paragraph</p>
<p>Yet one more Paragraph</p>
 
<script>
$( "p" ).click(function() {
  $( this ).slideUp();
});
</script>
 
</body>
</html>
```



 2. toggle()

 - 일치하는 요소를 표시하거나 숨긴다.

```
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>toggle demo</title>
  <style>
  p {
    background: #dad;
    font-weight: bold;
    font-size: 16px;
  }
  </style>
  <script src="https://code.jquery.com/jquery-3.5.0.js"></script>
</head>
<body>
 
<button>Toggle 'em</button>
<p>Hiya</p>
<p>Such interesting text, eh?</p>
 
<script>
$( "button" ).click(function() {
//   $( "p" ).toggle();
  $( "p" ).toggle( "slow" );
});
</script>
 
</body>
</html>
```

3. unbind()
- 요소에서 이전에 연결된 이벤트 핸들러 제거

 ```
  <!doctype html>
 <html lang="en">
 <head>
   <meta charset="utf-8">
   <title>unbind demo</title>
   <style>
   button {
     margin: 5px;
   }
   button#theone {
     color: red;
     background: yellow;
   }
   </style>
   <script src="https://code.jquery.com/jquery-3.5.0.js"></script>
 </head>
 <body>
  
 <button id="theone">Does nothing...</button>
 <button id="bind">Bind Click</button>
 <button id="unbind">Unbind Click</button>
 <div style="display:none;">Click!</div>
  
 <script>
 function aClick() {
   $( "div" ).show().fadeOut( "slow" );
 }
 $( "#bind" ).click(function() {
   $( "#theone" )
     .bind( "click", aClick )
     .text( "Can Click!" );
 });
 $( "#unbind" ).click(function() {
   $( "#theone" )
     .unbind( "click", aClick )
     .text( "Does nothing..." );
 });
 </script>
  
 </body>
 </html>
 ```





 4. on
 - 하나 이상의 이벤트에 대한 이벤트 핸들러 함수를 선택한 요소에 연결한다..

```
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>on demo</title>
  <style>
  p {
    background: yellow;
    font-weight: bold;
    cursor: pointer;
    padding: 5px;
  }
  p.over {
    background: #ccc;
  }
  span {
    color: red;
  }
  </style>
  <script src="https://code.jquery.com/jquery-3.5.0.js"></script>
</head>
<body>
 
<p>Click me!</p>
<span></span>
 
<script>
var count = 0;
$( "body" ).on( "click", "p", function() {
  $( this ).after( "<p>Another paragraph! " + (++count) + "</p>" );
});
</script>
 
</body>
</html>
```



###### jQuery Ajax

- 비동기 통신 처리를 구현하는 기술. 



(1) $.ajaxt() 사용
- 비동기 HTTP(Ajax) 요청을 수행 --> parsing이 필요 없어진다.

```
<!doctype html>
<html lang="en">
 
<head>
    <meta charset="utf-8">
    <title>insertBefore demo</title>
    <script src="https://code.jquery.com/jquery-3.5.0.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $.ajax({
                url: "./test.jsp",
                dataType: "json",
                success: function (data) {
                    console.log(data);
                    // result = jQuery.parseJSON(data);
                    result = data;
                    console.log('Call Back Call: ' + result.name);
                    $("#panel").append(
                        "<tr>" +
                        "<td>이름</td>" +
                        "<td>아이디</td>" +
                        "<td>국어</td>" +
                        "<td>영어</td>" +
                        "</tr>" +
                        "<tr>" +
                        "<td>" + result.name + "</td>" +
                        "<td>" + result.id + "</td>" +
                        "<td>" + result.kuk + "</td>" +
                        "<td>" + result.eng + "</td>" +
                        "</tr>"
                    );
                },
                statusCode: {
                    404: function () {
                        alert("page not found");
                    },
                    500: function () {
                        alert("page error");
                    }
                }
            });
        });
 
    </script>
    <style>
        td {
            border: 1px solid gray;
        }
    </style>
</head>
 
<body>
    <!-- 테이블로 출력 -->
    <table id="panel"></table>
</body>
 
</html>

```





(2) $.getJSON 사용

- GET HTTP 요청을 사용하여 서버에서 JSON 인코딩 데이터를 로드한다.
- flickr.com 에서 제공하는 데이터 정보 API에서 JSON 데이터를 가져와서 출력한다.

- 자바 스크립트는 서로 다른 도메인에 대한 요청을 보안상 제한한다.

- 다른 도메인으로부터 데이터를 가져올 때 JSONP(JSON with Padding)사용할 수 있다.

- JSONP 요청 URL에 '?jsoncallback=?' 를 붙여서 사용한다.
- tags:, tagmode, format 는 서버에 보내는 파라메터이다.

```
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>jQuery.getJSON demo</title>
  <style>
  img {
    height: 100px;
    float: left;
  }
  </style>
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
</head>
<body>
 
<div id="images"></div>
 
<script>
(function() {
  var flickerAPI = "https://api.flickr.com/services/feeds/photos_public.gne?jsoncallback=?";
  $.getJSON( flickerAPI, {
    tags: "mount rainier",
    tagmode: "any",
    format: "json"
  })
    .done(function( data ) {
      console.log(data.items[0]);
      $.each( data.items, function( i, item ) {
        $( "<img>" ).attr( "src", item.media.m ).appendTo( "#images" );
        if ( i === 3 ) {
          return false;
        }
      });
    });
})();
</script>
 
</body>
</html>
```





(3) $.post() 사용

★ 주의: 실행은 톰캣을 실행하고 요청페이 확인 후 Ajax로 요청한다.
- http://localhost:8000/get.jsp : 요청페이지 확인
- http://localhost:8000/postAjax.html : 비동기 통신 요청

```html
<!DOCTYPE html>
<html lang='ko'>
<head>
<meta charset='UTF-8'>
<meta name='viewport' content='width=device-width, initial-scale=1.0'>
<title></title>
<style></style>
<script src='https://code.jquery.com/jquery-3.5.0.js'></script>
<script>
function requestCheck(){
    let param = $('#frmSungjuk').serialize();
    console.log(`param:${param}`);
    $.post(
        'get.jsp',
        param,
        function(data){
            display(data);
       },'json')
       .fail(function(){
           alert('error');
       });
}
 
function display(result){
    $('#panel').text('').append(
        `성명: ${result.name}
         국어: ${result.kuk}
         영어: ${result.eng}
         총점: ${result.tot}
         평균: ${result.avg}`
    );
 
}
</script>
</head>
<body>
<div id="panel">
</div>
<hr>
<form action="" id="frmSungjuk">
    성명 :<input type="text" name="name" value="가길동">
    국어 :<input type="text" name="kuk" value="80">
    영어 :<input type="text" name="eng" value="100">
    <button type="button" onclick='requestCheck()'>성적계산</button>  
</form>
</body>
</html>
```



(4) $.ajax() 사용

★ 주의: 실행은 톰캣을 실행하고 요청페이 확인 후 Ajax로 요청한다.
- http://localhost:8000/get.jsp : 요청페이지 확인
- http://localhost:8000/testAjax.html : 비동기 통신 요청

```html
<!doctype html>
<html lang="en">
 
<head>
    <meta charset="utf-8">
    <title>insertBefore demo</title>
    <script src="https://code.jquery.com/jquery-3.5.0.js"></script>
    <script type="text/javascript">
       function requestCheck() {
            let param = $("#frmSungjuk").serialize();
            console.log(param);
            $.ajax({
                url: "./get.jsp",
                dataType: "json",
                data : param,
                success: function (data) {
                    console.log(data);
                    console.log('Call Back Call: ' + result.name);
                    display(data);
                },
                statusCode: {
                    404: function () {
                        alert("page not found");
                    },
                    500: function () {
                        alert("page error");
                    }
                }
            });
        }   
        function display(result){
            $("#panel").text("").append(
                    " 성명: " + result.name+
                    " 국어: " + result.kuk+
                    " 영어: " + result.eng+
                    " 총점: " + result.tot+
                    " 평균: " + result.avg
            );        
        }
    </script>
 
</head>
 
<body>
 
 
    <div id="panel" align="center"></div>
    <hr>
    <form id="frmSungjuk">
        성명: <input type="text" name="name"  value='가길동'/><br/>
        국어: <input type="text" name="kuk"  value='80'/><br/>
        영어: <input type="text" name="eng"  value='100'/><br/><br/>
    
        <button type="button" onclick='requestCheck()'>성적계산</button>  
    
    </form>
 
</body>
 
</html>
 
```





###### jQuery Effects

1. jQuery Hide/Show

 - jQuery는 Html elements를 숨기고 보여준다

 - 파라메터에 speed와 callback함수명이 올수있다.

 - speed: slow, fast, milliseconds(초단위)

 - callback함수명 :hidden, show 한후 실행할 함수 호출

 - toggle(): hide(), show()가 번갈아 호출



(1) hide()/show()

 ```
 <!DOCTYPE html>
 <html>
 <head>
     <script src="https://code.jquery.com/jquery-3.5.0.js"></script>
 <script>
 $(document).ready(function(){
     $("#hide").click(function(){
         $("p").hide();
     });
     $("#show").click(function(){
         $("p").show();
     });
 });
 </script>
 </head>
 <body>
  
 <p>If you click on the "Hide" button, I will disappear.</p>
  
 <button id="hide">Hide</button>
 <button id="show">Show</button>
  
 </body>
 </html>
 ```





(2) hide(speed,callback)/show(speed,callback)

 ```
 <!DOCTYPE html>
 <html>
 <head>
     <script src="https://code.jquery.com/jquery-3.5.0.js"></script>
     <script>
         $(document).ready(function(){
             $("button").click(function(){
                 $("p").hide(1000);
             });
         });
     </script>
 </head>
 <body>
  
 <button>Hide</button>
  
 <p>This is a paragraph with little content.</p>
 <p>This is another small paragraph.</p>
  
 </body>
 </html>
 ```



2. jQuery Fade

(1) fadeIn() - 보여짐/ fadeOut()- 안보임

```

<!DOCTYPE html>
<html>
<head>
    <style>
        div {
            width:80px;height:80px;display:none;
        }
        div#div1{
            background-color:red;
        }
        div#div2{
            background-color:green;
        }
        div#div3{
            background-color:blue;
        }
    </style>
    <script src="https://code.jquery.com/jquery-3.5.0.js"></script>
    <script>
        $(document).ready(function(){
            $("button").first().click(function(){
                $("#div1").fadeIn();
                $("#div2").fadeIn("slow");
                $("#div3").fadeIn(3000);
            });
            $("button").last().click(function(){
                $("#div1").fadeOut();
                $("#div2").fadeOut("slow");
                $("#div3").fadeOut(3000);
            });
        });
    </script>
</head>
<body>
 
<p>Demonstrate fadeIn()/fadeOut with different parameters.</p>
 
<button>Click to fade in boxes</button><br>
<button>Click to fade out boxes</button><br<br>
 
<div id="div1"></div><br>
<div id="div2"></div><br>
<div id="div3"></div>
 
</body>
</html>
```



(2) .fadeToggle( [duration ] [, easing ] [, complete ] )

 - duration : 애니메이션 실행 시간을 결정하는 문자열 또는 숫자

 - easing : 전환에 사용할 여유 함수를 나타내는 문자열(swing, linear)

 - complete : 애니메이션이 완료되면 호출할 함수로, 일치하는 요소당 한 번 호출된다.

```
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>fadeToggle demo</title>
  <script src="https://code.jquery.com/jquery-3.5.0.js"></script>
</head>
<body>
 
<button>fadeToggle p1</button>
<button>fadeToggle p2</button>
<p>This paragraph has a slow, linear fade.</p>
<p>This paragraph has a fast animation.</p>
<div id="log"></div>
 
<script>
$( "button" ).first().click(function() {
  $( "p" ).first().fadeToggle( "slow", "linear" );
});
$( "button" ).last().click(function() {
  $( "p" ).last().fadeToggle( "fast", function() {
    $( "#log" ).append( "<div>finished</div>" );
  });
});
</script>
 
</body>
</html>
```



(3) .fadeTo( duration, opacity [, complete ] )

 - duration : 애니메이션 실행 시간을 결정하는 문자열 또는 숫자
 - opacity : 대상 불투명도를 나타내는 0과 1 사이의 숫자

 - complete : 애니메이션이 완료되면 호출할 함수

 - 일치하는 요소의 불투명도를 조정한다.

```
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>fadeTo demo</title>
  <script src="https://code.jquery.com/jquery-3.5.0.js"></script>
</head>
<body>
 
<p>
Click this paragraph to see it fade.
</p>
 
<p>
Compare to this one that won't fade.
</p>
 
<script>
$( "p" ).first().click(function() {
  $( this ).fadeTo( "slow", 0.33 );
});
</script>
 
</body>
</html>
```





3. jQuery Slide
   - 슬라이딩 동작으로 일치하는 요소를 표시한다.

```
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>slideDown demo</title>
  <style>
  div {
    background: #de9a44;
    margin: 3px;
    width: 80px;
    height: 40px;
    display: none;
    float: left;
  }
  </style>
  <script src="https://code.jquery.com/jquery-3.5.0.js"></script>
</head>
<body>
 
Click me!
<div></div>
<div></div>
<div></div>
 
<script>
$( document.body ).click(function () {
  if ( $( "div" ).first().is( ":hidden" ) ) {
    $( "div" ).slideDown( "slow" );
  } else{
    $( "div" ).slideUp("slow");
  }
});
</script>
 
</body>
</html>
```





- slideToggle()

```
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>slideToggle demo</title>
  <style>
  p {
    width: 400px;
  }
  </style>
  <script src="https://code.jquery.com/jquery-3.5.0.js"></script>
</head>
<body>
 
<button>Toggle</button>
<p>
  This is the paragraph to end all paragraphs.  You
  should feel <em>lucky</em> to have seen such a paragraph in
  your life.  Congratulations!
</p>
 
<script>
$( "button" ).click(function() {
  $( "p" ).slideToggle( "slow" );
});
</script>
 
</body>
</html>
```





4. animation()
   - CSS 속성 집합의 사용자 지정 애니메이션을 수행한다.

```
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>animate demo</title>
  <style>
  div {
    background-color: #bca;
    width: 100px;
    border: 1px solid green;
  }
  </style>
  <script src="https://code.jquery.com/jquery-3.5.0.js"></script>
</head>
<body>
 
<button id="go">&raquo; Run</button>
<div id="block">Hello!</div>
 
<script>
// Using multiple unit types within one animation.
 
$( "#go" ).click(function() {
  $( "#block" ).animate({
    width: "70%",
    opacity: 0.4,
    marginLeft: "2em",
    fontSize: "3em",
    borderWidth: "10px"
  }, 1500 );
});
</script>
 
</body>
</html>
```

