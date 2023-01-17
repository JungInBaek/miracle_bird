package com.multi.miraclebird.point;

import java.util.List;

public interface PointDAOInterface {

	List<PointVO> list();

	PointVO one(int pointId);

	void chargeInsert(ChargeVO chargeVO);

	int findPoint(int pointId);

	void pointCharge(UserPointVO userPointVO);

	List<ChargeVO> chargeList(Long userId);

}