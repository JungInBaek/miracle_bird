<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="circle-container">
	<img src="resources/profile/${profileVo.profileImg}" alt="">
</div>
<div class="account">@${userVo.username }</div>
<div class="edit-profile">
	<a href="/miraclebird/profile">
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