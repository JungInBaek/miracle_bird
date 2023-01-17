package com.multi.miraclebird.store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.miraclebird.profile.ProfileVO;
import com.multi.miraclebird.user.UserDAO;
import com.multi.miraclebird.user.UserVO;


@Service
public class StoreService implements StoreServiceInterface {
	@Autowired
	StoreDAOInterface storeDAO;
	
	@Autowired
	UserDAO userDAO;
	
	@Override
	public int myPoint(Long userId) {
		return storeDAO.myPoint(userId);
	}
	
	// 페이징 구현
	@Override
	public int pages(int count) {
		int pages = 0;
		if(count % 6 == 0) {
			pages = count / 6;
		} else {
			pages = count / 6 + 1;
		}
		return pages;
	}

	@Override
	public int findProduct(UserProductVO findProduct) {
		return storeDAO.findProduct(findProduct);
	}

	@Override
	public List<CategoryVO> cateList() {
		return storeDAO.cateList();
	}

	@Override
	public List<OrderVO> orderList(Long userId) {
		return storeDAO.orderList(userId);
	}

	@Override
	public int count(CategoryPageVO vo) {
		return storeDAO.count(vo);
	}

	@Override
	public List<ProductVO> list(CategoryPageVO vo) {
		return storeDAO.list(vo);
	}

	@Override
	public UserVO selectUser(Long userId) {
		return userDAO.selectUser(userId);
	}

	@Override
	public int productPoint(int productId) {
		return storeDAO.productPoint(productId);
	}

	@Override
	public void pointUpdate(ProfileVO profileVO) {
		storeDAO.pointUpdate(profileVO);
	}

	@Override
	public void orderInsert(OrderVO orderVO) {
		storeDAO.orderInsert(orderVO);
	}

	@Override
	public void userProductInsert(UserProductVO userProductVO) {
		storeDAO.userProductInsert(userProductVO);
	}
}
