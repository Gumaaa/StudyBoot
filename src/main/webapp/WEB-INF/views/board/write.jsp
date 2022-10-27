<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot.jsp"></c:import>
<c:import url="../temp/summer.jsp"></c:import>
<script defer src="/js/qnaFileAdd.js"></script>
</head>
<body>
	<div class="container-fluid">
		<div class="row justify-content-center">
			<div class="col-6">
				<h1>Board Write Page</h1>
				<form action="./write" method="post" enctype="multipart/form-data">
				
					<!-- 제목 -->
					<div class="mb-3">
						<label for="title" class="form-label">Title</label>
						<input type="text" name="title" id="title" class="form-control" placeholder="제목">
					</div>
					
					<!-- 작성자 -->
					<div class="mb-3">
						<label for="writer" class="form-label">Writer</label>
						<input type="text" name="writer" id="writer" class="form-control" placeholder="작성자">
					</div>
					
					<!-- 내용 -->
					<div class="mb-3">
						<label for="contents" class="form-label">Contents</label>
						<textarea class="form-control" name="contents" id="contents"></textarea>
					</div>

					<!-- 파일 -->
					<div>
						<button type="button" id="fileAddBtn">파일 추가</button>
					</div>
						<div id="fileAddForm"></div>
						<div id="fileAddCheck"></div>
					<br>
					<div>
					<button class="btn btn-primary" type="submit">작성</button>
					<button class="btn btn-danger" href="#">취소</button>
				</form>
			</div>
		</div>
	</div>

	<script>
      $(document).ready(function () {
           $('#contents').summernote({
            height: 250
         });
      });
   </script>

</body>
</html>