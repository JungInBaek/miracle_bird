<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>내 프로필</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/profile99.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.css">
    <link
        href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500;700;900&family=Roboto:ital,wght@0,300;0,400;0,500;0,700;0,900;1,300&display=swap"
        rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<script>
	$.ajax({
		url : "oneProfile",
		dataType : "json",
		success : function(profileJson) {
			document.getElementById("bio").value = profileJson.bio;
			document.getElementById("from").value = profileJson.miracleStartTime;
			document.getElementById("to").value = profileJson.miracleEndTime;
			/* document.getElementById("username").innerHTML = profileJson.username; */
			document.getElementById("profileImg").value = profileJson.profileImg;
			var profileSrc = "${pageContext.request.contextPath}/resources/profile/" + profileJson.profileImg;
			document.getElementById("profileSrc").src = profileSrc;
		}
	})
	</script>
	<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
	<script type="text/javascript">
		google.charts.load("current", {packages : [ "calendar" ]});
		google.charts.setOnLoadCallback(drawChart);
	
		function drawChart() {
			$.ajax({
				url : "profile/feedChart",
				dataType : "json",
				success : function(list) {
					var dataTable = new google.visualization.DataTable();
					dataTable.addColumn({type : 'date',	id : 'Date'});
					dataTable.addColumn({type : 'number', id : 'Won/Loss'});
					var arr = new Array(list.length);
					for (i = 0; i < list.length; i++) {
						one = new Array(2);
						one[0] = new Date(list[i].feedTime);
						one[1] = list[i].count;
						arr[i] = one;
					}
					/* alert(arr); */
					dataTable.addRows(arr);
	
					var chart = new google.visualization.Calendar(document
							.getElementById('calendar_basic'));
	
					var options = {
						/* title : "활동기록", */
						height : 350,
						colorAxis : {
							minValue : 0,
							colors : [ '#ffffff', 'yellow' ]
						},
						calendar: {
							dayOfWeekLabel: {
						        color: '#ffffff',
						    },
							monthLabel: {
						        color: '#ffffff'
						  	}
						}
					};
	
					chart.draw(dataTable, options);
				}
			})
		}
	</script>
</head>

<body>
    <!-- 헤더 -->
    <header>
        <div class="head">
            <!-- 로고 -->
            <a href="/miraclebird">
                <img src="resources/img/logo.svg" alt="로고" class="logo">
            </a>
            <!-- 네비게이션바 -->
            <nav>
                <ul class="nav-container">
                    <li class="nav-item"><a href="#">COMMUNITY</a></li>
                    <li class="nav-item"><a href="/miraclebird/recruit/list">FIND</a></li>
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

    <!-- 나의 정보 -->
    <div class="info">
        <form action="updateProfile" method="post" enctype="multipart/form-data">
            <!-- 좌측 정보 -->
            <div class="info-left">
                <div class="image-resizing">
                    <img src="" alt="프로필 사진" id="profileSrc">
                    <input type="hidden" name="profileImg" id="profileImg">	
                </div>
                <input type="file" name="file" id="file" accept="image/*">
                <label for="file">
                    <div class="btn-upload">사진 업로드</div>
                </label>
            </div>

            <!-- 우측 정보 -->
            <div class="info-right">
                <div class="title">나의 정보</div>
                <div class="intro-title">자기 소개</div>
                <div class="intro">
                    <textarea name="bio" id="bio" rows="7"></textarea>
                </div>
                <div class="time-title">활동 시간대</div>
                <div class="time">
                    <span><input type="time" name="miracleStartTime" id="from" min="04:00:00" max="10:00:00"></span>
                    <span>~</span>
                    <span><input type="time" name="miracleEndTime" id="to" min="04:00:00" max="10:00:00"></span>
                </div>

                <button class="btn-submit">Edit Profile</button>
            </div>
        </form>


        <!-- 잔디 -->
        <div class="grass-field"> 내가 심은 기록 보기
            <div class="grass" id="calendar_basic"></div>
        </div>
    </div>
    </div>
</body>

</html>