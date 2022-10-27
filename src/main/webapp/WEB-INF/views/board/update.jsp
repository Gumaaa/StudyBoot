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
				<h1>Board Update Page</h1>
				<form action="update" method="post" enctype="multipart/form-data">
				
					<div class="mb-3">
						<label for="writer" class="form-label">Writer</label>
						<input type="text" disabled name="writer" id="writer" class="form-control" value="${update.writer}" placeholder="작성자">
					</div>
					
					<div class="mb-3">
						<label for="title" class="form-label">Title</label>
						<input type="text" name="title" id="title" class="form-control" value="${update.title}" placeholder="제목">
					</div>
					
					<div class="mb-3">
						<label for="contents" class="form-label">Contents</label>
						<textarea class="form-control" name="contents" id="contents">${update.contents}</textarea>
					</div>
					
					<div class="mb-3" id="fileAddForm">
						<c:forEach items="${update.qnaFileVOs}" var="updateFile">
							<p>${updateFile.oriName}
								<button type="button" class="deleteFile" data-file-num="${updateFile.fileNum}">삭제</button> 
							</p>
						</c:forEach>
					</div>
					
					<div class="mb-3">
						<button type="button" id="fileAddBtn">파일 추가</button>
					</div>
					

					<div>
						<button class="btn btn-primary">수정완료</button>
					</div>
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