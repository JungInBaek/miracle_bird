<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- 유저네임(인스타아이디) :
<br>
미라클 포인트 : ${vo.miraclePoint }
<br>
미라클 타임 : ${vo.miracleStartTime } ~ ${vo.miracleEndTime }
<br>
자기소개 : ${vo.bio }
<br>
프로필 이미지
<br>
<img src="resources/profile/${vo.profileImg}" height=150 width=150> --%>
<div class="profile-inner">
	<div class="circle-container">
		<img src="resources/profile/${profileVo.profileImg}" alt="프로필이미지">
	</div>
	<!-- <div class="name">홍길동</div> -->
	<div class="account">@${userVo.username }</div>
	<div class="edit-profile">
		<a href="#">
			<div>프로필 수정</div>
		</a>
	</div>

	<div class="number">
		<div class="post">
			<span class="content">32</span> <span class="sub-title">Posts</span>
		</div>
		<div class="time">
			<span class="content">${profileVo.miracleStartTime } ~ ${profileVo.miracleEndTime }</span> <span class="sub-title">Time</span>
		</div>
	</div>

	<div class="text-box">${profileVo.bio }</div>

	<div class="month">
		<img src="resources/img/grass.svg" alt="잔디"> <span>December</span>
	</div>

	<div class="grass-field">
		<div class="grass"></div>
		<div class="grass"></div>
		<div class="grass"></div>
		<div class="grass"></div>
		<div class="grass"></div>
		<div class="grass"></div>
		<div class="grass"></div>
		<div class="grass"></div>
		<div class="grass"></div>
		<div class="grass"></div>
		<div class="grass"></div>
		<div class="grass"></div>
		<div class="grass"></div>
		<div class="grass"></div>
		<div class="grass"></div>
		<div class="grass"></div>
		<div class="grass"></div>
		<div class="grass"></div>
		<div class="grass"></div>
		<div class="grass"></div>
		<div class="grass"></div>
		<div class="grass"></div>
		<div class="grass"></div>
		<div class="grass"></div>
		<div class="grass"></div>
		<div class="grass"></div>
		<div class="grass"></div>
		<div class="grass"></div>
		<div class="grass"></div>
		<div class="grass"></div>
		<div class="grass"></div>
	</div>
</div>