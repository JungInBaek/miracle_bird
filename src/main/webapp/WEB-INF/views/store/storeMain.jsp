<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상점 메인 화면</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script type="text/javascript">
	// 상점 메인 화면에 들어 왔을 때 배경으로 가게 구현
	$.ajax({
		url : "productList",
		data : {
			page : 1,
			categoryId : 1
		},
		success : function(list) {
			$('#d1').empty()
			$('#d1').html(list)
		},
		error : function() {
			alert('에러 발생')
		}
	})
	$(function() {
		// 배경 카테고리 클릭시
		$('#product').click(function() {
			$.ajax({
				url : "productList",
				data : {
					page : 1,
					categoryId : 1
				},
				success : function(list) {
					$('#d1').empty()
					$('#d1').html(list)
				},
				error : function() {
					alert('에러 발생')
				}
			})
		})
		// 말풍선 카테고리 클릭시
		$('#balloon').click(function() {
			$.ajax({
				url : "productList",
				data : {
					page : 1,
					categoryId : 2
				},
				success : function(list) {
					$('#d1').empty()
					$('#d1').html(list)
				},
				error : function() {
					alert('에러 발생')
				}
			})
		})
		// 캐릭터 카테고리 클릭시
		$('#character').click(function() {
			$.ajax({
				url : "productList",
				data : {
					page : 1,
					categoryId : 3
				},
				success : function(list) {
					$('#d1').empty()
					$('#d1').html(list)
				},
				error : function() {
					alert('에러 발생')
				}
			})
		})
	})
</script>
</head>
<body>

	<button id="product">배경</button>
	<button id="balloon">말풍선</button>
	<button id="character">캐릭터</button>
	<a href="point"><button>포인트</button></a>
	<a href="order"><button>주문 조회</button></a> 내 포인트 : ????
	<div id="d1"></div>
</body>
</html>