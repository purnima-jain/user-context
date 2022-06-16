package com.purnima.jain.user.context.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.purnima.jain.user.context.domain.entities.UserContext;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class UserContextFilter implements Filter {

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

		UserContextHolder.getContext().setCorrelationId(httpServletRequest.getHeader(UserContext.CORRELATION_ID));
		UserContextHolder.getContext().setAuthToken(httpServletRequest.getHeader(UserContext.AUTH_TOKEN));
		UserContextHolder.getContext().setUserId(httpServletRequest.getHeader(UserContext.USER_ID));
		UserContextHolder.getContext().setOrganizationId(httpServletRequest.getHeader(UserContext.ORGANIZATION_ID));

		log.debug("UserContextFilter Correlation Id: {}", UserContextHolder.getContext().getCorrelationId());

		filterChain.doFilter(httpServletRequest, servletResponse);

	}

}
