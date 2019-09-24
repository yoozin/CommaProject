<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="google-signin-client_id" content="712569324791-15au55v5pvecbdvmt0ot8shmfe32nunr.apps.googleusercontent.com">
<script src="https://apis.google.com/js/platform.js" async defer></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
	$(function(){
		
		
		$("#LoginCheck").click(function(){
			
			var memberId = $("#memberId").val();
			var memberPassword = $("#password").val();
			var re = false;
			var num = 1;
			var formObj = $("form[role='form']"); 
			
			
			if (valdate() == false){
				
				return re;
			}
			
			
			$.ajax({
				 async: true,
		            type : 'POST',
		            data : memberId,
		            url : "member/loginIdCheck.do",
		            dataType : "json",
		            contentType: "application/json; charset=UTF-8",
		            success : function(data) {
		            	console.log(data);
		                if (data.cnt == 0) {
							alert("아이디가 존재하지 않습니다.");
		                    
		                    $("#memberId").focus();
		                    num = 0;
		                    return false;
		                
		                } else{
		                	$.ajax({
		       				 async: true,
		       		            type : 'POST',
		       		            data : memberPassword,
		       		            url : "member/loginPwdCheck.do",
		       		            dataType : "json",
		       		            contentType: "application/json; charset=UTF-8",
		       		            success : function(data) {
		       		            	console.log(data);
		       		                if (data.cnt == 0) {
		       		                    
		       		                    alert("비밀번호가 틀렸습니다.");
		       		                    $("#password").focus();
		       		                    return false;
		       		                   
		       		                
		       		                } else{
		       		                 formObj.attr("action", "member/LoginWithSession");    ///board/delete/로
		       		                 formObj.submit(); 


		       		                }
		       		            }
		       		           
		       		            
		       			});
		                }
		            }
			});
/* 			if(num == 0){
				return re;
			} */
			
/* 			return re;
 */	
			
		});
	
	});
	function valdate(){
		var re = /^[a-zA-Z0-9]{4,12}$/;
		var id = document.getElementById("memberId");
		var pwd = document.getElementById("password");
		if(!check(re,id,"아이디는 4~12자의 영문 대, 소문자 및 숫자로 입력해주세요")){
			return false;
		}
		if(!check(re,pwd,"비밀번호는 4~12자의 영문 대,소문자 및 숫자로 입력해주세요")){
			return false;
		}
		function check(re,what,msg){
			if(re.test(what.value)){
				return true;
			}
			alert(msg);
			what.value="";
			what.focus();
		}
		
		function onSignIn(googleUser) {
			 var id_token = googleUser.getAuthResponse().id_token;
			  var profile = googleUser.getBasicProfile();
			  console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
			  console.log('Name: ' + profile.getName());
			  console.log('Image URL: ' + profile.getImageUrl());
			  console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
			}
		 function signOut() {
			    var auth2 = gapi.auth2.getAuthInstance();
			    auth2.signOut().then(function () {
			      console.log('User signed out.');
			    });
			  }
	}
	

</script>


<title>Insert title here</title>
</head>
<body>
<%-- 	
	<h1>${memberVO.memberName}님의 페이지</h1>
	<form action="test" method = "get">
		<input type="submit" value="test">
	
	</form>
	<form action="logout" method = "get">
		<input type="submit" value="logout">
	
	</form>
	
	 --%>
	<c:choose>
	
	
	
    <c:when test="${not empty sessionScope.member}">
        <h2>로그인 성공 </h2>
        이름 : ${sessionScope.member.memberName}
 
        이메일 : <c:out value="${sessionScope.member.memberEmail}"/> 
        <a href="member/logout">로그아웃</a>
        <a href="boardWrite.jsp">글쓰러가기</a>  <a href="page2">페이지2</a>
    </c:when>

    
    <c:otherwise>
        <h2>로그인 </h2>
        <form role = "form" id = "frm1" name="form1" method="post">
        <table>
            <tr height="40px">
                <td>유저ID</td>
                <td><input type="text" name="memberId"  id="memberId"></td>
            </tr>
            <tr height="40px">
                <td>패스워드</td>
                <td><input type="password" name="password" id="password"></td>
            </tr>
            
        </table>
        	<button type="button" value="login" id="LoginCheck" >로그인하기</button>
        </form>
        
        	<a href="google/login">누르기</a>
        	
        	<div class="g-signin2" data-onsuccess="onSignIn"></div>
        	
          <div id="google_id_login" style="text-align: center">
			    <a href="${google_url}">
			      구글 로그인
			    </a>
			  </div>
			  <a href="#" onclick="signOut();">Sign out</a>
    </c:otherwise>
</c:choose>
	
	
</body>
</html>