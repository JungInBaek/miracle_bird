<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
    <link href="resources/css/partyCom5.css" rel="stylesheet" type="text/css">
    <link
        href=“https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500;700;900&family=Roboto:ital,wght@0,300;0,400;0,500;0,700;0,900;1,300&display=swap”
        rel=“stylesheet”>
    <link rel=“stylesheet”
    href=“https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.css”>
    <title>Party Feed</title>
    <!-- TODO: 스크롤 추가 -->
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
            <button class="btn">Main</button>
            <button class="btn">Feed</button>
            <button class="btn" id="here" onload="backChange()" style="background-color:#ffb100">Community</button>
            <button class="btn">Style</button>
            <button class="btn">People</button>
            <button type="button" class="btn">Applicants</button>
        </div>
    <div class="mainInfo">
        <div class="main">
            <div class="mainContent">
                    <div class="content" onClick="location.href='partyComDetail.html'" style="cursor: pointer;">
                        <p style="text-align: right;">날짜</p><br>
                        <p style="text-align: center;">제목</p><br>
                        <p>이름</p>
                        </div>
                    <div class="content">
                        <p style="text-align: right;">날짜</p><br>
                        <p style="text-align: center;">제목</p><br>
                        <p>이름</p>
                    </div>
                    <div class="content">
                        <p style="text-align: right;">날짜</p><br>
                        <p style="text-align: center;">제목</p><br>
                        <p>이름</p>
                    </div>
                    <div class="content">
                        <p style="text-align: right;">날짜</p><br>
                        <p style="text-align: center;">제목</p><br>
                        <p>이름</p>
                    </div>
                    <div class="content">
                        <p style="text-align: right;">날짜</p><br>
                        <p style="text-align: center;">제목</p><br>
                        <p>이름</p>
                    </div>
                    <div class="content">
                        <p style="text-align: right;">날짜</p><br>
                        <p style="text-align: center;">제목</p><br>
                        <p>이름</p>
                    </div>
                    <div class="content">
                        <p style="text-align: right;">날짜</p><br>
                        <p style="text-align: center;">제목</p><br>
                        <p>이름</p>
                    </div>
                    <div class="content">
                        <p style="text-align: right;">날짜</p><br>
                        <p style="text-align: center;">제목</p><br>
                        <p>이름</p>
                    </div>
                    <div id="wrap">
                        <section class="contentModal">
                            <div class="containerModal">
                                <div class="btnClass">
                                    <button class="create" onClick="javascript:popOpen();">글쓰기</button>
                                </div>
                            </div>
                        </section>   
                    </div>
                </div>
                <!-- 모달창 -->
                
                <form action="">
                    <div class="modal-bg" onClick="javascript:popClose();"></div>
                    <div class="modal-wrap">
                        <button class="modal-close" onClick="javascript:popClose();">&times;</button>
                    </div>
        <!-- //modal 영역 -->
                    <div class="modal-bg" onClick="javascript:popClose();"></div>
                    <div class="modal-wrap">
                        <span>
                            <h4 style=" margin: 20px; display: inline;">글쓰기</h4>
                            <button class="modal-close" onClick="javascript:popClose();">&times;</button>
                        </span>
                        <textarea placeholder="새로운 내용을 남겨주세요!"></textarea>
                        <button type="submit" class="complete">작성하기</button>
                    </div>
                </form>
            </div>
           <div class="mainText" onload="backChange()" id="bg">
                <a><marquee>환영합니다. 지옥에서 돌아온 닭 파티룸입니다.</marquee> </a>
            </div>
        </div>
        
    </div>
    </div>
    <script lang="javascript">
        function popOpen() {
            var modalPop = $('.modal-wrap');
            var modalBg = $('.modal-bg'); 
            
            $(modalPop).show();
            $(modalBg).show();
        }
        
        function popClose() {
            var modalPop = $('.modal-wrap');
            var modalBg = $('.modal-bg');
            
            $(modalPop).hide();
            $(modalBg).hide();
        }
    </script>
    <script lang="javascript">
        function popOpen1() {
            var modalPop1 = $('.modal-wrap1');
            var modalBg1 = $('.modal-bg1'); 
            
            $(modalPop1).show();
            $(modalBg1).show();
        }
        
        function popClose1() {
            var modalPop1 = $('.modal-wrap1');
            var modalBg1 = $('.modal-bg1');
            
            $(modalPop1).hide();
            $(modalBg1).hide();
        }
    </script>
    
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