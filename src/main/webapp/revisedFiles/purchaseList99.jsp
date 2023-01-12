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
  <a href="#" class="home">
    <img src="../resources/img/home.svg" alt="홈">
    <span>홈으로 가기</span>
  </a>
  <a href="#" class="item">
    <span>포인트 내역보기</span>
    <img src="../resources/img/swap.svg" alt="전환">
  </a>

  <!-- 카드 -->
  <ul class="list">
    <li class="card">
      <div class="card-frame">
        <div class="card-flip">
          <div class="card-front">
            <h3>Janurary <br> 06</h3>
          </div>
          <div class="card-back">
            <h4>구매 내역</h4>
            <table>
              <tr>
                <th>포인트</th>
                <th>구매 시간</th>
              </tr>
              <tr>
                <td>5000P</td>
                <td>10시 30분 37초</td>
              </tr>
              <tr>
                <td>50000P</td>
                <td>11시 59분 28초</td>
              </tr>
            </table>
            <span class="total">결제 총액: 55000원</span>
          </div>
        </div>
        
      </div>
    </li>
    <li class="card">
      <div class="card-frame">
        <div class="card-flip">
          <div class="card-front">
            <h3>Janurary <br> 06</h3>
          </div>
          <div class="card-back">
            <h4>구매 내역</h4>
            <table>
              <tr>
                <th>포인트</th>
                <th>구매 시간</th>
              </tr>
              <tr>
                <td>5000P</td>
                <td>10시 30분 37초</td>
              </tr>
              <tr>
                <td>50000P</td>
                <td>11시 59분 28초</td>
              </tr>
            </table>
            <span class="total">결제 총액: 55000원</span>
          </div>
        </div>
      </div>
    </li>
    
  </ul>
</body>

</html>