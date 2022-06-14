<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>homepage</title>
<meta charset="utf-8">
<script>
	function read(addressnum) {
		let url = "read/" + addressnum;
		location.href = url;
	}
</script>
</head>
<body>
	<div class="container">
		<h1 class="col-sm-offset-2 col-sm-10">주소 목록</h1>
		<form action="list" class="form-inline">
			<div class="form-group">
				<select class="form-control" name="col">
					<option value="name"
						<c:if test = "col == 'name'">
							selected
						</c:if>>이름</option>
					<option value="handphone"
						<c:if test = "col == 'handphone'">
							selected
						</c:if>>전화번호</option>
					<option value="address"
						<c:if test = "col == 'address'">
							selected
						</c:if>>주소</option>
					<option value="total"
						<c:if test = "col == 'total'">
							selected
						</c:if>>전체출력</option>
				</select>
			</div>

			<div class="form-group">
				<input type="text" class="form-control" placeholder="Enter 검색어"
					name="word" value="${word }">
			</div>
			<button class="btn btn-default">검색</button>
			<button class="btn btn-default" type="button"
				onclick="location.href = 'create'">등록</button>
		</form>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>번호</th>
					<th>이름</th>
					<th>핸드폰번호</th>
					<th>우편번호</th>
					<th>주소</th>
					<th>상세주소</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${empty list }">
						<tr>
							<td colspan="7">등록된 글이 없습니다.</td>
						</tr>
					</c:when>

					<c:otherwise>
						<c:forEach var="dto" items="${list }">
							<tr>
								<td>${dto.addressnum }</td>
								<td><a href="javascript:read('${dto.addressnum }')">${dto.name }</a>

								</td>
								<td>${dto.handphone }</td>
								<td>${dto.zipcode }</td>
								<td>${dto.address }</td>
								<td>${dto.address2}</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>



			</tbody>
		</table>

		<div>${paging }</div>

	</div>
</body>
</html>
