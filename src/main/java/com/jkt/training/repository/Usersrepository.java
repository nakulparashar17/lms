package com.jkt.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jkt.training.entity.Users;
@Repository
public interface Usersrepository extends JpaRepository<Users, String>{
	public Users findByEmail(String email);
	
	@Query(nativeQuery = true, value = "select * from users where lineManager=?1")
	public List<Users> getAllUsersManagerId(String id);
	
}
