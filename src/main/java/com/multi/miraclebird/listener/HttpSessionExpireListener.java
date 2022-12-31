package com.multi.miraclebird.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.beans.factory.annotation.Autowired;

import com.multi.miraclebird.user.UserDAO;

public class HttpSessionExpireListener implements HttpSessionListener {
	
	@Autowired
	private UserDAO userDao;

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		Long userId = (Long) session.getAttribute("user_id");
		userDao.deleteAccessToken(userId);
	}

}
