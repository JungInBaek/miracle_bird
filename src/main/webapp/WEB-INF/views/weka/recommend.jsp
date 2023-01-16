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
		성별 : <input type="text" name="gender" /> <br />
		연령대 : <input type="text" name="age" /> <br />
		지역First : <input type="text" name="areaFirst" /> <br />
		지역Second : <input type="text" name="areaSecond" /> <br />
		지역Third : <input type="text" name="areaThird" /> <br />
		지역Fourth : <input type="text" name="areaFourth" /> <br />
		수입First : <input type="text" name="incomeFirst" /> <br />
		수입Second : <input type="text" name="incomeSecond" /> <br />
		수입Third : <input type="text" name="incomeThird" /> <br />
		수입Fourth : <input type="text" name="incomeFourth" /> <br />
		<button>제출</button>
	</form>
</body>
</html>