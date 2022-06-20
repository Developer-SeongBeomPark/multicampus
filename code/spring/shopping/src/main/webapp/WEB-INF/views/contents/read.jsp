<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 조회</title>
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-sm-3">
				<h4>
					<img src="/svg/box2-heart.svg"> 상품 정보
				</h4>
				<img class="img-rounded" src="/contents/${dto.filename}"
					style="width: 250px">
				<div class="caption">
					<p>상품명:${dto.pname}</p>
					<p>${dto.detail }</p>
				</div>
			</div>
			<div class="col-sm-6">
				<h4>
					<img src="/svg/rulers.svg"> 사이즈 및 수량
				</h4>
				<ul class="list-group">
					<li class="list-group-item">사이즈 : <c:choose>
							<c:when test="${dto.cateno == 1 }">
								<li class="list-group-item">L / M / S
							</c:when>

							<c:when test="${dto.cateno == 2 }">
								<li class="list-group-item">동일
							</c:when>

							<c:when test="${dto.cateno == 3 }">
								<li class="list-group-item">280 / 275 / 270 / 265 / 260 /
									255 / 250 / 245 / 240 / 235 / 230
							</c:when>

						</c:choose>
					<li class="list-group-item">가격 : ${dto.price }
					<li class="list-group-item">재고 : ${dto.stock }
					<li class="list-group-item"><a
						href="javascript:history.back()"> <img class='btn'
							src="/svg/arrow-return-left.svg" /></a>
				</ul>
			</div>
		</div>
	</div>


</body>
</html>