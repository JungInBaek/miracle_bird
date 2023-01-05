<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.2.1.js"></script>
<script>
	$.ajax({
		url : "profile/one",
		success : function(profileResult) {
			$("#profileResult").html(profileResult);
		}
	})
	$.ajax({
		url : "profile/allFeed",
		success : function(feedResult) {
			$('#feedResult').html(feedResult);
		}
	})
</script>
</head>
<body>
	프로필 결과
	<hr>
	<div id="profileResult"></div>
	<a href="my-profileUpdate.jsp"><button>수정</button></a> 피드 결과
	<div id="feedResult"></div>
	<!-- https://graph.instagram.com/{api-version}/{user-id}/media
  ?access_token={access-token} -->
</body>
</html>