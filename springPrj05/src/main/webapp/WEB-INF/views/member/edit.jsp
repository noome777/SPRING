<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

   <h1>회원 정보 수정</h1>
	
	<form action="" method="post">
		아이디 : <input type="text" name="id" value="${loginMember.id}" readonly>
		<br>
		패스워드 : <input type="password" name="pwd">
		<br>
		닉네임 : <input type="text" name="nick" value="${loginMember.nick}">
		<br>
		<input type="submit" value="정보 수정">
	</form>
</body>
</html>