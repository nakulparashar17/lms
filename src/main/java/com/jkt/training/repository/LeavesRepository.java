package com.jkt.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jkt.training.entity.Leaves;

public interface LeavesRepository extends JpaRepository<Leaves, Integer> {

}
