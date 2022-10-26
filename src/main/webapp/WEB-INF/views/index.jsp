<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<div><a href="./qna/list">QNA</a></div>
	<img alt="" src="./images/DDDD.jpg" id="id1">
	<c:if test="${member.id == null}">
		<a href="/member/add">JOIN</a>
		<a href="/member/login">LOGIN</a>
	</c:if>
	<c:if test="${member.id != null}">
		<a href="/member/logout">LOGOUT</a>
		${member.id}님의 역할은 ${member.roleVOs[0].roleName}
	</c:if>
  
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
	
	<div id="test">>

		뿡
	</div>

</body>
</html>