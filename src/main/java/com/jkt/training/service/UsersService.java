package com.jkt.training.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jkt.training.entity.Users;
import com.jkt.training.repository.Usersrepository;


@Service
public class UsersService {
	@Autowired
	private Usersrepository userrepo;
	
	public Users findUsersByEmail(String email) {
    	return userrepo.findByEmail(email);
    }
	
  	public List<Users> getAllUsers()
	{
		return userrepo.findAll();
	}
	
  	public List<Users> getAllUsersManagerId(String id)
	{
		return userrepo.getAllUsersManagerId(id);
	}
	
	public Users findById(String id)
	{
		Optional<Users> result = userrepo.findById(id);
		Users user=null;
		if(result.isPresent())
		{
			user=result.get();
		}
		return user;
	}

	public void addUsers(Users user) {
		userrepo.save(user);
		
	}
	
	
	public Users updateUsers(Users user,String EmpId)
	{
	
//		if(userrepo.existsById(EmpId))
//			userrepo.save(user);
		Optional<Users> optuser = userrepo.findById(EmpId);
        Users c = optuser.get();
        if(user.getId()!= null)
            c.setId(user.getId());
        if(user.getEmail() != null)
            c.setEmail(user.getEmail());
        if(user.getPassword() != null)
            c.setPassword(user.getPassword());
        userrepo.save(c);
        return c;
	
	}
	
	public void deleteEmp(String id)
	{
//		Users user=userrepo.getOne(EmpId);
//		userrepo.delete(user);
		 Optional<Users> optuser = userrepo.findById(id);
	        Users user = optuser.get();
	        userrepo.delete(user);     
	}

	
}
