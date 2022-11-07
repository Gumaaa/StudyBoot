<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot.jsp"></c:import>
<script src="/js/util.js"></script>
<script defer src="/js/memberAdd.js"></script>
</head>
<body>
	<h1>회원가입</h1>
	<%-- <form action="./add" method="POST" id="joinForm"> --%>
		<form:form modelAttribute="memberVO" method="POST" id="joinForm">
		<sec:csrfInput/>
		<div class="input-group flex-nowrap">
		  <span class="input-group-text" id="addon-wrapping">ID</span>
			<form:input path="id" cssClass="form-control" id="id" />
		  <!-- <input type="text" class="form-control" name="id" id="id" placeholder="아이디" aria-label="id" aria-describedby="addon-wrapping"> -->
		</div>
		<div id="idCheck">
			<form:errors path="id"></form:errors>
		</div>

		<div class="input-group flex-nowrap">
		  <span class="input-group-text" id="addon-wrapping">PW</span>
		  <form:password path="pw" cssClass="form-control" id="pw"/>
		  <!-- <input type="password" class="form-control" name="pw" id="pw" placeholder="비밀번호" aria-label="pw" aria-describedby="addon-wrapping"> -->
		</div>
		<form:errors path="pw"></form:errors>
		<div id="pwCheck"></div>
		
		<div class="input-group flex-nowrap">
		  <span class="input-group-text" id="addon-wrapping">PW2</span>
		  <form:password path="pwCheck" cssClass="form-control" id="pwEquals"/>
		  <!-- <input type="password" class="form-control" name="pwEquals" id="pwEquals" placeholder="비밀번호 재확인" aria-label="pwEquals" aria-describedby="addon-wrapping"> -->
		</div>
		<form:errors path="pwCheck"></form:errors>
		<div id="pwEqualsCheck"></div>
			
		<div class="input-group flex-nowrap">
		  <span class="input-group-text" id="addon-wrapping">NAME</span>
		  <form:input path="name" cssClass="form-control" id="name" />
		  <!-- <input type="text" class="form-control" name="name" id="name" placeholder="이름" aria-label="name" aria-describedby="addon-wrapping"> -->
		</div>
		<form:errors path="name"></form:errors>
		<div id="nameCheck">
			${name}
		</div>
	
		<div class="input-group flex-nowrap">
		  <span class="input-group-text" id="addon-wrapping">EMAIL</span>
		  <form:input path="email" cssClass="form-control" id="email"/>
		  <!-- <input type="email" class="form-control" name="email" id="email" placeholder="이메일" aria-label="email" aria-describedby="addon-wrapping"> -->
		</div>
		<form:errors path="email"></form:errors>
		<div id="emailCheck"></div>
		
		<div class="input-group flex-nowrap">
		  <span class="input-group-text" id="addon-wrapping">AGE</span>
		  <form:input path="age" cssClass="form-control" id="age"/>
		  <!-- <input type="email" class="form-control" name="email" id="email" placeholder="이메일" aria-label="email" aria-describedby="addon-wrapping"> -->
		</div>
		<form:errors path="age"></form:errors>
		<div id="ageCheck"></div>
		
		<div class="input-group flex-nowrap">
		  <span class="input-group-text" id="addon-wrapping">BIRTHDAY</span>
		  <form:input path="birth" cssClass="form-control" id="birth"/>
		  <!-- <input type="email" class="form-control" name="email" id="email" placeholder="이메일" aria-label="email" aria-describedby="addon-wrapping"> -->
		</div>
		<form:errors path="birth"></form:errors>
		<div id="birthCheck"></div>
	
		<br>
		
		<button type="submit" id="joinBtn" class="btn btn-primary">가입하기</button>
		<button type="reset" class="btn btn-danger">취소</button>
		<a href="../" class="btn btn-dark">Index</a>
	</form:form>

	<!-- Post btn -->
	<div>
		<button type="button" id="test">Post Test</button>
		<button type="button" id="test2">Ajax Get Test</button>
		<button type="button" id="test3">Ajax Post Test</button>
	</div>
	
	<div>
		<div>
			ALL <input type="checkbox" id="all">
		</div>

		<div>
			동의1 <input type="checkbox" class="check">
			<div>
				약관1
			</div>
		</div>
		<div>
			동의2 <input type="checkbox" class="check">
			<div>
				약관2
			</div>
		</div>
		<div>
			동의3 <input type="checkbox" class="check">
			<div>
				약관3
			</div>
		</div>
	</div>

	<div>
		<select id="s1">
			<option>1</option>
			<option>2</option>
		</select>
		<button type="button" id="s1Add">Add</button>
	</div>
</body>
</html>