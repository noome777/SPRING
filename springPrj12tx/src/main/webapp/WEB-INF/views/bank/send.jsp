<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>송금하기</h1>
	
	<form action="/app12/bank/send" method="post">
		얼마를 보내시겠어요 ? <input type="number" name="money">
		<input type="submit" value="송금">
		
	</form>
</body>
</html>