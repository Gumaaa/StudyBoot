<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="./temp/boot.jsp"></c:import>
<link href="/css/test.css" rel="stylesheet">
<script defer src="/js/test.js"></script>
</head>
<body>
	<h1>Index Page</h1>
	<h1>
		<spring:message code="hi" var="h" />
	</h1>
	<h1>
		<spring:message code="test" text="Code가 없어요~" />
	</h1>
	<h1>${h}</h1>

	<div>
		<a href="./qna/list">QNA</a>
	</div>
	<img alt="" src="./images/DDDD.jpg" id="id1">
		
		<!-- 로그인 전 -->
		<!-- !isAuthenicated() : 로그인 안 했을 때 -->
		<sec:authorize access="!isAuthenticated()">
			<a href="/oauth2/authorization/kakao">
				<img alt="" src="../images/kakao_login_medium_narrow.png">
			</a>
			<a href="/member/login">LOGIN</a>
			<a href="/member/add">JOIN</a>
		</sec:authorize>

		<!-- 로그인 후 -->
		<!-- isAuthenicated() : 로그인 했을 때 -->
		<sec:authentication property="Principal" var="member"/>
		<sec:authorize access="isAuthenticated()">
		<form action="./member/logout" id="outForm" method="post">
			<sec:csrfInput/>
			<button>LOGOUT</button>
		</form>
			<a href="#" id="logout">LOGOUT</a>
			<a href="/member/mypage">MYPAGE</a>
			<spring:message code="welcome" arguments="${member.name}"></spring:message>
			<!-- argumentSeparator="||"는 원하는 구분자 ,면 변수 사이에 , 사용가능 -->
			<spring:message code="welcome2" arguments="${member.id}||${member.name}" argumentSeparator="||"></spring:message>
			
			<%-- <sec:authorize access="hasRole('ADMIN')"> --%>
			<sec:authorize url="/admin">
				<a href="/admin">admin</a>
			</sec:authorize>
			
			<sec:authorize access="hasAnyRole('ADMIN', 'MANAGER')">
				<a href="/manager">manager</a>
			</sec:authorize>
		</sec:authorize>
		

	<div>
		<img alt="" src="/file/qna/dfbce689-af1c-4fb7-9346-f354585aa417_겁쟁이 쉼터.png">
		<img alt="" src="/file/notice/SS.jpg">
		<a href="/fileDown/qna?fileNum=2">qnaDown</a>
		<a href="/fileDown/notice?fileNum=2">noticeDown</a>
	</div>

	<button id="btn">click</button>

	<button class="buttons">btn1</button>
	<button class="buttons">btn2</button>
	<button class="buttons">btn3</button>

	<div id="test">뿡</div>
	<script type="text/javascript">
		$("#logout").click(function() {
			$("#outForm").submit();
		})
	</script>
</body>
</html>