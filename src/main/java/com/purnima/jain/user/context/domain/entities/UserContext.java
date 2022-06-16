package com.purnima.jain.user.context.domain.entities;

import lombok.Data;

@Data
public class UserContext {

	public static final String CORRELATION_ID = "x-correlation-id";
	public static final String AUTH_TOKEN = "x-auth-token";
	public static final String USER_ID = "x-user-id";
	public static final String ORGANIZATION_ID = "x-organization-id";

	private String correlationId;
	private String authToken;
	private String userId;
	private String organizationId;

}
