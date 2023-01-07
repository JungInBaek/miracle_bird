<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>미라클 스토어</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/store.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.css">
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500;700;900&family=Roboto:ital,wght@0,300;0,400;0,500;0,700;0,900;1,300&display=swap"
	rel="stylesheet">


<script type="text/JavaScript"
	src=http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js></script>
<script type="text/javascript">
	function productBuy(productId) {
		let f = document.createElement('form');
		f.setAttribute('method', 'post');
		f.setAttribute('action', "productBuy?productId=" + productId);
		document.body.appendChild(f);
		if (confirm("상품을 구입하시겠습니까?")) {
			f.submit();
		} else {
			return;
		}
	}
</script>
</head>
<body>
	<!-- 프로필 -->
	<div class="profile">
		<div class="circle-container">
			<img src="../resources/img/profile.png" alt="">
		</div>
		<div class="name">${userVO.userId}</div>
		<div class="account">@${username}</div>
		<div class="point-container">
			<img src="../resources/img/money.svg" alt="저금통" class="point-icon">
			<span class="point">${point}</span>
		</div>
		<div class="category">
			<div>
				<a href="productList?page=1&categoryId=1">
					<div class="color category-item">
						<img src="../resources/img/palette.svg" alt="색상" class="color-icon"> 
						<span class="color-text">컬러</span>
					</div>
				</a> 
				<a href="productList?page=1&categoryId=2">
					<div class="speech-bubble category-item">
						<img src="../resources/img/bubble.svg" alt="말풍선" class="bubble-icon mouseover"> 
						<span class="bubble-text mouseover">말풍선</span>
					</div>
				</a> <a href="productList?page=1&categoryId=3">
					<div class="speech-bubble category-item">
						<img src="../resources/img/bubble.svg" alt="캐릭터" class="bubble-icon mouseover"> 
						<span class="bubble-text mouseover">캐릭터</span>
					</div>
				</a>
			</div>
			<a href="#">
				<div class="add-point category-item">
					<img src="../resources/img/add-coin.svg" alt="포인트"	class="add-icon mouseover"> 
					<span class="add-text mouseover">포인트 충전</span>
				</div>
			</a>
			<a href="#">
				<div class="add-point category-item">
					<img src="../resources/img/add-coin.svg" alt="포인트"	class="add-icon mouseover"> 
					<span class="add-text mouseover">구매 내역</span>
				</div>
			</a>
		</div>
	</div>

	<!-- 메인 -->
	<div class="main">
		<!-- 헤더 -->
		<header>
			<div class="head">
				<!-- 네비게이션바 -->
				<nav>
					<ul class="nav-container">
						<li class="nav-item"><a href="#">COMMUNITY</a></li>
						<li class="nav-item"><a href="/miraclebird/recruit/list">JOIN</a></li>
						<c:if test="${partyId != null}">
                    		<li class="nav-item"><a href="/miraclebird/party/main">MY PARTY</a></li>
                    	</c:if>
						<li class="nav-item"><a href="/miraclebird/store/productList?page=1&categoryId=1">STORE</a></li>
						<li class="nav-item"><a href="/miraclebird/myFeed.jsp">PROFILE</a></li>
						<li class="nav-item">
	                    	<c:choose>
	                    		<c:when test="${userVO.userId == null}">
	                    			<a href="/miraclebird/loginPage"><button>LOGIN</button></a>
	                    		</c:when>
	                    		<c:otherwise>
	                    			<a href="/miraclebird/logout"><button>LOGOUT</button></a>
	                    		</c:otherwise>
	                    	</c:choose>
                   	 	</li>
					</ul>
				</nav>
			</div>
		</header>

		<!-- 컨텐츠 -->
		<div class="item-container">
			<c:forEach items="${list}" var="one" varStatus="status">
				<div class="item">
					<div class="item-image"
						style="background-color: ${one.productClass}"></div>
					<div class="item-text">
						<div class="item-text-title">${one.productName}</div>
						<div class="item-price">${one.productPrice}</div>
					</div>
					<div onclick='productBuy(${one.productId})' class="item-buy">
					</div>
				</div>

			</c:forEach>
		</div>
		<%
		int pages = (int) request.getAttribute("pages");
		int cateNum = (int) request.getAttribute("cateNum");
		for (int p = 1; p <= pages; p++) {
		%>
		<div style="display: inline; align: center;">
		
			<a href="productList?page=<%=p%>&categoryId=<%=cateNum%>">
				<button style="background: lime; color: red; width: 50px; border-radius: 10px;"><%=p%></button>
			</a>
		</div>
		<%
		}
		%>
	</div>
</body>
</html>