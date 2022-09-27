package com.fbaa.learnspringframeworkweb.sample.enterprise.flow.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fbaa.learnspringframeworkweb.sample.enterprise.flow.business.BusinessService;

// Sending response in the right format
@RestController
public class Controller {
	//"/sum" => 100
	
	@Autowired
	private BusinessService businessService;
	
	@GetMapping("sum")
	public long displaySum() {
		return businessService.calculateSum();
	}
}
