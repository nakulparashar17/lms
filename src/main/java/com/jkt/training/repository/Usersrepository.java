package com.jkt.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jkt.training.entity.Users;

public interface Usersrepository extends JpaRepository<Users, String>{

}
