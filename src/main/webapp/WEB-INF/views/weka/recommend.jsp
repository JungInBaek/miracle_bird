<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <link href="${pageContext.request.contextPath}/resources/css/create.css" rel="stylesheet" type="text/css">
    <link
        href=“https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500;700;900&family=Roboto:ital,wght@0,300;0,400;0,500;0,700;0,900;1,300&display=swap”
        rel=“stylesheet”>
    <link rel=“stylesheet”
    href=“https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.css”>
    <title>파티 추천</title>
</head>
<body>
<header>
        <div class="head">
            <!-- 로고 -->
            <a href="/miraclebird">
                <img src="${pageContext.request.contextPath}/resources/img/logo.svg" alt="로고" class="logo">
            </a>
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
	<div class="box">
        <div class="partyInfo">
        	<h1>파티 추천 정보 입력</h1>
        	<br>
            <!-- form action 넣기 -->
            <form action="/miraclebird/recommend/result" method="get">
                <table class="party">
                    <tbody>
                        <tr>
                            <td><img src="${pageContext.request.contextPath}/resources/img/gender.png" class="img" /></td>
                            <td class="td1"><a>GENDER</a></td>
                            <td>
                            	<input type="radio" class="form-check-input" name="gender" value="0" />남성
								<input type="radio" class="form-check-input" name="gender" value="1" />여성
                            </td>
                        </tr>
                        <tr>
                            <td><img src="${pageContext.request.contextPath}/resources/img/age.png" class="img" /></td>
                            <td class="td1"><a>AGE</a></td>
                            <td>
                        		<input type="radio" name="age" value="20" />20대&nbsp;
								<input type="radio" name="age" value="30" />30대&nbsp;
								<input type="radio" name="age" value="40" />40대&nbsp;
								<input type="radio" name="age" value="50" />50대&nbsp;
								<input type="radio" name="age" value="60" />60대&nbsp;
                            </td>
                        </tr>
                        <tr>
                            <td><img src="${pageContext.request.contextPath}/resources/img/area.png" class="img" /></td>
                            <td class="td1"><a>AREA</a></td>
                            <td>
								<input type="radio" name="area" value="first"/>경기, 강원&nbsp; 
								<input type="radio" name="area" value="second" />충청&nbsp;
								<input type="radio" name="area" value="third" />전라, 경상&nbsp;
								<input type="radio" name="area" value="fourth" />제주&nbsp;
                            </td>
                        </tr>
                        <tr>
                            <td><img src="${pageContext.request.contextPath}/resources/img/add-coin.png" class="img" /></td>
                            <td class="td1"><a>INCOME</a></td>
                            <td>
								<div class="form-group">
			   	        		<div class="form-check">
			   	        			<label class="form-check-label">
										<input type="radio" class="form-check-input" name="income" value="first" />300만원 미만&nbsp; 
									</label>
								</div>
								<div class="form-check">
			   	        			<label class="form-check-label">
										<input type="radio" class="form-check-input" name="income"  value="second" />300만원 이상 500만원 미만&nbsp; 
									</label>
								</div>
								<div class="form-check">
			   	        			<label class="form-check-label">
								<input type="radio" class="form-check-input" name="income"  value="third" />500만원 이상 700만원 미만&nbsp;
														</label>
								</div>
								<div class="form-check">
			   	        			<label class="form-check-label">
								<input type="radio" class="form-check-input" name="income"  value="fourth" />700만원 이상&nbsp;
									</label>
								</div>
						    </div>
                            </td>
                        </tr>
                    </tbody>
                </table>
                <br>
				<div class="partyBtn">
            		<button type="submit" class="create">START</button>
            		<a href="/miraclebird">
            			<button type="button" class="cancle" >CANCEL</button>
            		</a>
        		</div>
             </form>
        </div>
</div>
</body>
</html>