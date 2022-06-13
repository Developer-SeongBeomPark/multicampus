<%@ page contentType="text/html; charset=UTF-8" %> 
 
<!DOCTYPE html> 
<html> 
<head>
  <title>homepage</title>
  <meta charset="utf-8">
  <script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	function sample6_execDaumPostcode() {
		new daum.Postcode(
				{
					oncomplete : function(data) {
						// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

						// 각 주소의 노출 규칙에 따라 주소를 조합한다.
						// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
						var addr = ''; // 주소 변수
						var extraAddr = ''; // 참고항목 변수

						//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
						if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
							addr = data.roadAddress;
						} else { // 사용자가 지번 주소를 선택했을 경우(J)
							addr = data.jibunAddress;
						}

						// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
						if (data.userSelectedType === 'R') {
							// 법정동명이 있을 경우 추가한다. (법정리는 제외)
							// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
							if (data.bname !== ''
									&& /[동|로|가]$/g.test(data.bname)) {
								extraAddr += data.bname;
							}
							// 건물명이 있고, 공동주택일 경우 추가한다.
							if (data.buildingName !== ''
									&& data.apartment === 'Y') {
								extraAddr += (extraAddr !== '' ? ', '
										+ data.buildingName : data.buildingName);
							}
							// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
							if (extraAddr !== '') {
								extraAddr = ' (' + extraAddr + ')';
							}
							// 조합된 참고항목을 해당 필드에 넣는다.
							//document.getElementById("sample6_extraAddress").value = extraAddr;

						} else {
							//document.getElementById("sample6_extraAddress").value = '';
						}

						// 우편번호와 주소 정보를 해당 필드에 넣는다.
						document.getElementById('sample6_postcode').value = data.zonecode;
						document.getElementById("sample6_address").value = addr;
						// 커서를 상세주소 필드로 이동한다.
						document.getElementById("sample6_detailAddress")
								.focus();
					}
				}).open();
	}
</script>
</head>
<body> 
<div class="container">
<h1 class="col-sm-offset-2 col-sm-10">제목</h1>
<form class="form-horizontal" 
      action="create"
      method="post"
      >
 
  <div class="form-group">
				<label class="control-label col-sm-2" for="name">이름</label>
				<div class="col-sm-6">
					<input type="text" name="name" id="name" class="form-control">
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="handphone">전화번호</label>
				<div class="col-sm-6">
					<input type="text" name="handphone" id="handphone"
						class="form-control">
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="zipcode">우편번호</label>
				<div class="col-sm-2">
					<input type="text" name="zipcode" class="form-control"
						id="sample6_postcode" placeholder="우편번호">
				</div>
				<div class="col-sm-4">
					<button class="btn" type="button"
						onclick="sample6_execDaumPostcode()">주소 찾기</button>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="address">주소</label>
				<div class="col-sm-6">
					<input type="text" name="address" id="sample6_address"
						class="form-control" placeholder="주소">
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="address2">상세주소</label>
				<div class="col-sm-6">
					<input type="text" name="address2" id="sample6_detailAddress"
						class="form-control" placeholder="상세주소">
				</div>
			</div>
  
   <div class="form-group">
   <div class="col-sm-offset-2 col-sm-5">
    <button class="btn">등록</button>
    <button type="reset" class="btn">취소</button>
   </div>
 </div>
</form>
</div>
</body> 
</html> 