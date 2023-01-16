<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
    <link href="${pageContext.request.contextPath}/resources/css/partyStyle5.css" rel="stylesheet" type="text/css">
    <link
        href=“https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500;700;900&family=Roboto:ital,wght@0,300;0,400;0,500;0,700;0,900;1,300&display=swap”
        rel=“stylesheet”>
    <link rel=“stylesheet”
    href=“https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.css”>
    <title>Party Style</title>
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
    <div >
        <div class="cate">
            <a href="/miraclebird/party/main">
            	<button class="btn">Main</button>
            </a>
            <a href="/miraclebird/party/feed?page=1">
            	<button class="btn">Feed</button>
            </a>
            <button class="btn">Community</button>
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
            <div class="mainContent">
                <div class="content">
                    <div class="container">
                        <div class="image-upload" id="image-upload">
                
                            <form action="/miraclebird/party/img/update" method="post" enctype="multipart/form-data">
                                <div class="button">
                                    <label for="chooseFile" style="font-weight: bold; font-size: 20px;">
                                        Party Image Change
                                    </label>
                                </div>
                                <input type="file" id="chooseFile" name="file" accept="image/*" onchange="loadFile(this)">
                                <div class="fileContainer">
	                                <div class="fileInput">
	                                    <p>FILE NAME: </p>
	                                    <p id="fileName">${partyImgVO.oriImgName}</p>
	                                </div>
	                                <div class="buttonContainer">
	                                    <div class="submitButton" id="submitButton"><button type="submit" style="background-color:#FFb100; border:none; color:white; font-weight:bold;">SUBMIT</button></div>
	                                </div>
                            	</div>
                            </form>
                        </div>
                        <div class="image-show" id="image-show"></div>
                        <br>
                        <br>
                        <form action="/miraclebird/party/intro/update" method="post">
                            <div class="IntroParty">
                                <label style="font-size: 20px; font-weight: bold;">Party Intro Change </label><br>
                                <input type="text" name="intro" value="${partyVO.intro}" style="border-radius: 30px; border: 2px solid #FFb100; width: 500px; height: 40px; margin-top: 30px; padding: 10px; margin-right: 10px;">
                                <button type="submit" style="border-radius: 30px; border: none; background-color: #FFb100; height: 42px; width: 100px; color: white; font-weight: bold; font-size: 15px;">SUBMIT</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <div class="mainText" onload="backChange()" id="bg">
                <a><marquee>${partyVO.intro}</marquee> </a>
            </div>
        </div>
    </div>
    </div>

    <script lang="javascript">
        function loadFile(input) {
    var file = input.files[0];	//선택된 파일 가져오기

    //미리 만들어 놓은 div에 text(파일 이름) 추가
    var name = document.getElementById('fileName');
    name.textContent = file.name;

  	//새로운 이미지 div 추가
    var newImage = document.createElement("img");
    newImage.setAttribute("class", 'img');

    //이미지 source 가져오기
    newImage.src = URL.createObjectURL(file);   

    newImage.style.width = "70%";
    newImage.style.height = "70%";
    newImage.style.visibility = "hidden";   //버튼을 누르기 전까지는 이미지를 숨긴다
    newImage.style.objectFit = "contain";
    
    var inputFile = document.getElementById(fileName);
    inputFile.value = null;
    
    //이미지를 image-show div에 추가
    var container = document.getElementById('image-show');
    container.appendChild(newImage);
};

var submit = document.getElementById('submitButton');
submit.onclick = showImage;     //Submit 버튼 클릭시 이미지 보여주기

function showImage() {
    var newImage = document.getElementById('image-show').lastElementChild;
  
    //이미지는 화면에 나타나고
    newImage.style.visibility = "visible";
  
    //이미지 업로드 버튼은 숨겨진다
    document.getElementById('image-upload').style.visibility = 'hidden';

    document.getElementById('fileName').textContent = null;     //기존 파일 이름 지우기
}

    </script>

    <script lang="javascript">
        function colorChange(){
            var area = document.getElementById("area");
            var area1 = document.getElementById("area1");
            var color = document.getElementById("color");
            area.style.backgroundColor = color.value;
            area1.style.backgroundColor = color.value;
        };
    </script>
    
    <script lang="javascript">
    	let list;
    	$.ajax({
    		type: "get",
    		url: "/miraclebird/party/products",
    		async: false,
    		dataType: "json",
    		success: function(data) {
    			list = data;
    			console.log(data);
    		}
    	});
    	
    	function backChange(){
            // 데이터에 있는 색상 코드 입력
            // var Acolor = new Array('red', 'orange', 'green');
            var Acolor = list;
            var Bcolor = Math.floor(Math.random() * Acolor.length);
            var Ccolor = Acolor[Bcolor]; 
            document.getElementById('bg').style.background=Ccolor;
            document.getElementById('here').style.background=Ccolor;
        }
    	
        setInterval(backChange,8000);
    </script>
</body>
</html>