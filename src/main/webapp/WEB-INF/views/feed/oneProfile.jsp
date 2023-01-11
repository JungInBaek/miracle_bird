<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="profile-inner">
	<div class="circle-container">
		<img src="resources/profile/${profileVo.profileImg}" alt="프로필이미지">
	</div>
	<!-- <div class="name">홍길동</div> -->
	<div class="account">@${userVo.username }</div>
	<div class="edit-profile">
		<a href="profile.jsp">
			<!-- 로그인 한 유저가 아닐 경우(본인의 프로필이 아닌 경우) 버튼 숨김 -->
			<div>프로필 수정</div>
		</a>
	</div>

	<div class="number">
		<div class="post">
			<span class="content">${posts }</span> <span class="sub-title">Posts</span>
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