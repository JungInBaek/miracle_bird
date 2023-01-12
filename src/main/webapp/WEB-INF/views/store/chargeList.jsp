<%@page import="java.time.LocalDate"%>
<%@page import="com.multi.miraclebird.point.ChargeVO"%>
<%@page import="java.util.List"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>포인트 구매내역</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/pointList.css">
  <link href="https://fonts.googleapis.com/css2?family=Courgette&family=Hahmlet:wght@900&family=Noto+Sans+KR:wght@300;400;500;700;900&family=Roboto:ital,wght@0,300;0,400;0,500;0,700;0,900;1,300&family=Titan+One&display=swap" rel="stylesheet">
</head>

<body>

  <div class="point-title">포인트 구매내역카드 리스트</div>
  <!-- 페이지 이동 -->
  <a href="/miraclebird/store/productList?page=1&categoryId=1" class="home">
    <img src="../resources/img/home.svg" alt="홈">
    <span>홈으로 가기</span>
  </a>
  <a href="purchaseList" class="item">
    <span>상품 내역보기</span>
    <img src="../resources/img/swap.svg" alt="전환">
  </a>

  <!-- 카드 -->
  <ul class="list">
    <%
  		List<LocalDate> date = (List<LocalDate>) request.getAttribute("date");
  		List<ChargeVO> chargeList = (List<ChargeVO>) request.getAttribute("chargeList");
  		for (int i = 0; i < date.size(); i++) {
  	%>
    <li class="card">
      <div class="card-frame">
        <div class="card-flip">
          <div class="card-front">
            <h3><%= date.get(i)%></h3>
          </div>
          <div class="card-back">
            <h4>포인트 충전 내역</h4>
            <table>
              <tr>
                <th>포인트</th>
                <th>충전 시간</th>
                <th>결제 금액</th>
              </tr>
   	<%
			int sum = 0;
			for (int j = 0; j < chargeList.size(); j++) {
				if (String.valueOf(date.get(i)).equals(chargeList.get(j).getChargeDate().format(DateTimeFormatter.ISO_LOCAL_DATE))) {
					int price = chargeList.get(j).getPointPrice();
					sum += price;
	%>
              <tr>
                <td><%= chargeList.get(j).getPointAmount()%> P</td>
                <td><%= chargeList.get(j).getChargeDate().format(DateTimeFormatter.ofPattern("HH시 mm분 ss초"))%></td>
                <td><%= price%> 원</td>
              </tr>
    <%
				}
			}
  	%>
            </table>
            <span class="total">결제 총액: <%= sum %>원</span>
          </div>
        </div>
    </li>
    <%	
    	}
  	%>
  </ul>


</body>

</html>