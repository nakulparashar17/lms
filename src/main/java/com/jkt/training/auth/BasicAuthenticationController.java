package com.jkt.training.auth;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin( "http://localhost:3000")
public class BasicAuthenticationController {

	 @GetMapping(path = "/basicauth")
	    public AuthenticationBean helloWorldBean() {
	        //throw new RuntimeException("Some Error has Happened! Contact Support at ***-***");
	        return new AuthenticationBean("You are authenticated");
	    }   
}