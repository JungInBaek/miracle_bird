<%@page import="java.time.LocalDate"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Collection"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="com.multi.miraclebird.store.OrderVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>상품 구매내역</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/purchaseList.css">
  <link href="https://fonts.googleapis.com/css2?family=Courgette&family=Hahmlet:wght@900&family=Noto+Sans+KR:wght@300;400;500;700;900&family=Roboto:ital,wght@0,300;0,400;0,500;0,700;0,900;1,300&family=Titan+One&display=swap" rel="stylesheet">
</head>

<body>

  <div class="point-title">상품 구매내역카드 리스트</div>
  <!-- 페이지 이동 -->
  <a href="/miraclebird/store/productList?page=1&categoryId=1" class="home">
    <img src="../resources/img/home.svg" alt="홈">
    <span>홈으로 가기</span>
  </a>
  <a href="chargeList" class="item">
    <span>포인트 내역보기</span>
    <img src="../resources/img/swap.svg" alt="전환">
  </a>

  <!-- 카드 -->
  <ul class="list">
  	<%
  		List<LocalDate> date = (List<LocalDate>) request.getAttribute("date"); 
  		List<OrderVO> orderList = (List<OrderVO>) request.getAttribute("orderList");
  		for (int i = 0; i < date.size(); i++) {
  	%>
  			<li class="card">
					<div class="card-frame">
			        	<div class="card-flip">
			          		<div class="card-front">
			            		<h3><%= date.get(i)%></h3>
			          		</div>
				          	<div class="card-back">
					            <h4>상품 구매 내역</h4>
					            <table>
					              <tr>
					                <th>상품 명</th>
					                <th>구매 시간</th>
					                <th>상품 금액</th>
					              </tr>
  	<%
			int sum = 0;
  			for (int j = 0; j < orderList.size(); j++) {
  				if (String.valueOf(date.get(i)).equals(orderList.get(j).getOrderDate().format(DateTimeFormatter.ISO_LOCAL_DATE))) {
  					int price = orderList.get(j).getProductPrice();
  					sum += price;
	%>
					              <tr>
					                <td><%= orderList.get(j).getProductName()%></td>
					                <td><%= orderList.get(j).getOrderDate().format(DateTimeFormatter.ofPattern("HH시 mm분 ss초"))%></td>
					                <td><%= price%> P</td>
					              </tr>
	<%
				} 
  			}
  	%>  	
				            	</table>
				            	<span class="total">총 금액 : <%= sum %> P</span>
			          	</div>
		          	</div>
		        </div>
           </li>
    <%
    	}
  	%>

  </ul>

</body>

</html>