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
	write Date : <fmt:formatDate value="${board.wDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
	update Date :${board.uDate}
	view : ${board.viewCount}
</form> 

<p>
<button id="modify_btn">modify</button>
<button id="delete_btn">delete</button>
<button id="list_btn">list</button>
</p>

<script>

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