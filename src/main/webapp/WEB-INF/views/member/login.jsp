<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot.jsp"></c:import>
</head>
<body>
	<section class="container-fluid col-lg-4 mt-5 min-vh-100">
		<h1>로그인</h1>
		
		<div>
			<h3>${param.error}</h3>
			<h3>${param.message}</h3>
			<h3>${msg}</h3>
		</div>
	
		<div class="row">
			<form action="login" method="POST">
			<div class="mb-3">
			  <input type="text" name="id" class="form-control" id="id" placeholder="아이디" value="${cookie.userId.value}">
			</div>
			
			<div class="mb-3">
			  <input type="password" name="pw" class="form-control" id="pw" placeholder="비밀번호">
			</div>
			
			<div class="input-group mb-3">
		  		<div class="input-group-text">
		    		<input name="rememberId" class="form-check-input mt-0" type="checkbox" value="" aria-label="Checkbox for following text input">
		    		아이디 자동 저장
		  		</div>
		  	</div>
			
			
			<button type="submit" class="btn btn-primary">로그인</button>
			</form>
		</div>
	</section>
	<script type="text/javascript">
		history.replaceState({}, null, location.pathname)
	</script>
		
</body>
</html>