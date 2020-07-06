package com.jkt.training.auth;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jkt.training.entity.Users;
import com.jkt.training.exception.NotFoundException;
import com.jkt.training.repository.Usersrepository;

@RestController
@CrossOrigin( "http://localhost:3000")
public class BasicAuthenticationController {

	@Autowired
	private Usersrepository repo;
	
	 @GetMapping(path = "/basicauth")
	    public AuthenticationBean helloWorldBean() {
	        //throw new RuntimeException("Some Error has Happened! Contact Support at ***-***");
	        return new AuthenticationBean("You are authenticated");
	    }   
	 
	 @PostMapping(path="/login",consumes = "application/json")
	 public Users loginPage(@RequestBody Users user) {
		 Optional<Users> u=repo.findById(user.getId());
		 if(u.isPresent()) {
			 Users utemp=u.get();
			 return utemp; 
		 }
		 else {
			 throw new NotFoundException("user not found");
		 }
	 }
}