<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- 제이쿼리 -->    
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>

<!-- 부트스트랩 -->    
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>

    <style>
        /* 사이드바 */
        #sidemenu-area{
            width: 100%;
            height: 100%;
            display: flex;
            flex-direction: column;
            margin-left: -70%;
            transition: 700ms;
        }
        #sidemenu-area:hover{
            margin-left: 0%;
            transition: 700ms;
        }
        #profile-area{
            height: 30%;
            width: 100%;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: space-evenly;
        }
        #profile-img-area{
            width: 50%;
            height: 50%;
        }
        #profile-img-area > img{
            border-radius: 50%; 
            width: 100%; 
            height: 100%;
            border: 3px solid black;
        }
        .sidemenu{
            height: 10%;
            border : 5px solid black;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .profile-etc{
            display: flex;
        }
    </style>

<div id="sidemenu-area">
   <div id="profile-area">
      <c:if test="${loginMember != null }">
         <div id="profile-img-area">
            <img src="${root}/resources/upload/profile/${loginMember.fileName}">
         </div>
         <div id="profile-etc">
            <a href="${root}/member/mypage">마이페이지</a>
            <a href="${root}/member/logout">로그아웃</a>
         </div>
      </c:if>
      <c:if test="${loginMember == null }"> 
         <div id="profile-img-area">
            <img src="${root}/resources/img/guest.png">
         </div>
         <div id="profile-etc">
            <a href="${root}/member/join">회원가입</a>
            <a href="${root}/member/login">로그인</a>
         </div>
      </c:if>
   </div>
   
   <div class="sidemenu">1</div>
   <div class="sidemenu">2</div>
   <div class="sidemenu">3</div>
   <div class="sidemenu">4</div>
   
</div>