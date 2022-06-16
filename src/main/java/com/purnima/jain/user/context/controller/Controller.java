package com.purnima.jain.user.context.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.purnima.jain.user.context.domain.entities.UserContext;
import com.purnima.jain.user.context.domain.service.UserContextServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/v1/user-context")
@Slf4j
public class Controller {

	@Autowired
	private UserContextServiceImpl userContextService;

	@Operation(operationId = "/getUserContext", summary = "Gets the User-Context", parameters = {
				@Parameter(name = "x-correlation-id", description = "Correlation Id for the Request", in = ParameterIn.HEADER, required = true, example = "1234567890", schema = @Schema(implementation = String.class)),
				@Parameter(name = "x-auth-token", description = "Auth Token for the Request", in = ParameterIn.HEADER, required = true, example = "auth_token", schema = @Schema(implementation = String.class)),
				@Parameter(name = "x-user-id", description = "User Id for the Request", in = ParameterIn.HEADER, required = true, example = "user_abcd", schema = @Schema(implementation = String.class)),
				@Parameter(name = "x-organization-id", description = "Organization Id for the Request", in = ParameterIn.HEADER, required = true, example = "org_5555", schema = @Schema(implementation = String.class)) 
			}, 
			responses = @ApiResponse(responseCode = "200", description = "User Context Retrieved Successfully", 
				content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = UserContext.class))))
	@GetMapping(value = "/getUsercontext", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserContext> getUserContext() {
		UserContext userContext = userContextService.getUserContext();
		log.info("userContext:: {}", userContext);

		return new ResponseEntity<>(userContext, HttpStatus.OK);
	}

}
