<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <link href="../resources/css/partyMain5.css" rel="stylesheet" type="text/css">
    <link
        href=“https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500;700;900&family=Roboto:ital,wght@0,300;0,400;0,500;0,700;0,900;1,300&display=swap”
        rel=“stylesheet”>
    <link rel=“stylesheet”
    href=“https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.css”>
    <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
    	let list;
    	$.ajax({
    		type: "get",
    		url: "/miraclebird/party/attendance",
    		async: false,
    		dataType: "json",
    		success: function(data) {
    			console.log(data);
    			list = data;
    		}
    	});
    
	    google.charts.load('current', {'packages':['line']});
	    google.charts.setOnLoadCallback(drawChart);
		
	    function drawChart() {
	    	var data = new google.visualization.DataTable();
			data.addColumn('date', '');
			data.addColumn('number', '');
		    data.addRows(list.length);
		    for (var i = 0; i < list.length; i++) {
		    	let date = list[i].attendanceDate;
		    	data.setCell(i, 0, new Date(date.year, date.monthValue, date.dayOfMonth));
		    	data.setCell(i, 1, list[i].attendanceCount);
			}
		
		    var options = {
		      width: 900,
		      height: 400
		    };
		
		    var chart = new google.charts.Line(document.getElementById('linechart_material'));		
		    chart.draw(data, google.charts.Line.convertOptions(options));
		  }
    </script>
    <title>Party Main</title>
</head>

<body>
	<!-- 헤더 -->
    <header>
        <div class="head">
            <!-- 로고 -->
            <a href="/miraclebird">
                <img src="${pageContext.request.contextPath}/resources/img/logo.svg" alt="로고" class="logo animate__animated animate__fadeInLeft">
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
    <div>
        <div class="cate">
            <a href="/miraclebird/party/main">
            	<button class="btn" id="here" onload="backChange()"
						style="background-color: #ffb100">Main</button>
            </a>
            <a href="/miraclebird/party/feed?page=1">
            	<button class="btn">Feed</button>
            </a>
            <a href="/miraclebird/party/community">
	            <button class="btn">Community</button>
            </a>
            <a href="/miraclebird/party/members">
            	<button class="btn">People</button>
            </a>
            <c:if test="${isLeader}">
            	<a href="/miraclebird/party/applicants">
            		<button class="btn">Applicants</button>
            	</a>
            </c:if>
            <c:if test="${isLeader}">
            	<a href="/miraclebird/party/style">
            		<button class="btn">Style</button>
            	</a>
            </c:if>
        </div>
        
    <div class="mainInfo">
        <div class="main">
            <div class="mainImg">
            	<!-- 구글 차트 -->
            	<div id="linechart_material"></div>
            </div>
            <div class="mainText" onload="backChange()" id="bg">
                <a><marquee>${partyVO.intro}</marquee> </a>
            </div>
        </div>
        <div class="partyInfo">
            <div class="stati">
                <a>대표 이미지</a><br>
        		<c:if test='${partyImgVO == null}'>
	            	<span>
	                	<img src="${pageContext.request.contextPath}/resources/img/logo.svg" width="246px" height="180px"/>
	                	<a style="font-size: 15px;">파티 대표 이미지를 등록해주세요!</a>
	            	</span>
            	</c:if>
            	<c:if test='${partyImgVO != null}'>
                	<img src="${pageContext.request.contextPath}/resources/partyImg/${partyImgVO.imgName}" width="246px" height="180px" />
            	</c:if>
            </div>
            <div class="time">
                <a>Time</a><br>
                <h4>${partyVO.miracleStartTime} ~ ${partyVO.miracleEndTime}</h4>
            </div>
            <div class="activity">
                <a>Activity</a><br>
                <h4>${partyVO.activity}</h4>
            </div>
            <div class="member">
                <a>Members</a><br>
                <h4>${partyMemberCount}/${partyVO.maxMemberCount}</h4>
            </div>
        </div>
    </div>
    </div>    
    <script lang="javascript">
		let colorList;
		$.ajax({
			type : "get",
			url : "/miraclebird/party/products",
			async : false,
			dataType : "json",
			success : function(data) {
				colorList = data;
				console.log(data);
			}
		});

		function backChange() {
			// 데이터에 있는 색상 코드 입력
			// var Acolor = new Array('red', 'orange', 'green');
			var Acolor = colorList;
			var Bcolor = Math.floor(Math.random() * Acolor.length);
			var Ccolor = Acolor[Bcolor];
			document.getElementById('bg').style.background = Ccolor;
			document.getElementById('here').style.background = Ccolor;
		}

		setInterval(backChange, 8000);
	</script>
</body>
</html>