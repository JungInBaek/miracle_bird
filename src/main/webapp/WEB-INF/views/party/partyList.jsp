<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="resources/css/partyList.css" rel="stylesheet" type="text/css">
    <link
        href=“https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500;700;900&family=Roboto:ital,wght@0,300;0,400;0,500;0,700;0,900;1,300&display=swap”
        rel=“stylesheet”>
    <link rel=“stylesheet” href=“https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.css”>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css">
    <!-- TODO: 페이지네이션 구현 -->
    <title>파티 목록 화면</title>
  </head>
</head>
<body>
<header>
      <div class="head">
          <!-- 로고 -->
          <a href="#">
              <img src="resources/img/logo.svg" alt="로고" class="logo">
          </a>
          <!-- 네비게이션바 -->
            <nav>
                <ul class="nav-container animate__animated animate__fadeIn">
                    <li class="nav-item"><a href="/miraclebird">COMMUNITY</a></li>
                    <li class="nav-item"><a href="/miraclebird/recruit/list">JOIN</a></li>
                    <c:if test="${partyId != null}">
                    	<li class="nav-item"><a href="/miraclebird/party/main">MY PARTY</a></li>
                    </c:if>
                    <li class="nav-item"><a href="/miraclebird/myFeed">MY FEED</a></li>
                    <li class="nav-item"><a href="/miraclebird/profile">PROFILE</a></li>
                    <li class="nav-item"><a href="/miraclebird/store/productList?page=1&categoryId=1">STORE</a></li>
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
  <div class="search">
      <input type="text" placeholder="검색어를 입력해주세요." />
      <a href="#">
        <img src="resources/img/search-normal.png"class="searchBtn">
      </a>
    </div>
    <div class="box">
      <div class="wrap">
        <div class="party" onclick="location.href='create.jsp'" style="cursor:pointer">
          <td><img src="resources/img/profile-circle.png" class="profile" /></td>
          <table>
            <tbody>
              <tr>
                <td>파티 이름</td>
                <td> 데이터 넣기</td>
              </tr>
              <tr>
                <td>파티 시간</td>
                <td>데이터 넣기</td>
              </tr>
              <tr>
                <td>파티 활동</td>
                <td>데이터 넣기</td>
              </tr>
              <tr>
                <td><img src="resources/img/profile-2user.png" class="people"></td>
                <td>데이터 넣기</td>
              </tr>
            </tbody>
          </table>
        </div>
        <div class="party">
          <td><img src="resources/img/profile-circle.png" class="profile" /></td>
          <table>
            <tbody>
              <tr>
                <td>파티 이름</td>
                <td> 데이터 넣기</td>
              </tr>
              <tr>
                <td>파티 시간</td>
                <td>데이터 넣기</td>
              </tr>
              <tr>
                <td>파티 활동</td>
                <td>데이터 넣기</td>
              </tr>
              <tr>
                <td><img src="resources/img/profile-2user.png" class="people"></td>
                <td>데이터 넣기</td>
              </tr>
            </tbody>
          </table>
        </div>
        <div class="party">
          <td><img src="resources/img/profile-circle.png" class="profile" /></td>
          <table>
            <tbody>
              <tr>
                <td>파티 이름</td>
                <td> 데이터 넣기</td>
              </tr>
              <tr>
                <td>파티 시간</td>
                <td>데이터 넣기</td>
              </tr>
              <tr>
                <td>파티 활동</td>
                <td>데이터 넣기</td>
              </tr>
              <tr>
                <td><img src="resources/img/profile-2user.png" class="people"></td>
                <td>데이터 넣기</td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
    <div class="partyBtn">
      <button class="btn">
        <a href="#">  
          파티신청내역
        </a>
      </button>
      <button class="btn">
        <a href="#">
          파티 생성
        </a>
        </button>
      <button class="btn">
        <a href="#">
          파티 모집글 등록
        </a>
      </button>
    </div>

</body>
</html>