package com.jkt.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jkt.training.entity.Users;
import com.jkt.training.exception.NotFoundException;
import com.jkt.training.service.UsersService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class UsersController {

	@Autowired
	private UsersService userser;
	
	@GetMapping("/users")
	public List<Users> getAllUsers()
	{
		return userser.getAllUsers();
	}
	
	@GetMapping("/users/{id}")
	public Users getUserbyId(@PathVariable String id)
	{
		Users user=userser.findById(id);
		if(user==null)
		{
			throw new NotFoundException("User not found with id:"+id);
		}
		return user;
	}

	@PostMapping(path="/users",consumes = "application/json")
	public String addUsers(@RequestBody Users user)
	{
		Users isExist=userser.findUsersByEmail(user.getEmail());
		if(isExist!=null) {
			return "already added by this email";
		}
		else {
			userser.addUsers(user);
			return "New User Added";
		}
	}
	

	
	
	  @RequestMapping(method=RequestMethod.PUT, value="/users/{id}")
	    public Users update(@PathVariable String EmpId, @RequestBody Users user) {
		  return userser.updateUsers(user, EmpId);
	    }
	  
	  @RequestMapping(method=RequestMethod.DELETE, value="/users/{id}")
	    public String delete(@PathVariable String id) {
		  userser.deleteEmp(id);
		  return "user deleted";
	    }
	
}

