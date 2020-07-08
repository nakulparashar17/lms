package com.jkt.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jkt.training.entity.Leaves;


@Repository
public interface LeavesRepository extends JpaRepository<Leaves, Integer> {

    public List<Leaves> findByUsersId(String id);
	
	@Query(nativeQuery = true, value = "select * from leaves where active=true")
	public List<Leaves> getAllActiveLeaves();
	
	@Query(nativeQuery = true, value = "select * from leaves where active=true and users_username=?1")
	public List<Leaves> getAllUserActiveLeaves(String id);
	
	@Query(nativeQuery = true, value = "select * from leaves where acceptRejectFlag=true")
	public List<Leaves> getAllApprovedLeaves();
	
	@Query(nativeQuery = true, value = "select * from leaves where acceptRejectFlag=true and users_username=?1")
	public List<Leaves> getAllUserApprovedLeaves(String id);
	
	@Query(nativeQuery = true, value = "select * from leaves where acceptRejectFlag=false")
	public List<Leaves> getAllRejectedLeaves();
	
	@Query(nativeQuery = true, value = "select * from leaves where acceptRejectFlag=false and users_username=?1")
	public List<Leaves> getAllUserRejectedLeaves(String id);
}
