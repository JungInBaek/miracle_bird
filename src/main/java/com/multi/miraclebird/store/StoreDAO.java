package com.multi.miraclebird.store;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StoreDAO {
	@Autowired
	SqlSessionTemplate mybatis;	
	
	public List<ProductVO> list(CategoryPageVO vo) {
		return mybatis.selectList("product.list", vo);
	}
	public int count() {
		return mybatis.selectOne("product.count");
	}
	
}
