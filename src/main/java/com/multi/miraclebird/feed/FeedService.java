package com.multi.miraclebird.feed;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.multi.miraclebird.api.InstagramApiService;
import com.multi.miraclebird.party.vo.PartyFeedPagingVO;
import com.multi.miraclebird.party.vo.PartyFeedVO;
import com.multi.miraclebird.user.UserVO;

@Service
public class FeedService {

	@Autowired
	private FeedDAO feedDao;
	
	public FeedVO selectFeedByFeedId(FeedVO feedVO) {
		return feedDao.selectFeedByFeedId(feedVO);
	}
	
	public List<FeedVO> allFeedByUserId(Long userId) {
		return feedDao.allFeedByUserId(userId);
	}
	
	public List<PartyFeedVO> findPartyMemberFeed(PartyFeedPagingVO partyFeedPagingVO) {
		return feedDao.findPartyMemberFeed(partyFeedPagingVO);
	}
	
	public Integer getPartyMemberFeedCount(PartyFeedPagingVO partyFeedPagingVO) {
		return feedDao.getPartyMemberFeedCount(partyFeedPagingVO);
	}
}
