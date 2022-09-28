<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style>
    #join-main{
        width: 100%;
        height: 60%;
        border: 1px solid black;
    }
    #join-main > form{
        width: 100%;
        height: 100%;
    }
    #join-form{
        width: 100%;
        height: 100%;
        display: grid;
        grid-template-columns: 250px 1fr;
        grid-template-rows: repeat(10, 10%);
        justify-items: center;
        align-items: center;
        align-content: space-evenly;
        justify-content: space-evenly;
    }
    #join-form > *{
        width: 80%;
        height: 50%;
    }
    #profile-tumb{
        height: 100px;
        width: 100px;
        justify-self: start;
        margin-left: 10%;
        grid-column: 2/3;
        grid-row: span 2;
    }
    #join-btn-area{
        grid-column: span 2;
        display: flex;
        justify-content: center;
    }
</style>

<div id="join-main">
    <form action="" method="post" enctype="multipart/form-data">
        <div id="join-form">
            <div><label for="">아이디</label></div>
            <div>
                <input type="text" name="id">
                <button>중복확인</button>
            </div>
            <div><label for="">패스워드</label></div>
            <div><input type="password" name="pwd"></div>
            <div><label for="">패스워드 확인</label></div>
            <div><input type="password" name="pwd2"></div>
            <div><label for="">닉네임</label></div>
            <div><input type="text" name="nick"></div>
            <div><label for="">성별</label></div>
            <div>
                <label for="male">남자</label><input type="radio" id="male" name="gender" value="M">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <label for="female">여자</label><input type="radio" id="female" name="gender" value="F">
            </div>
            <div><label for="">MBTI</label></div>
            <div><input type="text" name="mbti"></div>
            <div><label for="">프로필사진</label></div>
            <div><input type="file" name="profile"></div>
            <div></div>
            <div id="profile-tumb">
                <img id="profile-img-thumb" src="${root}/resources/upload/profile/IMG_9058.JPG" width="100%" height="100%">
            </div>
            <div></div>
            <div id="join-btn-area">
                <input type="submit" value="가입하기">
            </div>
        </div>
    </form>
</div>

<script>

		const fileInputTag = document.querySelector('input[name=profile]');
		
		 fileInputTag.onchange = function(){
		     
		     const imgTag = document.querySelector('#profile-img-thumb');
		     
		     if(fileInputTag.files.length > 0){
		         //파일 선택됨
		         const fr = new FileReader();
		         fr.onload = function(data){
		             console.log(data);
		             imgTag.src = data.target.result;
		         }
		         fr.readAsDataURL(fileInputTag.files[0]); //파일 읽기
		     }else{
		         imgTag.src = "";
		     }
		 }

</script>