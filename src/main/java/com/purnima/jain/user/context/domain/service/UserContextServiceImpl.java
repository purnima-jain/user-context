package com.purnima.jain.user.context.domain.service;

import org.springframework.stereotype.Service;

import com.purnima.jain.user.context.domain.entities.UserContext;
import com.purnima.jain.user.context.utils.UserContextHolder;

@Service
public class UserContextServiceImpl {

	public UserContext getUserContext() {
		return UserContextHolder.getContext();
	}

}
