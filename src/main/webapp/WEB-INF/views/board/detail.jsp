<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot.jsp"></c:import>
</head>
<body>
	<h1>Detail Page</h1>
	
	<table>
		<tr>
			<th>제목</th>
			<th>작성자</th>
			<th>날짜</th>
			<th>조회수</th>
			<th>내용</th>
		</tr>
		
		<tr>
			<td>${detail.title}</td>
			<td>${detail.writer}</td>
			<td>${detail.regDate}</td>
			<td>${detail.hit}</td>
			<td>${detail.contents}</td>
		</tr>
	</table>
	<div>
		<c:forEach items="${detail.qnaFileVOs}" var="qnaFile">
				<img alt="" src="/file/qna/${qnaFile.fileName}">
			<a href="/fileDown/qna?fileNum=${qnaFile.fileNum}">이미지 다운로드</a>
		</c:forEach>
	</div>
	
	<br>
	<a class="btn btn-primary" href="./update?num=${detail.num}">수정</a>
	<a class="btn btn-danger" href="#">삭제</a>
</body>
</html>