package com.multi.miraclebird.party;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PartyService {
	
	@Autowired
	private PartyDAO partyDao;
	
	@Autowired
	private PartyMemberDAO partyMemberDao;
	
	
	public void createParty(PartyVO partyVO) {
		partyDao.createParty(partyVO);
		partyMemberDao.createPartyLeader(partyVO);
	}
	

}
