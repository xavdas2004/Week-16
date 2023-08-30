package com.promineotech.jeep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.jeep.entity.Order;
import com.promineotech.jeep.entity.OrderRequest;
import com.promineotech.jeep.service.JeepOrderService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/orders")
@Slf4j
public class DefaultJeepOrderController implements JeepOrderController {
	
	@Autowired
	private JeepOrderService jeepOrderService;
	
    public Order createOrder(OrderRequest orderRequest) {
        log.debug("Received order request: {}", orderRequest);
        return jeepOrderService.createOrder(orderRequest); 
    }
}