package com.multi.miraclebird.store;

import java.util.List;

import com.multi.miraclebird.profile.ProfileVO;

public interface StoreDAOInterface {

	// 추상메서드 생성
	
	List<ProductVO> list(CategoryPageVO vo);

	int count(CategoryPageVO vo);

	int myPoint(Long userId);

	int productPoint(int productId);

	void pointUpdate(ProfileVO profileVO);

	void orderInsert(OrderVO orderVO);

	void userProductInsert(UserProductVO userProductVO);

	int findProduct(UserProductVO findProduct);

	List<CategoryVO> cateList();

	List<OrderVO> orderList(Long userId);

	//	파티원들의 아이템 조회
	List<ProductVO> findPartyMemberProductByPartyId(Integer partyId);

}