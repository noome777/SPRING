<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
</head>
<body>
	
	<button onclick="test01();">테스트01</button>
	
	<script>
		function test01(){
			$.ajax({
				url: "/app16/test01",
				type: 'get',
				data: {"k1" : "v1"},
				success: function(data){
					alert("test1 성공");
				} ,
				error: function(){
					alert("test01 실패");
				}
			});
		}
	</script>
	
	<button onclick="test02();">테스트02</button>

	<script>
		function test02(){
			$.ajax({
				url: "/app16/test02",
				type: 'GET',
				data: {age : 20},
				success: function(data){
					console.log(data);
				} ,
				error: function(e){
					console.log(e);
				}
			});
		}
	</script>
	
	<button onclick="test03();">테스트03</button>

	<script>
		function test03(){
			$.ajax({
				url: "/app16/test03",
				type: 'GET',
				data: {age : 20},
				success: function(data){
					console.log(data);
					console.log(data.id);
					console.log(data.pwd);
				} ,
				error: function(e){
					console.log(e);
				}
			});
		}
	</script>
</body>
</html>