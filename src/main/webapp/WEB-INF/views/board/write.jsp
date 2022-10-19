<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot.jsp"></c:import>
</head>
<body>
	<h1>Board Write Page</h1>
	
	<div>
		<form action="./write" method="post" enctype="multipart/form-data">
			<!-- 제목 -->
			<div class="form-floating">
  				<textarea class="form-control" name="title" placeholder="Leave a comment here" id="floatingTextarea"></textarea>
  				<label for="floatingTextarea">Title</label>
			</div>
			<br>
			<!-- 작성자 -->
			<div class="form-floating">
			  <textarea class="form-control" name="writer" placeholder="Leave a comment here" id="floatingTextarea"></textarea>
			  <label for="floatingTextarea2">Writer</label>
			</div>
			<br>
			<!-- 내용 -->
			<div class="form-floating">
			  <textarea class="form-control" name="contents" placeholder="Leave a comment here" id="summernote" style="height: 100px"></textarea>
			</div>
			<!-- 파일 -->
			<div class="form-floating">
  				<input type="file" name="files">
  				<input type="file" name="files">
			</div>
			<br>
			<button class="btn btn-primary" type="submit">작성</button>
			<button class="btn btn-danger" href="#">취소</button>
		</form>
	</div>
	<script type="text/javascript">
	$(document).ready(function() {
		  $('#summernote').summernote();
		});
	</script>
</body>
</html>