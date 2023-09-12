<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function validateForm(form) {
		if(form.name.value == "") {
			alert("작성자를 입력하세요.");
			form.name.focus();
		}
		if(form.title.value == "") {
			alert("제목을 입력하세요.");
			form.title.focus();
		}
		if(form.content.value == "") {
			alert("내용을 입력하세요.");
			form.content.focus();
		}
		if(form.pass.value == "") {
			alert("비밀번호를 입력하세요.");
			form.pass.focus();
		}
	}
</script>
</head>
<body>
	<h2>수정하기(Edit)</h2>
	<form name="editForm" method="post" action="edit.do" enctype="multipart/form-data" onsubmit="return validateForm(this)">
	<input type="hidden" name="idx" value="${dto.idx}" />
		<table border="1">
			<tr>
				<td>작성자</td>
				<td><input type="text" name="name" value="${dto.name}"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" value="${dto.title}"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="content">${dto.content}</textarea></td>
			</tr>
			<tr>
				<td>첨부파일</td>
				<td><input type="file" name="ofile"></td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="submit">작성완료</button>
					<button type="reset">취소</button>
					<button type="button" onclick="location.href='list.do'">목록 바로가기</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>