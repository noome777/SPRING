<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<style>
    #center{
        width: 60vw;
        height: 60vh;
        border: 5px solid black;
        display: grid;
        grid-template-columns: 1fr 5fr 3fr 1fr;
        grid-template-rows: repeat(11 , 20px);
        row-gap: 10px;
        align-content : center;
    }

    .table-header{
        text-align: center;
    }

    #center > div {
        border-bottom: 1px dashed black;
    }
    
    #page-area{
        width: 30%;
        margin: 0 auto;
        display: flex;
        justify-content: space-evenly;
    }

</style>

<div id="center">

    <div class="table-header">번호</div>
    <div class="table-header">제목</div>
    <div class="table-header">작성자</div>
    <div class="table-header">조회수</div>
    
    <c:forEach items="${voList}" var="x">
	    <div>${x.no}</div>
	    <div><a href="${root}/board/detail/${x.no}">${x.title}</a></div>
	    <div>${x.writer}</div>
	    <div>${x.hit}</div>
    </c:forEach>


</div>

<c:if test="${not empty loginMember}">
	<div style="text-align: right;">
	    <a href="${root}/board/write">글 작성</a>
	</div>
</c:if>

<%-- <div id="page-area">
	<c:if test="${pv.startPage ne 1}">
		<a href="/app99/board/list/${pv.startPage - 1}" class="btn btn-primary btn-sm">이전</a>
	</c:if>
	<c:forEach begin="${pv.startPage}" end="${pv.endPage}" var="i">
	    <a href="/app99/board/list/${i}" class="btn btn-primary btn-sm">${i}</a>
	</c:forEach>
	<c:if test="${pv.endPage ne maxPage}">
		<a href="/app99/board/list/${pv.endPage + 1}" class="btn btn-primary btn-sm">다음</a>
	</c:if>
</div> --%>

<div id="page-area">

	<c:if test="${pv.startPage ne 1}">
		<a href="/app99/board/list/${pv.startPage - 1}" class="btn btn-primary btn-sm">이전</a>
	</c:if>
	
	<c:forEach begin="${ pv.startPage }" end="${ pv.endPage }" var="i">
	    <a href="/app99/board/list/${i}" class="btn btn-primary btn-sm">${i}</a>
	</c:forEach>
	
	<c:if test="${pv.endPage ne pv.maxPage }">
		<a href="/app99/board/list/${pv.endPage + 1}" class="btn btn-primary btn-sm">다음</a>
	</c:if>	
	

</div>



	


    