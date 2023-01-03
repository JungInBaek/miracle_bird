package com.multi.miraclebird.recruit;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RecruitDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public List<RecruitPartyVO> getRecruitPartyList() {
		List<RecruitPartyVO> list = new ArrayList<>();
		
		mybatis.selectList("recruit.recruitPartyList");
		
		return list;
	}
	
}
