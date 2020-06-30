package com.jkt.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jkt.training.entity.Users_Leaves_Track;
@Repository
public interface UsersLeavesRepository extends JpaRepository<Users_Leaves_Track, Integer>{

}
