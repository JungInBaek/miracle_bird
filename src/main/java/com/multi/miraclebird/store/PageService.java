package com.multi.miraclebird.store;

import org.springframework.stereotype.Service;

@Service
public class PageService {
	public int pages(int count) {
		int pages = 0;
		if(count % 6 == 0) {
			pages = count / 6;
		} else {
			pages = count / 6 + 1;
		}
		return pages;
	}
}
