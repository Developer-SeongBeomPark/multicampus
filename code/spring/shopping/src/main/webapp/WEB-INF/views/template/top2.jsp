<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath }" />
<c:choose>
	<c:when
		test="${not empty sessionScope.id && sessionScope.grade == 'A'}">
		<c:set var="str">관리자 페이지 입니다.</c:set>
	</c:when>
	<c:when
		test="${not empty sessionScope.id && sessionScope.grade != 'A'}">
		<c:set var='str'>안녕하세요  ${sessionScope.id } 님!</c:set>
	</c:when>
	<c:otherwise>
		<c:set var="str">기본 페이지 입니다.</c:set>
	</c:otherwise>
</c:choose>
<!DOCTYPE html>
<html>
<head>
<title>memo</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"></script>

<style type="text/css">
#grade {
	color: white;
}
</style>

<style>
$
(
function
(
)
{
$.
ajax
({
url
:
"/contents/getCategory"
,
type
:

 

"GET"
,
dataType
:

 

"json"
,
success
:

 

function(
data
)
{


	
for
(
 
var
i
=
 
0;
i
<
data.length;
i
++)
{
$('#pmenu').append("<li><a
href='/contents/mainlist/"+data[i].cateno+"'>"
+
data[i].catename
+
"</a></li>");
}
}
,
error: function(request, status, error) {alert ("code = "+
	request.status + " message = " + request.responseText + " error = " +
	error); // 실패 시 처리
	
}
}
)
;//
ajax
 
end

	
}
)
;//
페이지로딩
</style>
</head>
<body>
	<!--상단메뉴-->
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
		<div class="container-fluid">
			<button type="button" class="btn btn-secondary" onclick = "location.href='${root}/'">
				<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
					fill="currentColor" class="bi bi-shop" viewBox="0 0 16 16">
  <path
						d="M2.97 1.35A1 1 0 0 1 3.73 1h8.54a1 1 0 0 1 .76.35l2.609 3.044A1.5 1.5 0 0 1 16 5.37v.255a2.375 2.375 0 0 1-4.25 1.458A2.371 2.371 0 0 1 9.875 8 2.37 2.37 0 0 1 8 7.083 2.37 2.37 0 0 1 6.125 8a2.37 2.37 0 0 1-1.875-.917A2.375 2.375 0 0 1 0 5.625V5.37a1.5 1.5 0 0 1 .361-.976l2.61-3.045zm1.78 4.275a1.375 1.375 0 0 0 2.75 0 .5.5 0 0 1 1 0 1.375 1.375 0 0 0 2.75 0 .5.5 0 0 1 1 0 1.375 1.375 0 1 0 2.75 0V5.37a.5.5 0 0 0-.12-.325L12.27 2H3.73L1.12 5.045A.5.5 0 0 0 1 5.37v.255a1.375 1.375 0 0 0 2.75 0 .5.5 0 0 1 1 0zM1.5 8.5A.5.5 0 0 1 2 9v6h1v-5a1 1 0 0 1 1-1h3a1 1 0 0 1 1 1v5h6V9a.5.5 0 0 1 1 0v6h.5a.5.5 0 0 1 0 1H.5a.5.5 0 0 1 0-1H1V9a.5.5 0 0 1 .5-.5zM4 15h3v-5H4v5zm5-5a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v3a1 1 0 0 1-1 1h-2a1 1 0 0 1-1-1v-3zm3 0h-2v3h2v-3z"></path>
</svg>
			</button>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
				aria-controls="navbarNavDropdown" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNavDropdown">
				<ul class="navbar-nav">
					<!--
					<li class="nav-item"><a class="nav-link" href="#">Features</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="#">Pricing</a>
					</li>
					-->
					
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#"
						id="navbarDropdownMenuLink" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> Product
					</a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
							<li><a class="dropdown-item" href="/contents/mainlist/1">Jean</a></li>
							<li><a class="dropdown-item" href="/contents/mainlist/2">Bag</a></li>
							<li><a class="dropdown-item" href="/contents/mainlist/3">Shoes
									here</a></li>
						</ul></li>
					
					
					
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#"
						id="navbarDropdownMenuLink" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> Community
					</a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
							<li><a class="dropdown-item" href="${root}/member/mypage">Mypage</a></li>
							<li><a class="dropdown-item" href="${root}/contents/detail">Review</a></li>
							<li><a class="dropdown-item" href="/notice/list">Notice</a></li>
							<li><a class="dropdown-item" href="#">Q&A</a></li>
						</ul></li>
				</ul>
			</div>
			<div class="dropdown text-end">
          <a href="#" class="d-block link-dark text-decoration-none dropdown-toggle" id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
            <img src="https://github.com/mdo.png" alt="mdo" width="32" height="32" class="rounded-circle">
          </a>
          <ul class="dropdown-menu text-small" aria-labelledby="dropdownUser1" style="">
          <!-- 
          <c:when test="${empty sessionScope.id }">
            <li><a class="dropdown-item" href="#">회원가입</a></li>
            <li><a class="dropdown-item" href="#">로그인</a></li>
          </c:when>
          
          <c:when test="${not empty sessionScope.id && sessionScope.grade == 'A'}">
		  	<li><a class="dropdown-item" href="#">상품 등록</a></li>
            <li><a class="dropdown-item" href="#">상품 목록</a></li>
            <li><a class="dropdown-item" href="#">회원 목록</a></li>
            <li><a class="dropdown-item" href="#">주문 목록</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="#">로그아웃</a></li>					
		  </c:when>
		  
		  <c:otherwise>
		    <li><a class="dropdown-item" href="#">장바구니</a></li>
            <li><a class="dropdown-item" href="#">정보 수정</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="#">로그아웃</a></li>
		  </c:otherwise>
		   -->
		  
          </ul>
        </div>
		</div>
	</nav>
</body>
</html>




