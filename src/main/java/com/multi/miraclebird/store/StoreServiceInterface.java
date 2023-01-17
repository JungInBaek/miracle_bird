package com.multi.miraclebird.store;

import java.util.List;

import com.multi.miraclebird.profile.ProfileVO;
import com.multi.miraclebird.user.UserVO;

public interface StoreServiceInterface {

	int myPoint(Long userId);

	// 페이징 구현
	int pages(int count);

	int findProduct(UserProductVO findProduct);

	List<CategoryVO> cateList();

	List<OrderVO> orderList(Long userId);

	int count(CategoryPageVO vo);

	List<ProductVO> list(CategoryPageVO vo);

	UserVO selectUser(Long userId);

	int productPoint(int productId);

	void pointUpdate(ProfileVO profileVO);

	void orderInsert(OrderVO orderVO);

	void userProductInsert(UserProductVO userProductVO);

}