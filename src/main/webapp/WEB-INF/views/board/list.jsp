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
	<h1>${board} List Page</h1>

	<table class="table table-hover">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>

		<c:forEach items="${list}" var="list">
			<tr class="tr">
				<td>${list.num}</td>
				<td><a href="./detail?num=${list.num}">${list.title}</a></td>
				<td>${list.writer}</td>
				<td>${list.regDate}</td>
				<td>${list.hit}</td>
			</tr>
		</c:forEach>
	</table>

	<nav aria-label="Page navigation example">
		<ul class="pagination">
			<li class="page-item">
				<a class="page-link" href="#" aria-label="Previous">
					<span aria-hidden="true">&laquo;</span>
				</a>
			</li>
			<li class="page-item"><a class="page-link" href="#">1</a></li>
			<li class="page-item"><a class="page-link" href="#">2</a></li>
			<li class="page-item"><a class="page-link" href="#">3</a></li>
			<li class="page-item">
				<a class="page-link" href="#" aria-label="Next">
					<span aria-hidden="true">&raquo;</span> 
				</a>
			</li>
		</ul>
	</nav>
	<div>
		<a class="btn btn-primary" href="./write">글쓰기</a>
	</div>
	
	<script type="text/javascript">
		let result = '${result}';
		if(result != "") {
			if(result == '1') {
				alert('등록 성공:)')
			} else {
				alear('등록 실패:(')
			}
		}
	</script>
</body>
</html>