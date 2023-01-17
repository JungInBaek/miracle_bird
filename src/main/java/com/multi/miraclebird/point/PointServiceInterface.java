package com.multi.miraclebird.point;

import java.util.List;

public interface PointServiceInterface {

	// 포인트 전체 목록
	List<PointVO> list();

	// 포인트 하나 찾기
	PointVO one(int pointId);

	// 포인트 충전 시 charge에 Insert
	void chargeInsert(ChargeVO chargeVO);

	// 포인트의 양 찾기
	int findPoint(int pointId);

	// 포인트 충전
	void pointCharge(UserPointVO userPointVO);

	List<ChargeVO> chargeList(Long userId);

}