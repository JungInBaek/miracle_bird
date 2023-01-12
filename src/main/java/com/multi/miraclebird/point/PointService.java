package com.multi.miraclebird.point;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PointService {
	@Autowired
	PointDAO pointDAO;
	
	// 포인트 전체 목록
	public List<PointVO> list() {
		return pointDAO.list();
	}

	// 포인트 하나 찾기
	public PointVO one(int pointId) {
		return pointDAO.one(pointId);
	}
	
	// 포인트 충전 시 charge에 Insert
	public void chargeInsert(ChargeVO chargeVO) {
		pointDAO.chargeInsert(chargeVO);
	}

	// 포인트의 양 찾기
	public int findPoint(int pointId) {
		return pointDAO.findPoint(pointId);
	}

	// 포인트 충전
	public void pointCharge(UserPointVO userPointVO) {
		pointDAO.pointCharge(userPointVO);
	}

	public List<ChargeVO> chargeList(Long userId) {
		return pointDAO.chargeList(userId);
	}
	
}
