<%@ page contentType="text/html; charset=UTF-8" %> 
<%  String root = request.getContextPath(); %>
<!-- webapp이 root임 -->
 
<!DOCTYPE html> 
<html> 
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body> 
<div class="container">
 
  <div class="page-header row">
   <div class="col-sm-4">
    <img src="<%=root %>/images/img_chania.jpg" class="img-responsive img-thumbnail" alt="Cinque Terre" >
   </div>
   <div class="col-sm-8"><h1>Homepage</h1></div>     
  </div>
  <ul class="nav nav-tabs">
    <li class="active"><a href="<%=root%>/index.do">Home</a></li>
    <li class="dropdown">
      <a class="dropdown-toggle" data-toggle="dropdown" href="#">게시판<span class="caret"></span></a>
      <ul class="dropdown-menu">
        <li><a href="<%=root%>/bbs/create.do">생성</a></li>
        <li><a href="<%=root%>/bbs/list.do">목록</a></li>                       
      </ul>
    </li>
    <li class="dropdown">
      <a class="dropdown-toggle" data-toggle="dropdown" href="#">메모<span class="caret"></span></a>
      <ul class="dropdown-menu">
        <li><a href="<%=root%>/memo/create.do">생성</a></li>
        <li><a href="<%=root%>/memo/list.do">목록</a></li>                       
      </ul>
    </li>
    <li class="dropdown">
      <a class="dropdown-toggle" data-toggle="dropdown" href="#">주소록<span class="caret"></span></a>
      <ul class="dropdown-menu">
        <li><a href="<%=root%>/addr/createForm.do">생성</a></li>
        <li><a href="<%=root%>/addr/list.do">목록</a></li>                       
      </ul>
    </li>
    <li><a href="#">Menu 2</a></li>
    <li><a href="#">Menu 3</a></li>
  </ul>   
</div>
 