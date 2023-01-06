<%@page import="com.multi.miraclebird.store.ProductVO"%>
<%@page import="java.util.List"%>
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
	function productBuy() {
		let f = document.createElement('form');
		var productId = $('input[name=productId]').val();
		console.log(productId);
		let obj;
		obj = document.createElement('input');
		obj.setAttribute('type', 'hidden');
		obj.setAttribute('name', 'productId');
		obj.setAttribute('value', productId);
		
		f.appendChild(obj);
		f.setAttribute('method', 'post');
		f.setAttribute('action', "productBuy?productId="+ productId);
		document.body.appendChild(f);
		if (confirm("상품을 구입하시겠습니까?")) {
			f.submit();
			// location.href = "productBuy?productId="+ productId;
		} else {
			return;
		}
	}
</script>
</head>
<body>

	<!-- 	<button id="product">배경</button>
	<button id="balloon">말풍선</button>
	<button id="character">캐릭터</button> -->
	<a href="productList?page=1&categoryId=1"><button>배경</button></a>
	<a href="productList?page=1&categoryId=2"><button>말풍선</button></a>
	<a href="productList?page=1&categoryId=3"><button>캐릭터</button></a>
	<a href="point"><button>포인트</button></a>
	<a href="order"><button>주문 조회</button></a> 내 포인트 : ${point}원
	<h3>전체 상품 개수>> ${count}개</h3>

	<div id="d1">
		<table border="1">
			<tr>
				<td class="left">productNo</td>
				<td class="left">상품 명</td>
				<td class="left">상품 가격</td>
				<td class="left">상품 그림</td>
			</tr>
			<c:forEach items="${list}" var="one">
				<tr>
					<td class="right">${one.productNo}</td>
					<td class="right">${one.productName}</td>
					<td class="right">${one.productPrice}</td>
					<td class="right">
					<input type = "hidden" name = "productId" value="${one.productId}">
					<button onclick="productBuy()">${one.productClass}</button>
					</td>
					<%-- <td class="right">${one.productId}</td> --%>
				</tr>
			</c:forEach>
		</table>
	</div>

	<%
	int pages = (int) request.getAttribute("pages");
	int cateNum = (int) request.getAttribute("cateNum");
	for (int p = 1; p <= pages; p++) {
	%>
	<a href="productList?page=<%=p%>&categoryId=<%=cateNum%>">
		<button style="background: lime; color: red; width: 50px;"><%=p%></button>
	</a>
	<%
	}
	%>
</body>
</html>