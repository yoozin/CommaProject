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
<title>ResultPage</title>
 <script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
<form id="boardForm" role="form" method="post" autocomplete="off"> 
	No. ${board.boardId}
	board Title : ${board.title}
	travel Date : <fmt:formatDate value="${board.travelDate}" pattern="yyyy-MM-dd"/>
	writer : ${board.writer}<br>
	${board.content} 
	write Date : <fmt:formatDate value="${board.wDate}" pattern="yyyy-MM-dd"/>
	update Date :<fmt:formatDate value="${board.uDate}" pattern="yyyy-MM-dd"/>
		<input type="hidden" name="boardId" value="${board.boardId}"/><br>
		<input type="hidden" name="writer" value="${board.writer}"/><br>
		<input type="hidden" name="title"  value="${board.title}"/>
		<input type="hidden" name="travelDate" value="<fmt:formatDate value="${board.travelDate}" pattern="yyyy-MM-dd"/>"/><br>
		<input type="hidden" name="content" value="${board.content}"/>
		<input type="hidden" name="wDate" value="<fmt:formatDate value="${board.wDate}" pattern="yyyy-MM-dd HH:mm:ss.SSS"/>"/>
		<input type="hidden" name="uDate" value="<fmt:formatDate value="${board.uDate}" pattern="yyyy-MM-dd HH:mm:ss.SSS"/>"/>
</form> 

<p>
<button id="modify_btn">modify</button>
<button id="delete_btn">delete</button>
<button id="list_btn">list</button>
</p>

<script>

// 폼을 변수에 저장

var formObj = $("form[role='form']");

$("#modify_btn").click(function(){
	 var form = document.getElementById("boardForm");
	 var url = "<c:url value='/board/modify'/>";
	 url = url + "?boardId=" + ${board.boardId};    
	 form.action = url;    
	 form.submit();
	
});

$("#delete_btn").click(function(){
	if(confirm("are you sure?")==true){
			formObj.attr("action", "delete");
			formObj.attr("method", "post");
			formObj.submit();
	}else{
		return;
	}
}); 

$("#list_btn").click(function(){
	formObj.attr("action", "list");
	formObj.attr("method", "post");
	formObj.submit();
})

</script> 
</body>
</html>