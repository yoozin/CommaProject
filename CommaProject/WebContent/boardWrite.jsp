<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- include libraries(jQuery, bootstrap) -->
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 
<!-- include summernote css/js-->
<link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote-bs4.css" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote-bs4.js"></script>
<!-- include summernote-ko-KR -->
<script src="/resources/js/summernote-ko-KR.js"></script>

<title>글쓰기</title>

<script>
$(document).ready(function() {
	  $('#summernote').summernote({
 	    	placeholder: 'content',
	        minHeight: 370,
	        maxHeight: null,
	        focus: true, 
	        lang : 'ko-KR'
	       
	        callbacks: {
	            onImageUpload: function(files, editor, welEditable) {
	             for (var i = files.length - 1; i >= 0; i--) {
	             sendFile(files[i], this);
	             }
	            }
	        }
	        
	  });
	});
	
	function sendFile(file, el) {
    var form_data = new FormData();
    form_data.append('file', file);
    $.ajax({
      data: form_data,
      type: "POST",
      url: '/image',
      cache: false,
      contentType: false,
      enctype: 'multipart/form-data',
      processData: false,
      success: function(url) {
        $(el).summernote('editor.insertImage', url);
        $('#imageBoard > ul').append('<li><img src="'+url+'" width="480" height="auto"/></li>');
      }
    });
  }
</script>

</head>
<body>
<h2 style="text-align: center;">Write your story</h2><br><br><br>

<div style="width: 60%; margin: auto;">
	<form method="post" action="board/write">
		<input type="text" name="writer" style="width: 20%;" placeholder="writer"/><br>
		<input type="text" name="title" style="width: 40%;" placeholder="title"/>
		<input type="date" name="travelDate"><br>
		<br><br> 
		<textarea id="summernote" name="content"></textarea>
		<input id="subBtn" type="button" value="submit" style="float: right;" onclick="goWrite(this.form)"/>
	</form>
</div>

</body>

<script>
function goWrite(frm) {
	var title = frm.title.value;
	var writer = frm.writer.value;
	var content = frm.content.value;
	var travelDate = frm.travelDate.value;
	if (title.trim() == ''){
		alert("제목을 입력해주세요");
		return false;
	}
	if (writer.trim() == ''){
		alert("작성자를 입력해주세요");
		return false;
	}
	if (content.trim() == ''){
		alert("내용을 입력해주세요");
		return false;
	}
	if (travelDate.trim() == ''){
		alert("날짜 입력해주세요");
		return false;
	}
	
	
	frm.submit();
}
</script>

</html>
<%-- <form action="board/write" method="post"> 
	<input type="text" name="title" placeholder="title"><br>
	<input type="date" name="travelDate"><br>
	<input type="text" name="writer" placeholder="writer"><br>
	<input type="text" name="content" placeholder="please write your content"><br>
	<input type="file" name="uploadFile" multiple>
	<input type="submit" value="upload">
</form> --%>
