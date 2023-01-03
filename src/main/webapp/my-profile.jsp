<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.2.1.js"></script>
<script>
	$(function() {
		$.ajax({
			url : "profile/one",
			success : function(result) {
				$("#result").html(result);
			}
		})
	})
</script>
</head>
<body>
로그인된 유저<br>
프로필 결과
<hr>
<div id="result"></div>
<a href="my-profileUpdate.jsp"><button>수정</button></a>
</body>
</html>