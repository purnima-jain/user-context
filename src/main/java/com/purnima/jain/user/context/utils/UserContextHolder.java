package com.purnima.jain.user.context.utils;

import org.springframework.util.Assert;

import com.purnima.jain.user.context.domain.entities.UserContext;

public class UserContextHolder {

	private static final ThreadLocal<UserContext> userContext = new ThreadLocal<UserContext>();

	public static final UserContext getContext() {
		UserContext context = userContext.get();

		if (context == null) {
			context = createEmptyContext();
			userContext.set(context);
		}
		return userContext.get();
	}

	public static final void setContext(UserContext userContext) {
		Assert.notNull(userContext, "Only non-null UserContext instances are permitted");
	}

	private static final UserContext createEmptyContext() {
		return new UserContext();
	}

}
