<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파티 추천</title>
</head>
<body>
	<form action="/miraclebird/recommend/result" method="get">
		<input type="radio" name="gender" value="0" />남성
		<input type="radio" name="gender" value="1" />여성
		<br/>
		<input type="radio" name="age" value="20" />20대&nbsp;
		<input type="radio" name="age" value="30" />30대&nbsp;
		<input type="radio" name="age" value="40" />40대&nbsp;
		<input type="radio" name="age" value="50" />50대&nbsp;
		<input type="radio" name="age" value="60" />60대&nbsp;
		<br/>		
		<input type="radio" name="area" value="first"/>경기, 강원&nbsp; 
		<input type="radio" name="area" value="second" />충청&nbsp;
		<input type="radio" name="area" value="third" />전라, 경상&nbsp;
		<input type="radio" name="area" value="fourth" />제주&nbsp;
		<br/>
		<input type="radio" name="income" value="first" />300만원 미만&nbsp; 
		<input type="radio" name="income"  value="second" />300만원 이상 500만원 미만&nbsp; 
		<input type="radio" name="income"  value="third" />500만원 이상 700만원 미만&nbsp;
		<input type="radio" name="income"  value="fourth" />700만원 이상&nbsp;
		<br/>
		<button>제출</button>
	</form>
</body>
</html>