<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set value="/app99" var="root"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="${root}/resources/css/common.css">

</head>
<body>
   
   <div id="wrap">

      <aside>
         <%@ include file="/WEB-INF/views/common/sidemenu-content.jsp" %>
      </aside>

      <main>
         <a href="${root}">
            <header>로고</header>
         </a>
         <%@ include file="/WEB-INF/views/member/mypage-content.jsp" %>
      </main>

      <aside>
         어사이드 ~~~
      </aside>

   </div>

</body>
</html>