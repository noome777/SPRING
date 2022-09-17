<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>리다이렉트</h1>
	
	<!-- 세션에 담아서 새로고침을 할 때는 메세지가 그대로 남아있지만, flash는 일회용이기 때문에 새로고침 시에 메세지가 사라짐 -->
	<h3>일회용 데이터  (세션)::: ${sessionScope.msg}</h3>
	<h3>일회용 데이터  (리퀘스트)::: ${requestScope.msg}</h3>
</body>
</html>