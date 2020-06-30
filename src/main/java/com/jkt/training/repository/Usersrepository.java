package com.jkt.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jkt.training.entity.Users;
@Repository
public interface Usersrepository extends JpaRepository<Users, String>{
	public Users findByEmail(String email);
}
