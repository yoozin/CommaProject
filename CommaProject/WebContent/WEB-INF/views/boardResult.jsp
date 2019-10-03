<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
<title>ResultPage</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<style>
    body {
  background: #eee;
  margin: 0;
  padding: 0;
  font-family: "Source Sans Pro", sans-serif;
  color: #333;
}


.content{

}
.container {
  width: 60%;
  margin: 180px auto;
}

.shrink {
  padding: 20px 0;
}

p {
  margin: 0 0 40px 0;
  line-height: 24px;
}

strong {
  font-weight: bold;
}
</style>
<style>
body {
  background: #eee;
  padding: 0;
  margin: 0;
  margin-top: 150px;
  font-family: "Open Sans", sans-serif;
  font-family: 'Open Sans', Helvetica, Arial, sans-serif;
}

.commaicon {
 padding-top: -100px;
}
.container2 {
  width: 80%;
  margin-top: -6px;
  margin-left:151px;
  clear: both;
}


nav {
  background: #fff;
  height: 80px;
  line-height: 80px;
  box-shadow: 1px 1px 1px rgba(0, 0, 0, 0.2);
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  z-index: 9998;
  transition: all 0.5s;
}
nav.scrollUp {
  transform: translateY(-80px);
}
nav ul.navbar-menu {
  margin: 12px;
  padding: 0;
  margin-top: -77px;
  display: inline-block;
  float: right;
  font-family: 'Open Sans', Helvetica, Arial, sans-serif;
}
nav ul.navbar-menu li {
  display: inline-block;
  margin: 0 10px;
}
nav ul.navbar-menu li a {
  color: #666;
  font-size: 14px;
}
nav a#brand {
  text-transform: uppercase;
  foat: left;
  font-weight: 800;
  font-size: 20px;
}
nav button {
  background: none;
  width: 30px;
  height: 40px;
  margin-top: 20px;
  border: none;
  float: right;
  display: inline-block;
  cursor: pointer;
  display: none;
}
nav button span {
  width: 30px;
  height: 40px;
  height: 2px;
  background: #333;
  display: block;
  margin: 5px 0;
}

@media (max-width: 768px) {
  nav ul.navbar-menu {
    display: none;
  }

  nav button {
    display: block;
  }
}

*, *:before, *:after {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
}

* {
  box-sizing: border-box;
  margin: 0;
  padding: 0;

  -webkit-box-sizing: border-box;
 	-moz-box-sizing: border-box;
}

body{
  background-color: #dee1e3;
  font-family: "Roboto", "Tahoma", "Arial", sans-serif;,
}

.text-right{ text-align: right; }

.comments-app{
  margin: 50px auto;
  max-width: 680px;
  padding: 0 50px;
  width: 100%;
}

.comments-app h1{
  color: #191919;
  margin-bottom: 1.5em;
  text-align: center;
  text-shadow: 0 0 2px rgba(152, 152, 152, 1);
}

.comment-form{  }
.comment-form .comment-avatar{  }

.comment-form .form{ margin-left: 100px; }

.comment-form .form .form-row{ margin-bottom: 10px; }
.comment-form .form .form-row:last-child{ margin-bottom: 0; }

.comment-form .form .input{
  background-color: #fcfcfc;
  border: none;
  border-radius: 4px;
  box-shadow: 0 1px 1px rgba(0, 0, 0, .15);
  color: #555f77;
  font-family: inherit;
  font-size: 14px;
  padding: 5px 10px;
  outline: none;
  width: 100%;

  -webkit-transition: 350ms box-shadow;
  -moz-transition: 350ms box-shadow;
  -ms-transition: 350ms box-shadow;
  -o-transition: 350ms box-shadow;
  transition: 350ms box-shadow;
}

.comment-form .form textarea.input{
  height: 100px;
  padding: 15px;
}

.comment-form .form label{
  color: #555f77;
  font-family: inherit;
  font-size: 14px;
}

.comment-form .form input[type=submit]{
  background-color: #555f77;
  border: none;
  border-radius: 4px;
  box-shadow: 0 1px 1px rgba(0, 0, 0, .15);
  color: #fff;
  cursor: pointer;
  display: block;
  margin-left: auto;
  outline: none;
  padding: 6px 15px;

  -webkit-transition: 350ms box-shadow;
  -moz-transition: 350ms box-shadow;
  -ms-transition: 350ms box-shadow;
  -o-transition: 350ms box-shadow;
  transition: 350ms box-shadow;
}

.comment-form .form .input:focus,
.comment-form .form input[type=submit]:focus,
.comment-form .form input[type=submit]:hover{
  box-shadow: 0 2px 6px rgba(121, 137, 148, .55);
}

.comment-form .form.ng-submitted .input.ng-invalid,
.comment-form .form .input.ng-dirty.ng-invalid{
  box-shadow: 0 2px 6px rgba(212, 47, 47, .55) !important;
}

.comment-form .form .input.disabled {
    background-color: #E8E8E8;
}


.comments{  }

.comment-form,
.comment{
  margin-bottom: 20px;
  position: relative;
  z-index: 0;
}

.comment-form .comment-avatar,
.comment .comment-avatar{
  border: 2px solid #fff;
  border-radius: 50%;
  box-shadow: 0 1px 2px rgba(0, 0, 0, .2);
  height: 80px;
  left: 0;
  overflow: hidden;
  position: absolute;
  top: 0;
  width: 80px;
}

.comment-form .comment-avatar img,
.comment .comment-avatar img{
  display: block;
  height: auto;
  width: 100%;
}

.comment .comment-box{
  background-color: #fcfcfc;
  border-radius: 4px;
  box-shadow: 0 1px 1px rgba(0, 0, 0, .15);
  margin-left: 100px;
  min-height: 60px;
  position: relative;
  padding: 15px;
}

.comment .comment-box:before,
.comment .comment-box:after{
  border-width: 10px 10px 10px 0;
  border-style: solid;
  border-color: transparent #FCFCFC;
  content: "";
  left: -10px;
  position: absolute;
  top: 20px;
}

.comment .comment-box:before{
  border-color: transparent rgba(0, 0, 0, .05);
   top: 22px;
}

.comment .comment-text{
  color: #555f77;
  font-size: 15px;
  margin-bottom: 25px;
}

.comment .comment-footer{
  color: #acb4c2;
  font-size: 13px;
}

.comment .comment-footer:after{
  content: "";
  display: table;
  clear: both;
}

.comment .comment-footer a{
  color: #acb4c2;
  text-decoration: none;

  -webkit-transition: 350ms color;
  -moz-transition: 350ms color;
  -ms-transition: 350ms color;
  -o-transition: 350ms color;
  transition: 350ms color;
}

.comment .comment-footer a:hover{
  color: #555f77;
  text-decoration: underline;
}

.comment .comment-info{
  float: left;
  width: 85%;
}

.comment .comment-author{ }
.comment .comment-date{ }

.comment .comment-date:before{
  content: "|";
  margin: 0 10px;
}

.comment-actions{
  float: left;
  text-align: right;
  width: 15%;
}
</style>

   

</head>
<body>

<div class="container">
<nav> 
  <div class="container2">
    
    <div class="commaicon">
    <a href="/CommaProject/index" id="brand" ><img height = "22px;" src="${pageContext.request.contextPath}/resources/images/blackLogo.png"/></a>
      </div>
    
    <ul class="navbar-menu">
      <li><a href="/CommaProject/index.jsp">Home</a></li>
      <li><a href="board/list">Stories</a></li>
      <li><a href="#">Comma</a></li>
      <li><a href="member/logout.do">Logout</a></li>
    </ul>
    
  </div>
</nav>

<form id="boardForm" role="form" method="post" autocomplete="off"> 
<div class="content">
  <div><h2>${board.title}</h2><br></div>
  
  <p><strong>${board.writer}&ensp;
   |&ensp;<fmt:formatDate value="${board.wDate}" pattern="yyyy. MM. dd. HH:mm"/>&ensp;
   |&ensp;Travel Date_ <fmt:formatDate value="${board.travelDate}" pattern="yyyy. MM. dd. E요일 "/>&ensp;
   |&ensp;View_ ${board.viewCount }
   <br>
   ${board.content}
   </strong></p>
   
   <hr><br>
   <div></div> 
  </div>
   
</form> 
<br><br><br><br><br><br>

<p class="button">
<button class= "btn btn-primary" id="modify_btn">modify</button>
<button class= "btn btn-primary" id="delete_btn">delete</button>
<button class= "btn btn-primary" id="list_btn">list</button>
</p>
</div>

<div class="comments-app">
  <h1>Comments App</h1>
  
  <!-- From -->
  <div class="comment-form">
    <!-- Comment Avatar -->
    <div class="comment-avatar">
      <img src="https://upload.wikimedia.org/wikipedia/commons/6/66/An_up-close_picture_of_a_curious_male_domestic_shorthair_tabby_cat.jpg">
    </div>

    <div class="form" id = "commentfrm" name="form" method="post">
      <div class="form-row">
        <textarea name="commentText" id = "newCommentText" class="input" placeholder="댓글을 입력해주세요." required></textarea>
      </div>

      <div class="form-row">
        <input class="input"
        	   name="commentWriter"
        	   id = "commentWriter"
               placeholder="${sessionScope.loginInfo.memberName}"
               value = "${sessionScope.loginInfo.memberName}"
               type="text" readonly>
      </div>

      <div class="form-row text-right">
        <input
               id="comment-anonymous"
               type="checkbox">
        <label for="comment-anonymous">Anonymous</label>
      </div>

      <div class="form-row">
        <button type="button" id="CreateComment" >댓글 작성</button>
      </div>
    </div>
  </div>

  <!-- Comments List -->
  
  
<c:forEach var="result" items="${list}" varStatus="status">
  
  <div class="comments">
    <!-- Comment -->
    <div class="comment" >
      <!-- Comment Avatar -->
      
      
      <div class="comment-avatar">
        <img src="${pageContext.request.contextPath}/resources/img/고양이3.jpg">
      </div>

      <!-- Comment Box -->
      <div class="comment-box">
        <div class="comment-text"><c:out value = "${ result.commentText }"/></div>
        <div class="comment-footer">
          <div class="comment-info">
            <span class="comment-author">
              <em ng-if="comment.anonymous">Anonymous</em>
              <a ng-if="!comment.anonymous" href="{{ comment.author }}"><c:out value = "${result.commentText }"/></a>
            </span>
            <span class="comment-date" ><c:out value = "${ result.commentRdate }" /></span>
          </div>

          <div class="comment-actions">
            <a href = "CommaProjectTest/comment/${ result.commentNo }">Delete</a>
          </div>
        </div>
      </div>

   
    </div>
    
    
    
 </c:forEach>
<script>



$(function(){
	$("#CreateComment").click(function(){
		
		var boardId = ${board.boardId};
		var commentWriter = $("#commentWriter").val();
		
		var commentText = $("#commentWriter").val();
		alert(commentWriter);
		$.ajax({
			type : "POST",
			url : "/CommaProject/comment/create.do",
			/* headers :{
				"Content-type" : "application/json",
				"X-HTTP-Method-Override":"POST"
			}, */
			dataType : "text",
			data : {
				"boardId" : boardId,
				"commentWriter" : commentWriter,
				"commentText" : commentText
				
			},
			success : function(result){
				if (result == "regSuccess"){
					alert("댓글입력완료");
					location.reload();
					
				}
/*  				getComment();
 */ 				
 				
 				$("#commentText").val("");
				 $("#commentWriter").val("");
			}
			
			
			
			
		});
		
		
		
		
	});
	
	
	/* function getComment(){
		var boardId = ${board.boardId};

		alert(boardId);
		$.getJSON("/CommaProjectTest/comment/all/", function(data){
			
	 		console.log(data);
			var str = "";
			
			$(data).each(function(){
				
				str +="추가되었습닏. ";
				 
				
				
				
				
	 		});
			 
			$("#comments").html(str);
	 		
		}); 
		
		
		

		
	}
	 */
	
	
});




$("#modify_btn").click(function(){
    var url = "<c:url value='/board/modify'/>";
    url = url + "?boardId=" +  ${board.boardId};    
    location.href= url;
   
});

$("#delete_btn").click(function(){
   if(confirm("are you sure?")==true){
       var url = "<c:url value='/board/delete'/>";
       url = url + "?boardId=" +  ${board.boardId};    
       location.href= url;
   }else{
      return;
   }
}); 

$("#list_btn").click(function(){
    var url = "<c:url value='/board/list'/>";
    location.href= url;
})

</script> 
</body>
</html>