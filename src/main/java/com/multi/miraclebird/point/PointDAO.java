package com.multi.miraclebird.point;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PointDAO implements PointDAOInterface {

	@Autowired
	SqlSessionTemplate mybatis;
	
	@Override
	public List<PointVO> list() {
		return mybatis.selectList("point.list");
	}

	@Override
	public PointVO one(int pointId) {
		return mybatis.selectOne("point.one", pointId);
	}

	@Override
	public void chargeInsert(ChargeVO chargeVO) {
		mybatis.insert("charge.chargeInsert", chargeVO);
	}

	@Override
	public int findPoint(int pointId) {
		return mybatis.selectOne("point.findPoint", pointId);
	}

	@Override
	public void pointCharge(UserPointVO userPointVO) {
		mybatis.update("profile.pointCharge", userPointVO);
	}

	@Override
	public List<ChargeVO> chargeList(Long userId) {
		return mybatis.selectList("charge.chargeList", userId);
	}
	
}
