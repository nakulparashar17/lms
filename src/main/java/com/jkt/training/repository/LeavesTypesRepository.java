package com.jkt.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jkt.training.entity.Leaves_Types;
@Repository
public interface LeavesTypesRepository extends JpaRepository<Leaves_Types, Integer>{
	
}
