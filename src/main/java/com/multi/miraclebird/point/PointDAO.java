package com.multi.miraclebird.point;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PointDAO {

	@Autowired
	SqlSessionTemplate mybatis;
	
	public List<PointVO> list() {
		return mybatis.selectList("point.list");
	}

	public PointVO one(int pointId) {
		return mybatis.selectOne("point.one", pointId);
	}

	public void chargeInsert(ChargeVO chargeVO) {
		mybatis.insert("charge.chargeInsert", chargeVO);
	}

	public int findPoint(int pointId) {
		return mybatis.selectOne("point.findPoint", pointId);
	}

	public void pointCharge(UserPointVO userPointVO) {
		mybatis.update("profile.pointCharge", userPointVO);
	}
	
}
