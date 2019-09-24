<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<script>



$(function() {
    //idck 버튼을 클릭했을 때 
    var idck = 0;
    $("#idck").click(function() {
       
        //userid 를 param.
        var memberId =  $("#memberId").val(); 
        
        $.ajax({
            async: true,
            type : 'POST',
            data : memberId,
            url : "member/idcheck.do",
            dataType : "json",
            contentType: "application/json; charset=UTF-8",
            success : function(data) {
                if (data.cnt > 0) {
                    
                    alert("아이디가 존재합니다. 다른 아이디를 입력해주세요.");
                    //아이디가 존제할 경우 빨깡으로 , 아니면 파랑으로 처리하는 디자인
                    
                    $("#memberId").focus();
                    
                
                } else {
                    alert("사용가능한 아이디입니다.");
                    //아이디가 존제할 경우 빨깡으로 , 아니면 파랑으로 처리하는 디자인
                    
                    $("#memberPassword").focus();
                    //아이디가 중복하지 않으면  idck = 1 
                    idck = 1;
                    
                }
            },
            error : function(error) {
                
                alert("error : " + error);
            }
        });
    });
    
    $('#DosignUp').click(function(){
    	
    	 var userid = $("#memberId").val();
    	    var userpwd = $("#memberPassword").val();
    	    var inputPwdCfm = $("#re_pwd").val();
    	    var username = $("#memberName").val();
    	    var email = $("#memberEmail").val();
    	    var phone = $("#memberPhone").val();
    	 
    	    
    	    if(userid.length == 0){
    	        alert("아이디를 입력해 주세요"); 
    	        $("#memberId").focus();
    	        return false;
    	    }
    	    
    	    if(userpwd.length == 0){
    	        alert("비밀번호를 입력해 주세요"); 
    	        $("#memberPassword").focus();
    	        return false;
    	    }
    	 
    	    if(userpwd != inputPwdCfm){
    	        alert("비밀번호가 서로 다릅니다. 비밀번호를 확인해 주세요."); 
    	        $("#re_pwd").focus();
    	        return false; 
    	    }
    	 
    	    if(username.length == 0){
    	        alert("이름을 입력해주세요");
    	        $("#memberName").focus();
    	        return false;
    	    }
    	    
    	    if(email.length == 0){
    	        alert("이메일을 입력해주세요");
    	        $("#memberEmail").focus();
    	        return false;
    	    }
    	    
    	    if(phone.length == 0){
    	        alert("전화번호를 입력해주세요.");
    	        $("#memberPhone").focus();
    	        return false;
    	    }
    	    
    	    if(confirm("회원가입을 하시겠습니까?")){
    	        alert("회원가입을 축하합니다");
    	        return true;
    	    }
    	    
    	    if(confirm("회원가입을 하시겠습니까?")){
    	        if(idck==0){
    	            alert('아이디 중복체크를 해주세요');
    	            return false;
    	        }else{
    	        alert("회원가입을 축하합니다");
    	        $("#frm").submit();
    	        }
    	    }
    	

    	
    	
    });
    
    
    
});
 
 

</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action = "member/insertMember" method="post">
		아이디 : <input type = "text" name = "memberId" id = "memberId">  <input type = "button" id="idck" value="중복체크"><br>
		이름 : <input type = "text" name = "memberName" id = "memberName"> <br>
		비밀번호 : <input type = "password" name = "memberPassword" id = "memberPassword"> <br>
		비밀번호 확인 : <input type = "password" name = "re_pwd" id = "re_pwd"> <br>
		이메일 : <input type = "email" name = "memberEmail" id = "memberEmail"> <br>
		전화번호 : <input type = "tel" name = "memberPhone" id = "memberPhone">	<br><br>
		
		<input type = "submit" value = "회원가입하기" name="frm" id="DosignUp">	<br>
		
	</form>

</body>
</html>