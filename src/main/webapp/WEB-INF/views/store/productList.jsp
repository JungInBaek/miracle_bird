<%@page import="com.multi.miraclebird.store.ProductVO"%>
<%@page import="com.multi.miraclebird.store.CategoryVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.text.*" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>미라클 스토어</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/store99.css">
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
	<%
	DecimalFormat df = new DecimalFormat("###,###");
	int point = (int) request.getAttribute("point");
	%>
	<!-- 프로필 -->
	<div class="profile">
		<div class="circle-container">
			<img src="../resources/img/profile.png" alt="">
		</div>
		<div class="account">@${userVO.username}</div>
		<div class="point-container">
			<img src="../resources/img/money.svg" alt="저금통" class="point-icon">
			<span class="point"><%=df.format(point) %></span>
		</div>
		<div class="category">
			<div>
				<%
				int cateNum2 = (int) request.getAttribute("cateNum");
				List<CategoryVO> cateList = (List<CategoryVO>) request.getAttribute("cateList");
				for (int p = 0; p < cateList.size(); p++) {
					if (cateList.get(p).getCategoryId() == cateNum2) {
				%>
						<a href="productList?page=1&categoryId=<%=cateList.get(p).getCategoryId()%>">
							<div class="color color-box category-item">
								<img src="../resources/img/<%=cateList.get(p).getCategoryImg()%>" alt="<%=cateList.get(p).getCategoryName()%>" class="color-icon"> 
								<span class="color-text"><%=cateList.get(p).getCategoryName()%></span>
							</div>
						</a>
				<%
					} else {
				%>
						<a href="productList?page=1&categoryId=<%=cateList.get(p).getCategoryId()%>">
							<div class="speech-bubble category-item">
								<img src="../resources/img/<%=cateList.get(p).getCategoryImg()%>" alt="<%=cateList.get(p).getCategoryName()%>" class="bubble-icon mouseover"> 
								<span class="color-text"><%=cateList.get(p).getCategoryName()%></span>
							</div>
						</a>
				<%	
					}
				}
				%>
			</div>
			<div class="btn-container">
				<a href="pointList">
					<div class="add-point btn">
						<img src="../resources/img/add-coin.svg" alt="포인트"	class="add-icon mouseover"> 
						<span class="add-text mouseover">포인트 충전</span>
					</div>
				</a>
				<a href="purchaseList">
					<div class="buy-history btn">
						<img src="../resources/img/list.svg" alt="포인트"	class="add-icon mouseover"> 
						<span class="add-text mouseover">구매 내역</span>
					</div>
				</a>
			</div>
		</div>
	</div>

	<!-- 메인 -->
	<div class="main">
		<!-- 헤더 -->
		<header>
			<div class="head">
				<!-- 네비게이션바 -->
				<nav>
                <ul class="nav-container animate__animated animate__fadeIn">
                    <li class="nav-item"><a href="/miraclebird/recruit/list">FIND</a></li>
                    <c:if test="${partyId != null}">
                    	<li class="nav-item"><a href="/miraclebird/party/main">MY PARTY</a></li>
                    </c:if>
                    <li class="nav-item"><a href="/miraclebird/myFeed">MY FEED</a></li>
                    <li class="nav-item"><a href="/miraclebird/profile">PROFILE</a></li>
                    <li class="nav-item"><a href="/miraclebird/store/productList?page=1&categoryId=1">STORE</a></li>
                    <li class="nav-item"><a href="/miraclebird/recommend">RECOMMEND</a></li>
                    <li class="nav-item">
                    	<c:choose>
                    		<c:when test="${userId == null}">
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
     	<div style="background-color: transparent; border: none; width: auto; padding: 5px 10px; margin: 0 10px; font-weight: 500; font-size: 15px; color: #222; font-weight: 600;">구매하신 배경은 회원님의 파티룸에서 사용 가능합니다!</div>
		<div class="item-container">
			<%
			List<ProductVO> productList = (List<ProductVO>) request.getAttribute("list");
			for (int i = 0; i < productList.size(); i++) {
			%>
			<div class="item">
				<div class="item-image"
					style="background-color: <%= productList.get(i).getProductClass()%>"></div>
				<div class="item-text">
					<div class="item-text-title"> <%= productList.get(i).getProductName()%></div>
					<div class="item-price"><%= df.format(productList.get(i).getProductPrice()) %> P</div>
				</div>
				<div onclick='productBuy(<%= productList.get(i).getProductId()%>)' class="item-buy">
				구매하기
				</div>
			</div>
			<% } %>
		</div>
		<%
		int pages = (int) request.getAttribute("pages");
		int cateNum = (int) request.getAttribute("cateNum");
		for (int p = 1; p <= pages; p++) {
		%>
		<div style="display: inline-block; align: center;">
			<a href="productList?page=<%=p%>&categoryId=<%=cateNum%>">
				<button style="background-color: transparent; border: none; width: auto; padding: 5px 10px; 
				margin: 0 10px; font-weight: 500; font-size: 18px; color: #222;"><%=p%></button>
			</a>
		</div>
		<%
		}
		%>
	</div>
</body>
</html>