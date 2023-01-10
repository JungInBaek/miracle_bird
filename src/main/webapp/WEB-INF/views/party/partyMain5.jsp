<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <link href="resources/css/partyMain5.css" rel="stylesheet" type="text/css">
    <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
    <link
        href=“https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500;700;900&family=Roboto:ital,wght@0,300;0,400;0,500;0,700;0,900;1,300&display=swap”
        rel=“stylesheet”>
    <link rel=“stylesheet”
    href=“https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.css”>
    <title>Party Main</title>
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
                <ul class="nav-container">
                    <li class="nav-item"><a href="#">COMMUNITY</a></li>
                    <li class="nav-item"><a href="#">FIND</a></li>
                    <li class="nav-item"><a href="#">MY PARTY</a></li>
                    <li class="nav-item"><a href="#">MY FEED</a></li>
                    <li class="nav-item"><a href="#">PROFILE</a></li>
                    <li class="nav-item"><a href="#">STORE</a></li>
                    <li class="nav-item"><a href="#"><button>LOGIN</button></a></li>
                </ul>
            </nav>
        </div>
    </header>
    <div >
        <div class="cate">
            <button type="button" class="btn" id="here" onload="backChange()" style="background-color:#ffb100">Main</button>
            <button type="button" class="btn">Feed</button>
            <button type="button" class="btn">Community</button>
            <button type="button" class="btn">Style</button>
            <button type="button" class="btn">People</button>
            <button type="button" class="btn">Applicants</button>
        </div>
    <div class="mainInfo">

        <div class="main">
            <div class="mainImg" style="margin: auto;">
                party 대표 이미지를 등록해주세요!
            </div>
            <div class="mainText" onload="backChange()" id="bg">
                <a><marquee>환영합니다. 지옥에서 돌아온 닭 파티룸입니다.</marquee> </a>
            </div>
        </div>
        <div class="partyInfo">
            <div class="stati">
                <a>statistics</a><br>
                <h4>그래프 넣어야함</h4>
            </div>
            <div class="time">
                <a>Time</a><br>
                <h4>DB데이터</h4>
            </div>
            <div class="activity">
                <a>Activity</a><br>
                <h4>DB데이터</h4>
            </div>
            <div class="member">
                <a>Members</a><br>
                <h4>DB데이터</h4>
            </div>
        </div>
        
    </div>
    </div>

    <script lang="javascript">

        function backChange(){
            // 데이터에 있는 색상 코드 입력
            var Acolor = new Array('red', 'orange', 'green'); 
            var Bcolor = Math.floor(Math.random() * Acolor.length);
            var Ccolor = Acolor[Bcolor]; 
            document.getElementById('bg').style.background=Ccolor;
            document.getElementById('here').style.background=Ccolor;
            }  
            setInterval(backChange,2000);

    </script>
    
</body>
</html>