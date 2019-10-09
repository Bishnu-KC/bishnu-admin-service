package com.idexcel.adminservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="healthCheck")
public class HealthCheckController {
	
	@ResponseStatus(code=HttpStatus.OK)
	@GetMapping
	public String checkHealth() {
		return "Bishnu-Admin-Service is Up and running!!!";
	}

}
