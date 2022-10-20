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
</head>
<body>
	<h1>Index Page</h1>
	<img alt="" src="./images/DDDD.jpg" id="id1">
	<a href="./qna/list">QNA</a>
	<div>
	<img alt="" src="/file/qna/dfbce689-af1c-4fb7-9346-f354585aa417_겁쟁이 쉼터.png">
	<img alt="" src="/file/notice/SS.jpg">
	<a href="/fileDown/qna?fileNum=2">qnaDown</a>
	<a href="/fileDown/notice?fileNum=2">noticeDown</a>
	</div>
</body>
</html>