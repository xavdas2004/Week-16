package com.promineotech.jeep.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
//import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.Order;
import com.promineotech.jeep.entity.OrderRequest;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;
@Validated
@RequestMapping("/orders")
@OpenAPIDefinition(info = @Info(title = "Jeep Order Service"), servers = {
@Server(url = "http://localhost:8080", description = "Local server.")})


@ResponseStatus(HttpStatus.CREATED)
public interface JeepOrderController {
	// @formatter off
	@Operation(summary = "Returns a list of Jeeps",
			description = "Returns a list of Jeeps given an optional model and/or trim",
			responses = {
				@ApiResponse(
					responseCode = "200",
					description = "A list of Jeeps is returned",
					content = @Content(
						mediaType = "application/json",
						schema = @Schema(implementation = Jeep.class))),
				@ApiResponse(
					responseCode = "400",
					description = "The request parameters are invalid",
					content = @Content(mediaType = "application/json")),
				@ApiResponse(
					responseCode = "404",
					description = "The request parameters are invalid",
					content = @Content(mediaType = "application/json")),
				@ApiResponse(
					responseCode = "500",
					description = "The request parameters are invalid",
					content = @Content(mediaType = "application/json")),
			},
			parameters = {
					
			})
	Order createOrder(@Valid @RequestBody OrderRequest orderRequest);
}