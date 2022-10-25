<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body>
	<h1>회원가입</h1>
	<form action="add" method="POST">
		<div class="input-group flex-nowrap">
		  <span class="input-group-text" id="addon-wrapping">@</span>
		  <input type="text" class="form-control" name="id" placeholder="아이디" aria-label="id" aria-describedby="addon-wrapping">
		</div>
	
		<div class="input-group flex-nowrap">
		  <span class="input-group-text" id="addon-wrapping">@</span>
		  <input type="password" class="form-control" name="pw" placeholder="비민번호" aria-label="pw" aria-describedby="addon-wrapping">
		</div>
	
		<div class="input-group flex-nowrap">
		  <span class="input-group-text" id="addon-wrapping">@</span>
		  <input type="text" class="form-control" name="name" placeholder="이름" aria-label="name" aria-describedby="addon-wrapping">
		</div>
	
		<div class="input-group flex-nowrap">
		  <span class="input-group-text" id="addon-wrapping">@</span>
		  <input type="email" class="form-control" name="email" placeholder="이메일" aria-label="email" aria-describedby="addon-wrapping">
		</div>
	
		<br>
		
		<button type="submit" class="btn btn-primary">가입하기</button>
		<button type="reset" class="btn btn-danger">취소</button>
	</form>
	

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>	
</body>
</html>