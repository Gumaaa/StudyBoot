<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
				<form:form modelAttribute="qnaVO" method="POST" enctype="multipart/form-data">
				<%-- <form action="./write" method="post" enctype="multipart/form-data"> --%>
				
					<!-- 제목 -->
					<div class="mb-3">
						<label for="title" class="form-label">Title</label>
						<form:input path="title" id="title" cssClass="form-control"/>
						<form:errors path="title"></form:errors>
						<!-- <input type="text" name="title" id="title" class="form-control" placeholder="제목"> -->
					</div>
					
					<!-- 작성자 -->
					<div class="mb-3">
						<label for="writer" class="form-label">Writer</label>
						<form:input path="writer" id="writer" cssClass="form-control"/>
						<form:errors path="writer"></form:errors>
						<!-- <input type="text" name="writer" id="writer" class="form-control" placeholder="작성자"> -->
					</div>
					
					<!-- 내용 -->
					<div class="mb-3">
						<label for="contents" class="form-label">Contents</label>
						<form:textarea path="contents" id="contents" cssClass="form-control"/>
						<form:errors path="contents"></form:errors>
						<!-- <textarea class="form-control" name="contents" id="contents"></textarea> -->
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
					</form:form>
				<%-- </form> --%>
			</div>
		</div>
	</div>

	<script>
      $(document).ready(function () {
           $('#contents').summernote({
            height:250,
            callbacks: {
            	onImageUpload: function(file) {
					console.log("ImageUpload");
					console.log("file", file);

					uploadFile(file);
                    const imgNode = '<img src="data:image/png;base64,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">';

					$('#contents').summernote('pasteHTML', imgNode);
				},
				onMediaDelete:function(file) {
					console.log("Delete Media");
					console.log("DeleteFile => ", file);

					deleteFile(file);
				}
            }
         });
		 // 글쓰기 시 써머노트에서 파일 삭제
		 function deleteFile(file) {
			console.log("SRC => ", file.attr("src"));
			$.post("./summerFileDelete", {fileName:file.attr("src")}, function(result){				
				console.log("result => ", result);
			});
		 }
           
           // ajax upload 함수
           function uploadFile(file) {
			console.log("file ", file);
			console.log("fileName => ", file[0].name);

			const formData = new FormData(); // <form>
			formData.append("file", file[0]); // <input type="file"

			$.ajax({
				type:"POSt",
				url:"summerFile",
				data:formData,
				// header
				cache:false,
				processData:false,
				contentType:false,
				enctype:'multipart/form-data',
				success:function(img) {
					console.log("Image => ", img);
					img = '<img src="'+img+'">'
					$('#contents').summernote('pasteHTML', img, file[0].name);
				},
				error:function() {
					console.log('Image Upload Fail');
				}

			})
			
		}
      });
   </script>

</body>
</html>