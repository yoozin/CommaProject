<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>



</script>
</head>
<body>
<div>
    <form id="boardForm" name="boardForm" method="post">
        <table>
            <thead>
                <tr>
                	<th>no.</th>
                    <th>boardId</th>
                    <th>title</th>
                    <th>writer</th>
                    <th>travelDate</th>
                    <th>writeDate</th>
                    <th>updateDate</th>
                    <th>comments</th>
                </tr>
            </thead>
            <tbody>
           		<c:set var="i" value="0"/>
                <c:forEach var="result" items="${list}" varStatus="status">
                    <tr>              
                  		<td><c:out value="${i}"/></td>
                        <td><c:out value="${result.boardId }"/></td>
                        <td><a href='#' onClick='fn_view(${result.boardId})'><c:out value="${result.title }"/></a></td>
                        <td><c:out value="${result.writer }"/></td>
                        <td><c:out value="${result.travelDate }"/></td>
                        <td><c:out value="${result.wDate }"/></td>
                        <td><c:out value="${result.uDate }"/></td>
                        <td><c:out value="${result.replyCount}"/></td>
                        <td><c:out value="${result.viewCount}"/></td>
                    </tr>
                    </c:forEach>
               
            </tbody>
        </table>
       
        
        <input type="button" value="글쓰기" style="float: right;" onclick="location.href='/write'">
        <div>            
            <a href='#' onClick='fn_write()'>write</a>            
        </div>
    </form>
    
    
<script>


	
//글쓰기

function fn_write(){
    
    var form = document.getElementById("boardForm");
    
    form.action = "<c:url value='/board'/>";
    form.submit();
    
}
 
//글조회
function fn_view(boardId){
    
    var form = document.getElementById("boardForm");
    var url = "<c:url value='/board/viewOne'/>";
    url = url + "?boardId=" + boardId;
    
    form.action = url;    
    form.submit(); 
}
</script>
</div>