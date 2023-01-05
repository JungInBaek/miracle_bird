<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
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
	<div id="profileResult"></div>
	<a href="my-profileUpdate.jsp"><button>수정</button></a>
	<hr>
	피드 결과
	<div id="feedResult"></div>
	<!-- https://graph.instagram.com/{api-version}/{user-id}/media
  ?access_token={access-token} -->
</body>
</html>