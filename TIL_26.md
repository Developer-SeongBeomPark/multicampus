### DAY 26(5/13 Fri)

---

[]()

[]()

[]()



13. 드롭다운 리스트 상자에 아이템을 추가,삭제,변경

    ```html
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <script>
            // 대분류
            let addressList = ["서울","인천","경기도","강원도"];
            
            // 중분류
            let gugunListSeoul = ["노원구", "강남구", "구로구", "마포구"];
            let gugunListIncheon = ["남동구", "부평구", "서구", "계양구"];
            let gugunListKy = ["부천시", "시흥시", "안양시", "수원시"];
            
            window.onload = function(){
                let sido = document.getElementById('sidoSelect');
                for(i=0 ; i < addressList.length; i++){
                    let optionel = document.createElement('option');
                    optionel.value = addressList[i];
                    optionel.appendChild(document.createTextNode(addressList[i]));
                    sido.appendChild(optionel);
                }
    
                let gugun = document.getElementById("gugunSelect");
                let btnArea = document.getElementById("btnArea");
                gugun.style.display = "none";
                btnArea.style.display = "none";
            }
    
            function changeSidoSelect(){
                let sido = document.getElementById("sidoSelect");
                let idx = sido.options.selectedIndex;
                
                let area = document.getElementById("area"); 
                area.value = "";
     
                gugunSelectFill(idx);
            }
    
            function gugunSelectFill(idx){
                let data = null;
                let gugun = document.getElementById('gugunSelect');
                let btnArea = document.getElementById('btnArea');
                if (idx == 0) { 
                    gugun.style.display = "none";  // 중분류 태그 감추기
                    btnArea.style.display = "none";
                    return;
                }
                if (idx == 1){ data = gugunListSeoul }
                if (idx == 2){ data = gugunListIncheon }
                if (idx == 3){ data = gugunListKy }
                
                if (idx == 4){
                    gugun.style.display = "none"; 
                    alert("현재는 지원하지 않습니다.");
                    return; 
                }
                gugun.innerHTML = "";
                gugun.innerHTML = "<option value = ''>중분류를 선택하세요</option>"
               
                for (i =0 ; i<data.length; i++){   
                    // 새로운 <option value=''>값</option> 태그 생성
                    let optionEl = document.createElement("option");
                
                    // value 속성 태그에 저장
                    optionEl.value = data[i];
                    
                    // text 문자열을 새로 생성한 <option> 태그에 추가
                    optionEl.appendChild (document.createTextNode(data[i]));
                    
                    // 만들어진 option 태그를 <select>태그에 추가
                    gugun.appendChild(optionEl);
                }
        
                gugun.style.display = "";                      
                btnArea.style.display = "";  
            }
    
            function getArea(){
                let area = document.getElementById("area"); // 태그 검색
                let sido = document.getElementById("sidoSelect");
                let gugun = document.getElementById("gugunSelect");
                //alert(sido.value + " " + gugun.value); // 선택값의 출력
                
                area.value = sido.value + " " + gugun.value;
         
            }
    
    
    
    
        </script>
    </head>
    <body>
        <div id="sido">
            <select onChange = "changeSidoSelect();" id="sidoSelect">
                <option value="">대분류를 선택하세요.</option>
            </select>
    
            <select name="" id="gugunSelect">
                <option value="">중분류를 선택하세요</option>
            </select>
    
            <label for="">
                <button id = "btnArea" name = "btnArea" onclick = "getArea()">선택</button>
                선택한 지역 : 
                <input type="text" id = "area" size = "40">
            </label>
        </div>
    </body>
    </html>
    ```



##### Ajax의 이해























##### Ajax 통신 예제

1. Html 파일 비동기 요청

   ```html
   <!DOCTYPE html>
   <html lang="en">
   <head>
       <meta charset="UTF-8">
       <meta http-equiv="X-UA-Compatible" content="IE=edge">
       <meta name="viewport" content="width=device-width, initial-scale=1.0">
       <title>Document</title>
       <script>
           function loadDoc(){
               let xhttp;
               if(window.XMLHttpRequest){
                   xhttp = new XMLHttpRequest();
               } else {
                  // code for IE6, IE5
                   xhttp = ActiveXObject("Microsoft.XMLHTTP");
               } 
               xhttp.onreadystatechange = function(){
                   if (xhttp.readyState == 4 && xhttp.status == 200){
                       alert(xhttp.responseText);
                       document.getElementById("demo").innerHTML = xhttp.responseText;
                   }
               };
    
               xhttp.open("GET","info.html",true);
               xhttp.send();
           }
    
       </script>
   </head>
   <body>
    
       <p id='demo'>Let AJAX change this text.</p>
       <button onclick='loadDoc()'>Change Content</button>
       
   </body>
   </html>
   ```

2. xml 파일 비동기 요청

   ```html
   <!DOCTYPE html>
   <html lang="en">
   <head>
       <meta charset="UTF-8">
       <meta http-equiv="X-UA-Compatible" content="IE=edge">
       <meta name="viewport" content="width=device-width, initial-scale=1.0">
       <title>Document</title>
       <script>
           function loadDoc(){
               let xhttp;
               if(window.XMLHttpRequest){
                   xhttp = new XMLHttpRequest();
               } else {
                  // code for IE6, IE5
                   xhttp = ActiveXObject("Microsoft.XMLHTTP");
               } 
    
               xhttp.onreadystatechange = function(){
                   if (xhttp.readyState == 4 && xhttp.status == 200){
                       xmlDoc = xhttp.responseXML;
                       let txt = '';
                       let x = xmlDoc.getElementsByTagName("ARTIST");
                       console.log(`x : ${x.length}`);
                       for (let i=0; i < x.length ; i++){
                           txt = txt + x[i].childNodes[0].nodeValue + '<br>';
                       }
                       document.getElementById("demo").innerHTML = txt;
                   }else{
                       if (xhttp.readyState != 4 && xhttp.status != 200){
                           alert(xhttp.status)
                       }
                   }
               };
    
               xhttp.open("GET","catalog.xml",true);
               xhttp.send();
           }
    
       </script>
   </head>
   <body>
    
       <p id='demo'>Let AJAX change this text.</p>
       <button onclick='loadDoc()'>Change Content</button>
       
   </body>
   </html>
   ```

   