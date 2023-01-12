package com.multi.miraclebird.party.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.multi.miraclebird.party.vo.PartyAttendanceVO;

@Repository
public class PartyAttendanceDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;

	public PartyAttendanceVO findPartyAttendanceByAttendanceDateAndPartyId(PartyAttendanceVO partyAttendanceVO) {
		return mybatis.selectOne("partyAttendance.findPartyAttendanceByAttendanceDateAndPartyId", partyAttendanceVO);
	}

	public void insertPartyAttendance(PartyAttendanceVO partyAttendanceVO) {
		mybatis.insert("partyAttendance.insertPartyAttendance", partyAttendanceVO);
	}

	public void updatePartyAttendance(PartyAttendanceVO partyAttendanceVO) {
		mybatis.update("partyAttendance.updatePartyAttendance", partyAttendanceVO);
	}

	public List<PartyAttendanceVO> getPartyAttendanceWeeklyByPartyId(Integer partyId) {
		return mybatis.selectList("partyAttendance.getPartyAttendanceWeeklyByPartyId", partyId);
	}
	

}
