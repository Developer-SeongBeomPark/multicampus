<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html> 
<html> 
<head>
  <title>상품메인페이지</title>
  <meta charset="utf-8">
  <link rel="stylesheet" href="/css/style.css">
  <script>
  	function detail(contentsno){
  		let url = "/contents/detail/" + contentsno;
  		url += "?nowPage=${nowPage}";
  		location.href = url;
  	}
  </script>
</head>
<body> 
 
<div class="container">
	  <c:choose>
	      <c:when test="${cateno==1 }">
	      <h3>Jean</h3>
	      </c:when>
	      <c:when test="${cateno==2 }">
	      <h3>Bag</h3>
	      </c:when>
	      <c:when test="${cateno==3 }">
	      <h3>Shoes</h3>
	      </c:when>
      </c:choose>
      
<c:choose>   
<c:when test="${empty list}">
   <div class="row">
   <h2>상품 준비중 입니다.</h2> 
   <p><img src="/contents/default.jpg" class="img-thumbnail"  width="236" height="306"></p>
   
   </div>
</c:when>
<c:otherwise>
<c:set var="list" value="${list}"/>
<div class="row">
    <c:forEach var="dto" begin="0" end="3" items="${list}">
    <div class="col-sm-3">
      <c:choose>
      <c:when test="${cateno==1 }">
      <h3>Ripped Skinny</h3>
      </c:when>
      <c:when test="${cateno==2 }">
      <h3>Luxury BAG</h3>
      </c:when>
      </c:choose>
      <p>
      <!--<a href="/contents/detail/${dto.contentsno }">-->
      <a href = "javascript:detail('${dto.contentsno }')">
       <img src="/contents/${dto.filename }" class="img-thumbnail"  width="236" height="306"></a></p>
        <p> ${dto.pname }<br> <b>가격 :  ${dto.price }</b> </p>
        <div> 
         <a href="/contents/detail/${dto.contentsno }"><img class='btn'src="/svg/cart4.svg"/></a>
         <a href="/contents/detail/${dto.contentsno }"><img class='btn' src="/svg/bag-heart-fill.svg"/></a>
        </div>
 
    </div>
    </c:forEach>
</div>

<br><br>

 <div class="row">
    <c:forEach var="dto" begin="4" end="7" items="${list}">
    <div class="col-sm-3">
      <c:choose>
      <c:when test="${cateno==1 }">
      <h3>Vintage Skinny</h3>
      </c:when>
      <c:when test="${cateno==2 }">
      <h3>Classy BAG</h3>
      </c:when>
      </c:choose>
      <p>
       <!--<a href="/contents/detail/${dto.contentsno }">-->
       <a href = "javascript:detail('${dto.contentsno }')">
        <img src="/contents/${dto.filename }" class="img-thumbnail"  width="236" height="306"></a></p>
        <p> ${dto.pname }<br> <b>가격 : ${dto.price }</b> </p>
        <div> 
         <a href="/contents/detail/${dto.contentsno }"><img class='btn'src="/svg/cart4.svg"/></a>
         <a href="/contents/detail/${dto.contentsno }"><img class='btn' src="/svg/bag-heart-fill.svg"/></a>
        </div>
    </div>
    </c:forEach>
 </div>
	${paging }
</c:otherwise>
</c:choose>
</div>
</body> 
</html> 