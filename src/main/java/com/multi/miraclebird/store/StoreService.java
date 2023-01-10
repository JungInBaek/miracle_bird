package com.multi.miraclebird.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StoreService {
	@Autowired
	StoreDAO storeDAO;
	
	public int myPoint(Long userId) {
		return storeDAO.myPoint(userId);
	}
	
	// 페이징 구현
	public int pages(int count) {
		int pages = 0;
		if(count % 6 == 0) {
			pages = count / 6;
		} else {
			pages = count / 6 + 1;
		}
		return pages;
	}

	public int findProduct(UserProductVO findProduct) {
		return storeDAO.findProduct(findProduct);
	}
}
