<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
프로필 수정
<form action="updateProfile"
	  method="post"
	  enctype="multipart/form-data">
	프로필 이미지 <input type="file" name="file"> <br>
	미라클활동 시간 : <input type="time" name="miracleStartTime"/> ~ <input type="time" name="miracleEndTime"/> <br />
	자기소개 : <input type="text" name="bio"><br>
	<button>완료</button>
</form>
</body>
</html>