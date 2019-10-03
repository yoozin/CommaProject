<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<title>board</title>
<style>
body {
  background: #eee;
  padding: 0;
  margin: 0;
  margin-top: 140px;
  font-family: "Open Sans", sans-serif;
  font-family: 'Open Sans', Helvetica, Arial, sans-serif;
}
.commaicon {
 padding-top: 26px;
}
.container2 {
  width: 80%;
  margin: 0 auto;
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
  margin: 0;
  padding: 0;
  margin-top: -48px;
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


   
</style>
<script>
//이전버튼 이벤트
function fn_prev(page, range, rangeSize){
   var form = document.getElementById("boardForm");
   var page = ((range-2)*rangeSize)+1;
   var range = range-1;
   
   var url = "<c:url value='/board/list'/>";
   url = url + "?page=" + page;
   url = url + "&range=" + range;
   form.action = url;
   form.submit();
}

//페이지 번호 클릭
function fn_pagination(page, range, rangeSize, searchType, keyword) {
    var form = document.getElementById("boardForm");
   var url = "<c:url value='/board/list'/>";
   url = url + "?page=" + page;
   url = url + "&range=" + range;

   location.href = url;   
}



//다음 버튼 이벤트
function fn_next(page, range, rangeSize){
   var form = document.getElementById("boardForm");
   var page = parseInt((range*rangeSize))+1;
   var range = parseInt(range)+1;
   
   var url = "<c:url value='/board/list'/>";
   url = url + "?page=" + page;
   url = url + "&range=" + range;
   form.action = url;
   form.submit();
}

function list_bt(){
   location.href = "<c:url value='/board/list'/>";
}

function comment_create(boardId){
   var form = document.getElementById("boardForm");
   var url = "<c:url value='../commentList.jsp'/>";
   url = url + "?boardId=" + boardId;
   form.action = url;
   form.submit();
}

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

//search
function btnSearch(){
    var form = document.getElementById("boardForm");
    var url = "<c:url value='/board'/>";
   url = url + "?searchType=" + $('#searchType').val();
   url = url + "&keyword=" + $('#keyword').val();
    
    form.action = url

    form.submit();
    
}

</script>
</head>
<body>
<article>
<div class="container">
		<nav>
		<div class="container2">

			<div class="commaicon">
				<a href="index" id="brand"><img height="22px;"
					src="${pageContext.request.contextPath}/resources/images/blackLogo.png" /></a>
			</div>

			<ul class="navbar-menu">
				<li><a href="http://localhost:8080/CommaProject/index">Home</a></li>
				<li><a href="http://localhost:8080/CommaProject/board/list">Stories</a></li>
				<li><a href="#">Comma</a></li>
				<c:choose>
					<c:when test="${not empty sessionScope.loginInfo}">
						<li>${sessionScope.loginInfo.memberId}님<a
							href="http://localhost:8080/CommaProject/member/logout.do">Logout</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="http://localhost:8080/CommaProject/contact.jsp">Login</a></li>
					</c:otherwise>
				</c:choose>
			</ul>

		</div>
		</nav>

		<div class="table-responsive">
<h3>Explore Stories</h3>
<br>

    <form id="boardForm" name="boardForm" method="post">
        <table class="table table-striped table-sm">
        <colgroup>
         <col style="width:auto;"/>
         <col style="width:auto;"/>
         <col style="width:auto;"/>
         <col style="width:auto;"/>
         <col style="width:auto;"/>
         <col style="width:auto;"/>
         <col style="width:auto;"/>
         <col style="width:auto;"/>
      </colgroup>
            <thead>
                <tr>
                   
                    <th>no.</th>
                    <th>title</th>
                    <th>writer</th>
                    <th>travelDate</th>
                    <th>writeDate</th>
                    <th>updateDate</th>
                    <th>replyCount</th>
                    <th>viewCount</th>
                </tr>
            </thead>
          <tbody>
            <c:choose>
            <c:when test="${empty list}">
               <tr><td colspan="8" align="center">데이터가 없습니다.</td></tr>
            </c:when>
            <c:when test="${!empty list }">
            
                    <c:forEach var="result" items="${list}" varStatus="status">      
                      <tr>
                         <td>${result.boardId }</td>
                        <td><a href='#' onclick='fn_view(${result.boardId})'><c:out value="${result.title }"/></a></td>
                        <td><c:out value="${result.writer }"/></td>
                        <td><fmt:formatDate value="${result.travelDate }" dateStyle="full"/></td>
                        <td><fmt:formatDate value="${result.wDate }" pattern="yyyy-MM-dd hh:mm:ss"/></td>
                        <td><c:out value="${result.uDate }"/></td>
                        <td><c:out value="${result.replyCount}"/></td>
                        <td><c:out value="${result.viewCount}"/></td>
                    </tr>
                </c:forEach>
                </c:when>
                </c:choose>
            </tbody>
        </table>
        <div>
      <button type="button" class="btn btn-sm btn-primary" id="fn_write()" onclick="fn_write()">글쓰기</button><br>
      </div>
    <br>
    
    </div>
    
    <!-- pagination{s} -->
   <div id="paginationBox">
      <ul class="pagination">
         <c:if test="${pagination.prev}">
            <li class="page-item"><a class="page-link" href="#" onClick="fn_prev('${pagination.page}', '${pagination.range}', '${pagination.rangeSize}')">Previous</a></li>
         </c:if>
            
         <c:forEach begin="${pagination.startPage}" end="${pagination.endPage}" var="idx">
            <li class="page-item <c:out value="${pagination.page == idx ? 'active' : ''}"/> "><a class="page-link" href="#" onClick="fn_pagination('${idx}', '${pagination.range}', '${pagination.rangeSize}')"> ${idx} </a></li>
         </c:forEach>
            
         <c:if test="${pagination.next}">
            <li class="page-item"><a class="page-link" href="#" onClick="fn_next('${pagination.range}', 
'${pagination.range}', '${pagination.rangeSize}')">Next</a></li>
         </c:if>
      </ul>
   </div>
   <!-- pagination{e} -->

    
    <!-- Search -->
    <div class="form-group row justify-content-center">
       <div class="w100" style="padding-right:10px">
          <select class="form-control form-control-sm" name="searchType" id="searchType">
             <option value="title">제목</option>
             <option value="content">내용</option>
             <option value="writer">작성자</option>
          
   
          </select>
       </div>
       <div class="w300" style="padding-right:10px">
          <input type="text" class="form-control form-control-sm" name="keyword" id="keyword">
       </div>
       <div>
          <button class="btn btn-sm btn-primary" name="btnSearch" id="btnSearch" onclick="btnSearch()">검색</button>
          <button class="btn btn-sm btn-primary" name="list" id="list" onclick="list_bt()">전체보기</button>
       </div>

    </div>
    </form>
    <!-- search -->
    
    
    </div>
</article>
</body>
</html>