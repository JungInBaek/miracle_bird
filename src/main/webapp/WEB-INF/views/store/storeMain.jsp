<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script type="text/javascript">
// 상점 메인 화면에 들어 왔을 때
$.ajax({
	url: "productList",
	success: function(result) {
		$('#d1').empty()
		$('#d1').html(result)
	},
	error : function() {
		alert('에러 발생')
	}
})
$(function() {
	// 배경 카테고리 클릭시
	$('#product').click(function() {
		$.ajax({
			url: "productList",
			success: function(result) {
				$('#d1').empty()
				$('#d1').html(result)
			},
			error : function() {
				alert('에러 발생')
			}
		})
	})
	// 포인트 카테고리 클릭시
	$('#point').click(function() {
		$.ajax({
			url : "pointList",
			success: function(result) {
				$('#d1').empty()
				$('#d1').html(result)
			}
		})
	})
})
</script>
</head>
<body>
<button id="product">배경</button>
<button id="point">포인트</button>
<a href="order"><button>주문 조회</button></a>
<div id="d1"></div>
</body>
</html>